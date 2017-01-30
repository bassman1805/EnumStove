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
	
	//Rather than rewrite this a ton in updateTemperature
	public void plusTemp(){
		switch(myTemperature){
			case COLD:
				myTemperature = Temperature.WARM;
				break;
			case WARM:
				myTemperature = Temperature.HOT;
				break;
			case HOT:
				myTemperature = Temperature.BLAZING;
				break;
			default:
				//do nothing
		}
	}
		public void minusTemp(){
			switch(myTemperature){
				case BLAZING:
					myTemperature = Temperature.HOT;
					break;
				case HOT:
					myTemperature = Temperature.WARM;
					break;
				case WARM:
					myTemperature = Temperature.COLD;
					break;
				default:
					//do nothing
			}
		}
	
	//First checks if the timer has run down
	//If it has, checks if the temp matches the setting
	//If it doesn't, check to see if it needs to get hotter or cooler
	//then call plusTemp() or minusTemp()
	//then decide if timer needs to be reset
	public void updateTemperature(){
		if(timer != 0){ //tick down timer if it's not run out
			timer --;
		}
		else{
			switch(mySetting){
				case HIGH:
					if(myTemperature != Temperature.BLAZING){
						//only thing to do here is increase temp
						plusTemp();
						
						if(myTemperature != Temperature.BLAZING){
							this.timer = TIME_DURATION;
						}
					}
					break;
				case MEDIUM:
					if(myTemperature != Temperature.HOT){
						//only time we would decrease temp is if we're at blazing, otherwise increase
						if(myTemperature == Temperature.BLAZING) minusTemp();
						else plusTemp();
						
						if(myTemperature != Temperature.HOT){
							this.timer = TIME_DURATION;
						}
					}
					break;
				case LOW:
					if(myTemperature != Temperature.WARM){
						//only time we would increase temp is if we're at cold, otherwise decrease
						if(myTemperature == Temperature.COLD) plusTemp();
						else minusTemp();
						
						if(myTemperature != Temperature.WARM){
							this.timer = TIME_DURATION;
						}
					}
					break;
				default:
					if(myTemperature != Temperature.COLD){
						//only ever decrease temp to get here
						minusTemp();
						
						if(myTemperature != Temperature.COLD){
							this.timer = TIME_DURATION;
						}
					}
					break;
			}
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
