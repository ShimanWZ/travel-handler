package application;

import Core.Person;
import Core.TravelHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignupControler {
	
	private String firstname, lastname, username, password;
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField userName;
	@FXML private TextField passWord;
	
	public void signup() {
		firstname = firstName.getText();
		lastname = lastName.getText();
		username = userName.getText();
		password = passWord.getText();
		TravelHandler.addMember(new Person(firstname, lastname, username, password));
		Main.window.setScene(Main.signin);
	}
	
}
