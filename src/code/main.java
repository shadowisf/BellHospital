package code;

import java.io.*;
import java.util.*;

/* 
 * SWE4201: BELL HOSPITAL MANAGEMENT SYSTEM
 * 
 * 
 * BY:      LES PAUL RANALAN
 * 
 * 
 * NOTE:    COMMENTS ARE PROVIDED BELOW AS EXPLANATIONS FOR EASIER UNDERSTANDING FOR THE PROGRAM.
 * 		    THE COMMENTS CAN BE FOUND ONLY IN PATIENT RECORD.
 * 
 *  			THIS IS TO AVOID REPETITION OF COMMENTS OF EVERY METHOD IN THE PROGRAM AS
 *  			EVERY OPERATION IS EXACTLY THE SAME EXCEPT FOR THE ACCESS OPERATION.
 * 
 * 		    THE ACCESS OPERATION OF APPOINTMENT RECORDS IS EXPLAINED WITH COMMENTS AS
 * 			IT FUNCTIONS DIFFERENTLY FROM THE REST OF THE OPERATIONS.
 */

class bell_hospital_main {
	// declaration of all scanners in all records.
	private static Scanner scan_string = new Scanner(System.in);
	private static Scanner scan_int = new Scanner(System.in);

	private static int record = 0;

	// declaration of bold text command.
	private final static String setBoldStart = "\033[1m";
	private final static String setBoldEnd = "\033[0m";

