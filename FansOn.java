import tme3.*;

class FansOn extends Event {
        private boolean fans = false;
	private long dLay = 0;
        public FansOn(long delayTime) {
            super(delayTime);
	    dLay = delayTime;
        }
	public void run(){
	sleepEvent(dLay);
	System.out.println(this);
	action();
	}	
        public void action() {
            fans = true;
        }
        public String toString() {
            return "Fans are on";
        }
}

