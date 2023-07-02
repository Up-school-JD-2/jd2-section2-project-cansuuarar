package SmartPhoneApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Phone implements Serializable{

	private String brand;
	private String model;
	private String serialNumber;
	private double memory;
	private String osType;
	private List<App> appList;
	private List<Contact> contactList;

	public Phone(String brand, String model, String serialNumber, double memory, String osType, List<App> appList,List<Contact> contactList) {
		super();
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
		this.memory = memory;
		this.osType = osType;
		this.appList = appList;
		this.appList = new ArrayList<>();
		this.contactList = contactList;
		this.contactList = new ArrayList<>();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public List<App> getAppList() {
		return appList;

	}

	public void setAppList(List<App> appList) {
		this.appList = appList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public void printPhoneInfo(Phone phone) {
		System.out.println("\nPhone information: " + "\nBrand: " + getBrand() + "\nModel: " + getModel()
				+ "\nSerialNumber: " + getSerialNumber() + "\nMemory: " + getMemory() + "\nOs: " + getOsType());

		System.out.print("Apps: ");
		for (App app : appList) {
			System.out.print(app.getName() + " ");
		}
		
		System.out.print("\nContacts: ");
		for(Contact contact : contactList) {
			System.out.print(contact.getFirstName() + ", " +  contact.getPhoneNumber());
		}
		
		

	}

	
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + ", serialNumber=" + serialNumber + ", memory=" + memory
				+ ", osType=" + osType + ", appList=" + appList + ", contactList=" +contactList + "]";
	}
	

}
