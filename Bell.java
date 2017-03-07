import tme3.*;

   class Bell extends Event {
       int rings = 1;
        long eventTime;
        public Bell(long delayTime, int rings, Controller c){ 
            super(delayTime);
            this.rings = rings;
	      for(int i=1; i<rings; i++){
 	      c.addEvent(new Bell(delayTime+(2000*i),0,c));
            }

        }
        public void action() {
	}
	public void run(){};
        @Override 
        public String toString() { 
            return "Bing!"; 
        }
    }
