package view;

import java.util.ArrayList;

import model.TourList;
import view.Menu;
import utils.Validator;

public class TourManager {
	public static void main(String[] args) {

		TourList tourList = new TourList();

		Menu<String> menu = new Menu<>();
		ArrayList<String> optionsList = new ArrayList<>();
		optionsList.add("Add new tour");
		optionsList.add("List all domestic tour in the system");
		optionsList.add("Compute the average tour charge of all international tours");
		optionsList.add("Search tour by minimum tour charge");
		optionsList.add("Remove the tour having given code");
		optionsList.add("Sort all tours of list by multiple levels in descending order of tour’s price and then in ascending order of tour’s title");
		optionsList.add("Update tour information");
		optionsList.add("Save (Load) tours to (from) file");
		optionsList.add("Quit");

		do {
			int choice = menu.int_getChoice(optionsList);
			switch (choice) {
			case 1:
				tourList.addTour();
				break;
			case 2:
				tourList.printDomesticTours();
				break;
			case 3:
				tourList.averageInternationalCharge();
				break;
			case 4:
				tourList.searchMinimumChargeTour();
				break;
			case 5:
				tourList.removeByCode();
				break;
			case 6:
				tourList.listSort();
				break;
			case 7:
				tourList.updateTour();
				break;
			case 8:
				int save = Validator.checkSave();
				if (save == 1) {
					tourList.saveToFile("tours.txt");
				} else {
					tourList.loadFromFile("tours.txt");
				}
				break;
			case 9:
				return;
			}
		} while (true);

	}

}
