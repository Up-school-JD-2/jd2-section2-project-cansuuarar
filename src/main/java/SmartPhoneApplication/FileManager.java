package SmartPhoneApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

	public void backupData(Phone phone) {

		File file1 = new File("apps.txt");
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file1));
			objectOutputStream.writeObject(phone.getAppList());
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public void readBackupData(Phone phone) {
		
		File file1 = new File("apps.txt");
		
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file1));
			try {
				List<App> listApp = (List<App>) objectInputStream.readObject();
				objectInputStream.close();
				
				for(App app : listApp) {
					System.out.println("read from file");
					System.out.println(app.getName());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
