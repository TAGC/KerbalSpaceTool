package rocket;

import java.util.LinkedList;
import java.util.List;

import parts.Part;

public class RocketSection {
	List<Part> parts;
	
	public static class Builder {
		
		List<Part> parts;
		
		public Builder() {
			parts = new LinkedList<Part>();
		}
		
		public Builder addPart(Part p) {
			parts.add(p);
			return this;
		}
		
		public Builder addPart(Part p, int number) {
			for(int i=0; i < number; i++) parts.add(p);
			return this;
		}
		
		public Builder addPartSet(List<Part> p) {
			parts.addAll(p);
			return this;
		}
		
		public Builder addPartSet(List<Part> p, int number) {
			for(int i=0; i < number; i++) parts.addAll(p);
			return this;
		}
		
		public RocketSection build() {
			return new RocketSection(this);
		}
	}
	
	private RocketSection(Builder b) {
		parts = b.parts;
	}
	
	public List<Part> getParts() {
		return parts;
	}
}
