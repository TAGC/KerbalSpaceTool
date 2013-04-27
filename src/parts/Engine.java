package parts;

public enum Engine implements Part {
	BASIC_JET_ENGINE(950, 1, 150),
	LV_T30_LIQUID_FUEL_ENGINE(850, 1.25, 215),
	ROCKOMAX_MAINSAIL_LIQUID_ENGINE(850, 6, 1500),
	LV_T45_LIQUID_FUEL_ENGINE(950, 1.5, 200),
	ROCKOMAX_POODLE_LIQUID_ENGINE(600, 2.5, 220),
	LV_909_LIQUID_FUEL_ENGINE(750, 0.5, 50),
	LV_1_LIQUID_FUEL_ENGINE(150, 0.03, 1.5),
	LV_N_ATOMIC_ROCKET_MOTOR(1700, 2.25, 60),
	ROCKOMAX_MARK_55_RADIAL_MOUNT_LIQUID_ENGINE(850, 0.9, 120),
	ROCKOMAX_24_77(240, 0.09, 20),
	TOROIDAL_AEROSPIKE_ROCKET(850, 1.5, 175),
	TURBOJET_ENGINE(950, 1.2, 225);
	
	int cost;
	double mass, thrust;
	
	private Engine(int cost, double mass, double thrust) {
		this.cost = cost;
		this.mass = mass;
		this.thrust = thrust;
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
		
		return String.format("%s (Cost: %s, Mass: %.2f, Thrust: %.2f)",
				this, cost, mass, thrust);
	}
	
	public double getThrust() {
		return thrust;
	}

}
