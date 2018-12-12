package project2;

import java.util.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpleCooking{
	HashMap<String, String> basic_list = new HashMap<String, String>();
	Scanner scanner;
	Desktop desktop;
	void choiceMenu() {
		while(true) {
			System.out.println("자취생을 위한 간단 요리 코너!");
			
			System.out.println("1. 요리 목록 보기    2. 메인 화면으로 돌아간다.");
			int c = yourChoice(2);
			if(c==2)break;
			else BasicList();
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
		basic_list.put("계란볶음밥", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1411503&memberNo=1109");
		basic_list.put("계란탕", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555069&memberNo=847606");
		basic_list.put("된장찌개", "https://m.post.naver.com/viewer/postView.nhn?volumeNo=1555114&memberNo=847606");
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
