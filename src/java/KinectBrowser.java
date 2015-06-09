
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
        JTextField textfield = new JTextField();

        
        // Don't forget to change the links, to make the program work
        final static String WEBPAGE_HOME = "http://localhost:8084/INFPRJ078_WEBAPP/index.jsp";
        final static String WEBPAGE_REGISTRATION = "http://localhost:8084/INFPRJ078_WEBAPP/registration.jsp";

        final static String WEBPAGE_CREATE_TASK = "http://localhost:8084/INFPRJ078_WEBAPP/create_task.jsp";
        final static String WEBPAGE_SHOW_TASK = "http://localhost:8084/INFPRJ078_WEBAPP/show_task.jsp";

        
        LinkedList<String> links = new LinkedList<>();
 
        // Create the JFrame and start the Kinect Skeleton sensor
        public void create(){
            links.add(WEBPAGE_HOME);
            links.add(WEBPAGE_REGISTRATION);
            links.add(WEBPAGE_CREATE_TASK);
            links.add(WEBPAGE_SHOW_TASK);
            
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(browserView, BorderLayout.CENTER);
            frame.add(textfield, BorderLayout.SOUTH);
            frame.setSize(800, 700);
            frame.setLocationRelativeTo(null);
            browser.loadURL(WEBPAGE_HOME);
            frame.setVisible(true);
            kinect.startKinect();
        }  
        
    // Get the Y-coordinates of the left and right hand and control web page
    public void controlPage() throws InterruptedException{
        // Without this while statement the kinect will shut off immediately
        int counter = 0;
        while(kinect.isInitialized()){
            // Give the web browser time to process the url loading
            if(kinect.tracked){
                try{
                    textfield.setText(String.valueOf(kinect.handsY[0]));
                    Thread.sleep(1000); 

                    if(kinect.handsY[0] >= 3*kinect.shouldersY[0]){
                        counter++;
                        if(counter>4){
                            counter = 0;
                        }
                        browser.loadURL(links.get(counter));
                        System.out.println("page " + counter);
                    }

                    else if(kinect.handsY[1] <= 3*kinect.shouldersY[1]){
                        counter--;
                        if(counter<0){
                            counter = 4;
                        }
                        browser.loadURL(links.get(counter));
                        System.out.println("page " + counter);
                    }
                }
                catch(Exception e){}                                                               
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        KinectBrowser bs = new KinectBrowser();
        bs.create();
        bs.controlPage();        
    }
}