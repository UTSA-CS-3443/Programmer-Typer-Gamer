package application.model;

import java.io.*;


public class LoginModel {
	
	// profile name (alphabet only)
	private String profileName;
	
	public LoginModel (String inputName) {
		this.profileName = "../../userFiles/" +  inputName;
	}
	
	public void organize () throws IOException {
		File fileName = new File(this.profileName);
		
		if (fileName.exists() && !fileName.isDirectory()) {
			
		}
		else if (!fileName.exists() && !fileName.isDirectory()) {
			
		}
		else {
			System.out.println("This should really be a file");
		}
	}
	
	// stats for each difficulty

}
