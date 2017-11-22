package application.model;

import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;


public class LoginModel {
	
	// profile name (alphabet only)
	private String profileName;
	private File folderName;
	private ArrayList<String> nameArr;
	
	public LoginModel () {
		// init
		this.nameArr = new ArrayList<String>();
		File folderName = new File("src/userFiles");
		
		// get existing user files
		for (String name : folderName.list()) {
			this.nameArr.add(name);
		}
		
		// fill out empty files
		for (int i = 0; i < 4; i++) {
			String fileName = "src/userFiles/user" + i + ".txt";
			File userFile = new File(fileName);
			if (userFile.exists() && !userFile.isDirectory()) {
				break;
			}
			else if (!userFile.exists() && !userFile.isDirectory()) {
				try {
					userFile.createNewFile();
					this.nameArr.add("empty " + i);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void organize () throws IOException {
		
		
		// stats class
//		if (fileName.exists() && !fileName.isDirectory()) {
//			
//		}
//		else if (!fileName.exists() && !fileName.isDirectory()) {
//			
//		}
//		else {
//			System.out.println("This should really be a file");
//		}
	}
	
	public void update(String inputText) {
		this.profileName = inputText;
		
		try {
			this.organize();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<String> getNameArr () {
		return this.nameArr;
	}
	
	// stats for each difficulty
	

}
