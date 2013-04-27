package tool;

import rocket.Rocket;
import rocket.RocketDesigns;


public class KSTool {
	
	public static void main(String args[]) {
		
		Rocket rocket = RocketDesigns.ORBITER_II.getInstance();
		
		rocket.printCharacteristics();
	}
}
