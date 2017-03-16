//: innerclasses/controller/Event.java
// The common methods for any control event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @author: Sean Connelly
 * @date  : Jan. 30, 2017
 *
 * Description: Event abstract class
 *
 */

package tme3;
import java.io.*;
import java.io.Serializable;

public abstract class Event implements Runnable{
    public long eventTime;
    public final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() { // Allows restarting
        eventTime = System.currentTimeMillis() + delayTime;
    }
    public boolean ready(long offset) {
        return System.currentTimeMillis() >= eventTime + offset;
    } 
    public void sleepEvent(long dLay){
        long start, end, slept;
        boolean interrupted = false;

        while(dLay > 0){
            start=System.currentTimeMillis();
            try{
                Thread.sleep(dLay);
                break;
            }catch(InterruptedException e){
                //work out how much more time to sleep for
                end=System.currentTimeMillis();
                slept=end-start;
                dLay-=slept;
                interrupted=true;
            }
        }
        if(interrupted){
            //restore interruption before exit
            Thread.currentThread().interrupt();
        }
	
    }
    
    public abstract void action()throws Controller.ControllerException;
} ///:~i
