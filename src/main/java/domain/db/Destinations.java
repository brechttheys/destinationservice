package domain.db;

import java.util.ArrayList;

import domain.model.Address;


public class Destinations {
	private static Destinations instance = null;
	private ArrayList<Address> destinationlist = new ArrayList<Address>();
	protected Destinations() {
		Address add1 = new Address("Best Hotel","Leuven","Vlaams-Brabant", "Belgium", "3000", "Brusselsestraat", "15");
		Address add2 = new Address("Okay Hotel","Diest","Vlaams-Brabant", "Belgium", "3030", "Diestsestraat", "22");
		Address add3 = new Address("Bad Hotel","Canterbury","Kent", "United Kingdom", "AB405", "Jeffersonstreet", "35B");
		Address add4 = new Address("Terrible Hotel","Edinburgh","Scotland", "United Kingdom", "BDS04", "Scotsmanstreet", "342");
		destinationlist.add(add1);
		destinationlist.add(add2);
		destinationlist.add(add3);
		destinationlist.add(add4);
	}
	public static Destinations getInstance() {
		if (instance == null) {
			instance = new Destinations();
		}
		return instance;
	}
	
	public void addDestination(Address d) {
		if (d == null) throw new IllegalArgumentException("Destination cannot be null");
		destinationlist.add(d);
	}
	
	public void removeDestination(Address d) {
		if (d == null) throw new IllegalArgumentException("Destination cannot be null");
		for(Address e : destinationlist) {
			if (e.equals(d)) {
				destinationlist.remove(e);
			}
		}
	}
	
	public Address getDestinationWithName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		for (Address e : destinationlist) {
			if (e.getName().trim().toLowerCase().replaceAll("\\s", "").equals(name.trim().toLowerCase().replaceAll("\\s", ""))) {
				return e;
			}
		}
		return null;
	}
	
	public ArrayList<Address> getAllDestinationsInProvince(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		ArrayList<Address> destinationsinprovince = new ArrayList<Address>();
		for (Address e : destinationlist) {
			if (e.getProvince().trim().toLowerCase().replaceAll("\\s", "").equals(name.trim().toLowerCase().replaceAll("\\s", ""))) {
				destinationsinprovince.add(e);
			}
		}
		return destinationsinprovince;
	}
	
	public ArrayList<Address> getAllDestinationsInCountry(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		ArrayList<Address> destinationsincountry = new ArrayList<Address>();
		for (Address e : destinationlist) {
			if (e.getCountry().trim().toLowerCase().replaceAll("\\s", "").equals(name.trim().toLowerCase().replaceAll("\\s", ""))) {
				destinationsincountry.add(e);
			}
		}
		return destinationsincountry;
	}
	
	public ArrayList<Address> getAllDestinationsInTown(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		ArrayList<Address> destinationsincity = new ArrayList<Address>();
		for (Address e : destinationlist) {
			if (e.getTown().trim().toLowerCase().replaceAll("\\s", "").equals(name.trim().toLowerCase().replaceAll("\\s", ""))) {
				destinationsincity.add(e);
			}
		}
		return destinationsincity;
	}
	
	public ArrayList<Address> getDestinationlist() {
		return destinationlist;
	}
}
