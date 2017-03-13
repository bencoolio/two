import java.io.*;
import tme3.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.*;
/***********************************************************************
 * GreenhouseControls.java
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @author: Sean Connelly
 * @date  : January 30, 2017
 *
 * This produces a specific application of the control system, all in a 
 * single class. Inner classes allow you to encapsulate different 
 * functionality for each type of event.
 *
 * Instructions: To be compiled and run with command line
 *               java GreenhouseControls -f example2.txt to serialize.
 *               java GreenhouseControls -d dump.out to deserialize 
 *
 **********************************************************************/

public class GreenhouseControls extends Controller {
    public List<Thread> threadList = new ArrayList<Thread>();
    public void addThread(Thread c) {threadList.add(c);}

    public void what(){
	while(threadList.size() > 0){
	    for(Thread e : new ArrayList<Thread>(threadList)){
		System.out.println(e);
		threadList.remove(e);
	    }
	}
    }
    
	
        
    private String eventsFile = "examples1.txt";
    private boolean powerOn = true;
    protected int errorCode = 0; 
    protected long endTime = 0;
    protected boolean windowOk = true;    
   
    // A class that demonstrates a malfunction event. An exceptino is thrown
    // when the action method is used.
    public class PowerOut extends Event {
        public PowerOut(long delayTime){
            super(delayTime);
            powerOn = false;
            errorCode = 2;
        }
        public void action()throws ControllerException{
            if(errorCode == 2)
                throw new ControllerException("Power Out!!");
        }
	public void run(){};
        @Override
        public String toString(){
            return "ErrorCode 2. Power is out!";
        }
    }
    // A class that fixes the errorCode. Has fix method that restores the error
    // variables and a log method that prints the fixed error and writes the fix
    // to the file 'fix.log'.
    public class PowerOn implements Fixable {
        public void fix(){
            powerOn = true;
            errorCode = 0;
        }
        public void log(){
            try{
                BufferedWriter bw =
                new BufferedWriter(new FileWriter("fix.log"));
                Date date = new Date();
                String content = "Error Code 2"+
                ": Power Now On. "+date+"\n";
                System.out.println(content);
                bw.write(content);
                bw.close();

            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
    // A class that fixes the errorCode. Has fix method that restores the error
    // variables and a log method that prints the fixed error and writes the fix
    // to the file 'fix.log'.
    public class FixWindow implements Fixable {
        public void fix(){
            windowOk = true;
            errorCode = 0;
        }
        public void log(){
            try{
                BufferedWriter bw =
                new BufferedWriter(new FileWriter("fix.log"));
                Date date = new Date();
                String content = "Error Code 1"+
                ": Window Malfunction Fixed. "+date+"\n";
                System.out.println(content);
                bw.write(content);
                bw.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
//--GreenhouseControls methods----------------------------------------
     
    public static void printUsage() {
        System.out.println("Correct format: ");
        System.out.println("  java GreenhouseControls -f <filename>, or");
        System.out.println("  java GreenhouseControls -d dump.out");
    }
    // A method called when an exception is thrown. It shutsdown the program.
    public void shutdown(){
        System.out.println("Emergency Shutdown");
        System.exit(0);
    }
    // A method that returns the error code.
    public int getError() {
        return this.errorCode;
    }
    /**
     * A method that returns a Fixable object.
     *
     * @param errorcode  Type int passed and evaluated, returning a FixWindow or
     * PowerOn object, based on the errorcode that is passed.
     */
    public Fixable getFixable(int errorcode){
        errorCode = errorcode;
        if(errorCode == 1){
            return new FixWindow();
        }else if(errorCode == 2){
            return new PowerOn();
        }
        return null;
    }

//---------------------------------------------------------
    public static void main(String[] args)throws ControllerException,
        ClassNotFoundException,IOException {
	try {
	    String option = args[0];
	    String filename = args[1];

	    if ( !(option.equals("-f")) && !(option.equals("-d")) ) {
		System.out.println("Invalid option");
		printUsage();
	    }

	    GreenhouseControls gc = new GreenhouseControls();
	    if (option.equals("-f"))  {
		try{ 

	 Restart rs = new Restart(0,filename,gc); 
         gc.addEvent(rs);
        //gc.addEvent(gc.new Restart(0, filename)); 
	 }catch(IOException f){
         System.out.println(f);
} 
          
         }   

            if (option.equals("-d")) {
                try{
                    Restore rs = new Restore(filename);
                    rs.display();
                }catch(Exception p){
                    System.out.println(p);
                }
            }//end -d if 

            try{ 
                gc.run(0);
		gc.what();
            }catch(ControllerException e){
                System.out.println(e);
                // writes the error thrown to the file 'error.log' and
                // also prints the message.           
                try{
                    BufferedWriter bw =
                    new BufferedWriter(new FileWriter("error.log"));
                    Date date = new Date();
                    String content = "Error Code "+gc.getError()+
                    ": Power Out. "+date+"\n";
                    System.out.println(content); 
                    bw.write(content);
                    bw.close();
                    gc.endTime = System.currentTimeMillis();
                    //writes the GreenhouseControls object to the file 'dump.out'.
                    ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("dump.out"));
                    out.writeObject(gc);

                }catch(IOException a){
                    System.out.println(a);
                }
                gc.shutdown();
            }//end gc.run() try catch
    
	}catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Invalid number of parameters");
	    printUsage();
	}
    }
} ///:~

