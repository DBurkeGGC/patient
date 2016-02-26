package patient;

/*********************************************************************
Patient interface.

@author Dale Burke
@version September 2014
*********************************************************************/
public interface IPatient {

	/**
	 * Returns a statement on how the patient will be billed. Non-adult
	 * patients will require assistance from adults.
	 * 
	 * @return how to bill the patient.
	 */
	String billing();
	
	/**
	 * Returns the priority rating for this patient based on patient age
	 * and symptom.
	 * 
	 * @return the patient's priority rating.
	 */
	int priority();
	
	/**
	 * Assigns and returns the patient's doctor, differs based on patient
	 * age group and ailment.
	 * 
	 * @return the patient's doctor.
	 */
	String doctor();
	
	/**
	 * Returns the subclass type / age grouping of the patient.
	 * 
	 * @return the patient's type of age group.
	 */
	String type();
	
	/**
	 * Returns the section of the hospital the patient should be assigned to.
	 * Different age groups and ailments are treated in different areas.
	 * 
	 * @return the hospital section the patient should be assigned to.
	 */
	String section();
	
	/**
	 * Returns the last verbal response of the patient.
	 * 
	 * @return the patient's last response.
	 */
	String response();
	
	/**
	 * Returns the recommended treatment for this patient.
	 * 
	 * @return the recommended treatment for this patient.
	 */
	String treatment();
	
	/**
	 * Returns the symptoms valid for this type of patient.
	 * 
	 * @return the symptoms valid for this patient class.
	 */
	String[] validSymptoms();
}
