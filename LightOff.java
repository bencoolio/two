import tme3.*;

    public class LightOff extends Event {
	private boolean light = false;
        public LightOff(long delayTime) { 
            super(delayTime); 
        }

	public void run(){
	System.out.println(this);
	action();
	}
	
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }

        public String toString() { 
            return "Light is off";
        }
    }

