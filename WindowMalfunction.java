import tme3.*;
import tme3.ControllerException;
    // A class that demonstrates a malfunction event. An exception is thrown
    // when the action method is used.
    public class WindowMalfunction extends Event {
	private boolean windowOk = false;
	private int errorCode = 0;
        public WindowMalfunction(long delayTime){
            super(delayTime);
            windowOk = false;
            errorCode = 1;
        }
        public void action()throws ControllerException{
            if(errorCode == 1)
                throw new ControllerException("Window Malfunction!!");
        }
        @Override
        public String toString(){
            return "ErrorCode 1.  Window Malfunction!";
        }
    }

