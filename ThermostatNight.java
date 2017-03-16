import tme3.*;
 public class ThermostatNight extends Event {
	private String thermostat = "Day";
	private long dLay = 0;
        public ThermostatNight(long delayTime) {
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
            thermostat = "Night";
        }
	public void ready(){};
        public String toString() {
            return "Thermostat on night setting";
        }
    }

