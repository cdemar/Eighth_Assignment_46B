package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {

	// Return true if the FlightNet doesn't contain an airport with specified
	// name.

	public boolean nameIsAvailable(String name) {
		for (Airport airline : this) {
			if (airline.getName().equals(name))
				return false;
		}
		return true;
	}

	// Connects a1 and a2. You’ll have to connect a1 to a2, and also a2 to a1.

	public void connect(Airport a1, Airport a2) {

		if (!this.contains(a1)) {
			this.add(a1);
		}
		if (!this.contains(a2)) {
			this.add(a2);
		}
		a1.connectTo(a2);
		a2.connectTo(a1);
	}

	// Opposite of above.
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}

	// Removes removeMe from the FlightNet, and disconnects it from any airports
	// that are still in the FlightNet.
	public void removeAndDisconnect(Airport removeMe) {
		if (this.contains(removeMe))
			this.remove(removeMe);
		for (Airport airline : this)
			disconnect(removeMe, airline);
	}

	/*
	 * Checks all airports in the FlightNet. Returns the first airport whose
	 * (x,y) location is within maximumDistance of the x,y args of the method.
	 * Returns null if no airport is within maximumDistance. Note: Check out the
	 * hypot method of the Math class.
	 */
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {

		for (Airport airline : this) {

			// is this needed?
			double place = Math.abs(Math.hypot(x - airline.getX(),
					y - airline.getY()));

			// System.out.println(airline.getName() + " " + place);

			if (place <= maximumDistance) {
				return airline;
			}
		}
		return null;
	}

	// Code given from Professor in Canvas
	public static FlightNet makeTestInstance() {
		Airport sfo = new Airport("SFO", 31, 207);
		Airport lax = new Airport("LAX", 81, 291);
		Airport jfk = new Airport("JFK", 724, 169);
		Airport mia = new Airport("MIA", 667, 455);
		Airport sea = new Airport("SEA", 92, 31);

		FlightNet net = new FlightNet();

		net.add(sfo);
		net.add(lax);
		net.add(jfk);
		net.add(mia);
		net.add(sea);

		net.connect(sfo, sea);
		net.connect(sfo, jfk);
		net.connect(sfo, lax);
		net.connect(jfk, mia);
		net.connect(jfk, sea);

		return net;
	}
}
