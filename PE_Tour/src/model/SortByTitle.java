package model;

import java.util.Comparator;

/**
 * SortByTitle
 */
public class SortByTitle implements Comparator<Tour> {

	@Override
	public int compare(Tour o1, Tour o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
