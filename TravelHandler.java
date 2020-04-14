package Core;
import java.util.ArrayList;

public class TravelHandler {
	private static ArrayList<Group> groups = new ArrayList<Group>();
	private static ArrayList<Person> members = new ArrayList<Person>();
	
	public ArrayList<Person> getMembers() {
		return members;
	}
	public ArrayList<Group> getGroups(){
		return groups;
	}
	public static void addMember(Person person) {
		members.add(person);
	}
	public static void addGroup(Group group) {
		groups.add(group);
	}


}
