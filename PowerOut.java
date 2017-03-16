import tme3.*;
    // A class that demonstrates a malfunction event. An exceptino is thrown
    // when the action method is used.
   class PowerOut extends Event {
  	private boolean powerOn = true;
	private long dLay = 0;
	Controller x = new Controller();
	Controller.ControllerException y = x.new ControllerException("");
	protected int errorCode = 0;
        public PowerOut(long delayTime){
            super(delayTime);
            powerOn = false;
            errorCode = 2;
	    dLay = delayTime;
        }
        public void action()throws Controller.ControllerException{
            if(errorCode == 2)
               throw y;	
        }
        public void run(){
	    sleepEvent(dLay);
	    System.out.println(this);
	    try{ 
                action();
            }catch(Exception e){
            }
	}
        @Override
        public String toString(){
            return "ErrorCode 2. Power is out!";
        }
    }

