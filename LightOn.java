import tme3.*;

public class LightOn extends Event {
    private boolean light = false;
    private long dLay = 0;

    public LightOn(long delayTime) {
        super(delayTime);
        dLay = delayTime;
    }
   
    public void run(){      
	sleepEvent(dLay); 
	System.out.println(this);
	action();
    }

    public void action() {
        // Put hardware control code here to
        // physically turn on the light.
        light = true;
    }

    public String toString() {
        return "Light is on";
    }
}

