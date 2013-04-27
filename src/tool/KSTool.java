package tool;

import parts.Cockpit;
import parts.Engine;
import parts.FuelTank;
import parts.Miscellaneous;
import rocket.Rocket;
import rocket.RocketSection;


public class KSTool {
	
	static Rocket rocket;
	static RocketSection cockpit, topControl, mainFuelTanks, auxFuelTanks;
	
	public static void main(String args[]) {
		
		cockpit = new RocketSection.Builder()
			.addPart(Cockpit.MK1_2_COMMAND_POD)
			.addPart(Miscellaneous.MK16_PARACHUTE)
			.build();
		
		topControl = new RocketSection.Builder()
			.addPart(Miscellaneous.TR_18A_STACK_DECOUPLER)
			.addPart(Miscellaneous.ADVANCED_SAS_MODULE)
			.addPart(FuelTank.FL_R25_RCS_FUEL_TANK)
			.addPart(Miscellaneous.RV_105_RCS_THRUSTER_BLOCK, 4)
			.build();
		
		mainFuelTanks = new RocketSection.Builder()
			.addPart(FuelTank.FL_T400_FUEL_TANK, 3)
			.addPart(Engine.LV_T30_LIQUID_FUEL_ENGINE)
			.build();
		
		auxFuelTanks = new RocketSection.Builder()
			.addPartSet(mainFuelTanks.getParts())
			.addPart(Miscellaneous.TT_38K_RADIAL_DECOUPLER)
			.build();
		
		rocket = new Rocket.Builder()
			.addName("Orbiter II")
			.addSection(cockpit)
			.addSection(topControl)
			.addSection(mainFuelTanks)
			.addSection(auxFuelTanks, 6)
			.build();
		
		rocket.printCharacteristics();
	}
}
