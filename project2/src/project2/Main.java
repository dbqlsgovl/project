package project2;

import java.util.*;
//import java.io.*;


public class Main {
	Scanner scanner;
	Main(){
		int is_first=0;
		if(is_first ==1) tutorial();
	}
	void run() {
		while(true) {
		showMenu();
		choiceMenu();
		}
	}
	void showMenu() {
		System.out.println("������� ��Ȱ������ �������ִ� �Ŵ���! [������� ��� ��]�Դϴ�!");
		System.out.println("�ǰ��� �����Ȱ�� ���� ������, �Ĵ��� ������ ���ƿ�!\n");
		System.out.println("Menu");
		System.out.println(">>>>1. ������ ����       2. �Ĵ� ����      3. ���α׷� ����<<<<");
	}

	void choiceMenu() {
		scanner = new Scanner(System.in);
		Housework housework = new Housework();
		int choice = scanner.nextInt();
		switch(choice) {
		case 1 : housework.choiceMenu();
		
		}
	}
	
	void tutorial() {
		
		System.out.println("<������� ��� ��>�� ���� ���� ȯ���մϴ�!");
		System.out.println("�������� ȥ�� ��� ����� ��Ȱ ������ ������ �帮�ڽ��ϴ�.");
		System.out.println("����� �̸��� �����ΰ���?");
		String user_name = scanner.nextLine();
		System.out.println(user_name + "�� �̽ñ���! ������ �� ��Ź�帳�ϴ�.");
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		
	}
}
