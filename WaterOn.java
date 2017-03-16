import tme3.*;

    public class WaterOn extends Event {
	private boolean water = false;
	private long dLay = 0;
        public WaterOn(long delayTime) { 
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
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }

