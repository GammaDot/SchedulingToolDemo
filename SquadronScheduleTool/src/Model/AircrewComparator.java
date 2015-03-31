package Model;

import java.util.Comparator;

public class AircrewComparator implements Comparator<Aircrew> {
	@Override
	public int compare(Aircrew o1, Aircrew o2) {
		Aircrew ac1 = (Aircrew) o1;
		Aircrew ac2 = (Aircrew) o2;
		
		if(ac1.getTotalFYFlightHours() < ac2.getTotalFYFlightHours())
			return -1;
		
		if(ac1.getTotalFYFlightHours() == ac2.getTotalFYFlightHours())
			return 0;
		
		return 1;
	}

}
