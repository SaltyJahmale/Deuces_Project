/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.util.ArrayList;

/**
 *
 * @author jahmale
 */
public class trackingSystem {
    handMotionControl kinect = new handMotionControl();
    
    public void trackMovement(){
        kinect.startKinect();
        ArrayList list = new ArrayList();
        
        while(kinect.isInitialized()){
            // the closer your hand is to your waist, the closer the float will
            //be to 0
            try{
                Thread.sleep(1000);
                System.out.println("leftX: "+kinect.leftHandX);
                list.add(kinect.leftHandX);
                if(list.size()== 20){
                    System.exit(0);
                }
            }
            catch(Exception e){}                                                   
        }
    }
    
    public void swypeLeft(){
        float lastX = 0;
        float currentX;
        kinect.startKinect();
        /*if leftX is smaller than 0.1 but bigger than 0.02 it is in the middle 
           far left is in the minus, so, if leftX is smaller than -.4
                    but bigger than -.6 it is far left
            the swipe movement will be as follows:
            every thread it will remember the last leftX, 
        if last leftX was smaller than 0.1 but bigger than 0.02
	&&
	if current leftX is smaller than -.4 but bigger than -.6
		System.out.println("swipe initiated");
        */
        while(kinect.isInitialized()){
            // the closer your hand is to your waist, the closer the float will
            //be to 0
            try{
                Thread.sleep(1000);
                //first thing to do: check current and last
                //////////System.out.println("current leftX: "+kinect.leftHandX);
                if(lastX != 0.0){
                    if(lastX < 0.2 && lastX> 0.02){
                        System.out.println("step 1");
                        if(kinect.leftHandX < -.4 && kinect.leftHandX > -.6)
                            System.out.println("Swype has been initiated");
                    }
                }
                //this automatically updates the list
                lastX=(kinect.leftHandX);
            }
            catch(Exception e){}                                                   
        }
    }
    
    public static void main(String[] args){
        trackingSystem hub = new trackingSystem();
        //hub.trackMovement();
        hub.swypeLeft();
    }
}
