package view;

import utils.Validator;

import java.util.ArrayList;

public class Menu<E>{

    public int int_getChoice(ArrayList<E> options) {
		int choice;
		int numChoice = options.size();
		for (int index = 0; index < numChoice; index++) {
			System.out.println(index + 1 + ". " + options.get(index));
		} 
		choice = Validator.inputIntRange(1, numChoice);
		return choice;
    }

	public E ref_getChoice(ArrayList<E> options) {
		int choice;
		int numChoice = options.size();
		do {
			choice =  int_getChoice(options);
		} while (choice < 0 || choice > numChoice);
		return options.get(choice - 1);
	}
}
