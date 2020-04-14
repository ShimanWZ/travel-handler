package application;

import java.io.IOException;

import Core.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SigninControler {
	private String username= "", password= "";
	private static Person person;
	@FXML private TextField userName;
	@FXML private PasswordField passWord;
	@FXML private Label label = new Label();
	
	
	@FXML
	public void signUp() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
		Main.signup = new Scene(root);
		Main.signup.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.window.setScene(Main.signup);
	}
	
	// to log in
	public void enter() throws IOException {
		userHandler();
		passwordHandler();
		for (Person person : Main.travelWU.getMembers()) {
			if (person.getUsername().equals(username)) {
				Parent main = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
				Main.mainmenu = new Scene(main);
				if (person.getPassword().equals(password)) {
					SigninControler.person = person;
					Main.window.setScene(Main.mainmenu);
				}
				else label.setText("wrong password, try again!");
			}
			else label.setText("you haven't signedup yet");
		}
	}
	
	//to get the user and pass entered in textfields
	private void userHandler() {
		username = userName.getText();
	}
	private void passwordHandler() {
		password = passWord.getText();
	}
	
	
	//to get te person logged into system
	public static Person getPerson() {
		return person;
	}
}
