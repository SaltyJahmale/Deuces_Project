/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;
import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;
import java.util.ArrayList;
/**
 *
 * @author jahmale
 */
public class handMotionControl extends J4KSDK {
    float rightHandY;
    float leftHandY;
    float[] handsY = {rightHandY, leftHandY};
    
    float rightHandX;
    float leftHandX;
    float[] handsX = {rightHandX, leftHandX};
    
    float[] handsToReturn;

    @Override
    public void onDepthFrameEvent(short[] shorts, byte[] bytes, float[] floats, float[] floats1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onColorFrameEvent(byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onSkeletonFrameEvent(boolean[] blns, float[] floats, float[] floats1, byte[] bytes) {
        handsX = trackHands('X');
        handsY = trackHands('Y');
    }
    
    public float[] trackHands(char position){
       Skeleton[] skeletons = getSkeletons();
       ArrayList list = new ArrayList();
       
       for(Skeleton skeleton: skeletons){
           if(skeleton.isTracked()){
               list.add(skeleton.getPlayerID(), true);
           }
           else if(!skeleton.isTracked()){
               list.add(skeleton.getPlayerID(), false);
           }
       }
        
       if(position == 'Y') {
        for(int i = 0; i< list.size(); i++){
             if(list.get(i) == (Boolean) true){
                 rightHandY = skeletons[i].get3DJointY(skeletons[i].HAND_RIGHT);
                 leftHandY = skeletons[i].get3DJointY(skeletons[i].HAND_LEFT);
                 float[] hands = {rightHandY, leftHandY}; 
                 handsY = hands;  
             }
         }
         handsY = handsToReturn;
        }
       
       else if(position == 'X'){
           for(int i = 0; i<list.size(); i++){
               if(list.get(i) == (Boolean) true){
                 rightHandX = skeletons[i].get3DJointX(skeletons[i].HAND_RIGHT);
                 leftHandX = skeletons[i].get3DJointX(skeletons[i].HAND_LEFT);
                 float[] hands = {rightHandX, leftHandX}; 
                 handsX = hands;  
             }
           }
           handsX = handsToReturn;
       }
       
       return handsToReturn;
    }
    
    
    public void startKinect(){
        System.out.println("Starting kinect");
        this.start(J4KSDK.SKELETON);
        System.out.println("Kinect started");
    }
   
}
