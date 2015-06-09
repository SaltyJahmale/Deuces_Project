/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;
import java.util.ArrayList;


/**
 *
 * @author Yusuf
 */
public class KinectController extends J4KSDK{
    float rightHandY, leftHandY, rightShoulderY, leftShoulderY;
    
    float[] handsY = {rightHandY, leftHandY};
    float[] shouldersY = {rightShoulderY, leftShoulderY};
    boolean tracked = false;

    @Override
    public void onDepthFrameEvent(short[] shorts, byte[] bytes, float[] floats, float[] floats1) {
        
    }

    @Override
    public void onColorFrameEvent(byte[] bytes) {
    }

    @Override
    public void onSkeletonFrameEvent(boolean[] blns, float[] floats, float[] floats1, byte[] bytes) {
        handsY = getHandCoordinates();
    }
    public float[] getHandCoordinates(){
        Skeleton[] skeletons = getSkeletons();
        ArrayList a = new ArrayList();

        for(Skeleton s: skeletons){
            if(s.isTracked()){
                a.add(s.getPlayerID(), true);
            }else{
                a.add(s.getPlayerID(), false);
            }
        }
        
        for(int i = 0; i< a.size(); i++){
            if(a.get(i) == (Boolean) true){
                rightHandY = skeletons[i].get3DJointX(skeletons[i].HAND_RIGHT);
                leftHandY = skeletons[i].get3DJointX(skeletons[i].HAND_LEFT);
                
                rightShoulderY = skeletons[i].get3DJointX(skeletons[i].SHOULDER_RIGHT);
                leftShoulderY = skeletons[i].get3DJointX(skeletons[i].SHOULDER_LEFT);
                
                float[] shoulders = {rightShoulderY, leftShoulderY};
                shouldersY = shoulders;
                float[] hands = {rightHandY, leftHandY}; 
                handsY = hands; 
                tracked = skeletons[i].isTracked();
            }       
        }
        return handsY;
    }
    
    public void startKinect() {
        System.out.println("Start Kinect");
        this.start(J4KSDK.SKELETON);  
    }
    
    public static void main(String[] args){
        KinectController kc = new KinectController();
        kc.startKinect();
        while(kc.isInitialized()){
            if(kc.handsY[0] !=0.0)
            System.out.println("Right hand " + kc.handsY[0]);
        }
    }
}
 
    

    
