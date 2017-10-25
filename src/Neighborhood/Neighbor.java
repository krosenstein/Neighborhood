package Neighborhood;

public class Neighbor<V> {
	private V house;
	private int distance;
	private String name;
	public Neighbor(V newHouse) {
		house = newHouse;
		distance = 0;
		name = "";
	}
	public Neighbor(V newHouse, int newDistance) {
		house = newHouse;
		distance = newDistance;
		name = "";
	}
	public Neighbor(V newHouse, int newDistance, String newName) {
		house = newHouse;
		distance = newDistance;
		name = newName;
	}
	
	public void setHouse(V newHouse) {
		house = newHouse;
	}
	public V getHouse() {
		return house;
	}
	public void setDistance(int newDistance) {
		distance = newDistance;
	}
	public int getDistance() {
		return distance;
	}
	public void setName(String newName) {
		name = newName;
	}
	public String getName() {
		return name;
	}
}
