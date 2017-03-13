import tme3.*;

  public class ThermostatDay extends Event {
	private String thermostat = "Day";
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
	public void run(){
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

