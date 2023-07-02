package smartPhoneApplication;

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

		do {
			System.out.println("\n 1- Add a phone.");
			System.out.println(" 2- Delete an app from specified phone");
			System.out.println(" 3- Update an app at specified phone");
			System.out.println(" 4- Delete a contact from specified phone");
			System.out.println(" 5- Update a contact at specified phone");
			System.out.println(" 6- Search a contact at specified phone");
			System.out.println(" 7- Show available storage space of phone");
			System.out.println(" 8- Print phone information.");
			System.out.println("-3- Exit");

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
					System.out.println("\n1- Add an app");
					System.out.println("2- Add a contact");
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

					}

				} while (choice2 > -1);

			}

			case 2 -> {

				System.out.print("Enter application name will be deleted from specified phone: ");
				String appName = sc.next();
				System.out.print("Enter phone brand name will be deleted: ");
				String phoneBrand = sc.next();

				for (Phone phone : phoneManager.phoneList) {
					System.out.println(phone.toString());
					if (phone.getBrand().equalsIgnoreCase(phoneBrand)) {
						for (App app : appManager.appList) {
							if (app.getName().equalsIgnoreCase(appName)) {
								appManager.deleteAppFromPhone(phone, app);
							}
						}
					} else {
						System.out.println("application couldnt find ");
					}
				}
			}

			case 3 -> {
				System.out.print("Enter application name will be updated at specified phone: ");
				String appName = sc.next();
				System.out.print("Enter phone brand name will be updated: ");
				String phoneBrand = sc.next();
				System.out.println("Enter new version off application.");
				String newVersion = sc.next();

				for (Phone phone : phoneManager.phoneList) {
					if (phone.getBrand().equalsIgnoreCase(phoneBrand)) {
						for (App app : appManager.appList) {
							if (app.getName().equalsIgnoreCase(appName)) {
								appManager.updateAppInPhone(phone, app, newVersion);
							}
						}
					} else {
						System.out.println("App couldnt find.");
					}

				}
			}

			case 4 -> {
				System.out.print("Enter contact's first name will be deleted from specified phone: ");
				String firstName = sc.next();
				System.out.print("Enter phone brand: ");
				String phoneBrand = sc.next();

				for (Phone phone : phoneManager.phoneList) {
					if (phone.getBrand().equalsIgnoreCase(phoneBrand)) {
						for (Contact contact : contactManager.contactList) {
							if (contact.getFirstName().equalsIgnoreCase(firstName)) {
								contactManager.deleteContactFromPhone(phone, contact);
							}
						}
					} else {
						System.out.println("contact couldnt find.");
					}
				}
			}

			case 5 -> {
				System.out.print("Enter phone brand will be updated: ");
				String phoneBrand = sc.next();
				System.out.print("Enter contact's first name will be updated at specified phone: ");
				String contactName = sc.next();
				System.out.println("Enter contact's new phone number: ");
				String newPhoneNumber = sc.next();

				for (Phone phone : phoneManager.phoneList) {
					if (phone.getBrand().equalsIgnoreCase(phoneBrand)) {
						for (Contact contact : contactManager.contactList) {
							if (contact.getFirstName().equalsIgnoreCase(contactName)) {
								contactManager.updateContactPhoneNumber(phone, contact, newPhoneNumber);
							}
						}
					}
				}
			}

			case 6 -> {
				System.out.print("Enter phone brand will be search: ");
				String phoneBrand = sc.next();
				System.out.print("Enter contact's first name will be searched at specified phone: ");
				String contactName = sc.next();

				for (Phone phone : phoneManager.phoneList) {
					if (phone.getBrand().equalsIgnoreCase(phoneBrand)) {
						for (Contact contact : contactManager.contactList) {
							if (contact.getFirstName().equalsIgnoreCase(contactName)) {
								contactManager.searchContact(phone, contact);
							}
						}
					} else {
						System.out.println("contact couldnt find.");
					}
				}
			}

			case 7 -> {
				for (Phone phone : phoneManager.phoneList) {
					double appSize = phone.getAppList().stream().mapToDouble(p -> p.getSize()).sum();
					double freeSpace = phone.getMemory() - appSize;
					System.out.println(phone.getBrand() + "'s free space is " + freeSpace + " GB.");

				}

			}

			case 8 -> {
				for (Phone p : phoneManager.phoneList) {
					p.printPhoneInfo(p);
					fileManager.backupData(p);
					fileManager.readBackupData(p);

				}
				
				
				for (Phone p : phoneManager.phoneList) {
					p.printPhoneInfo(p);
					System.out.println();
					fileManager.backupData(p);
					fileManager.readBackupData(p);

				}
			}
			}

		} while (choice > -1);

	}

}
