package project2;

import java.util.*;


public class Main {
	Scanner scanner;

	void run() {
		System.out.println("������� ��Ȱ������ �������ִ� �Ŵ���! [������� ��� ��]�Դϴ�!");
		System.out.println("�ǰ��� �����Ȱ�� ���� ������, �Ĵ��� ������ ���ƿ�! ����� ���� ������ �丮 ����Ʈ�� �غ�Ǿ� �ֽ��ϴ�!\n");
		while(true) {
		showMenu();
		choiceMenu();
		}
	}
	void showMenu() {
		System.out.println("Menu");
		System.out.println(">>>>1. ������ ����       2. �Ĵ� ����      3. ���� �丮     4. ���α׷� ����<<<<");
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
			case 4 : System.out.println("���α׷��� �����մϴ�..."); System.exit(0);
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
