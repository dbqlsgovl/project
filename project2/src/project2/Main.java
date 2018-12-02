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
		System.out.println("자취생의 생활패턴을 관리해주는 매니저! [자취생의 모든 것]입니다!");
		System.out.println("건강한 자취생활을 위해 집안일, 식단을 관리해 보아요!\n");
		System.out.println("Menu");
		System.out.println(">>>>1. 집안일 관리       2. 식단 관리      3. 프로그램 종료<<<<");
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
		
		System.out.println("<자취생의 모든 것>에 오신 것을 환영합니다!");
		System.out.println("이제부터 혼자 사는 당신의 생활 습관을 관리해 드리겠습니다.");
		System.out.println("당신의 이름은 무엇인가요?");
		String user_name = scanner.nextLine();
		System.out.println(user_name + "님 이시군요! 앞으로 잘 부탁드립니다.");
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		
	}
}
