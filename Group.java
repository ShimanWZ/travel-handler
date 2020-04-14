package Core;
import java.util.ArrayList;

public class Group {
	String name;
	ArrayList<Person> members = new ArrayList<Person>();
	City cityToTravelTo;
	Date timeInitialized = new Date(0,0,0);
	
	public Group(String name, ArrayList<Person> members) {
		this.name = name;
		this.members = members;
		for (Person p : members) {
			p.setInGroup(true);
		}
		TravelHandler.addGroup(this);
	}
	public void setCity(City city, Date date, Date today) {
		if(Date.hasAyearPassed(date ,today)) {
			cityToTravelTo = city;
			timeInitialized = today;
		}
	}
	public void setCity(City city, Date today) {
		if(Date.hasAyearPassed(timeInitialized ,today)) {
			cityToTravelTo = city;
			timeInitialized = today;
		}
	}
	public String toString() {
		return name;
	}
	
	public String groupInfo() {
		String s = "";
		s += "group name: " + name + "\n";
		s += "city to travel: " + cityToTravelTo + "\n\n";
		s+= "members: \n";
		for (Person p : members) {
			s += p.getFirstName() + " " + p.getLastName() + "\n";
		}
		return s;
	}
}
