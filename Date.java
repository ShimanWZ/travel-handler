package Core;


public class Date {
	private int year, day, month;
	static private Date today = new Date(2020, 4, 14);
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public static boolean hasAyearPassed(Date first, Date last) {
		int days;
		if (last.getYear() - first.getYear() <= 0) return false;
		else if (last.getYear() - first.getYear() >= 2) return true;
		else {
			int totDays;
			int year1Days = (last.getMonth() - 1 ) * 30 + last.day;
			int year2Days = (12 -first.getMonth()) *30 + first.getDay();
			totDays = year1Days + year2Days;
			if (totDays >=356) return true;
			else return false;
		}
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public static Date getToday() {
		return today;
	}

	public static void setToday(Date today) {
		Date.today = today;
	}
}
