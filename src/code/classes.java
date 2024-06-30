package code;

import java.io.*;

class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	private int p_id, p_age;
	private String p_name, p_insurance, p_symptoms, p_address, p_number, p_gender;

	Patient(int p_id, String p_insurance, String p_name, String p_gender, int p_age, String p_symptoms,
			String p_address, String p_number) { // setter injection for class patient
		this.p_id = p_id;
		this.p_insurance = p_insurance;
		this.p_gender = p_gender;
		this.p_age = p_age;
		this.p_name = p_name;
		this.p_symptoms = p_symptoms;
		this.p_address = p_address;
		this.p_number = p_number;
	}

	public int getPatientID() { // getter injection to return patient id
		return p_id;
	}

	public String toString() { // getter injection using toString function to return format of patient information
		return String.format(
				" |-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|"
						+ "\n | " + "%-20s%-20s%-30s%-10s%-10s%-30s%-25s%-100s%s",
				p_id, p_insurance, p_name, p_gender, p_age, p_symptoms, p_number, p_address, " |");
	}
}

class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int d_id;
	private String d_name, d_spec, d_number;

	Doctor(int d_id, String d_name, String d_spec, String d_number) { // setter injection for class doctor
		this.d_name = d_name;
		this.d_spec = d_spec;
		this.d_number = d_number;
		this.d_id = d_id;
	}

	public int getDoctorID() { // getter injection to return doctor id
		return d_id;
	}

	public String toString() { // getter injetion using toString function to return format of doctor information
		return String.format(
				" |-------------------------------------------------------------------------------------------------------------------------|"
						+ "\n | " + "%-30s%-30s%-30s%-30s%s",
				d_id, d_name, d_spec, d_number, "|");
	}
}

class Appointment implements Serializable {
	private final static String setBoldStart = "\033[1m";
	private final static String setBoldEnd = "\033[0m";

	private static final long serialVersionUID = 1L;
	private int a_room, a_patientid, a_doctorid, a_datemonth, a_dateyear, a_dateday;
	private String a_time;

	Appointment(int a_room, int a_patientid, int a_doctorid, int a_datemonth, int a_dateday, int a_dateyear,
			String a_time) { // setter injection for class appointment
		this.a_room = a_room;
		this.a_patientid = a_patientid;
		this.a_doctorid = a_doctorid;
		this.a_datemonth = a_datemonth;
		this.a_dateyear = a_dateyear;
		this.a_dateday = a_dateday;
		this.a_time = a_time;
	}

	public int getAppointmentRoom() { // getter injection to return appointment room
		return a_room;
	}

	public int getAppointmentDateMonth() { // getter injection to return month of appointment date
		return a_datemonth;
	}

	public int getAppointmentDateDay() { // getter injection to return day of appointment date
		return a_dateday;
	}

	public int getAppointmentDateYear() { // getter injection to return year of appointment date
		return a_dateyear;
	}

	public int getAppointmentDoctorID() { // getter injection to return doctor id
		return a_doctorid;
	}

	public int getAppointmentPatientID() { // getter injection to return patient id
		return a_patientid;
	}

	public String toString() { // getter injetion using toString function to return format of appointment information
		return " +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n"
				+ "\n      " + setBoldStart + "ROOM NUMBER: \t\t\t" + setBoldEnd + a_room + "\n\n      " + setBoldStart
				+ "PATIENT REGISTRATION ID: \t\t" + setBoldEnd + a_patientid + "\n      " + setBoldStart
				+ "DOCTOR STAFF ID: \t\t\t" + setBoldEnd + a_doctorid + "\n       " + "\n      " + setBoldStart
				+ "DATE (MM/DD/YYYY): \t\t" + setBoldEnd + a_datemonth + "/" + a_dateday + "/" + a_dateyear + "\n      "
				+ setBoldStart + "TIME: \t\t\t\t" + setBoldEnd + a_time + "\n";
	}
}

class Medicine implements Serializable {
	private final static String setBoldStart = "\033[1m";
	private final static String setBoldEnd = "\033[0m";

	private static final long serialVersionUID = 1L;
	private int m_id, m_approvaldateday, m_approvaldatemonth, m_approvaldateyear, m_expirydateday, m_expirydatemonth,
			m_expirydateyear;
	private String m_name, m_strength, m_instructions, m_definition, m_treatment, m_sideeffects, m_note;

	Medicine(int m_id, String m_name, String m_strength, String m_definition, String m_treatment, String m_sideeffects,
			String m_instructions, String m_note, int m_expirydatemonth, int m_expirydateday, int m_expirydateyear,
			int m_approvaldatemonth, int m_approvaldateday, int m_approvaldateyear) { // setter injection for class medicine
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_strength = m_strength;
		this.m_definition = m_definition;
		this.m_instructions = m_instructions;
		this.m_note = m_note;
		this.m_treatment = m_treatment;
		this.m_sideeffects = m_sideeffects;
		this.m_expirydatemonth = m_expirydatemonth;
		this.m_expirydateday = m_expirydateday;
		this.m_expirydateyear = m_expirydateyear;
		this.m_approvaldatemonth = m_approvaldatemonth;
		this.m_approvaldateday = m_approvaldateday;
		this.m_approvaldateyear = m_approvaldateyear;
	}

	public int getMedicineID() { // getter injection to return medicine id
		return m_id;
	}

	public int getMedicineApprovalDateMonth() { // getter injection to return medicine approval date
		return m_approvaldatemonth;
	}

	public int getMedicineApprovalDateDay() { // getter injection to return month of approval date
		return m_approvaldateday;
	}

	public int getMedicineApprovalDateYear() { // getter injection to return year of approval date
		return m_approvaldateyear;
	}

	public int getMedicineExpiryDateMonth() { // getter injection to return month of expiry date
		return m_expirydatemonth;
	}

	public int getMedicineExpiryDateDay() { // getter injection to return day of expiry date
		return m_expirydateday;
	}

	public int getMedicineExpiryDateYear() { // getter injection to return year of expiry date
		return m_expirydateyear;
	}

	public String toString() { // getter injection using toSring function to return format of medicine information
		return "\n +------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n"
				+ "\n      " + setBoldStart + "MEDICINE ID: \t\t\t" + setBoldEnd + m_id + "\n      " + setBoldStart
				+ "MEDICINE NAME: \t\t\t" + setBoldEnd + m_name + " (" + m_strength + "mg" + ")" + "\n\n      "
				+ setBoldStart + "MEDICINE DEFINITION: \t\t" + setBoldEnd + m_definition + "\n      " + setBoldStart
				+ "MITIGATION: \t\t\t" + setBoldEnd + m_treatment + setBoldStart + "\n      "
				+ "POSSIBLE SIDE EFFECTS: \t\t" + setBoldEnd + m_sideeffects + "\n\n" + setBoldStart
				+ "      MANUFACTURING DATE (MM/DD/YYYY): \t" + setBoldEnd + m_approvaldatemonth + "/" + m_approvaldateday
				+ "/" + m_approvaldateyear + "\n      " + setBoldStart + "EXPIRY DATE (MM/DD/YYYY): \t" + setBoldEnd
				+ m_expirydatemonth + "/" + m_expirydateday + "/" + m_expirydateyear + "\n\n      " + setBoldStart
				+ "INSTRUCTIONS: \t\t\t" + setBoldEnd + m_instructions + setBoldStart + "\n      IMPORT NOTE(S): \t\t\t"
				+ setBoldEnd + m_note;
	}
}