import tme3.*;

class FansOn extends Event {
        private boolean fans = false;
        public FansOn(long delayTime) {
            super(delayTime);
        }
	public void run(){
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

