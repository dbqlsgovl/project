package project2;

import java.time.*;


public class Meal extends LivingAlone{
	Meal(){
		
	}
	void choiceMenu() {
		while(true) {
			System.out.println("�Ĵ� ������ �����̽��ϴ�.");
			today_did();
			jansori();
			show_time();
			System.out.println("��ħ, ����, ���� �� ��� �����͸� �����Ͻ� �ǰ���? ��ȣ �� �ϳ��� �Է��ϰ� ���͸� �����ּ���.");
			System.out.println("1.��ħ    2.����    3.����    4.���� ȭ������ ���ư���.");
			int c = super.yourChoice(4)-1;
			if(c==3) {
				break;
			}
			else {
				nextMenu(c);
			}
		}
	}
	void nextMenu(int i) {
		System.out.println("���� "+data.meal_name[i]+"�� ��̳���?");
		System.out.println("1.����� �� ���� �Ծ���.   2.�ν���Ʈ�� ������.   3.������.   4.���� �� �Ծ���.");
		int a = super.yourChoice(4);
		if(a==4)data.reportMealData(i, (byte)0);
		else data.reportMealData(i, (byte)a);
	}
	void jansori() {
		int count_instant=0;
		int count_skipmeal=0;
		for(int i=0;i<3;i++) {
			if((int)data.meal_component[i]==2) {
				count_instant++;
			}
			if((int)data.meal_component[i]==3) {
				count_skipmeal++;
			}
			
		}
		if(count_instant>0) {
			count_instant=0;
			System.out.print("���� ");
			for(int i = 0; i < 3; i++) {
				if((int)data.meal_component[i]==2) {
					if(count_instant > 0)System.out.print(", ");
					System.out.print(data.meal_name[i]);
					count_instant++;
				}
			}
		System.out.print("�� �ν���Ʈ�� ����̱���! ");

		switch(count_instant) {
		case 1 : System.out.println();break;
		case 2 : System.out.println("�Ϸ� �� ���� �ν���Ʈ�� ����ôٴ�, �ǰ��� �����ſ�...");break;
		case 3 : System.out.println("�������ŵ� ���� ����� �� �Ļ縦 ���ּ���! ���� �ǰ��� ���ؿ�!");break;
			}
		}
		if(count_skipmeal>0) {
			count_skipmeal=0;
			System.out.print("������ ");
			for(int i = 0; i < 3; i++) {
				if((int)data.meal_component[i]==3) {
					if(count_skipmeal > 0)System.out.print(", ");
					System.out.print(data.meal_name[i]);
					count_skipmeal++;
				}
			}
			System.out.print("�� �����̱���. ");
			switch(count_skipmeal) {
			case 0 : System.out.println();break;
			case 1 : System.out.println("������ �ǰ��� ���ؿ�.");break;
			case 2 : System.out.println("�� ���� �����̳׿�... �������Ű���?");break;
			case 3 : System.out.println("���� �� ���� �� ������ �ǰ���? ������ �ܽ��� �������, ������, ������ �� ���� ���ۿ��� �ҷ��Ϳ�!");break;
			}
		}
		System.out.println();
	}
	void today_did(){
		data.readMealData();
		System.out.print("������ [ ");
		for(int i=0; i<3; i++) {
			if((int)data.meal_component[i]==1 || (int)data.meal_component[i]==2) {
				System.out.print("<"+data.meal_name[i]+"> ");
			}
			
		}
		System.out.println("]�� ��̱���!");
	}
	void show_time() {
		int t = Meal_Time();
		switch(t) {
		case 1: if((int)data.meal_component[0]==0)System.out.println("��ħ ���� �ð��̿���!"); break;
		case 2: if((int)data.meal_component[1]==0)System.out.println("���� ���� �ð��̿���!"); break;
		case 3: if((int)data.meal_component[2]==0)System.out.println("���� ���� �ð��̿���!"); break;
		}
	}
	int Meal_Time() {
		LocalTime now = LocalTime.now();
		if(now.isAfter(LocalTime.of(6, 0,0))&&now.isBefore(LocalTime.of(11, 0, 0)))return 1;
		else if(now.isAfter(LocalTime.of(12, 0, 0))&&now.isBefore(LocalTime.of(15, 0, 0)))return 2;
		else if(now.isAfter(LocalTime.of(17, 0, 0))&&now.isBefore(LocalTime.of(20,0,0)))return 3;
		return 0;
	}
	
}
