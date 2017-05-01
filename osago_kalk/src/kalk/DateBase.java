/**
 * объявление пакета
 */
package kalk;
/**
 * подключение необходимых библиотек для работы файлами
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * объявление публичного класса в котором используются методы для работы с файлами 
 */

public class DateBase {	
  /**
	 * Объявление метода, для записи логинов и паролей в файл
	 */
	public static void write(String fileName, String l, String p){
		try{
				FileWriter writer = new FileWriter(fileName, true);
	            BufferedWriter bufferWriter = new BufferedWriter(writer);
	            bufferWriter.write(l);
	            bufferWriter.newLine();
	            bufferWriter.write(p);
	            bufferWriter.newLine();
	            bufferWriter.close();
				}
			catch (IOException e) {
				System.out.println(e);
		}
	}
	/**
	 * Объявление метода, для сравнения логинов и паролей введеных в соответствующие поля с
	 * логинами и паролями, имеющиеся в файле
	 */
	public static Boolean read (String fileName, JTextField login, JPasswordField password){
		File file = new File(fileName);
        FileReader fr = null;
        BufferedReader br = null;
        Boolean result = false;
        try{
        fr =new FileReader(file);
        br =new BufferedReader(fr);
        String line;
        String log = "";
		String pass = "";
        int count = 0;
        /**
         * сравнение строк из файла с введеными 
         */
        while((line = br.readLine()) != null){
            count=count+1;
            if (count % 2 == 0) pass=line;
        	else log = line;
            if (log.equals(login.getText()) && pass.equals(password.getText())) result = true;
        }
        br.close();
        fr.close();}
        catch (IOException e){ 
        	e.printStackTrace(); 
        } 
        return result;
	}
}

