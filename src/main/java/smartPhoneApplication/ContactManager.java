package smartPhoneApplication;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

	List<Contact> contactList = new ArrayList<>();
	
	public void addContact(Contact contact) {
		this.contactList.add(contact);
	}
	
	public void addContactToPhone(Phone phone, Contact contact) {
		phone.getContactList().add(contact);
	}
	
	public void deleteContactFromPhone(Phone phone, Contact contact) {
		phone.getContactList().remove(contact);
	}
	
	
	public void updateContactPhoneNumber(Phone phone, Contact contact,  String newPhoneNumber) {
		
		for(Contact c : phone.getContactList()) {
			if(c.equals(contact)) {
				contact.setPhoneNumber(newPhoneNumber);
				break;
			}
		}
	}
	
}
