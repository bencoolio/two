import tme3.*;

class Bell extends Event {
    Restart rs;
    GreenhouseControls f;
    int rings = 1;
    long eventTime;
    long dLay = 0;
    public Bell(long delayTime, int rings, GreenhouseControls c){ 
        super(delayTime);
        this.rings = rings;
	dLay = delayTime;
	f = c;
        for(int i=1; i<rings; i++){
//	    Event light = rs.createEvent("Bell", delayTime+(2000*i),100,c);
//	    Thread b = new Thread(light);
//            b.start();
//	    f.addThread(b);
            //c.addEvent(new Bell(delayTime+(2000*i),0,c));
        }
    }
    public void action() {};
    public void run(){
        sleepEvent(dLay+2000);
	System.out.println(this);
	}
        
    @Override 
    public String toString() { 
        return "Bing!"; 
    }
}
