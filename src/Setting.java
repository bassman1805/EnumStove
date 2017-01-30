
public enum Setting {
	OFF ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH("+++");
	private String value;
	
	Setting(String value_){
		value = value_;
	}
	
	public String toString(){
		return value;
	}
	
}
