package patient;

/*********************************************************************
Defines general patient attributes, such as name, attending physician,
symptoms, treatment, diagnosis and patient response. Implements the
IPatient interface.

@author Dale Burke
@version September 2014
*********************************************************************/
public abstract class Patient implements IPatient {

	/** patient's ID number */
	private int number;
	
	/** patient's name */
	private String name;
	
	/** patient's age */
	private int age;
	
	/** patient's symptom */
	private String symptom;
	
/*********************************************************************
Constructor method for Patient class. Requires a number, name, age, 
and symptom to be associated with the patient.

@param id the patient's identification number
@param name the patient's name
@param age the patient's age
@param symptom the patient's symptom
@return none
*********************************************************************/
	protected Patient(int number, String name, int age, String symptom) {
		this.number = number;
		this.name = name;
		this.age = age;
		this.symptom = symptom;
	}
	
	/** to be implemented in one of the patient subclasses */
	public abstract String type();
	public abstract String response();
	public abstract String treatment();
	public abstract String billing();
	public abstract String doctor();
	public abstract int priority();
	public abstract String section();
	public abstract String[] validSymptoms();
	public abstract boolean validAge(int i);

/*********************************************************************
Method to return a patient's ID number.

@param none
@return int patient ID number
*********************************************************************/
	public int number() {
		return number;
	}
	
/*********************************************************************
Method to set a patient's ID number.

@param int patient's ID number
@return none
*********************************************************************/
	public void setNumber(int i) {
		number = i;
	}
	
/*********************************************************************
Method to return a patient's name.

@param none
@return String patient name
*********************************************************************/
	public String name() {
		return name;
	}
	
/*********************************************************************
Method to set a patient's name.

@param String patient name
@return none
*********************************************************************/
	public void setName(String n) {
		name = n;
	}

/*********************************************************************
Method to return a patient's name.

@param none
@return int patient age
*********************************************************************/
	public int age() {
		return age;
	}
	
/*********************************************************************
Method to return a patient's symptom.

@param none
@return String patient symptom
*********************************************************************/
	public String symptom() {
		return symptom;
	}
	
/*********************************************************************
Method to set a patient's symptom.

@param String patient symptom
@return none
*********************************************************************/
	public void symptom(String s) {
		symptom = s;
	}
}
