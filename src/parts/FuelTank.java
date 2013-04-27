package parts;

public enum FuelTank implements Part {
	FL_T400_FUEL_TANK(850, 2.25, 180, 220, 0),
	ROCKOMAX_X200_32_FUEL_TANK(6600, 18, 1440, 1760, 0),
	ROCKOMAX_X200_16_FUEL_TANK(1800, 9, 720, 880, 0),
	ROCKOMAX_JUMBO_64_FUEL_TANK(12500, 36, 2880, 3520, 0),
	ROCKOMAX_X200_8_FUEL_TANK(900, 2.5, 350, 550, 0),
	FL_T200_FUEL_TANK(225, 1.125, 90, 110, 0),
	FL_T800_FUEL_TANK(1600, 4.5, 360, 440, 0),
	OSCAR_B_FUEL_TANK(80, 0.078675, 5.735, 7, 0),
	MK1_FUSELAGE(550, 1.1, 150, 0, 0),
	MK2_FUSELAGE(550, 0.9999999, 160, 0, 0),
	MK2_TO_SIZE_1_ADAPTER(550, 0.5, 80, 0, 0),
	MK3_FUSELAGE(550, 1.5, 240, 0, 0),
	MK3_TO_MK2_ADAPTER(550, 0.9999999, 160, 0, 0),
	STRATUS_V_ROUNDIFIED_MONOPROPELLANT_TANK(400, 0.235, 0, 0, 40),
	FL_R25_RCS_FUEL_TANK(800, 0.55, 0, 0, 100),
	FL_R1_RCS_FUEL_TANK(1300, 3.4, 0, 0, 750),
	ROUND_8_TOROIDAL_FUEL_TANK(100, 0.136, 10, 12.2, 0);
	
	int cost;
	double mass, liquidFuel, oxidiser, monopropellant;
	
	private FuelTank(int cost, double mass, double liquidFuel,
			double oxidiser, double monopropellant) {
		this.cost = cost;
		this.mass = mass;
		this.liquidFuel = liquidFuel;
		this.oxidiser = oxidiser;
		this.monopropellant = monopropellant;
	}
	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public double getMass() {
		return mass;
	}
	
	@Override
	public String getCharacteristics() {
		
		return String.format("%s (Cost: %s, Mass: %.2f, Liquid fuel: %.2f, " +
				"Oxidiser: %.2f, Monopropellant: %.2f)",
				this, cost, mass, liquidFuel, oxidiser, monopropellant);
	}
	
	public double getLiquidFuel() {
		return liquidFuel;
	}
	
	public double getOxidiser() {
		return oxidiser;
	}
	
	public double getMonopropellant() {
		return monopropellant;
	}
}
