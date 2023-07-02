package smartPhoneApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

	public void backupData(Phone phone) {

		File file1 = new File(
				"C:/Users/TCCARAR/git/jd2-section2-project-cansuuarar/src/main/java/smartPhoneApplication/appsAndContacts.txt");

		try {
			file1.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file1);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(phone.getAppList());
			objectOutputStream.writeObject(phone.getContactList());
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readBackupData(Phone phone) {

		File file1 = new File(
				"C:/Users/TCCARAR/git/jd2-section2-project-cansuuarar/src/main/java/smartPhoneApplication/appsAndContacts.txt");

		try {
			FileInputStream fileInputStream = new FileInputStream(file1);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			try {
				List<App> listApp = (List<App>) objectInputStream.readObject();
				List<Contact> listContact = (List<Contact>) objectInputStream.readObject();

				objectInputStream.close();
				fileInputStream.close();
				
				System.out.println();

				for (App app : listApp) {
					System.out.println(app.toString() + " read from file.");
				}

				for (Contact contact : listContact) {
					System.out.println(contact.toString() + " read from file.");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
