package parts;

public enum Cockpit implements Part {
	MK1_COCKPIT(1800, 1.25, 1),
	MK2_COCKPIT(1600, 1, 1),
	MK3_COCKPIT(1600, 3.5, 3),
	MK1_2_COMMAND_POD(1800, 4, 3),
	COMMAND_POD_MK1(600, 0.8, 1),
	MK2_LANDER_CAN(950, 2.5, 2),
	PROBODOBODYNE_QBE(500, 0.08, 0),
	PROBODOBODYNE_OKTO(450, 0.1, 0),
	PROBODOBODYNE_OKTO2(230, 0.04, 0),
	STAYPUTNIK_MK_2(300, 0.05, 0);
	
	int cost, crewCapacity;
	double mass;
	
	private Cockpit(int cost, double mass, int crewCapacity) {
		this.cost = cost;
		this.mass = mass;
		this.crewCapacity = crewCapacity;
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
		
		return String.format("%s (Cost: %s, Mass: %.2f, Crew Capacity: %s)",
				this, cost, mass, crewCapacity);
	}
	
	public int getCrewCapacity() {
		return crewCapacity;
	}

}
