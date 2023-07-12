package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Validator;
import model.Tour;
import model.TourList;
import view.Menu;
public class Validator {

	private static Scanner scanner = new Scanner(System.in);

	public static String inputString() {
		while (true) {
			try {
				System.out.println("Please do not input an empty String");
				String input = scanner.nextLine();
				if (input.isEmpty()) {
					throw new Exception();
				}
				return input;
			} catch (Exception e) {
				System.out.println("You entered an empty String. Try again");
			}
		}
	}

	public static int inputIntRange(int min, int max) {
		while (true) {
			try {
				System.out.println("Please enter a number in range [" + min + ", " + max + "]");
				int input = Integer.parseInt(scanner.nextLine());
				if ((input < min) || (input > max)) {
					throw new Exception();
				}
				return input;
			} catch (Exception e) {
				System.out.println("Value out of bound. Please try again");
			}
		}
	}

	public static double inputDouble() {
		while (true) {
			try {
				System.out.println("Please enter a positive real number");
				double input = Double.parseDouble(scanner.nextLine());
				if (input <= 0) {
					throw new Exception();
				}
				return input;
			} catch (Exception e) {
				System.out.println("Please try again");
			}
		}
	}

	public static LocalDate convertDate(String formattedDate) {
		LocalDate date = LocalDate.parse(formattedDate);
		return date;
	}

	public static LocalDate inputDate() {
		while (true) {
			try {
				System.out.println("Please input the date: yyyy-mm-dd");
				String input = inputString();
				LocalDate date = convertDate(input);
				return date;
			} catch (Exception e) {
				System.out.println("Invalid date format or date not exist!");
			}
		}
	}

	public static LocalDate inputEndDate(LocalDate startDate) {
		while (true) {
			try {
				LocalDate endDate = inputDate();
				if (endDate.compareTo(startDate) < 0) {
					throw new Exception();
				}
				return endDate;
			}
			catch (Exception e) {
				System.out.println("End date must be after start date! Try again.");
			}
		}
	}

	public static int searchCode(TourList tourList, String code) {
		for (Tour tour : tourList) {
			if (tour.getCode().equals(code)) {
				return tourList.indexOf(tour);
			}
		}
		return -1;
	}

	public static String validateCode(TourList tourList) {
		while (true) {
			try {
				System.out.println("Please enter a unique tour code.");
				String code = inputString();
				if (searchCode(tourList, code) != -1) {
					throw new Exception();
				}
				return code;
			} catch (Exception e) {
				System.out.println("This code existed!");
			}
		}
	}

	public static int inputTourType() {
		Menu<String> menu = new Menu<>();
		ArrayList<String> optionsList = new ArrayList<>();
		optionsList.add("DomesticTour");
		optionsList.add("InternationalTour");
		int choice = menu.int_getChoice(optionsList);

		return choice;
	}

	public static String inputTransportation() {
		Menu<String> menu = new Menu<>();
		ArrayList<String> optionsList = new ArrayList<>();
		optionsList.add("Airplane");
		optionsList.add("Ship");
		optionsList.add("Car");
		optionsList.add("Train");
		String choice = menu.ref_getChoice(optionsList);

		return choice;
	}

	public static int inputSort() {
		Menu<String> menu = new Menu<>();
		ArrayList<String> optionsList = new ArrayList<>();
		optionsList.add("Descending sort of tour's price");
		optionsList.add("Ascending sort of tour's title");
		int choice = menu.int_getChoice(optionsList);

		return choice;
		
	}

	public static int checkSave() {
		Menu<String> menu = new Menu<>();
		ArrayList<String> optStrings = new ArrayList<>();
		optStrings.add("Save to file tours.txt");
		optStrings.add("Load from file tours.txt");
		int choice = menu.int_getChoice(optStrings);

		return choice;
	}

}
