import tme3.*;

 public class WaterOff extends Event {
	private boolean water = false;
	private long dLay = 0;
        public WaterOff(long delayTime) {
            super(delayTime);
	    dLay = delayTime;
        }
	public void run(){
	sleepEvent(dLay);
	System.out.println(this);
	action();
	}
        public void action() {
            // Put hardware control code here.
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }

