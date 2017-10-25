package Neighborhood;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
public class Neighborhood<V> {
	HashMap<V, Collection<Neighbor<V>>> map = new HashMap<>();
	
	public void addHouse(V newHouse) {
		if (newHouse == null)
			throw new IllegalArgumentException();
		if (map.containsKey(newHouse))
			return;
		HashSet<Neighbor<V>> neighbors = new HashSet<Neighbor<V>>();
		map.put(newHouse, neighbors);
	}
	
	public boolean hasHouse(V house) {
		if (house == null)
			throw new IllegalArgumentException();
		return map.containsKey(house);
	}
	
	public Collection<V> getHouse() {
		return new HashSet<>(map.keySet());
	}
	
	public void removeHouse(V house) {
		if (house == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(house))
			return;
		map.remove(house);
	}
	
	public void addNeighbor(V from, V to, String name, int distance) {
		if (from == null || to == null || distance <= 0)
			throw new IllegalArgumentException();
		Neighbor<V> neighbor = new Neighbor<>(to, distance, name);
		if (!map.containsKey(from) || map.get(from).contains(neighbor))
			return;
		map.get(from).add(neighbor);
	}
	
	public boolean hasNeighbor(V from, V to) {
		if (from == null || to == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return false;
		for (Neighbor<V> index: map.get(from)) {
			if (index.getHouse().equals(to))
				return true;
		}
		return false;
	}
	
	public int distanceToNeighbor(V from, V to) {
		if (from == null || to == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return -1;
		for (Neighbor<V> index: map.get(from)) {
			if (index.getHouse().equals(to))
				return index.getDistance();
		}
		return -1;
	}
	
	public void changeDistance(V from, V to, int newDistance) {
		if (from == null || to == null || newDistance <= 0)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return;
		if (!map.get(from).contains(to))
			return;
		for (Neighbor<V> index: map.get(from)) {
			if (index.getHouse().equals(to))
				index.setDistance(newDistance);
		}
	}
	
	public void changeOwners(V from, V to, String newName) {
		if (from == null || to == null || newName == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return;
		for (Neighbor<V> index: map.get(from)) {
			if (index.getHouse().equals(to))
				index.setName(newName);
		}
	}
	
	public String getOwner(V from, V to) {
		if (from == null || to == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return null;
		for (Neighbor<V> index: map.get(from)) {
			if (index.getHouse().equals(to))
				return index.getName();
		}
		return null;
	}
	
	public void removeNeighbor(V from, V to) {
		if (from == null || to == null)
			throw new IllegalArgumentException();
		Neighbor<V> neighbor = new Neighbor<>(to);
		if (!map.containsKey(from) || map.get(from).contains(neighbor))
			return;
		map.get(from).remove(neighbor);
	}
	
	public Collection<V> neighborsOfHouse(V house) {
		if (house == null)
			throw new IllegalArgumentException();
		if(!map.containsKey(house))
			return null;
		HashSet<V> neighbors = new HashSet<>();
		for(Neighbor<V> index: map.get(house)) {
			neighbors.add(index.getHouse());
		}
		return neighbors;
	}
	
	public Collection<V> reachable(V from) {
		if (from == null)
			throw new IllegalArgumentException();
		if (!map.containsKey(from))
			return null;
		HashSet<V> neighborsAll = new HashSet<>();
		for (Neighbor<V> index: map.get(from)) {
			neighborsAll.add(index.getHouse());
			neighborsAll.addAll(neighborsOfHouse(index.getHouse()));
		}
		return neighborsAll;
	}
}
