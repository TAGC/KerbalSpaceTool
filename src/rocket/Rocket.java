package rocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import parts.Booster;
import parts.Cockpit;
import parts.Engine;
import parts.FuelTank;
import parts.Miscellaneous;
import parts.Part;
import utility.Utility;

public class Rocket {
	String name;
	List<Part> parts;
	Cockpit cockpit;
	boolean validDesign;
	
	public static class Builder {
		String name = "rocket";
		List<Part> parts;
		
		public Builder() {
			parts = new LinkedList<Part>();
		}
		
		public Builder addName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder addPart(Part p) {
			parts.add(p);
			return this;
		}
		
		public Builder addPart(Part p, int number) {
			for(int i=0; i < number; i++) parts.add(p);
			return this;
		}
		
		public Builder addSection(RocketSection section) {
			parts.addAll(section.getParts());
			return this;
		}
		
		public Builder addSection(RocketSection section, int number) {
			for(int i=0; i < number; i++) parts.addAll(section.getParts());
			return this;
		}
		
		public Rocket build() {
			return new Rocket(this);
		}
	}
	
	private Rocket(Builder b) {
		this.name = b.name;
		this.parts = b.parts;
		
		if(validDesign = checkValid()) {
			System.out.println("Rocket constructed\n");
		} else {
			System.out.println("Invalid rocket design\n");
		}
	}
	
	private boolean checkValid() {
		for(Part part : parts) {
			if(part instanceof Cockpit) {
				if(cockpit == null) {
					cockpit = (Cockpit) part;
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public int getCost() {
		int cost = 0;
		
		if(!validDesign) return 0;
		
		for(Part part : parts) {
			cost += part.getCost();
		}
		
		return cost;
	}
	
	public double getMass() {
		double mass = 0;
		
		if(!validDesign) return 0;
		
		for(Part part : parts) {
			mass += part.getMass();
		}
		
		return mass;
	}
	
	public int getMaxThrust() {
		int thrust = 0;
		
		if(!validDesign) return 0;
		
		for(Part part : parts) {
			if(part instanceof Engine) {
				thrust += ((Engine) part).getThrust();
			} else if(part instanceof Booster) {
				thrust += ((Booster) part).getThrust();
			}
		}
		
		return thrust;
	}
	
	public double getMaxTWR() {
		return getMaxThrust() / Utility.massToWeight(getMass());
	}
	
	private void printPartCharacteristics() {
		int occurances;
		List<Booster> boosters;
		List<Engine> engines;
		List<FuelTank> fuelTanks;
		List<Miscellaneous> miscs;
		
		boosters = Utility.getObjectsOfType(Booster.class, parts);
		engines = Utility.getObjectsOfType(Engine.class, parts);
		fuelTanks = Utility.getObjectsOfType(FuelTank.class, parts);
		miscs = Utility.getObjectsOfType(Miscellaneous.class, parts);
		
		System.out.println(" C O C K P I T ");
		System.out.println("-------------------------------");
		System.out.println(cockpit.getCharacteristics());
		System.out.println("\n\n");
		
		System.out.println(" F U E L    T A N K S ");
		System.out.println("-------------------------------");
		for(FuelTank tank : new HashSet<FuelTank>(fuelTanks)) {
			occurances = Collections.frequency(fuelTanks, tank);
			System.out.println(tank.getCharacteristics() + " x" + occurances);
		}
		System.out.println("\n\n");
		
		System.out.println(" E N G I N E S ");
		System.out.println("-------------------------------");
		for(Engine engine : new HashSet<Engine>(engines)) {
			occurances = Collections.frequency(engines, engine);
			System.out.println(engine.getCharacteristics() + " x" +
					occurances);
		}
		System.out.println("\n\n");
		
		System.out.println(" B O O S T E R S ");
		System.out.println("-------------------------------");
		for(Booster booster : new HashSet<Booster>(boosters)) {
			occurances = Collections.frequency(boosters, booster);
			System.out.println(booster.getCharacteristics() + " x" +
					occurances);
		}
		System.out.println("\n\n");
		
		System.out.println(" M I S C E L L A N E O U S ");
		System.out.println("-------------------------------");
		for(Miscellaneous misc : new HashSet<Miscellaneous>(miscs)) {
			occurances = Collections.frequency(miscs, misc);
			System.out.println(misc.getCharacteristics() + " x" +
					occurances);
		}
		System.out.println("\n\n");
	}
	
	public void printCharacteristics() {
		
		if(!validDesign) {
			System.out.println("No characteristics");
			return;
		}
		
		System.out.println(name.replace("", " ").trim());
		System.out.println("-------------------------------");
		
		String cost   = String.format("Cost                        : %s",
				getCost());
		String mass   = String.format("Mass                        : %.2f",
				getMass());
		String thrust = String.format("Maximum thrust              : %s",
				getMaxThrust());
		String twr    = String.format("Maximum thrust weight/ratio : %.2f",
				getMaxTWR());
		
		System.out.println(String.format("%s\n%s\n%s\n%s\n\n\n",
				cost, mass, thrust, twr));
		
		printPartCharacteristics();
	}
}
