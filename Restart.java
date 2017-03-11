import tme3.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.*;
    class Restart extends Event {
	private GreenhouseControls controller;
	private String eventsFile = "examples1.txt";
        public Restart(long delayTime, String filename, GreenhouseControls controller)
        throws IOException{
            super(delayTime);
            eventsFile = filename;
	    this.controller = controller;
        }

	public Event createEvent(String in, long l){
	
   try{
                        Class<?> thermo = Class.forName(in);
                        Constructor<?> constructor = thermo.getConstructor(long.class);
                       Object instance = constructor.newInstance(l);
        		return (Event)instance;
                }catch(ClassNotFoundException e) {
                        System.out.println(e);
                }catch(NoSuchMethodException e) {
                        System.out.println(e);
                }catch(InstantiationException e){
                        System.out.println(e);
                }catch(IllegalAccessException e){
                        System.out.println(e);
                }catch(InvocationTargetException e){
                        System.out.println(e);
                }
	return null;
}

	public void run(){};
       //adds events
        public void action(){
            //add a malfunction event
           // addEvent(new WindowMalfunction(5000));   
	    
            // PowerOut po = new PowerOut(5000);
            // controller.addEvent(po);
            try{
                //reads from 'examples' text files.          
                Scanner sc = new Scanner(new FileReader(eventsFile));
                Pattern num = Pattern.compile("\\d+");
                //loops through each line in file
                while (sc.hasNext()) {
                    String temp = sc.next();
                    Matcher matcher = num.matcher(temp);
                    //gets delay time from file for thermostatnight, converts
                    // string to long and adds it as parameter for thermostat delay
                    if(temp.contains("ThermostatNight")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
	    		Event thermo = createEvent("ThermostatNight", dLay);
//			Thread t = new Thread(thermo);
//			t.start();
			controller.addEvent(thermo);			
	            }
                    //gets delay time from file for lightOn, converts
                    // string to long and adds it as parameter for lightOn delay
                    if(temp.contains("LightOn")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
			Event lightOn = createEvent("LightOn", dLay);
			controller.addEvent(lightOn);  
 		    }
                    //gets delay time from file for waterOff, converts
                    // string to long and adds it as parameter for waterOff delay
                    if(temp.contains("WaterOff")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
                        Event waterOff = createEvent("WaterOff", dLay);
                        controller.addEvent(waterOff);
                    }
                    //gets delay time from file for ThermostatDay, converts
                    // string to long and adds it as parameter for ThermostatDay delay
                    if(temp.contains("ThermostatDay")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
                   	Event thermoDay = createEvent("ThermostatDay", dLay);
                        controller.addEvent(thermoDay);

		    }
                    //gets delay time and number of rings from file for Bell, 
                    //converts strings to long and adds it as parameter for Bell 
                    //delay and number of rings
                    if(temp.contains("Bell")){
                        long dLay = 0;
                        long nRings = 0;
                        int count = 1;
                        while(matcher.find()){
                            String inNum = matcher.group();
                            nRings = Long.parseLong(inNum);
                                while(count == 1){
                                dLay = Long.parseLong(inNum);
                                count++;
                            }
                        }

                        if(dLay == nRings)
                            nRings = 1;
                        controller.addEvent(new Bell(dLay,(int)nRings, this.controller));
                    }
                    //gets delay time from file for WaterOn, converts string
                    // to long and adds it as parameter for delayTime.
                    if(temp.contains("WaterOn")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
                	Event waterOn = createEvent("WaterOn", dLay);
                        controller.addEvent(waterOn);   
		    }

                    //gets delay time from file for LightOff, converts string
                    //to long and adds it as parameter for delayTime.
                    if(temp.contains("LightOff")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
                    	Event lightOff = createEvent("LightOff", dLay);
                        controller.addEvent(lightOff);
		    }
                    //gets delay time from file for Terminate, converts string
                    //to long and adds it as parameter for delayTime.
                    if(temp.contains("Terminate")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
			Event terminate = createEvent("Terminate", dLay);
                        controller.addEvent(terminate);
                    }
                    //gets delay time from file for FansOn, converts string
                    //to long and adds it as parameter for delayTime.
                    if(temp.contains("FansOn")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
			Event fansOn = createEvent("FansOn", dLay);
                        controller.addEvent(fansOn);
                    }
                    //gets delay time from file for FansOff, converts string
                    //to long and adds it as parameter for delayTime.
                    if(temp.contains("FansOff")){
                        matcher.find();
                        String inNum = matcher.group();
                        long dLay = Long.parseLong(inNum);
			Event fansOff = createEvent("FansOff", dLay);
                        controller.addEvent(fansOff);
                    }
                }//end while
                sc.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }//end action method
        @Override
        public String toString() {
            return "Restarting system";
        }
    }//end restart class
