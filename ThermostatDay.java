import tme3.*;

  public class ThermostatDay extends Event {
	private String thermostat = "Day";
	private long dLay = 0;
        public ThermostatDay(long delayTime) {
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
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

