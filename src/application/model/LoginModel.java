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
	
	public LoginModel () {
		
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
	
//	public ArrayList<String> getNameArr () {
//		return this.nameArr;
//	}
	
	// stats for each difficulty
	

}
