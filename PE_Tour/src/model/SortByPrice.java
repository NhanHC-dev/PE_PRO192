package model;

import java.util.Comparator;

/**
 * SortByPrice
 */
public class SortByPrice implements Comparator<Tour> {

	@Override
	public int compare(Tour o1, Tour o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}
}
