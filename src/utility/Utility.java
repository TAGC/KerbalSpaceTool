package utility;

import java.util.LinkedList;
import java.util.List;

public class Utility {
	
	// Gravitational constant on Kerbin at sea level.
	public static final double GRAV_CONST = 9.81;
	
	// Convert mass to weight given gravitational constant.
	public static double massToWeight(double mass) {
		return mass * GRAV_CONST;
	}
	
	// Given a list of T's, return a list of S's where S is a subclass
	// of T.
	public static <S extends T, T> List<S> getObjectsOfType(Class<S> type,
			List<T> List) {
		
		List<S> result = new LinkedList<S>();
		
		for(T element : List) {
			if(type.isAssignableFrom(element.getClass())) {
				result.add(type.cast(element));
			}
		}
		
		return result;
	}
}
