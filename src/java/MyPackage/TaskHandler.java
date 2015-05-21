import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class TaskHandler {

	private URI youtubeUrl;
	private String searchQuery;
	private URI googleUrl;
	private String localMainMusicPath;
	private String localMainVideoPath;
	private FileFinder filefinder = null;
	private String song;	 
	
	public TaskHandler() {
		this.filefinder = new FileFinder();
		this.searchQuery = "";
		this.youtubeUrl = URI.create("https://www.youtube.com/watch?v=S_xH7noaqTA&list=RDS_xH7noaqTA#t=5");
		this.googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
		this.localMainMusicPath = "C:\\Users\\sharelison\\Music\\";
		this.localMainVideoPath = "C:\\Users\\sharelison\\Videos\\";
		this.song = "Dreams.mp3";	
	}
	
	public TaskHandler(String mainMusicPath, String mainVideoPath) {
		this.filefinder = new FileFinder();
		this.searchQuery = "";
		this.youtubeUrl = URI.create("https://www.youtube.com/watch?v=S_xH7noaqTA&list=RDS_xH7noaqTA#t=5");
		this.googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
		this.localMainMusicPath = mainMusicPath;
		this.localMainVideoPath = mainVideoPath;
		this.song = "Dreams.mp3";	
	}
	
	public void playYoutube() {
		Desktop d = Desktop.getDesktop();
		if (d != null && d.isSupported(Desktop.Action.BROWSE)) {
			try {
				d.browse(youtubeUrl);
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Exception at playYoutube");
			}
		}
	}
	
	public void searchGoogle(String query) {
		updateGoogleUrl(query);
		Desktop d = Desktop.getDesktop();
		if (d != null && d.isSupported(Desktop.Action.BROWSE)) {
			try {
				d.browse(googleUrl);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void playSong(String songName) {
		song = songName;
		if(!filefinder.hasExtension(songName)) {
			song = filefinder.findFile(songName, localMainMusicPath);
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
	
	public void playVideo(String video) {			
		if(!filefinder.hasExtension(video)){
			video = filefinder.findFile(video, localMainVideoPath);
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
	
	/*
	 * Can open any local file.
	 * 
	 */
	public void openFileAtPath(String filepath) {
	    File file = new File(filepath);
		if(!filefinder.hasExtension(filepath)){
			file = prepareFile(filepath);
		} 
		
		Desktop d = Desktop.getDesktop();
		if(d != null && d.isSupported(Desktop.Action.OPEN)) {
			try {
				d.open(file);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void setYoutubeUrl(String url) {
		this.youtubeUrl = URI.create(url);
	}
	
	public void setMusicMainPath(String path) {
		localMainMusicPath = path;
	}
	
	public void setVideoMainPath(String path) {
		localMainVideoPath = path;
	}
	
	public String getYoutubeUrl() {
		return this.youtubeUrl.toString();
	}
	
	public String getMusicMainPath() {
		return localMainMusicPath;
	}
	
	public String getVideoMainPath() {
		return localMainVideoPath;
	}
	
	private void updateGoogleUrl(String query) {
		query = query.replace(" ", "+");
		searchQuery = query;
		googleUrl = URI.create("https://www.google.nl/search?q=" + searchQuery + "&oq=" + searchQuery);
	}
	
	private File prepareFile(String absolutePath) {
		absolutePath = absolutePath.replace("\\", "/");
 		int lastCharOfPath = absolutePath.lastIndexOf("/");
 		String filename = absolutePath.substring(lastCharOfPath + 1);
 		String path = absolutePath.substring(0, lastCharOfPath + 1);
 		File file = new File(path + filefinder.findFile(filename, path));
		return file;
	}
	
	private class FileFinder {
		
		public boolean isMp3(String songName) {
			if (songName.substring(songName.length() - 4).equals(".mp3")) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean hasExtension(String filename) {
			if(filename.substring(filename.length() - 4, filename.length() - 3).equals(".")) {
				return true;
			} else {
				return false;
			}
		}
		
		public String findFile(String nameFile, String path) {
			File dir = new File(path);
			File[] dirFiles = dir.listFiles();
			for (File file : dirFiles) {
				try {
				String filename = file.getName();
				String baseName = filename.substring(0, filename.length() - 4);
				if(baseName.equals(nameFile)) {
					return filename;
				}
				} catch(IndexOutOfBoundsException e) {
					continue;
				}
			}
			return nameFile;
		}
	}
}

