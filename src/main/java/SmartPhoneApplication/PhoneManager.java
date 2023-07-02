package SmartPhoneApplication;

import java.util.ArrayList;
import java.util.List;

public class PhoneManager {
	
	List<Phone> phoneList = new ArrayList<>();
	
	public void addPhone(Phone phone) {
		this.phoneList.add(phone);
		System.out.println(phone + " is added.");
	}
}
