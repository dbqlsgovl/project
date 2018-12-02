package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract public class LivingAlone {
	Scanner scanner;
	abstract void choiceMenu();
	int yourChoice() {
		scanner = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				choice = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				scanner.nextLine();
				continue;
			}
			if(choice<0 || choice>4) {
				scanner.nextLine();
				continue;
			}
			scanner.nextLine();
			return choice;
		}
	}
	abstract void jansori();
	abstract void today_did();


}
