import tme3.*;

class FansOn extends Event {
        private boolean fans = false;
        public FansOn(long delayTime) {
            super(delayTime);
        }
	public void run(){};	
        public void action() {
            fans = true;
        }
        public String toString() {
            return "Fans are on";
        }
}

