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
			System.out.println("자취생을 위한 간단 요리 코너!");
			
			System.out.println("1. 기본으로 제공 된 요리 목록     2. 나만의 요리 목록 관리   3. 메인 화면으로 돌아간다.");
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
		
		basic_list.put("전자레인지 밥 짓기","https://m.post.naver.com/viewer/postView.nhn?volumeNo=8715139&memberNo=11567548");
		basic_list.put("전자레인지 계란찜","https://m.post.naver.com/viewer/postView.nhn?volumeNo=15786199&memberNo=1411456");
		basic_list.put("볶음김치", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=10023882&memberNo=3149");
		basic_list.put("참치고추장볶음밥", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=6309718&memberNo=166676");
		basic_list.put("떡볶이", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=3777998&memberNo=740");
		basic_list.put("계란토스트", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555166&memberNo=847606&searchRank=38");
		basic_list.put("김계란말이", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555058&memberNo=847606&searchRank=60");
		Set<String> keys = basic_list.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String food = it.next();
			System.out.println(" < "+food+" > ");
		}
		System.out.println("요리의 이름을 정확하게 입력해주시면 레시피 링크로 이동합니다. 이전 메뉴로 돌아가시려면 숫자 0을 입력해주세요.");
		while(true) {
			String input = scanner.nextLine();
			if(input.equals("0")) break;
			String link = basic_list.get(input);
			if(link ==null)System.out.println(input+"는(은) 리스트에 존재하지 않습니다.");
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
		System.out.println("당신만의 간단 요리 리스트를 만들고 관리해보세요!");
		System.out.println("1.리스트 보기    2.리스트 만들기    3.리스트 지우기    4.메인으로 돌아간다.");
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
		System.out.println("요리의 이름을 정확하게 입력해주시면 레시피 링크로 이동합니다. 이전 메뉴로 돌아가시려면 숫자 0을 입력해주세요.");
		while(true) {
			String input = scanner.nextLine();
			if(input.equals("0")) break;
			String link = data.yourlist.get(input);
			if(link ==null)System.out.println(input+"는(은) 리스트에 존재하지 않습니다.");
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
			System.out.println("당신의 요리 리스트를 작성합니다. 추가할 요리의 이름을 입력해주세요. 이전 화면으로 돌아가려면 0을 입력해주세요.");
			String input_food = scanner.nextLine();
			if(input_food.equals("0"))break;
			System.out.println("레시피를 담은 링크를 입력해주세요.");
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