	// main method of bell hospital and it is also where the main menu is found.
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		/*
		 * try catch method. the program will go back and forth in main method as there
		 * will be no termination when error occurs.
		 */
		try {
			switch (record) {
			case 0:
				main_menu();
				break;

			case 1:
				patient_records();
				break;

			case 2:
				doctor_records();
				break;

			case 3:
				appointment_records();
				break;

			case 4:
				medicine_records();
				break;

			case 5:
				about_program();
				break;
			}
		}
		/*
		 * catch method if invalid input is entered. catch method is universal and
		 * directly executes if wrong input is entered wherever the user is whether it
		 * be patient records, appointment records, etc.
		 */
		catch (InputMismatchException e) {
			System.out.println(new String(new char[70]).replace("\0", "\r\n"));
			System.out.println(setBoldStart
					+ "   INVALID INPUT. INTEGERS ARE ONLY ACCEPTED IN THAT FIELD.\n\n   RESTARTING CURRENT RECORD..."
					+ setBoldEnd);

			String x;

			if (record == 0 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}

			if (record == 1 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}

			if (record == 2 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}

			if (record == 3 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}

			if (record == 4 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}

			if (record == 5 && scan_int.hasNext()) {
				x = scan_int.next();
				scan_int.reset();
				Thread.sleep(5000);
				main(null);
			}
		}
	}

	public static void main_menu() throws Exception {
		int main_menu;
		record = 0;

		System.out.println(new String(new char[70]).replace("\0", "\r\n"));

		System.out.println(("   +-----" + setBoldStart + "BELL" + setBoldEnd + "-" + setBoldStart + "HOSPITAL"
				+ setBoldEnd + "-" + setBoldStart + "MANAGEMENT" + setBoldEnd + "-----+" + "\n   |"
				+ "                                  |"));
		System.out.println("   |   1. patient records             |");
		System.out.println("   |   2. doctor records              |");
		System.out.println("   |   3. appointment records         |");
		System.out.println("   |   4. medicine records            |" + "\n   |                                  | ");
		System.out.println(
				"   |   5. about program" + "               |" + "\n   |" + "                                  |");
		System.out.println(
				"   |   0. exit" + "                        |" + "\n   |" + "                                  |");
		System.out.println("   +----------------------------------+" + "\n");
		System.out.print(setBoldStart + "   enter record: " + setBoldEnd);

		main_menu = scan_int.nextInt();

		// executes program to go to patient records
		if (main_menu == 1) {
			patient_records();
		}

		// executes program to go to doctor records
		if (main_menu == 2) {
			doctor_records();
		}

		// executes program to go to appointment records
		if (main_menu == 3) {
			appointment_records();
		}

		// executes program to go to medicine records
		if (main_menu == 4) {
			medicine_records();
		}

		// executes program to go to about program
		if (main_menu == 5) {
			about_program();
		}

		// exits the program entirely
		if (main_menu == 0) {
			System.out.println(new String(new char[70]).replace("\0", "\r\n"));
			System.out.println(setBoldStart + "   GOODBYE!\n" + setBoldEnd);
			Thread.sleep(1500);
			System.exit(0);
		}

		// if user enters a non-integer input
		else {
			System.out.println(new String(new char[70]).replace("\0", "\r\n"));
			System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
			Thread.sleep(1500);
			main_menu();
		}
	}

	// patient record method
	@SuppressWarnings("unchecked")
	public static void patient_records() throws Exception {
		record = 1;
		ArrayList<Patient> p_collection = new ArrayList<Patient>(); // initializes a new array list from class patient

		File file_patient = new File("patient.txt"); // creates new text file named patient.txt
		ObjectOutputStream p_oos = null; // initializes object output stream for class patient
		ObjectInputStream p_ois = null; // initializes object input stream for class patient

		if (file_patient.isFile()) { // if file patient.txt is found
			p_ois = new ObjectInputStream(new FileInputStream(file_patient)); // initializes new file input stream for
																				// reading patient.txt
			p_collection = (ArrayList<Patient>) p_ois.readObject(); // reads data from patient.txt and imports it to
																	// patient array list
			p_ois.close(); // closes the object input stream for class patient
		}

		int p_menu; // declares patient choice for operation menu as an integer
		int p_search = 0; // declares patient search as initially 0, which means search user did not
							// execute search function yet

		do {
			Iterator<Patient> p_iteration = p_collection.iterator(); // initializes patient iterator from patient array
																		// list
			ListIterator<Patient> p_list = null; // initializes list iterator from patient class

			if (p_search == 0) { // if search operation is active, clear menu
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%n",
						setBoldStart + "REGISTRATION ID", "    INSURANCE ID", "    NAME", "    GENDER", "    AGE",
						"    SYMPTOMS / FINDINGS", "    CONTACT NUMBER",
						"    HOME ADDRESS                                                                                         |"
								+ setBoldEnd);

				while (p_iteration.hasNext()) { // while loop for returning true if patient iteration has more elements
					Patient p_e = p_iteration.next(); // returns next element in patient iteration
					System.out.println(p_e); // prints all elements of patient iteration
				}

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

			}

			System.out.println("\n" + "\n" + "\n");
			System.out.println("   +-----" + setBoldStart + "PATIENT" + setBoldEnd + "-" + setBoldStart + "RECORDS"
					+ setBoldEnd + "-----+" + "\n   |" + "                         |");
			System.out.println("   |   1. add" + "                |");
			System.out.println("   |   2. refresh" + "            |");
			System.out.println("   |   3. search" + "             |          enter " + setBoldStart + "000" + setBoldEnd
					+ " to cancel operation.");

			System.out.println("   |   4. update" + "             |");
			System.out.println("   |   5. delete" + "             |" + "\n   |" + "                         |");
			System.out.println("   |   0. back" + "               |" + "\n   |" + "                         |");
			System.out.println("   +-------------------------+" + "\n");
			System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);
			p_menu = scan_int.nextInt();

			switch (p_menu) {
			case 1: // add
				System.out.print(
						"\n" + "   enter " + setBoldStart + "registration id" + setBoldEnd + " of patient: \t\t");
				int p_id1 = scan_int.nextInt();
				if (p_id1 == 000) { // if scanner reads "000" it will automatically cancel the operation and returns
									// to the menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "insurance id" + setBoldEnd + " of patient: \t\t");
				String p_insurance = scan_string.nextLine();
				if (p_insurance.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "name" + setBoldEnd + " of patient: \t\t\t");
				String p_name = scan_string.nextLine();
				if (p_name.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "gender" + setBoldEnd + " of patient: \t\t\t");
				String p_gender = scan_string.nextLine();
				if (p_gender.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "age" + setBoldEnd + " of patient: \t\t\t");
				int p_age = scan_int.nextInt();
				if (p_age == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "symptoms / findings" + setBoldEnd + " of patient: \t");
				String p_symptoms = scan_string.nextLine();
				if (p_symptoms.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "home address" + setBoldEnd + " of patient: \t\t");
				String p_address = scan_string.nextLine();
				if (p_address.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.print("   enter " + setBoldStart + "contact number" + setBoldEnd + " of patient: \t\t");
				String p_number = scan_string.nextLine();
				if (p_number.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   PATIENT RECORD ADDED." + setBoldEnd + "\n");
				Thread.sleep(1500);

				p_collection
						.add(new Patient(p_id1, p_insurance, p_name, p_gender, p_age, p_symptoms, p_address, p_number)); // adds all data of each variables entered by the user to a new patient object

				p_search = 0; // patient search is not executed yet by user

				p_oos = new ObjectOutputStream(new FileOutputStream(file_patient)); // initializes a new file output
																					// stream for writing data on
																					// patient.txt
				p_oos.writeObject(p_collection); // updates or stores the data of array list onto patient.txt
				p_oos.close(); // closes the object output stream for class patient
				break;

			case 2: // refresh
				patient_records(); // executes patient records
				p_search = 0;
				break;

			case 3: // search
				boolean found = false;
				System.out
						.print("\n" + "   enter " + setBoldStart + "registration id" + setBoldEnd + " of patient: \t");
				int p_id = scan_int.nextInt();
				if (p_id == 000) { // if scanner reads "000", it will automatically cancel the operation and go
									// back to the menu
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				p_iteration = p_collection.iterator(); // assigns patient iteration variable as patient array list as an
														// iterator
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%n",
						setBoldStart + "REGISTRATION ID", "    INSURANCE ID", "    NAME", "    GENDER", "    AGE",
						"    SYMPTOMS / FINDINGS", "    CONTACT NUMBER",
						"    HOME ADDRESS                                                                                         |"
								+ setBoldEnd);
				while (p_iteration.hasNext()) { // while loop for returning true if patient iteration has more or has
												// next elements
					Patient p_e = p_iteration.next(); // assigns p_e as patient iteration with next element

					if (p_e.getPatientID() == p_id) { // if the next element of patient iteration matches the entered
														// patient id
						System.out.println(p_e); // prints the array list of matching patient id
						found = true; // changes boolean found to true
						p_search = 1; // changes value of variable patient search to 1. this means that we are in the
										// search operation.
					}

				}

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

				if (found != true) { // if patient id entered by user is not found, it will display an error and
										// returns to menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   PATIENT RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				System.out.println("\n" + "\n" + "\n");
				break;

			case 4: // update
				if (file_patient.isFile()) { // if text file patient.txt is found
					p_ois = new ObjectInputStream(new FileInputStream(file_patient)); // initializes new file input
																						// stream for reading data in
																						// patient.txt
					p_collection = (ArrayList<Patient>) p_ois.readObject(); // reads the data from patient.txt and
																			// imports data to array list of patient
					p_ois.close(); // closes the object input stream for class patient
				}

				found = false; // declares boolean found as initially false.

				p_iteration = p_collection.iterator(); // assigns patient iteration as patient array list as an iterator
				p_list = p_collection.listIterator(); // assigns patient list as patient array list as a LIST iterator

				System.out.print("   enter " + setBoldStart + "registration id" + setBoldEnd + " of patient: ");
				p_id = scan_int.nextInt();
				if (p_id == 000) { // if scanner reads "000", it will automatically cancel the operation and return
									// to menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				while (p_list.hasNext()) { // while the patient list iterator has next element, it will return true
					Patient p_e = p_list.next(); // assigns p_e as the patient list iterator having next element

					if (p_e.getPatientID() == p_id) { // if patient id is matching with a patient object, the program
														// will then ask the user to enter new values to be entered in
														// the patient object
						System.out.print("\n" + "   enter " + setBoldStart + "NEW registration id" + setBoldEnd
								+ " of patient: \t");
						p_id1 = scan_int.nextInt();
						if (p_id1 == 000) { // if scanner detects "000", it will automatically stop the operation and
											// returns to menu.
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW insurance id" + setBoldEnd + " of patient: \t\t");
						p_insurance = scan_string.nextLine();
						if (p_insurance.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW name" + setBoldEnd + " of patient: \t\t\t");
						p_name = scan_string.nextLine();
						if (p_name.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW gender" + setBoldEnd + " of patient: \t\t");
						p_gender = scan_string.nextLine();
						if (p_gender.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW age" + setBoldEnd + " of patient: \t\t\t");
						p_age = scan_int.nextInt();
						if (p_age == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW symptoms / findings" + setBoldEnd
								+ " of patient: \t");
						p_symptoms = scan_string.nextLine();
						if (p_symptoms.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW home address" + setBoldEnd + " of patient: \t\t");
						p_address = scan_string.nextLine();
						if (p_address.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW contact number" + setBoldEnd + " of patient: \t");
						p_number = scan_string.nextLine();
						if (p_number.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							patient_records();
						}

						p_list.set(new Patient(p_id1, p_insurance, p_name, p_gender, p_age, p_symptoms, p_address,
								p_number)); // sets the specific patient object with the new values entered by the user
						found = true; // changes boolean found to true
					}
				}

				if (found) { // if patient id is found and is matching to the patient id entered by the user,
								// it will return true
					p_oos = new ObjectOutputStream(new FileOutputStream(file_patient)); // initializes a new file output
																						// stream from for reading
																						// patient.txt
					p_oos.writeObject(p_collection); // updates or writes the data of array list onto patient.txt
					p_oos.close(); // closes the object output stream for class patient
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println("   " + setBoldStart + "PATIENT RECORD UPDATED." + setBoldEnd);
					Thread.sleep(1500);
				}

				else { // if patient id is not found or is not matching with patient id entered by the
							// user, it will display error and returns to menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   PATIENT RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}
				break;

			case 5: // delete
				found = false;

				System.out
						.print("\n" + "   enter " + setBoldStart + "registration id" + setBoldEnd + " of patient: \t");
				p_id = scan_int.nextInt();
				if (p_id == 000) { // if scanner detects "000", it will automatically stop the operation and return
									// to menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					patient_records();
				}

				p_iteration = p_collection.iterator(); // assigns patient iteration as the patient array list as an
														// iterator.
				while (p_iteration.hasNext()) { // while condition for scanning data in patient array list
					Patient p_e = p_iteration.next(); // assigns p_e as patient iteration with next element.

					if (p_e.getPatientID() == p_id) { // if condition for matching patient id
						p_iteration.remove(); // removes patient array list of matching patient id
						found = true; // changes boolean found to true.
						p_search = 1;
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						p_search = 0;
						System.out.println(setBoldStart + "   PATIENT RECORD DELETED." + setBoldEnd);
						Thread.sleep(1500);
					}
				}

				if (found != true) { // if patient id is not found or is not matching with patient id entered by
										// user, it will display error and return to menu.
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					p_search = 0;
					System.out.println(setBoldStart + "   PATIENT RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				p_oos = new ObjectOutputStream(new FileOutputStream(file_patient)); // initializes a new object output
																					// stream
				p_oos.writeObject(p_collection); // updates and writes the data of array list onto patient.txt
				p_oos.close(); // closes the object output stream of class patient
				break;

			case 0: // back
				main_menu(); // goes back to main menu
				p_search = 0;
				break;

			default: // if user enters a number that does not corresponds to any of the switch cases
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
				Thread.sleep(1500);
				break;
			}
		} while (p_menu != 0);
	}

	@SuppressWarnings("unchecked")
	public static void doctor_records() throws Exception {
		record = 2;
		ArrayList<Doctor> d_collection = new ArrayList<Doctor>();

		File file_doctor = new File("doctor.txt");
		ObjectOutputStream d_oos = null;
		ObjectInputStream d_ois = null;

		if (file_doctor.isFile()) {
			d_ois = new ObjectInputStream(new FileInputStream(file_doctor));
			d_collection = (ArrayList<Doctor>) d_ois.readObject();
			d_ois.close();
		}

		int d_menu;
		int d_search = 0;

		do {
			Iterator<Doctor> d_iteration = d_collection.iterator();
			ListIterator<Doctor> d_list = null;

			if (d_search == 0) {
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-30s%-30s%-30s%-30s%n",
						setBoldStart + "STAFF ID", "    DOCTOR NAME", "    SPECIALIZATION",
						"    CONTACT NUMBER                |" + setBoldEnd);

				while (d_iteration.hasNext()) {
					Doctor d_e = d_iteration.next();
					System.out.println(d_e);
				}

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------+");

			}

			System.out.println("\n" + "\n" + "\n");
			System.out.println("   +-----" + setBoldStart + "DOCTOR" + setBoldEnd + "-" + setBoldStart + "RECORDS"
					+ setBoldEnd + "-----+" + "\n   |" + "                        |");
			System.out.println("   |   1. add" + "               |");
			System.out.println("   |   2. refresh" + "           |");
			System.out.println("   |   3. search" + "            |          enter " + setBoldStart + "000" + setBoldEnd
					+ " to cancel operation.");
			System.out.println("   |   4. update" + "            |");
			System.out.println("   |   5. delete" + "            |" + "\n   |" + "                        |");
			System.out.println("   |   0. back" + "              |" + "\n   |" + "                        |");
			System.out.println("   +------------------------+" + "\n");
			System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);
			d_menu = scan_int.nextInt();

			switch (d_menu) {

			case 1: // add
				System.out.print("\n" + "   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor: \t\t");
				int d_id1 = scan_int.nextInt();
				if (d_id1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				System.out.print("   enter " + setBoldStart + "name" + setBoldEnd + " of doctor: \t\t");
				String d_name = scan_string.nextLine();
				if (d_name.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				System.out.print("   enter " + setBoldStart + "specialization" + setBoldEnd + " of doctor: \t");
				String d_spec = scan_string.nextLine();
				if (d_spec.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				System.out.print("   enter " + setBoldStart + "contact number" + setBoldEnd + " of doctor: \t");
				String d_number = scan_string.nextLine();
				if (d_number.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   DOCTOR RECORD ADDED." + setBoldEnd);
				Thread.sleep(1500);

				d_collection.add(new Doctor(d_id1, d_name, d_spec, d_number));

				d_search = 0;

				d_oos = new ObjectOutputStream(new FileOutputStream(file_doctor));
				d_oos.writeObject(d_collection);
				d_oos.close();
				break;

			case 2: // refresh
				doctor_records();
				d_search = 0;
				break;

			case 3: // search
				boolean found = false;

				System.out.print("\n" + "   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor: \t");
				int d_id = scan_int.nextInt();
				if (d_id == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				d_iteration = d_collection.iterator();
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-30s%-30s%-30s%-30s%n",
						setBoldStart + "STAFF ID", "    DOCTOR NAME", "    SPECIALIZATION",
						"    CONTACT NUMBER                |" + setBoldEnd);
				while (d_iteration.hasNext()) {
					Doctor d_e = d_iteration.next();

					if (d_e.getDoctorID() == d_id) {
						d_search = 1;
						System.out.println(d_e);
						found = true;
					}
				}

				System.out.printf(
						" +-------------------------------------------------------------------------------------------------------------------------+");

				if (found != true) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));

					d_search = 0;
					System.out.println(setBoldStart + "   DOCTOR RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}
				break;

			case 4: // update
				if (file_doctor.isFile()) {
					d_ois = new ObjectInputStream(new FileInputStream(file_doctor));
					d_collection = (ArrayList<Doctor>) d_ois.readObject();
					d_ois.close();
				}

				found = false;

				d_iteration = d_collection.iterator();
				d_list = d_collection.listIterator();

				System.out.print("   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor: ");
				d_id = scan_int.nextInt();
				if (d_id == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				while (d_list.hasNext()) {
					Doctor d_e = d_list.next();

					if (d_e.getDoctorID() == d_id) {
						System.out.print(
								"\n" + "   enter " + setBoldStart + "NEW staff id" + setBoldEnd + " of doctor: \t\t");
						d_id1 = scan_int.nextInt();
						if (d_id1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							doctor_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW name" + setBoldEnd + " of doctor: \t\t\t");
						d_name = scan_string.nextLine();
						if (d_name.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							doctor_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW specialization" + setBoldEnd + " of doctor: \t\t");
						d_spec = scan_string.nextLine();
						if (d_spec.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							doctor_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW contact number" + setBoldEnd + " of doctor: \t\t");
						d_number = scan_string.nextLine();
						if (d_number.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							doctor_records();
						}

						d_list.set(new Doctor(d_id1, d_name, d_spec, d_number));
						found = true;
					}
				}

				if (found) {
					d_oos = new ObjectOutputStream(new FileOutputStream(file_doctor));
					d_oos.writeObject(d_collection);
					d_oos.close();
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println("   " + setBoldStart + "DOCTOR RECORD UPDATED." + setBoldEnd);
					Thread.sleep(1500);
				}

				else {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   DOCTOR RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}
				break;

			case 5: // delete
				found = false;

				System.out.print("\n" + "   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor: \t");
				d_id = scan_int.nextInt();
				if (d_id == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					doctor_records();
				}

				d_iteration = d_collection.iterator();

				while (d_iteration.hasNext()) {
					Doctor d_e = d_iteration.next();

					if (d_e.getDoctorID() == d_id) {
						d_iteration.remove();
						found = true;

						System.out.println(new String(new char[70]).replace("\0", "\r\n"));

						d_search = 0;
						System.out.println(setBoldStart + "   DOCTOR RECORD DELETED." + setBoldEnd);
						Thread.sleep(1500);
					}
				}

				if (found != true) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));

					d_search = 0;
					System.out.println(setBoldStart + "   DOCTOR RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				d_oos = new ObjectOutputStream(new FileOutputStream(file_doctor));
				d_oos.writeObject(d_collection);
				d_oos.close();
				break;

			case 0:
				main_menu();
				d_search = 0;
				break;

			default:
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
				Thread.sleep(1500);
				break;
			}
		} while (d_menu != 0);
	}

	@SuppressWarnings("unchecked")
	public static void appointment_records() throws Exception {
		record = 3;
		ArrayList<Appointment> a_collection = new ArrayList<Appointment>();
		ListIterator<Appointment> a_list = null;

		ArrayList<Patient> p_collection = new ArrayList<Patient>(); // initializes an array list of class patient
		ArrayList<Doctor> d_collection = new ArrayList<Doctor>(); // initializes an array list of class doctor

		Iterator<Patient> p_iteration = p_collection.iterator(); // initializes an iterator from class patient array
																	// list
		Iterator<Doctor> d_iteration = d_collection.iterator(); // initializes an iterator from class doctor array list

		File file_appointment = new File("appointment.txt");
		ObjectOutputStream a_oos = null;
		ObjectInputStream a_ois = null;

		if (file_appointment.isFile()) {
			a_ois = new ObjectInputStream(new FileInputStream(file_appointment));
			a_collection = (ArrayList<Appointment>) a_ois.readObject();
			a_ois.close();
		}

		/*
		 * the following code below is used to import and read patient.txt and
		 * doctor.txt in the java program. this then links all three classes altogether:
		 * appointments, doctor, and patient. this is VERY essential to the access
		 * operation which is case 3.
		 */
		File file_patient = new File("patient.txt");
		ObjectInputStream p_ois = null;

		if (file_patient.isFile()) {
			p_ois = new ObjectInputStream(new FileInputStream(file_patient));
			p_collection = (ArrayList<Patient>) p_ois.readObject();
			p_ois.close();
		}

		File file_doctor = new File("doctor.txt");
		ObjectInputStream d_ois = null;

		if (file_doctor.isFile()) {
			d_ois = new ObjectInputStream(new FileInputStream(file_doctor));
			d_collection = (ArrayList<Doctor>) d_ois.readObject();
			d_ois.close();
		}

		int a_menu;
		boolean found = false;
		int a_search = 0;

		do {

			Iterator<Appointment> a_iteration = a_collection.iterator();

			if (a_search == 0) {
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				while (a_iteration.hasNext()) {
					Appointment a_e = a_iteration.next();
					System.out.println(a_e);

				}
				System.out.println(
						" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			}

			System.out.println("\n" + "\n" + "\n");
			System.out.println("   +-----" + setBoldStart + "APPOINTMENT" + setBoldEnd + "-" + setBoldStart + "RECORDS"
					+ setBoldEnd + "-----+" + "\n   |" + "                             |");
			System.out.println("   |   1. add" + "                    |");
			System.out.println("   |   2. refresh" + "                |");
			System.out.println("   |   3. access" + "                 |");
			System.out.println("   |   4. search" + "                 |          enter " + setBoldStart + "000"
					+ setBoldEnd + " to cancel operation.");
			System.out.println("   |   5. update" + "                 |");
			System.out.println("   |   6. delete" + "                 |" + "\n   |" + "                             |");
			System.out.println("   |   0. back" + "                   |" + "\n   |" + "                             |");
			System.out.println("   +-----------------------------+" + "\n");
			System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);
			a_menu = scan_int.nextInt();

			switch (a_menu) {
			case 1: // add
				p_iteration = p_collection.iterator();
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.printf(setBoldStart + "\t\t\t\t\t\t\t\t\t\tPATIENT RECORDS" + setBoldEnd
						+ "\n\n +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
						+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%n", setBoldStart + "REGISTRATION ID",
						"    INSURANCE ID", "    NAME", "    GENDER", "    AGE", "    SYMPTOMS / FINDINGS",
						"    CONTACT NUMBER",
						"    HOME ADDRESS                                                                                         |"
								+ setBoldEnd);
				while (p_iteration.hasNext()) {
					Patient p_e = p_iteration.next();
					System.out.println(p_e);
				}
				System.out.println(
						" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");

				System.out.print("\n" + "   enter " + setBoldStart + "registration id" + setBoldEnd
						+ " of patient for appointment: \t");
				int a_patientid1 = scan_int.nextInt();
				if (a_patientid1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				d_iteration = d_collection.iterator();
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.printf(setBoldStart + "\t\t\t\t\t\t\tAVAILABLE DOCTORS" + setBoldEnd
						+ "\n\n +-------------------------------------------------------------------------------------------------------------------------+"
						+ "\n | " + "%-30s%-30s%-30s%-30s%n", setBoldStart + "STAFF ID", "    DOCTOR NAME",
						"    SPECIALIZATION", "    CONTACT NUMBER                |" + setBoldEnd);
				while (d_iteration.hasNext()) {
					Doctor d_e = d_iteration.next();
					System.out.println(d_e);
				}
				System.out.println(
						" +-------------------------------------------------------------------------------------------------------------------------+\n");

				System.out.print(
						"   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor for appointment: \t\t");
				int a_doctorid1 = scan_int.nextInt();
				if (a_doctorid1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.print("   enter " + setBoldStart + "room number" + setBoldEnd + " of appointment: \t\t\t");
				int a_room1 = scan_int.nextInt();
				if (a_room1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.print(
						"\n   enter " + setBoldStart + "month" + setBoldEnd + " of appointment date (1-12): \t\t");
				int a_datemonth1 = scan_int.nextInt();
				if (a_datemonth1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.print(
						"   enter " + setBoldStart + "day" + setBoldEnd + " of appointment date (1-28/29/30/31): \t");
				int a_dateday1 = scan_int.nextInt();
				if (a_dateday1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.print("   enter " + setBoldStart + "year" + setBoldEnd + " of appointment date: \t\t\t");
				int a_dateyear1 = scan_int.nextInt();
				if (a_dateyear1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.print("\n   enter " + setBoldStart + "time" + setBoldEnd + " of appointment: \t\t\t\t");
				String a_time = scan_string.nextLine();
				if (a_time.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   APPOINTMENT RECORD ADDED." + setBoldEnd);
				Thread.sleep(1500);

				a_collection.add(new Appointment(a_room1, a_patientid1, a_doctorid1, a_datemonth1, a_dateday1,
						a_dateyear1, a_time));

				a_search = 0;

				a_oos = new ObjectOutputStream(new FileOutputStream(file_appointment));
				a_oos.writeObject(a_collection);
				a_oos.close();
				break;

			case 2: // refresh
				a_search = 0;
				appointment_records();
				break;

			case 3: // access
				// initializes 3 booleans for finding doctor, patient, and appointment. all 3
				// are initially false.
				boolean doctor_found = false;
				boolean patient_found = false;
				boolean appointment_found = false;
				a_search = 1;

				/*
				 * the follow code below is then asking the user to input the registration id of
				 * patient and doctor staff id.
				 */
				System.out.print("\n" + "   enter " + setBoldStart + "registration id" + setBoldEnd
						+ " of patient in appointment: \t");
				int a_patientid = scan_int.nextInt();
				if (a_patientid == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				System.out.print(
						"   enter " + setBoldStart + "staff id" + setBoldEnd + " of doctor in appointment: \t\t");
				int a_doctorid = scan_int.nextInt();
				if (a_doctorid == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				a_iteration = a_collection.iterator();
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				while (a_iteration.hasNext()) {
					Appointment a_e = a_iteration.next();

					/*
					 * the following code below is the program checking if the patient id entered by
					 * the user is matching to the patient id and found in the array list of class
					 * appointment. if patient id matches, it will print patient information of that
					 * specific patient along with the appointment details above.
					 */
					if (a_e.getAppointmentPatientID() == a_patientid) {
						System.out.println(a_e);
						appointment_found = true;
						System.out.println(
								" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
					}
				}

				p_iteration = p_collection.iterator();
				while (p_iteration.hasNext()) {
					Patient p_e = p_iteration.next();

					if (p_e.getPatientID() == a_patientid) {
						patient_found = true;
						System.out.printf(
								" \n +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
										+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%n",
								setBoldStart + "REGISTRATION ID", "    INSURANCE ID", "    NAME", "    GENDER",
								"    AGE", "    SYMPTOMS / FINDINGS", "    CONTACT NUMBER",
								"    HOME ADDRESS                                                                                         |"
										+ setBoldEnd);
						System.out.println(p_e);
						System.out.println(
								" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
					}
				}

				/*
				 * the following code below is the program checking if the doctor id entered by
				 * the user is matching to the doctor id and found in the array list of class
				 * appointment. if doctor id matches, it will print doctor information of that
				 * specific doctor along with the appointment details above.
				 */
				d_iteration = d_collection.iterator();
				while (d_iteration.hasNext()) {
					Doctor d_e = d_iteration.next();

					if (d_e.getDoctorID() == a_doctorid) {
						doctor_found = true;
						System.out.printf(
								"\n +-------------------------------------------------------------------------------------------------------------------------+"
										+ "\n | " + "%-30s%-30s%-30s%-30s%n",
								setBoldStart + "STAFF ID", "    DOCTOR NAME", "    SPECIALIZATION",
								"    CONTACT NUMBER                |" + setBoldEnd);
						System.out.println(d_e);
						System.out.println(
								" +-------------------------------------------------------------------------------------------------------------------------+");
					}
				}
				/*
				 * the following code below is when any of the ids are not matching with the
				 * ones found in appointment records. it will print an error message.
				 */
				if (appointment_found != true) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println("\n   APPOINTMENT WITH PATIENT " + setBoldStart + "REGISTRATION ID NUMBER '"
							+ a_patientid + setBoldEnd + "' AND DOCTOR " + setBoldStart + "STAFF ID NUMBER '"
							+ a_doctorid + setBoldEnd + "' IS NOT REGISTERED IN APPOINTMENT RECORDS.");
				}

				if (patient_found != true) {
					System.out.println("\n   PATIENT " + setBoldStart + "REGISTRATION ID NUMBER '" + a_patientid
							+ setBoldEnd + "' IS NOT REGISTERED IN PATIENT RECORDS.");
				}

				if (doctor_found != true) {
					System.out.println("\n   DOCTOR " + setBoldStart + "STAFF ID NUMBER '" + a_doctorid + setBoldEnd
							+ "' IS NOT REGISTERED IN DOCTOR RECORDS.");
				}

				break;

			case 4: // search
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));

				int a_search_menu;
				a_search = 1;

				do {

					System.out.println("\n" + "\n" + "\n");

					System.out.println("   +-----" + setBoldStart + "APPOINTMENT" + setBoldEnd + "-" + setBoldStart
							+ "RECORDS" + setBoldEnd + "-----+" + "\n   |                             |");
					System.out.println(
							"   |   1. search via doctor id" + "   |" + "\n   |                             |");
					System.out.println("   |   2. search via month" + "       |");
					System.out.println("   |   3. search via year        |" + "         enter " + setBoldStart + "000"
							+ setBoldEnd + " to cancel operation.");
					System.out.println("   |   4. search via date" + "        |\n   |                             |");
					System.out.println("   |   0. back                   |" + "\n   |                             |");
					System.out.println("   +-----------------------------+" + "\n");
					System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);

					a_search_menu = scan_int.nextInt();

					switch (a_search_menu) {
					case 1: // search via doctor id
						found = false;

						System.out.print("\n" + "   enter " + setBoldStart + "staff id" + setBoldEnd
								+ " of doctor in appointment: \t");

						a_doctorid = scan_int.nextInt();
						if (a_doctorid == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						a_iteration = a_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));

						while (a_iteration.hasNext()) {
							Appointment a_e = a_iteration.next();

							if (a_e.getAppointmentDoctorID() == a_doctorid) {
								System.out.println(a_e);
								found = true;
							}
						}

						System.out.println(
								" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							found = false;
						}
						break;

					case 2: // search via month
						System.out.print("\n" + "   enter " + setBoldStart + "month" + setBoldEnd
								+ " of appointment (1-12): \t");
						int a_datemonth = scan_int.nextInt();
						if (a_datemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						a_iteration = a_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (a_iteration.hasNext()) {
							Appointment a_e = a_iteration.next();

							if (a_e.getAppointmentDateMonth() == a_datemonth) {
								System.out.println(a_e);
								found = true;
							}
						}

						System.out.println(
								" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							found = false;
						}
						break;

					case 3: // search via year
						System.out.print("\n   enter " + setBoldStart + "year" + setBoldEnd + " of appointment:  \t\t");
						int a_dateyear = scan_int.nextInt();
						if (a_dateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						a_iteration = a_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (a_iteration.hasNext()) {
							Appointment a_e = a_iteration.next();

							if (a_e.getAppointmentDateYear() == a_dateyear) {
								System.out.println(a_e);
								found = true;
							}
						}

						System.out.println(
								" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							found = false;
						}
						break;

					case 4: // search via date
						System.out.print("\n   enter " + setBoldStart + "month" + setBoldEnd
								+ " of appointment date (1-12): \t\t");
						a_datemonth = scan_int.nextInt();
						if (a_datemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print("   enter " + setBoldStart + "day" + setBoldEnd
								+ " of appointment date (1-28/29/30/31): \t");
						int a_dateday = scan_int.nextInt();
						if (a_dateday == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "year" + setBoldEnd + " of appointment date: \t\t\t");
						a_dateyear = scan_int.nextInt();
						if (a_dateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						a_iteration = a_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (a_iteration.hasNext()) {
							Appointment a_e = a_iteration.next();

							if (a_e.getAppointmentDateMonth() == a_datemonth && a_e.getAppointmentDateDay() == a_dateday
									&& a_e.getAppointmentDateYear() == a_dateyear) {
								System.out.println(a_e);
								found = true;
							}
						}

						System.out.println(
								" +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							found = false;
						}
						break;

					case 0: // back
						appointment_records();
						a_search = 0;
						break;

					default:
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN" + setBoldEnd);
						Thread.sleep(1500);
						break;
					}
				} while (a_search_menu != 0);

			case 5: // update
				if (file_appointment.isFile()) {
					a_ois = new ObjectInputStream(new FileInputStream(file_appointment));
					a_collection = (ArrayList<Appointment>) a_ois.readObject();
					a_ois.close();
				}

				found = false;

				a_iteration = a_collection.iterator();
				a_list = a_collection.listIterator();

				System.out.print("   enter " + setBoldStart + "room number" + setBoldEnd + " of appointment: ");
				int a_room = scan_int.nextInt();
				if (a_room == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				while (a_list.hasNext()) {
					Appointment a_e = a_list.next();

					if (a_e.getAppointmentRoom() == a_room) {
						p_iteration = p_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						System.out.printf(setBoldStart + "\t\t\t\t\t\t\t\t\t\tPATIENT RECORDS" + setBoldEnd
								+ "\n\n +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%n",
								setBoldStart + "REGISTRATION ID", "    INSURANCE ID", "    NAME", "    GENDER",
								"    AGE", "    SYMPTOMS / FINDINGS", "    CONTACT NUMBER",
								"    HOME ADDRESS                                                                                         |"
										+ setBoldEnd);
						while (p_iteration.hasNext()) {
							Patient p_e = p_iteration.next();
							System.out.println(p_e);
						}
						System.out.println(
								" +-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");

						System.out.print("\n" + "   enter " + setBoldStart + "NEW registration id" + setBoldEnd
								+ " of patient for appointment: \t");
						a_patientid1 = scan_int.nextInt();
						if (a_patientid1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						d_iteration = d_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						System.out.printf(setBoldStart + "\t\t\t\t\t\t\tAVAILABLE DOCTORS" + setBoldEnd
								+ "\n\n +-------------------------------------------------------------------------------------------------------------------------+"
								+ "\n | " + "%-30s%-30s%-30s%-30s%n", setBoldStart + "STAFF ID", "    DOCTOR NAME",
								"    SPECIALIZATION", "    CONTACT NUMBER                |" + setBoldEnd);
						while (d_iteration.hasNext()) {
							Doctor d_e = d_iteration.next();
							System.out.println(d_e);
						}
						System.out.println(
								" +-------------------------------------------------------------------------------------------------------------------------+\n");

						System.out.print("   enter " + setBoldStart + "NEW staff id" + setBoldEnd
								+ " of doctor for appointment: \t\t");
						a_doctorid1 = scan_int.nextInt();
						if (a_doctorid1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						System.out.print("   enter " + setBoldStart + "NEW room number" + setBoldEnd
								+ " of appointment: \t\t\t");
						a_room1 = scan_int.nextInt();
						if (a_room1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print("\n   enter " + setBoldStart + "NEW month" + setBoldEnd
								+ " of appointment date (1-12): \t\t\t");
						a_datemonth1 = scan_int.nextInt();
						if (a_datemonth1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW day" + setBoldEnd
								+ " of appointment date (1-28/29/30/31): \t\t");
						a_dateday1 = scan_int.nextInt();
						if (a_dateday1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW year" + setBoldEnd
								+ " of appointment date: \t\t\t\t");
						a_dateyear1 = scan_int.nextInt();
						if (a_dateyear1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						System.out.print(
								"\n   enter " + setBoldStart + "NEW time" + setBoldEnd + " of appointment: \t\t\t\t");
						a_time = scan_string.nextLine();
						if (a_time.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							appointment_records();
						}

						a_list.set(new Appointment(a_room1, a_patientid1, a_doctorid1, a_datemonth1, a_dateday1,
								a_dateyear1, a_time));
						found = true;
					}
				}

				if (found) {
					a_oos = new ObjectOutputStream(new FileOutputStream(file_appointment));
					a_oos.writeObject(a_collection);
					a_oos.close();
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println("   " + setBoldStart + "APPOINTMENT RECORD UPDATED." + setBoldEnd);
					Thread.sleep(1500);
				}

				else {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}
				break;

			case 6: // delete
				System.out
						.print("\n" + "   enter " + setBoldStart + "room number" + setBoldEnd + " of appointment: \t");
				a_room = scan_int.nextInt();
				if (a_room == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					appointment_records();
				}

				a_iteration = a_collection.iterator();
				while (a_iteration.hasNext()) {
					Appointment a_e = a_iteration.next();

					if (a_e.getAppointmentRoom() == a_room) {
						a_iteration.remove();
						found = true;
						a_search = 1;
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						a_search = 0;
						System.out.println(setBoldStart + "   APPOINTMENT RECORD DELETED." + setBoldEnd);
						Thread.sleep(1500);
					}
				}

				if (found != true) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					a_search = 0;
					System.out.println(setBoldStart + "   APPOINTMENT RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				a_oos = new ObjectOutputStream(new FileOutputStream(file_appointment));
				a_oos.writeObject(a_collection);
				a_oos.close();
				break;

			case 0: // back
				main_menu();
				a_search = 0;
				break;

			default:
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
				Thread.sleep(1500);
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				break;
			}
		} while (a_menu != 0);
	}

	@SuppressWarnings("unchecked")
	public static void medicine_records() throws Exception {
		record = 4;
		ArrayList<Medicine> m_collection = new ArrayList<Medicine>();
		ListIterator<Medicine> m_list = null;

		File file_medicine = new File("medicine.txt");
		ObjectOutputStream m_oos = null;
		ObjectInputStream m_ois = null;

		if (file_medicine.isFile()) {
			m_ois = new ObjectInputStream(new FileInputStream(file_medicine));
			m_collection = (ArrayList<Medicine>) m_ois.readObject();
			m_ois.close();
		}

		int m_menu;
		int m_search = 0;

		do {
			Iterator<Medicine> m_iteration = m_collection.iterator();

			if (m_search == 0) {
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));

				while (m_iteration.hasNext()) {
					Medicine m_e = m_iteration.next();
					System.out.println(m_e);
				}
				System.out.println(
						"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			}

			System.out.println("\n" + "\n" + "\n");
			System.out.println("   +-----" + setBoldStart + "MEDICINE" + setBoldEnd + "-" + setBoldStart + "RECORDS"
					+ setBoldEnd + "-----+" + "\n   |" + "                          |");
			System.out.println("   |   1. add" + "                 |");
			System.out.println("   |   2. refresh" + "             |");
			System.out.println("   |   3. search" + "              |          enter " + setBoldStart + "000"
					+ setBoldEnd + " to cancel operation.");
			System.out.println("   |   4. update" + "              |");
			System.out.println("   |   5. delete" + "              |" + "\n   |" + "                          |");
			System.out.println("   |   0. back" + "                |" + "\n   |" + "                          |");
			System.out.println("   +--------------------------+" + "\n");
			System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);
			m_menu = scan_int.nextInt();

			switch (m_menu) {
			case 1: // add
				System.out.print("\n" + "   enter " + setBoldStart + "id number" + setBoldEnd + " of medicine: \t\t\t");
				int m_id1 = scan_int.nextInt();
				if (m_id1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "name" + setBoldEnd + " of medicine: \t\t\t\t");
				String m_name = scan_string.nextLine();
				if (m_name.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "weight / mass" + setBoldEnd + " of medicine (mg): \t\t");
				String m_strength = scan_string.nextLine();
				if (m_strength.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "definition" + setBoldEnd + " of medicine: \t\t\t");
				String m_definition = scan_string.nextLine();
				if (m_definition.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "mitigation(s)" + setBoldEnd + " of medicine: \t\t\t");
				String m_treatment = scan_string.nextLine();
				if (m_treatment.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print(
						"   enter " + setBoldStart + "possible side effects" + setBoldEnd + " of medicine: \t\t");
				String m_sideeffects = scan_string.nextLine();
				if (m_sideeffects.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "instructions" + setBoldEnd + " of medicine: \t\t\t");
				String m_instructions = scan_string.nextLine();
				if (m_instructions.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "important note(s)" + setBoldEnd + " of medicine: \t\t");
				String m_note = scan_string.nextLine();
				if (m_note.equals("000")) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out
						.print("\n   enter " + setBoldStart + "month" + setBoldEnd + " of expiry date (1-12): \t\t\t");
				int m_expirydatemonth = scan_int.nextInt();
				if (m_expirydatemonth == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print(
						"   enter " + setBoldStart + "day" + setBoldEnd + " of expiry date (1-28/29/30/31): \t\t");
				int m_expirydateday = scan_int.nextInt();
				if (m_expirydateday == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "year" + setBoldEnd + " of expiry date: \t\t\t\t");
				int m_expirydateyear = scan_int.nextInt();
				if (m_expirydateyear == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print(
						"\n   enter " + setBoldStart + "month" + setBoldEnd + " of manufacturing date (1-12): \t\t");
				int m_approvaldatemonth1 = scan_int.nextInt();
				if (m_approvaldatemonth1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print(
						"   enter " + setBoldStart + "day" + setBoldEnd + " of manufacturing date (1-28/29/30/31): \t");
				int m_approvaldateday1 = scan_int.nextInt();
				if (m_approvaldateday1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				System.out.print("   enter " + setBoldStart + "year" + setBoldEnd + " of manufacturing date: \t\t\t");
				int m_approvaldateyear1 = scan_int.nextInt();
				if (m_approvaldateyear1 == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				m_collection.add(new Medicine(m_id1, m_name, m_strength, m_definition, m_treatment, m_sideeffects,
						m_instructions, m_note, m_expirydatemonth, m_expirydateday, m_expirydateyear,
						m_approvaldatemonth1, m_approvaldateday1, m_approvaldateyear1));

				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   MEDICINE RECORD ADDED." + setBoldEnd);
				Thread.sleep(1500);

				m_oos = new ObjectOutputStream(new FileOutputStream(file_medicine));
				m_oos.writeObject(m_collection);
				m_oos.close();

				m_search = 0;
				break;

			case 2: // refresh
				medicine_records();
				m_search = 0;
				break;

			case 3: // search
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));

				int m_search_menu;
				m_search = 1;

				do {
					System.out.println("\n\n\n");
					System.out.println(
							"   +------------" + setBoldStart + "MEDICINE" + setBoldEnd + "-" + setBoldStart + "RECORDS"
									+ setBoldEnd + "------------+" + "\n   |                                        |");
					System.out.println("   |   1. search via medicine id            |"
							+ "\n   |                                        |");
					System.out.println("   |   2. search via manufacturing month    |");
					System.out.println("   |   3. search via manufacturing year     |");
					System.out.println("   |   4. search via manufacturing date     |" + "          enter "
							+ setBoldStart + "000" + setBoldEnd + " to cancel operation."
							+ "\n   |                                        |");
					System.out.println("   |   5. search via expiry month           |");
					System.out.println("   |   6. search via expiry year            |");
					System.out.println("   |   7. search via expiry date            |"
							+ "\n   |                                        |");
					System.out.println("   |   0. back                              |"
							+ "\n   |                                        |");
					System.out.println("   +----------------------------------------+" + "\n");
					System.out.print(setBoldStart + "   enter operation: " + setBoldEnd);

					m_search_menu = scan_int.nextInt();

					switch (m_search_menu) {
					case 1: // search via id
						boolean found = false;

						System.out.print("\n   enter " + setBoldStart + "id number" + setBoldEnd + " of medicine: \t");
						int m_id = scan_int.nextInt();
						if (m_id == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();

						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineID() == m_id) {
								System.out.println(new String(new char[70]).replace("\0", "\r\n"));
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}
						break;

					case 2: // search via manufacturing month
						found = false;

						System.out.print("\n" + "   enter " + setBoldStart + "month" + setBoldEnd
								+ " of manufacturing date (1-12): \t");
						int m_approvaldatemonth = scan_int.nextInt();
						if (m_approvaldatemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineApprovalDateMonth() == m_approvaldatemonth) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}
						break;

					case 3: // search via manufacturing year
						found = false;

						System.out.print(
								"\n" + "   enter " + setBoldStart + "year" + setBoldEnd + " of manufacturing date: \t");
						int m_approvaldateyear = scan_int.nextInt();
						if (m_approvaldateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineApprovalDateYear() == m_approvaldateyear) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}

						break;

					case 4: // search via manufacturing date
						found = false;

						System.out.print("\n" + "   enter " + setBoldStart + "month" + setBoldEnd
								+ " of manufacturing date (1-12): \t\t");
						m_approvaldatemonth = scan_int.nextInt();
						if (m_approvaldatemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "day" + setBoldEnd
								+ " of manufacturing date (1-28/29/30/31): \t");
						int m_approvaldateday = scan_int.nextInt();
						if (m_approvaldateday == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "year" + setBoldEnd + " of manufacturing date: \t\t\t");
						m_approvaldateyear = scan_int.nextInt();
						if (m_approvaldateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineApprovalDateMonth() == m_approvaldatemonth
									&& m_e.getMedicineApprovalDateDay() == m_approvaldateday
									&& m_e.getMedicineApprovalDateYear() == m_approvaldateyear) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}

						break;

					case 5: // search via expiry month
						found = false;

						System.out.print("\n" + "   enter " + setBoldStart + "month" + setBoldEnd
								+ " of expiry date (1-12): \t");
						m_expirydatemonth = scan_int.nextInt();
						if (m_expirydatemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineExpiryDateMonth() == m_expirydatemonth) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}

						break;

					case 6: // search via expiry year
						found = false;

						System.out
								.print("\n" + "   enter " + setBoldStart + "year" + setBoldEnd + " of expiry date: \t");
						m_expirydateyear = scan_int.nextInt();
						if (m_expirydateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineExpiryDateYear() == m_expirydateyear) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}
						break;

					case 7: // search via exiry date
						found = false;

						System.out.print("\n" + "   enter " + setBoldStart + "month" + setBoldEnd
								+ " of expiry date (1-12): \t\t");
						m_expirydatemonth = scan_int.nextInt();
						if (m_expirydatemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "day" + setBoldEnd + " expiry date (1-28/29/30/31): \t");
						m_expirydateday = scan_int.nextInt();
						if (m_expirydateday == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "year" + setBoldEnd + " of expiry date: \t\t\t");
						m_expirydateyear = scan_int.nextInt();
						if (m_expirydateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_iteration = m_collection.iterator();
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						while (m_iteration.hasNext()) {
							Medicine m_e = m_iteration.next();

							if (m_e.getMedicineExpiryDateMonth() == m_expirydatemonth
									&& m_e.getMedicineExpiryDateDay() == m_expirydateday
									&& m_e.getMedicineExpiryDateYear() == m_expirydateyear) {
								System.out.println(m_e);
								found = true;
								m_search = 1;
							}
						}

						System.out.println(
								"\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

						if (found != true) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
							Thread.sleep(1500);
						}
						break;

					case 0: // back
						medicine_records();
						m_search = 0;
						break;

					default:
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
						Thread.sleep(1500);
					}
				} while (m_search_menu != 0);

			case 4: // update
				if (file_medicine.isFile()) {
					m_ois = new ObjectInputStream(new FileInputStream(file_medicine));
					m_collection = (ArrayList<Medicine>) m_ois.readObject();
					m_ois.close();
				}

				boolean found = false;

				m_iteration = m_collection.iterator();
				m_list = m_collection.listIterator();

				System.out.print("   enter " + setBoldStart + "id number" + setBoldEnd + " of medicine: ");
				int m_id = scan_int.nextInt();
				if (m_id == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				while (m_list.hasNext()) {
					Medicine m_e = m_list.next();

					if (m_e.getMedicineID() == m_id) {
						System.out.print("\n" + "   enter " + setBoldStart + "NEW id number" + setBoldEnd
								+ " of medicine: \t\t\t");
						m_id1 = scan_int.nextInt();
						if (m_id1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out
								.print("   enter " + setBoldStart + "NEW name" + setBoldEnd + " of medicine: \t\t\t\t");
						m_name = scan_string.nextLine();
						if (m_name.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW weight / mass" + setBoldEnd
								+ " of medicine (mg): \t\t");
						m_strength = scan_string.nextLine();
						if (m_strength.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW definition" + setBoldEnd + " of medicine: \t\t\t");
						m_definition = scan_string.nextLine();
						if (m_definition.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW mitigation(s)" + setBoldEnd + " of medicine: \t\t");
						m_treatment = scan_string.nextLine();
						if (m_definition.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW possible side effects" + setBoldEnd
								+ " of medicine: \t");
						m_sideeffects = scan_string.nextLine();
						if (m_definition.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW instructions" + setBoldEnd + " of medicine: \t\t\t");
						m_instructions = scan_string.nextLine();
						if (m_instructions.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW important note(s)" + setBoldEnd
								+ " of medicine: \t\t");
						m_note = scan_string.nextLine();
						if (m_note.equals("000")) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("\n   enter " + setBoldStart + "NEW month" + setBoldEnd
								+ " of expiry date (1-12): \t\t");
						m_expirydatemonth = scan_int.nextInt();
						if (m_expirydatemonth == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW day" + setBoldEnd
								+ "  of expiry date (1-28/29/30/31): \t");
						m_expirydateday = scan_int.nextInt();
						if (m_expirydateday == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW year" + setBoldEnd + " of expiry date: \t\t\t");
						m_expirydateyear = scan_int.nextInt();
						if (m_expirydateyear == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("\n   enter " + setBoldStart + "NEW month" + setBoldEnd
								+ " of manufacturing date (1-12): \t");
						m_approvaldatemonth1 = scan_int.nextInt();
						if (m_approvaldatemonth1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print("   enter " + setBoldStart + "NEW day" + setBoldEnd
								+ " of manufacturing date (1-28/29/30/31): ");
						m_approvaldateday1 = scan_int.nextInt();
						if (m_approvaldateday1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						System.out.print(
								"   enter " + setBoldStart + "NEW year" + setBoldEnd + " of manufacturing date: \t\t");
						m_approvaldateyear1 = scan_int.nextInt();
						if (m_approvaldateyear1 == 000) {
							System.out.println(new String(new char[70]).replace("\0", "\r\n"));
							System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
							Thread.sleep(1500);
							medicine_records();
						}

						m_list.set(new Medicine(m_id1, m_name, m_strength, m_definition, m_treatment, m_sideeffects,
								m_instructions, m_note, m_expirydatemonth, m_expirydateday, m_expirydateyear,
								m_approvaldatemonth1, m_approvaldateday1, m_approvaldateyear1));
						found = true;
					}
				}

				if (found) {
					m_oos = new ObjectOutputStream(new FileOutputStream(file_medicine));
					m_oos.writeObject(m_collection);
					m_oos.close();
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println("   " + setBoldStart + "MEDICINE RECORD UPDATED." + setBoldEnd);
					Thread.sleep(1500);
				}

				else {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				break;

			case 5: // delete
				found = false;

				System.out.print("\n" + "   enter " + setBoldStart + "id number" + setBoldEnd + " of medicine: \t");
				m_id = scan_int.nextInt();
				if (m_id == 000) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   OPERATION CANCELLED." + setBoldEnd);
					Thread.sleep(1500);
					medicine_records();
				}

				m_iteration = m_collection.iterator();
				while (m_iteration.hasNext()) {
					Medicine m_e = m_iteration.next();

					if (m_e.getMedicineID() == m_id) {
						System.out.println(new String(new char[70]).replace("\0", "\r\n"));
						m_iteration.remove();
						System.out.println(setBoldStart + "   MEDICINE RECORD DELETED." + setBoldEnd);
						found = true;
						Thread.sleep(1500);
					}
				}

				if (!found) {
					System.out.println(new String(new char[70]).replace("\0", "\r\n"));
					System.out.println(setBoldStart + "   MEDICINE RECORD NOT FOUND." + setBoldEnd);
					Thread.sleep(1500);
				}

				m_oos = new ObjectOutputStream(new FileOutputStream(file_medicine));
				m_oos.writeObject(m_collection);
				m_oos.close();

				m_search = 0;
				break;

			case 0: // back
				main_menu();
				m_search = 0;
				break;

			default:
				System.out.println(new String(new char[70]).replace("\0", "\r\n"));
				System.out.println(setBoldStart + "   INVALID INPUT. PLEASE TRY AGAIN." + setBoldEnd);
				Thread.sleep(1500);
				break;
			}
		} while (m_menu != 0);
	}

	public static void about_program() throws Exception {
		record = 5;
		System.out.println(new String(new char[70]).replace("\0", "\r\n"));
		int about_ch;

		System.out.println("   " + setBoldStart + "MODULE TITLE:" + setBoldEnd + " 	SOFTWARE ENGINEERING 4201");
		System.out.println(
				"   " + setBoldStart + "ASSIGNMENT TITLE:" + setBoldEnd + " 	BELL HOSPITAL MANAGEMENT SYSTEM\n");
		System.out.println("   " + setBoldStart + "COMPLETED BY:" + setBoldEnd + "		LES PAUL RANALAN");
		System.out.println("   " + setBoldStart + "COMPLETION DATE:" + setBoldEnd + " 	DEC. 6, 2022\n");
		System.out.println("   " + setBoldStart + "BUILD NUMBER:" + setBoldEnd + " 	1.0\n\n\n");

		System.out.println("   " + setBoldStart + "RECORDS:" + setBoldEnd
				+ "\n   as of version 1.0, the user can interact with 4 records. below are the list of all records:\n\n   1. patient records\n   	- this is where all patient informations are stored.\n   	- a single entry contains 1 patient.\n   	- its data is stored in a .txt or text file named 'patient.txt'.\n\n   2. doctor records\n   	- this is where all doctor informations are stored.\n   	- a single entry contains 1 doctor.\n   	- its data is stored in a .txt file or text file named 'doctor.txt'.\n\n   3. appointment records\n   	- this is where all appointment information is stored.\n   	- a single entry contains 1 patient, 1 doctor, and 1 appointment.\n   	- its data is stored in a .txt or text file named 'appointment.txt'.\n\n   4. medicine records\n   	- this is where all medicine informations are stored.\n   	- a single entry contains 1 medicine.\n   	- its data is stored in a .txt or text file named 'medicine.txt'.\n\n   each record is unique as it contains different data stored in a .txt file, the idea of storing data on .txt files makes\n   it even more convenient and fitting as the data can be linked with data from different records and the data is still present\n   even when the program is terminated.\n   however, when opening the .txt files, the data is encrypted and can only be read by java.\n   "
				+ setBoldStart + "NOTE: THE ACCESS OPERATION IS ONLY AVAILABLE FOR APPOINTMENT RECORDS." + setBoldEnd);

		System.out.println("\n\n\n   " + setBoldStart + "OPERATIONS:" + setBoldEnd
				+ "\n   as of version 1.0, the user can utilize numerous operations.\n   below is the list of the essential operations in this version:\n\n   1. add\n   	- add a new entry to the current record.\n   	- i.e.: to register a new patient to the hospital.\n\n   2. refresh\n   	- refresh or restart the entries in the current record.\n   	- i.e.: to rebuild the current entries to see any changes in the record.\n\n   3. access ("
				+ setBoldStart + "only available for appointment records" + setBoldEnd
				+ ")\n   	- display further information about an entry in the current record.\n   	- i.e.: to display the patient and doctor details of a specific id number in an appointment.\n\n   4. search\n   	- display only a specific entry in the current record.\n   	- i.e.: to display information on a specific registered patient in the hosital.\n\n   5. update\n   	- modify a specific entry in the current records.\n   	- i.e.: to search a specific doctor via id number and change their specialization and contact number.\n\n   6. delete\n   	- remove an entry in the current record.\n   	- i.e.: to remove a specific medicine in the catalog using its id number.\n");

		System.out.println("\n\n\n");
		System.out.println("\n   +---------" + setBoldStart + "ABOUT" + setBoldEnd + "-" + setBoldStart + "PROGRAM"
				+ setBoldEnd + "---------+" + "\n   |                               |");
		System.out.println("   |   0. exit                     |\n   |                               |");
		System.out.println("   +-------------------------------+");

		System.out.print(setBoldStart + "\n   enter operation: " + setBoldEnd);
		about_ch = scan_int.nextInt();
		if (about_ch == 0) {
			main_menu();
		}
	}
}