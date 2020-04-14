package application;

import java.io.IOException;
import java.util.ArrayList;

import Core.City;
import Core.Date;
import Core.Group;
import Core.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainPageControler {
	private Person person = SigninControler.getPerson();
	private ArrayList<Person> people = new ArrayList<Person>();
	@FXML private Label name;
	@FXML private Label lastName;
	@FXML private Label userName;
	@FXML private Label groupName;
	@FXML private Label info;
	@FXML private ChoiceBox<Group> groups;
	@FXML private ChoiceBox<Person> validPeople;
	@FXML private ChoiceBox<City> cities;
	@FXML private TextField newGroupName;
	@FXML private AnchorPane pane;
	
	//------------------------------initializing pages' info-------------------------------//
	@FXML
	private void ChoiceboxInitilize() {
		for(Group group : Main.travelWU.getGroups()) {
			groups.getItems().add(group);
		}
	}
	@FXML
	private void userInit() {
		name.setText(person.getFirstName());
		lastName.setText(person.getLastName());
		userName.setText(person.getUsername());
		if (person.getGroup() != null) groupName.setText(person.getGroup().toString());
	}
	@FXML
	private void loadInfo() {
		if (person.getGroup() != null ) info.setText(person.getGroup().groupInfo());
	}
	//---------------------------gets the value chosen in choice box and add person to the group selected
	public void addToGroup() {
		person.addGroup(groups.getValue(), Date.getToday());
	}
	//-----------------------------------button handler---------------------------------------------//
	public void userInfo() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));
		Main.userInfo = new Scene(root);
		Main.window.setScene(Main.userInfo);
	}
	public void joinGroup() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("joinGroup.fxml"));
		Main.joinGroup = new Scene(root);
		Main.window.setScene(Main.joinGroup);
	}
	public void addNewGroup() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreateGroup.fxml"));
		Main.newGroup = new Scene(root);
		Main.window.setScene(Main.newGroup);
	}
	public void goupInfo() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("GroupInfo.fxml"));
		Main.groupInfo = new Scene(root);
		Main.window.setScene(Main.groupInfo);
	}
	public void loadValidCitiesAndPeople() {
		for (Person person : Main.travelWU.getMembers()) {
			if (!person.isInGroup()) validPeople.getItems().add(person);
		}
		for(City city : City.values()) {
			cities.getItems().add(city);
		}
	}
	public void groupCreationDone() {
		Group newGroup = new Group(newGroupName.getText(),people);
		newGroup.setCity(cities.getValue(), Date.getToday());
	}
	public void addPersonToGroup() {
		people.add(this.validPeople.getValue());
	}
}
