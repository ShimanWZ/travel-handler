package Core;

public class Person {
	private String firstName, lastName, username, password;
	private Group group;
	private Date timeAddedToGroup = new Date(0,0,0);
	private boolean isInGroup = false;
	
	public Person(String firstName,String lastName,String username,String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		TravelHandler.addMember(this);
	}
	
	public void addGroup(Group group, Date today) {
		if(isValidToBeAddedInGp(today)) {
		this.group = group;
		isInGroup = true;
		timeAddedToGroup = today;
		}
	}
	private boolean isValidToBeAddedInGp(Date today) {
		if (Date.hasAyearPassed(this.timeAddedToGroup, today)) return true;
		else return false;
	}
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	//---------------------getters and setters---------------------------//	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getTimeAddedToGroup() {
		return timeAddedToGroup;
	}

	public void setTimeAddedToGroup(Date timeAddedToGroup) {
		this.timeAddedToGroup = timeAddedToGroup;
	}
	public void setInGroup(boolean b) {
		this.isInGroup = b;
	}
	public boolean isInGroup() {
		return isInGroup;
	}
}
