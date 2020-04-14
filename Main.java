package application;
	
import java.util.ArrayList;
import Core.City;
import Core.Date;
import Core.Group;
import Core.Person;
import Core.TravelHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage window;
	public static Scene signup, signin, mainmenu, userInfo, joinGroup, newGroup, groupInfo;
	public static TravelHandler travelWU = new TravelHandler();
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
			signin = new Scene(root);
			signin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setScene(signin);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		initializeApp();
		launch(args);
	}
	
	
	
	
	private static void initializeApp() {
		Person p1 = new Person("saba", "lastName", "username", "password");
		Person p2 = new Person("sara", "lastName", "username", "password");
		Person p3 = new Person("sahar", "lastName", "username", "password");
		Person p4 = new Person("maryam", "lastName", "username", "password");
		Person p5 = new Person("bita", "lastName", "username", "password");
		Person p6 = new Person("poone", "lastName", "username", "password");
		Person p7 = new Person("nika", "lastName", "username", "password");
		Person p8 = new Person("shaya", "lastName", "username", "password");
		
		ArrayList<Person> gp1 = new ArrayList<Person>();
		gp1.add(p1);
		gp1.add(p2);
		
		ArrayList<Person> gp2 = new ArrayList<Person>();
		gp2.add(p3);
		gp2.add(p4);
		
		Group grp1 = new Group("gp1", gp1);
		grp1.setCity(City.BOSTON,new Date(2018, 2, 12), Date.getToday());
		grp1.setCity(City.CARACAS, Date.getToday()); //it wont set it to caracas cause the time limit is not passed
		System.out.println(grp1);
		Group grp2 = new Group("gp2", gp2);
		grp2.setCity(City.BOSTON, new Date(2018, 2, 13), Date.getToday());
		System.out.println(grp2);

	}
}
