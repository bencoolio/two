import tme3.*;

    public class WaterOn extends Event {
	private boolean water = false;
        public WaterOn(long delayTime) { 
            super(delayTime); 
        }
	public void run(){};
        public void action() {
            // Put hardware control code here.
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }

