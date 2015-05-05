/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackage;

import edu.ufl.digitalworlds.j4k.J4KSDK;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Yusuf
 */
public class WebViewExample extends javafx.application.Application {
    WebView myBrowser;
    WebEngine myWebEngine;
    StackPane root;
    Button nextPage = new Button("Go to next page");
   
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("java-buddy.blogspot.com");

        myBrowser = new WebView();
        myWebEngine = myBrowser.getEngine();
        myWebEngine.load("http://localhost:8084/INFPRJ078_Prototype/CreateUser.html");
       
        nextPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                URL url;
                try {
                    url = new URL("http://localhost:8084/INFPRJ078_Prototype/ShowTask.jsp");
                    myWebEngine.load(url.toExternalForm());

                } catch (MalformedURLException ex) {
                    Logger.getLogger(WebViewExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        root = new StackPane();
        root.getChildren().add(myBrowser);
        root.getChildren().add(nextPage);
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
        
        /*while(kinect.isInitialized() ){
            if(kinect.handsY[0] >= 0.4){
                URL url = new URL("http://localhost:8084/INFPRJ078_Prototype/ShowTask.jsp");
                myWebEngine.load(url.toExternalForm());
                System.out.println("Inside if");
            }  
        }
                NewClass kinect = new NewClass();
        System.out.println("Start Kinect");
        kinect.start(J4KSDK.SKELETON);*/

        KinectController kinect = new KinectController();
        System.out.println("Start Kinect");
        kinect.start(J4KSDK.SKELETON);
        
        System.out.println("Position: " + kinect.handsY[0]);
   
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
