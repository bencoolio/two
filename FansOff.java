import tme3.*;

 class FansOff extends Event {
        private boolean fans = false;
	private long dLay = 0;
        public FansOff(long delayTime) {
            super (delayTime);
	    dLay = delayTime;
        }
	public void run(){
	    sleepEvent(dLay);
	    System.out.println(this);
	    action();
	}
        public void action() {
            fans = false;
        }
        public String toString() {
            return "Fans are off";
        }
    }


