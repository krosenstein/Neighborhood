package Tests;

import Neighborhood.Neighborhood;
import static org.junit.Assert.*;
import java.lang.AssertionError;

public class Tests {
	public static void main(String[] args) {
		Neighborhood<Integer> neighborhood = new Neighborhood<>();
		for (int i = 0; i < 7; i++) {
			neighborhood.addHouse(i);
		} 
		int[] from =     {1, 1, 1, 2, 3, 4, 4, 4, 5, 5, 6, 6};
		int[] to =       {2, 3, 6, 1, 5, 1, 2, 6, 3, 6, 2, 4};
		int[] distance = {5, 4, 5, 2, 4, 3, 7, 8, 11, 1, 9, 7};
		String name[] = {"Bob", "Fred", "George", "Tom", "Kyle", 
				"Eric", "Jake", "John", "Gregg", "Mike", "Ed", "Rick"};
		
		for (int i = 0; i < from.length; i++) {
			neighborhood.addNeighbor(from[i], to[i], name[i], distance[i]);
		}
		
		System.out.println(neighborhood.getOwner(1, 2)); // Bob
		System.out.println(neighborhood.getOwner(6, 4)); // Tom
		
		System.out.println(neighborhood.distanceToNeighbor(1, 2)); // 5
		System.out.println(neighborhood.distanceToNeighbor(6, 4)); // 7
		
		System.out.println(neighborhood.hasHouse(7)); // false
		System.out.println(neighborhood.hasHouse(2)); // true
		
		System.out.println(neighborhood.hasNeighbor(3, 5)); // true
		System.out.println(neighborhood.hasNeighbor(3, 6)); // false
	}
}
