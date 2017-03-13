import tme3.*;
 public class ThermostatNight extends Event {
	private String thermostat = "Day";
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
public void run(){
//	if(System.currentTimeMillis() >= this.eventTime;
		System.out.println(this);
		action();
	}
        public void action() {
            // Put hardware control code here.
            thermostat = "Night";
        }
	public void ready(){};
        public String toString() {
            return "Thermostat on night setting";
        }
    }

