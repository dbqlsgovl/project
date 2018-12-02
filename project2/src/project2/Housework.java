package project2;

//import java.util.InputMismatchException;
import java.util.Scanner;


public class Housework extends LivingAlone{
	Scanner scanner;
	Data data = new Data();
	public Housework() {
		
	}
	void choiceMenu() {
		scanner = new Scanner(System.in);
		System.out.println("집안일 관리에 들어오셨습니다.");
		today_did();
		jansori();
		System.out.println("\n오늘 어떤 집안일을 하셨나요? 번호 중 하나를 입력하고 엔터를 눌러주세요.");
		System.out.println("1.청소     2.설거지     3.빨래     4.메인 화면으로 돌아간다.");
		int c = yourChoice()-1;
		if(c == 4) {
		}
		else {
			data.reportDate(c);
		}
	}
	int yourChoice() {
		return super.yourChoice();
	}
	void jansori() { // 각각의 집안일들을 마지막으로 한 지 며칠이 지났는지를 알려줍니다. 청소와 설거지의 경우 3일이 지났을 시 잔소리를, 빨래는 7일이 지났을
						// 시 잔소리를 합니다.
		for (int i = 0; i < 3; i++) {

			if (data.component[i] != null && Integer.parseInt(data.component[i]) > 0) {
				System.out.println("마지막으로 " + data.kor_name[i] + "를 한지 " + data.component[i] + "일이 지났습니다.");
			}
		}
		if(Integer.parseInt(data.component[0])>=3) System.out.println("청소를 오랫동안 안 하셨네요. 먼지가 쌓이면 건강에 좋지 않아요!");
		if(Integer.parseInt(data.component[1])>=3) System.out.println("설거지가 밀렸군요. 음식 찌꺼기 때문에 자취방에 벌레가 꼬일거에요...");
		if(Integer.parseInt(data.component[2])>7) System.out.println("빨랫감이 쌓였어요! 오늘은 세탁기를 돌리는 게 어떨까요?");
	}

	void today_did() {
		System.out.print("오늘 하신 집안일은 [ ");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			data.compareDate(i);
			if (data.component[i] != null && Integer.parseInt(data.component[i]) == 0) {
				System.out.print("<" + data.kor_name[i] + "> ");
				count++;
			}
		}
		System.out.print("] 입니다.");
		switch (count) {
		case 1:
			System.out.println("잘 하셨어요.");
			break;
		case 2:
			System.out.println(" 두 개나 하셨군요. 훌륭해요!");
			break;
		case 3:
			System.out.println(" 당신은 집안일 마스터! 정말 성실하시군요!");
			break;
		}
		System.out.println();
	}

	

	void clean() {
		scanner = new Scanner(System.in);
		System.out.println("\n<청소> 메뉴를 선택하셨습니다.");
		data.compareDate(0);
		if (Integer.parseInt(data.component[0]) == 0)
			System.out.println("오늘 이미 청소기를 돌리셨군요. 대단해요!");
		else {
			if (data.component[0] == null)
				System.out.println("청소 데이터가 존재하지 않습니다. 새 데이터를 기록해주세요!");
			else
				System.out.println("마지막으로 청소기를 돌린 지 " + data.component[0] + "일이 되었습니다.");
		}
	}

	
}
