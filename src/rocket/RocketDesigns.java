package rocket;

import parts.Cockpit;
import parts.Engine;
import parts.FuelTank;
import parts.Miscellaneous;


public enum RocketDesigns {
	ORBITER_II(getInstanceOrbiterII());
	
	Rocket design;
	
	private RocketDesigns(Rocket design) {
		this.design = design;
	}
	
	public Rocket getInstance() {
		return design;
	}
		
	private static Rocket getInstanceOrbiterII() {
		
		Rocket orbiterII;
		RocketSection cockpit, topControl, mainFuelTanks, auxFuelTanks;
		String name = "OrbiterII";

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
		
		orbiterII = new Rocket.Builder()
			.addName(name)
			.addSection(cockpit)
			.addSection(topControl)
			.addSection(mainFuelTanks)
			.addSection(auxFuelTanks, 6)
			.build();
		
		return orbiterII;
	}
}
