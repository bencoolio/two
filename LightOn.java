import tme3.*;

   public class LightOn extends Event {
	private boolean light = false;
        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void run(){
              System.out.println(this);
		action();
        }

	public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }
        public String toString() {
            return "Light is on";
        }
    }

