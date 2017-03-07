import tme3.*;

    public class LightOff extends Event {
	private boolean light = false;
        public LightOff(long delayTime) { 
            super(delayTime); 
        }
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }

	public void run(){};
        public String toString() { 
            return "Light is off";
        }
    }

