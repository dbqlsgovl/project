package project2;

import java.io.*;
/*import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;*/
import java.time.*;

public class Data {
	String [] name = {"data_clean", "data_dishwashing", "data_laundry" ,"data_instant"};
	String [] kor_name = {"청소", "설거지", "빨래", "인스턴트"};
	String [] component = new String[4];
	void reportDate(int i) {
		FileOutputStream f_stream = null;
		LocalDate data = LocalDate.now();
		try {
			f_stream = new FileOutputStream(name[i]);
			ObjectOutputStream d_stream = new ObjectOutputStream(f_stream);
			d_stream.writeObject(data);
			
			f_stream.close();
			d_stream.close();
			System.out.println("\n < " + kor_name[i] +" > 데이터를 기록하였습니다!");

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
			//e.printStackTrace();
			//data_component[i] = "NoData";
		} catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
