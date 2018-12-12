package project2;

import java.util.*;


public class Main {
	Scanner scanner;

	void run() {
		System.out.println("자취생의 생활패턴을 관리해주는 매니저! [자취생의 모든 것]입니다!");
		System.out.println("건강한 자취생활을 위해 집안일, 식단을 관리해 보아요! 당신을 위한 간편한 요리 리스트도 준비되어 있습니다!\n");
		while(true) {
		showMenu();
		choiceMenu();
		}
	}
	void showMenu() {
		System.out.println("Menu");
		System.out.println(">>>>1. 집안일 관리       2. 식단 관리      3. 간단 요리     4. 프로그램 종료<<<<");
	}

	void choiceMenu() {
		Housework housework = new Housework();
		Meal meal = new Meal();
		SimpleCooking simplecooking = new SimpleCooking();
			int choice = yourChoice(4);
			switch(choice) {
			case 1 : housework.choiceMenu(); break;
			case 2 : meal.choiceMenu();break;
			case 3 : simplecooking.choiceMenu();break;
			case 4 : System.out.println("프로그램을 종료합니다..."); System.exit(0);
			default : break;
			}
		}
	int yourChoice(int i) {
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
			if(choice<=0 || choice>i) {
				scanner.nextLine();
				continue;
			}
			scanner.nextLine();
			return choice;
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		
	}
}
