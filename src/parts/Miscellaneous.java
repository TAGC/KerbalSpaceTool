package parts;

public enum Miscellaneous implements Part {
	ADVANCED_SAS_MODULE(1100, 0.1),
	ADVANCED_SAS_MODULE_LARGE(2200, 0.5),
	AVIONICS_PACKAGE(2300, 0.08),
	PLACE_ANYWHERE_7_LINEAR_RCS_PORT(500, 0.05),
	RV_105_RCS_THRUSTER_BLOCK(450, 0.05),
	SAS_MODULE(600, 0.07),
	ROCKOMAX_BRAND_DECOUPLER(200, 0.4),
	TT_38K_RADIAL_DECOUPLER(600, 0.025),
	HYDRAULIC_DETACHMENT_MANIFOLD(200, 0.4),
	TR_18A_STACK_DECOUPLER(600, 0.05),
	AERODYNAMIC_NOSE_CONE(680, 0.03),
	PROTECTIVE_ROCKET_NOSE_MK7(1000, 0.4),
	STANDARD_NC(680, 0.1),
	AV_R8_WINGLET(500, 0.02),
	MK25_PARACHUTE(400, 0.2),
	MK16_XL_PARACHUTE(850, 0.3),
	MK16_PARACHUTE(422, 0.1);
	
	int cost;
	double mass;
	
	private Miscellaneous(int cost, double mass) {
		this.cost = cost;
		this.mass = mass;
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
		
		return String.format("%s (Cost: %s, Mass: %.2f)",
				this, cost, mass);
	}
}
