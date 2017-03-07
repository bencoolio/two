import tme3.*;

 class FansOff extends Event {
        private boolean fans = false;
        public FansOff(long delayTime) {
            super (delayTime);
        }
        public void action() {
            fans = false;
        }
        public String toString() {
            return "Fans are off";
        }
    }


