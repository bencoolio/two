import tme3.*;
   class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
	public void run(){
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
