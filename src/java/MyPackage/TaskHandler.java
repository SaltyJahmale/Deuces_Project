import java.awt.Desktop;
import java.io.File;
import java.net.URI;


public class TaskHandler {

private URI youtubeUrl = URI.create("https://www.youtube.com/watch?v=S_xH7noaqTA&list=RDS_xH7noaqTA");
	private String searchQuery = "";
	private URI googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
	private String localMainMusicPath = "C:\\Users\\sharelison\\Music\\";
	private String localMainVideoPath = "C:\\Users\\sharelison\\Videos\\";
	private String song = "Dreams.mp3";	 
	
	public void playYoutube() {
		//Desktop d = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		Desktop d = Desktop.getDesktop();
		if (d != null && d.isSupported(Desktop.Action.BROWSE)) {
			try {
				d.browse(youtubeUrl);
			} catch(Exception e) {
				System.out.println("Exception at playYoutube");
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
	
	//set to only play mp3 files
	public void playSong(String songName) {
		if(!isMp3(songName)) {
			song = songName + ".mp3";
		}
		
		Desktop d = Desktop.getDesktop();
		try {
			if(d != null && d.isSupported(Desktop.Action.OPEN)) {
				d.open(new File(localMainMusicPath + song));
			}
		} catch(Exception e) {
			System.out.println("Exception at playSong");
			e.printStackTrace();
		}
	}
	
	//set to only play mp3 files
	public void playSongAtPath(String songPath) {	
	     File file;
		 try {
			if(isMp3(songPath)) {
		        file = new File(songPath);
			} else {
				file = new File(songPath + ".mp3");
			}
			
			Desktop d = Desktop.getDesktop();
			if (d != null && d.isSupported(Desktop.Action.OPEN)) {
				d.open(file);
			}

		 } catch(Exception e) {
	        System.out.println("Exception at playSongAtPath");
			e.printStackTrace();
		 }
		
	}
	
	public void playVideo(String video) {	
		
		/* videonames without given extension(videoname instead of videoname.mp4) can only be played if it's an mp4 file
		 * otherwise exception raised.
		 */		
		if(!hasExtension(video)){
			video = video + ".mp4";
		} 
		
		Desktop d = Desktop.getDesktop();
		if(d != null && d.isSupported(Desktop.Action.OPEN)) {
			try {
				File file = new File(localMainVideoPath + video);
				d.open(file);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void playVideoAtPath(String videoUrl) {
			/* videonames without given extension(videoname instead of videoname.mp4) can only be played if it's an mp4 file
			 * otherwise exception raised.
			 */		
			if(!hasExtension(videoUrl)){
				videoUrl = videoUrl + ".mp4";
			} 
			
			Desktop d = Desktop.getDesktop();
			if(d != null && d.isSupported(Desktop.Action.OPEN)) {
				try {
					File file = new File(videoUrl);
					d.open(file);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	private boolean isMp3(String songName) {
		if (songName.substring(songName.length() - 4).equals(".mp3")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setYoutubeUrl(String url) {
		this.youtubeUrl = URI.create(url);
	}
	
	private void updateGoogleUrl() {
		googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
	}
	
	public void setMusicMainPath(String path) {
		localMainMusicPath = path;
	}
	
	public void setVideoMainPath(String path) {
		localMainVideoPath = path;
	}
	
	private boolean hasExtension(String filename) {
		if(filename.substring(filename.length() - 4, filename.length() - 3).equals(".")) {
			return true;
		} else {
			return false;
		}
	}
	
}

