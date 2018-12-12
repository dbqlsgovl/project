package project2;

import java.time.*;


public class Meal extends LivingAlone{
	Meal(){
		
	}
	void choiceMenu() {
		while(true) {
			System.out.println("식단 관리에 들어오셨습니다.");
			today_did();
			jansori();
			show_time();
			System.out.println("아침, 점심, 저녁 중 어느 데이터를 관리하실 건가요? 번호 중 하나를 입력하고 엔터를 눌러주세요.");
			System.out.println("1.아침    2.점심    3.저녁    4.메인 화면으로 돌아간다.");
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
		System.out.println("오늘 "+data.meal_name[i]+"을 드셨나요?");
		System.out.println("1.제대로 된 밥을 먹었다.   2.인스턴트로 때웠다.   3.굶었다.   4.아직 안 먹었다.");
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
			System.out.print("오늘 ");
			for(int i = 0; i < 3; i++) {
				if((int)data.meal_component[i]==2) {
					if(count_instant > 0)System.out.print(", ");
					System.out.print(data.meal_name[i]);
					count_instant++;
				}
			}
		System.out.print("을 인스턴트로 때우셨군요! ");

		switch(count_instant) {
		case 1 : System.out.println();break;
		case 2 : System.out.println("하루 두 끼를 인스턴트로 때우시다니, 건강이 걱정돼요...");break;
		case 3 : System.out.println("귀찮으셔도 제발 제대로 된 식사를 해주세요! 정말 건강이 상해요!");break;
			}
		}
		if(count_skipmeal>0) {
			count_skipmeal=0;
			System.out.print("오늘은 ");
			for(int i = 0; i < 3; i++) {
				if((int)data.meal_component[i]==3) {
					if(count_skipmeal > 0)System.out.print(", ");
					System.out.print(data.meal_name[i]);
					count_skipmeal++;
				}
			}
			System.out.print("을 굶으셨군요. ");
			switch(count_skipmeal) {
			case 0 : System.out.println();break;
			case 1 : System.out.println("굶으면 건강이 상해요.");break;
			case 2 : System.out.println("두 끼나 굶으셨네요... 괜찮으신가요?");break;
			case 3 : System.out.println("정말 세 끼를 다 굶으신 건가요? 과도한 단식은 영양실조, 저혈압, 저혈당 등 많은 부작용을 불러와요!");break;
			}
		}
		System.out.println();
	}
	void today_did(){
		data.readMealData();
		System.out.print("오늘은 [ ");
		for(int i=0; i<3; i++) {
			if((int)data.meal_component[i]==1 || (int)data.meal_component[i]==2) {
				System.out.print("<"+data.meal_name[i]+"> ");
			}
			
		}
		System.out.println("]을 드셨군요!");
	}
	void show_time() {
		int t = Meal_Time();
		switch(t) {
		case 1: if((int)data.meal_component[0]==0)System.out.println("아침 먹을 시간이에요!"); break;
		case 2: if((int)data.meal_component[1]==0)System.out.println("점심 먹을 시간이에요!"); break;
		case 3: if((int)data.meal_component[2]==0)System.out.println("저녁 먹을 시간이에요!"); break;
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
