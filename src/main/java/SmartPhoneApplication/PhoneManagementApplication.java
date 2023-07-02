package SmartPhoneApplication;

import java.util.Scanner;

public class PhoneManagementApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int choice2 = 0;

		PhoneManager phoneManager = new PhoneManager();
		AppManager appManager = new AppManager();
		ContactManager contactManager = new ContactManager();

		FileManager fileManager = new FileManager();
		//String fileName = "output.txt";

		do {
			System.out.println("------------------");
			System.out.println(" 1- Add a phone.");
			System.out.println(" 2- Show available storage space of phone!");
			System.out.println("-2- Exit");

			System.out.println("-------------------");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> {
				System.out.print("Enter phone brand: ");
				String brand = sc.next();
				System.out.print("Enter phone model: ");
				String model = sc.next();
				System.out.print("Enter phone serial number: ");
				String serialNumber = sc.next();
				System.out.print("Enter phone memory: ");
				Double memory = sc.nextDouble();
				System.out.print("Enter phone os type: ");
				String osType = sc.next();

				Phone phone = new Phone(brand, model, serialNumber, memory, osType, null, null);
				phoneManager.addPhone(phone);

				do {
					System.out.println("1- Add an app");
					System.out.println("2- Delete an app");
					System.out.println("3- Update an app");
					System.out.println("4- Add a contact");
					System.out.println("5- Delete a contact");
					System.out.println("6- Update a contact");
					System.out.println("7- Call a contact");

					System.out.println("-2 Exit");

					choice2 = sc.nextInt();
					switch (choice2) {

					case 1 -> {
						System.out.print("Enter application name will be added: ");
						String name = sc.next();
						System.out.print("Enter application version will be added: ");
						String version = sc.next();
						System.out.print("Enter application size will be added: ");
						Double size = sc.nextDouble();
						App app = new App(name, version, size);
						appManager.appList.add(app);
						appManager.addAppToPhone(phone, app);
					}

					case 2 -> {
						System.out.print("Enter application name will be deleted: ");
						String name = sc.next();

						for (App a : appManager.appList) {
							if (a.getName().equalsIgnoreCase(name)) {
								appManager.deleteAppFromPhone(phone, a);
							} else {
								System.out.println("application couldnt find.");
							}
						}
					}
					case 3 -> {
						// TODO
						System.out.print("Enter application name will be updated: ");
						String name = sc.next();
						for (App a : appManager.appList) {
							if (a.getName().equalsIgnoreCase(name)) {
								appManager.updateAppInPhone(phone, a, a);
							} else {
								System.out.println("application couldnt find.");
							}
						}

					}

					case 4 -> {
						System.out.print("Enter contact's first name will be added: ");
						String firstName = sc.next();
						System.out.print("Enter contact's last name will be added: ");
						String lastName = sc.next();
						System.out.print("Enter contact's phone number will be added: ");
						String phoneNumber = sc.next();
						System.out.print("Enter contact' email address will be added: ");
						String email = sc.next();

						Contact contact = new Contact(firstName, lastName, phoneNumber, email);
						contactManager.addContact(contact);
						contactManager.addContactToPhone(phone, contact);
					}

					case 5 -> {
						System.out.print("Enter contact's first name will be deleted: ");
						String firstName = sc.next();

						for (Contact c : contactManager.contactList) {
							if (c.getFirstName().equalsIgnoreCase(firstName)) {
								contactManager.deleteContactFromPhone(phone, c);
							}
						}

					}

					case 6 -> {
						// System.out.print("Enter contact's first name will be updated: ");
						// String firstName = sc.next();
						System.out.print("Enter contact's new phone number: ");
						String phoneNumber = sc.next();

						for (Contact c : contactManager.contactList) {
							contactManager.updateContactPhoneNumber(phone, c, phoneNumber);
						}

					}

					}

					for (Phone p : phoneManager.phoneList) {
						p.printPhoneInfo(p);
						System.out.println();
						fileManager.backupData(p);
						fileManager.readBackupData(p);
						
					}

				} while (choice2 > -1);
				
			}

			case 2 -> {
				for (Phone phone : phoneManager.phoneList) {
					double appSize = phone.getAppList().stream().mapToDouble(p -> p.getSize()).sum();
					double freeSpace = phone.getMemory() - appSize;
					System.out.println(phone.getBrand() + "'s free space is " + freeSpace + " GB.");
					
				}
				

			}

			}

			
		} while (choice > -1);

	}

}
