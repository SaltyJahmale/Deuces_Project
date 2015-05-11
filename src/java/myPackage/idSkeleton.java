/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;
import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;
/**
 *
 * @author jahmale
 */
public class idSkeleton extends J4KSDK {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* What needs to be done is the following: 
    get the different joint positions, from different body types, to see if the
    differences are big. Also check if the positions stay the same per skeleton
    */
    public void recognize(){
        Skeleton mySkeleton = getSkeletons()[0];
        
        for(int i = 0; i < mySkeleton.getJointPositions().length; i++){
            System.out.println(mySkeleton.getJointPositions()[i]);
        }
    }
    
    public static void main(String[] args){
        idSkeleton getRecogd = new idSkeleton();
        getRecogd.start(J4KSDK.SKELETON);
        getRecogd.recognize();
    }
}
