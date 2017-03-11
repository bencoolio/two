import tme3.*;

 public class WaterOff extends Event {
	private boolean water = false;
        public WaterOff(long delayTime) {
            super(delayTime);
        }
	public void run(){};
        public void action() {
            // Put hardware control code here.
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }

