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
		System.out.println("������ ������ �����̽��ϴ�.");
		today_did();
		jansori();
		System.out.println("\n���� � �������� �ϼ̳���? ��ȣ �� �ϳ��� �Է��ϰ� ���͸� �����ּ���.");
		System.out.println("1.û��     2.������     3.����     4.���� ȭ������ ���ư���.");
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
	void jansori() { // ������ �����ϵ��� ���������� �� �� ��ĥ�� ���������� �˷��ݴϴ�. û�ҿ� �������� ��� 3���� ������ �� �ܼҸ���, ������ 7���� ������
						// �� �ܼҸ��� �մϴ�.
		for (int i = 0; i < 3; i++) {

			if (data.component[i] != null && Integer.parseInt(data.component[i]) > 0) {
				System.out.println("���������� " + data.kor_name[i] + "�� ���� " + data.component[i] + "���� �������ϴ�.");
			}
		}
		if(Integer.parseInt(data.component[0])>=3) System.out.println("û�Ҹ� �������� �� �ϼ̳׿�. ������ ���̸� �ǰ��� ���� �ʾƿ�!");
		if(Integer.parseInt(data.component[1])>=3) System.out.println("�������� �зȱ���. ���� ��� ������ ����濡 ������ ���ϰſ���...");
		if(Integer.parseInt(data.component[2])>7) System.out.println("�������� �׿����! ������ ��Ź�⸦ ������ �� ����?");
	}

	void today_did() {
		System.out.print("���� �Ͻ� �������� [ ");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			data.compareDate(i);
			if (data.component[i] != null && Integer.parseInt(data.component[i]) == 0) {
				System.out.print("<" + data.kor_name[i] + "> ");
				count++;
			}
		}
		System.out.print("] �Դϴ�.");
		switch (count) {
		case 1:
			System.out.println("�� �ϼ̾��.");
			break;
		case 2:
			System.out.println(" �� ���� �ϼ̱���. �Ǹ��ؿ�!");
			break;
		case 3:
			System.out.println(" ����� ������ ������! ���� �����Ͻñ���!");
			break;
		}
		System.out.println();
	}

	

	void clean() {
		scanner = new Scanner(System.in);
		System.out.println("\n<û��> �޴��� �����ϼ̽��ϴ�.");
		data.compareDate(0);
		if (Integer.parseInt(data.component[0]) == 0)
			System.out.println("���� �̹� û�ұ⸦ �����̱���. ����ؿ�!");
		else {
			if (data.component[0] == null)
				System.out.println("û�� �����Ͱ� �������� �ʽ��ϴ�. �� �����͸� ������ּ���!");
			else
				System.out.println("���������� û�ұ⸦ ���� �� " + data.component[0] + "���� �Ǿ����ϴ�.");
		}
	}

	
}
