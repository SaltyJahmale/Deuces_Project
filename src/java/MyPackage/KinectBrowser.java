package MyPackage;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;


public class KinectBrowser extends JFrame{
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        KinectController kinect = new KinectController();
        JFrame frame = new JFrame();
        
        final static double LOWER_LIMIT_VALUE = 0.2;
        final static double MIDDLE_LIMIT_VALUE = 0.4;
        final static double UPPER_LIMIT_VALUE = 0.6;
        
        // Don't forget to change the links, to make the program work
        final static String WEBPAGE_HOME = "http://localhost:8084/INFPRJ078_Prototype/CreateUser.html";
        final static String WEBPAGE_DASHBOARD = "http://localhost:8084/INFPRJ078_Prototype/ShowTask.jsp";
        final static String WEBPAGE_NEW_TASK = "http://localhost:8084/INFPRJ078_Prototype/CreateTask.jsp";
        
        LinkedList<String> links = new LinkedList<>();

        // Create the JFrame and start the Kinect Skeleton sensor
        public void create(){
            links.add(WEBPAGE_HOME);
            links.add(WEBPAGE_DASHBOARD);
            links.add(WEBPAGE_NEW_TASK);
            
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(browserView, BorderLayout.CENTER);
            frame.setSize(800, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            browser.loadURL("http://localhost:8084/INFPRJ078_Prototype/ShowTask.jsp");
            kinect.startKinect();

        }
        
       
        
    // Get the Y-coordinates of the left and right hand and control web page
    public void controlPage(){
        
        // Without this while statement the kinect will shut off immediately
        while(kinect.isInitialized()){
            // Give the web browser time to process the url loading
            try{
                Thread.sleep(2000); 
                if(kinect.handsY[0] >= UPPER_LIMIT_VALUE){
                    browser.loadURL(links.get(2));
                    System.out.println("Third page");
                    break;   
                }
                else if(kinect.handsY[0] >=LOWER_LIMIT_VALUE &&kinect.handsY[0] < MIDDLE_LIMIT_VALUE){
                    browser.loadURL(links.get(0));
                    System.out.println("First page");
                    break;   
                }
                else if(kinect.handsY[0] >=MIDDLE_LIMIT_VALUE &&kinect.handsY[0] <UPPER_LIMIT_VALUE){       
                    browser.loadURL(links.get(1));
                    System.out.println("Second page");
                    break;   
                }
            }
            catch(Exception e){}                                                   
        }
        controlPage();
    }
    
    public static void main(String[] args) {
        KinectBrowser bs = new KinectBrowser();
        bs.create();
        bs.controlPage();
        
    }
}