import tme3.*;
   class Terminate extends Event {
	private long dLay = 0;
        public Terminate(long delayTime) {
            super(delayTime);
	    dLay = delayTime;
        }
	public void run(){
	sleepEvent(dLay);
	System.out.println(this);
	action();
	}
        public void action() {
            System.exit(0);
        }
        public String toString() {
            return "Terminating";
        }
    }
