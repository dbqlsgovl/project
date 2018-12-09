package project2;

import java.io.*;
import java.time.*;
import java.util.Date;
import java.util.*;

public class Data {
	String [] name = {"data_clean", "data_dishwashing", "data_laundry"};
	String [] kor_name = {"청소", "설거지", "빨래"};
	String [] meal_name = {"아침", "점심", "저녁"};
	byte [] meal_component = new byte[3];
	String [] component = new String[3];
	HashMap<String, String> yourlist = new HashMap<String, String>();
	
	void reportDate(int i) {
		FileOutputStream f_stream = null;
		LocalDate data = LocalDate.now();
		try {
			f_stream = new FileOutputStream(name[i]);
			ObjectOutputStream d_stream = new ObjectOutputStream(f_stream);
			d_stream.writeObject(data);
			
			f_stream.close();
			d_stream.close();
			System.out.println("< " + kor_name[i] +" > 데이터를 기록하였습니다!\n");

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}

	void compareDate(int i) {
		FileInputStream f_stream = null;
		LocalDate data = null;
		LocalDate today = LocalDate.now();
		try {
			f_stream = new FileInputStream(name[i]);
			
			ObjectInputStream d_stream = new ObjectInputStream(f_stream);
			data = (LocalDate)d_stream.readObject();
			Period period = data.until(today);
			//System.out.print((int)period.getDays());
			this.component[i] = Integer.toString(period.getDays());
			f_stream.close();
			d_stream.close();
			
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	void reportMealData(int meal_number, byte j) {//파일에 어제의 데이터가 저장돼있으면 다 지우고 식사의 배열을 [0,0,0,]으로 초기화 후 . 만약 오늘의 데이터면, 입력받은 j를 
		FileOutputStream f_stream = null;
		try {
			f_stream = new FileOutputStream("data_meal");
			
			meal_component[meal_number] = j;
			f_stream.write(meal_component);
			
			f_stream.close();
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	void readMealData() {
		FileInputStream f_stream = null;
		try {
			f_stream = new FileInputStream("data_meal");
			if(isnt_it_today()) {
				for(int i=0; i<3; i++) {
					meal_component[i]=0;
				}
			}
			else {
			f_stream.read(meal_component);
			}
			f_stream.close();
			
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	boolean isnt_it_today(){
		LocalDate today = LocalDate.now();
		File file = new File("data_meal");
		Date lastmodified = new Date();
		lastmodified.setTime(file.lastModified());
		LocalDate tran = lastmodified.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if((int)(tran.until(today)).getDays()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void reportCookingList() {//자취생에게 필요한 각종 꿀팁 정보들을 파일로 저장하는 메소드입니다.
		FileOutputStream f_stream = null;
		try {
			f_stream = new FileOutputStream("HoneyTip_List");
			ObjectOutputStream d_stream = new ObjectOutputStream(f_stream);
			d_stream.writeObject(yourlist);
			
			f_stream.close();
			d_stream.close();

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
	void readCookingList() {
		FileInputStream f_stream = null;
		try {
			f_stream = new FileInputStream("HoneyTip_List");
			ObjectInputStream d_stream = new ObjectInputStream(f_stream);
			yourlist = (HashMap)d_stream.readObject();
			f_stream.close();
			d_stream.close();
			
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
