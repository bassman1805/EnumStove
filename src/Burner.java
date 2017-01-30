public class Burner {
	public enum Temperature{BLAZING, HOT, WARM, COLD};
	
	public static final int TIME_DURATION = 2;
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	public Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	public void plusButton(){
		switch(mySetting){
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			default:
				//do nothing
		}
	}
	public void minusButton(){
		switch(mySetting){
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			default:
				//do nothing
		}
	}
	
	public Temperature getTemp(){
		return myTemperature;
	}

}
