import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import com.oracle.jrockit.jfr.DataType;

import javazoom.jl.player.Player;


public class TaskHandler {

	private URI youtubeUrl = URI.create("https://www.youtube.com/watch?v=S_xH7noaqTA&list=RDS_xH7noaqTA");
	private String searchQuery = "";
	private URI googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
	private String mainPath = "C:\\Users\\sharelison\\Music\\";
	private String song = "Dreams.mp3";	    
	
	public void playYoutube() {
		//Desktop d = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		Desktop d = Desktop.getDesktop();
		if (d != null && d.isSupported(Desktop.Action.BROWSE)) {
			try {
				d.browse(youtubeUrl);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void searchGoogle(String query) {
		searchQuery = query;
		updateGoogleUrl();
		//Desktop d = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		Desktop d = Desktop.getDesktop();
		if (d != null && d.isSupported(Desktop.Action.BROWSE)) {
			try {
				d.browse(googleUrl);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void playMusic() {
		try {    
			String songFile = mainPath + song;
	        FileInputStream in = new FileInputStream(new File(songFile));
	        Player playMp3 = new Player(in);	        
	        System.out.println("playing...");
	        playMp3.play();
			System.out.println("played song successfully!");

		} catch(Exception e) {
	        System.out.println("songFile");

			e.printStackTrace();
		}
	}
	
	public void playSongAtPath(String songPath) {	
     FileInputStream fileInStream;
	 try {
		if(isMp3(songPath)) {
	        fileInStream = new FileInputStream(new File(songPath));
		} else {
			fileInStream = new FileInputStream(new File(songPath + ".mp3"));
		}
		
        Player playMp3 = new Player(fileInStream);	        
        System.out.println("playing...");
        playMp3.play();
		System.out.println("played song successfully!");

	 } catch(Exception e) {
        System.out.println("songFile");
		e.printStackTrace();
	 }
	
	}
	
	public void setUrl(String url) {
		this.youtubeUrl = URI.create(url);
	}
	
	public void updateGoogleUrl() {
		googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
	}
	
	public void setSong(String songName) {
		if (isMp3(songName)) {
			song = songName;
		} else {
			song = songName + ".mp3";
		}
	}
	
	public void setMainPath(String path) {
		mainPath = path;
	}
	
	private boolean isMp3(String songName) {
		if (songName.substring(songName.length() - 4).equals(".mp3")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void playVideo(String videoUrl) {
			Desktop d = Desktop.getDesktop();
			if(d.isSupported(Desktop.Action.BROWSE)) {
				
				try {
					URI url = new URI(videoUrl);
					d.browse(url);

				} catch(Exception e) {
					e.printStackTrace();

				}
			}
	}
}

