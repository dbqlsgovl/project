package project2;

import java.util.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpleCooking{
	HashMap<String, String> basic_list = new HashMap<String, String>();
	Scanner scanner;
	Data data = new Data();
	Desktop desktop;
	void choiceMenu() {
		while(true) {
			System.out.println("������� ���� ���� �丮 �ڳ�!");
			
			System.out.println("1. �⺻���� ���� �� �丮 ���     2. ������ �丮 ��� ����   3. ���� ȭ������ ���ư���.");
			int c = yourChoice(3);
			if(c==3)break;
			switch(c) {
			case 1:BasicList();break;
			case 2:yourList();break;
			}
		}
	}
	
	void BasicList(){
		scanner = new Scanner(System.in);
		desktop = Desktop.getDesktop();
		
		basic_list.put("���ڷ����� �� ����","https://m.post.naver.com/viewer/postView.nhn?volumeNo=8715139&memberNo=11567548");
		basic_list.put("���ڷ����� �����","https://m.post.naver.com/viewer/postView.nhn?volumeNo=15786199&memberNo=1411456");
		basic_list.put("������ġ", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=10023882&memberNo=3149");
		basic_list.put("��ġ�����庺����", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=6309718&memberNo=166676");
		basic_list.put("������", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=3777998&memberNo=740");
		basic_list.put("����佺Ʈ", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555166&memberNo=847606&searchRank=38");
		basic_list.put("��������", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555058&memberNo=847606&searchRank=60");
		Set<String> keys = basic_list.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String food = it.next();
			System.out.println(" < "+food+" > ");
		}
		System.out.println("�丮�� �̸��� ��Ȯ�ϰ� �Է����ֽø� ������ ��ũ�� �̵��մϴ�. ���� �޴��� ���ư��÷��� ���� 0�� �Է����ּ���.");
		while(true) {
			String input = scanner.nextLine();
			if(input.equals("0")) break;
			String link = basic_list.get(input);
			if(link ==null)System.out.println(input+"��(��) ����Ʈ�� �������� �ʽ��ϴ�.");
			else {
				try {
					desktop.browse(new URI(link));
					break;
				}catch(URISyntaxException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	void yourList() {
		System.out.println("��Ÿ��� ���� �丮 ����Ʈ�� ����� �����غ�����!");
		System.out.println("1.����Ʈ ����    2.����Ʈ �����    3.����Ʈ �����    4.�������� ���ư���.");
		int c = yourChoice(4);
		switch(c){
		case 1 : showyourlist();break;
		case 2: makeyourlist();break;
		}
		
	
	}
	void showyourlist() {
		data.readCookingList();
		Set<String> keys = data.yourlist.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String food = it.next();
			String li = data.yourlist.get(food);
			System.out.println(" < "+food+" > ");
		}
		data.readCookingList();
		System.out.println("�丮�� �̸��� ��Ȯ�ϰ� �Է����ֽø� ������ ��ũ�� �̵��մϴ�. ���� �޴��� ���ư��÷��� ���� 0�� �Է����ּ���.");
		while(true) {
			String input = scanner.nextLine();
			if(input.equals("0")) break;
			String link = data.yourlist.get(input);
			if(link ==null)System.out.println(input+"��(��) ����Ʈ�� �������� �ʽ��ϴ�.");
			else {
				try {
					desktop.browse(new URI(link));
					break;
				}catch(URISyntaxException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	void makeyourlist() {
		while(true) {
			System.out.println("����� �丮 ����Ʈ�� �ۼ��մϴ�. �߰��� �丮�� �̸��� �Է����ּ���. ���� ȭ������ ���ư����� 0�� �Է����ּ���.");
			String input_food = scanner.nextLine();
			if(input_food.equals("0"))break;
			System.out.println("�����Ǹ� ���� ��ũ�� �Է����ּ���.");
			String input_link = scanner.nextLine();
			data.yourlist.put(input_food, input_link);
			data.reportCookingList();
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
}
