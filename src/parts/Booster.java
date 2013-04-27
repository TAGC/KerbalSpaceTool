package parts;

public enum Booster implements Part {
	SEPATRON_1(100, 0.0725, 18, 8),
	RT_10_SOLID_FUEL_BOOSTER(450, 3.7475, 250, 433),
	ROCKOMAX_BACC_SOLID_FUEL_BOOSTER(800, 7.875, 315, 850);
	
	int cost, thrust;
	double mass, solidFuel;
	
	private Booster(int cost, double mass, int thrust, double solidFuel) {
		this.cost = cost;
		this.mass = mass;
		this.thrust = thrust;
		this.solidFuel = solidFuel;
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
		
		return String.format("%s (Cost: %s, Mass: %.2f, Thrust: %s, " +
				"Solid fuel: %.2f",
				this, cost, mass, thrust, solidFuel);
	}
	
	public int getThrust() {
		return thrust;
	}
	
	public double getSolidFuel() {
		return solidFuel;
	}
}
