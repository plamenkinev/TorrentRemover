package com.plamenkinev.torrentremover;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TorrentRemover {
	
	private String path;
	
	public TorrentRemover(String path) {
		this.path = path;
	}
	
	public File[] getFiles() {
		
		File file = new File(path);
		
		if (file.isDirectory()){
			File[] allFiles = file.listFiles();
			return allFiles;
		}
		
		System.out.println("Not a directory or the directory does not exist.");
		return null;
	}
	
	public void deleteTorrentFiles() {
		
		for (File file : getFiles()) {
			if (file.getName().contains(".torrent")) {
				String fileName = file.getName();
				if (file.delete())
					System.out.println(fileName + " was deleted successfully.");
				else 
					System.out.println("There was a problem deleting " + fileName);
			}
		}
	}
	
	public static void main(String[] args) {
		
		TorrentRemover tr;
		
		if (args.length == 1) {
			 tr = new TorrentRemover(args[0]);
			 tr.deleteTorrentFiles();
			 System.out.println("All torrent files removed successfully.");
			 }
		
		else {
//			try {
				tr = new TorrentRemover(JOptionPane.showInputDialog(null, "Select directory",
						"C:\\Users\\Plamen\\Downloads"));
				tr.deleteTorrentFiles();
				JOptionPane.showMessageDialog(null, "All torrent files removed successfully.");
//				}
		}

	}

}
