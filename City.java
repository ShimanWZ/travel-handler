package Core;

public enum City {
	SEATTLE("Seatle", Country.USA){
	},
	BOSTON("Boston", Country.USA){
	},
	MIAMI("Miami", Country.USA){
	},
	NEWYORKCITY("NewYork", Country.USA){
	},
	CHICAGO("Chicago", Country.USA){
	},
	SANJOSE("Sanjose", Country.COSTARICA){
	},
	MONTEVERDE("Monteverde", Country.COSTARICA){
	},
	DOMINICAL("Dominical", Country.COSTARICA){
	},
	TAMARINDO("Tamarindo", Country.COSTARICA){
	},
	CARACAS("Caracas", Country.VENEZUELA){
	},
	MERIDA("Merida", Country.VENEZUELA){
	},
	REYKJAVIK("Reyjavik", Country.ICELAND){
	};

	
	City(String string, Country country) {
		this.string = string;
		this.country = country;
	}
	
	private String string;
	private Country country;
	public String toString() {
		return string +"-" + country;
	}
}
