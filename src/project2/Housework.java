package project2;

import java.util.Scanner;


public class Housework extends LivingAlone{
	Scanner scanner;
	void choiceMenu() {
		scanner = new Scanner(System.in);
			while(true) {
				System.out.println("������ ������ �����̽��ϴ�.");
				today_did();
				jansori();
				System.out.println("\n���� � �������� �ϼ̳���? ��ȣ �� �ϳ��� �Է��ϰ� ���͸� �����ּ���.");
				System.out.println("1.û��     2.������     3.����     4.���� ȭ������ ���ư���.");
				int c = super.yourChoice(4)-1;
				if(c == 3) {
					break;
				}
				else {
					data.reportDate(c);
				}
			}
	}
	void jansori() { // ������ �����ϵ��� ���������� �� �� ��ĥ�� ���������� �˷��ݴϴ�. û�ҿ� �������� ��� 3���� ������ �� �ܼҸ���, ������ 7���� ������
						// �� �ܼҸ��� �մϴ�.
		System.out.println();
		for (int i = 0; i < 3; i++) {

			if (data.component[i] != null && Integer.parseInt(data.component[i]) > 0) {
				System.out.println("���������� " + data.kor_name[i] + "�� ���� " + data.component[i] + "���� �������ϴ�.");
			}
		}
		if(data.component[0] != null &&Integer.parseInt(data.component[0])>=3) System.out.println("û�Ҹ� �������� �� �ϼ̳׿�. ������ ���̸� �ǰ��� ���� �ʾƿ�!");
		if(data.component[1] != null &&Integer.parseInt(data.component[1])>=3) System.out.println("�������� �зȱ���. ���� ��� ������ ����濡 ������ ���ϰſ���...");
		if(data.component[2] != null &&Integer.parseInt(data.component[2])>7) System.out.println("�������� �׿����! ������ ��Ź�⸦ ������ �� ����?");
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
	}

	
}
