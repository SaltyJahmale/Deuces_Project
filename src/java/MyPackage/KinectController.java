/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackage;

import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;
import java.util.ArrayList;


/**
 *
 * @author Yusuf
 */
public class KinectController extends J4KSDK{
    float rightHandY;
    float leftHandY;
    float[] handsY = {rightHandY, leftHandY};

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
                rightHandY = skeletons[i].get3DJointY(skeletons[i].HAND_RIGHT);
                leftHandY = skeletons[i].get3DJointY(skeletons[i].HAND_LEFT);
                float[] hands = {rightHandY, leftHandY}; 
                handsY = hands;  
            }
        
        }
        return handsY;
    }
    
    public void startKinect() {
        System.out.println("Start Kinect");
        this.start(J4KSDK.SKELETON);  
    }
}
 
    

    
