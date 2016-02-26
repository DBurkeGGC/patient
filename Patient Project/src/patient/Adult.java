package patient;

import java.util.Random;

/*********************************************************************
Defines an adult patient; subclass of Patient.

@author Dale Burke
@version September 2014
*********************************************************************/
public class Adult extends Patient {
	
	/** type of payment for an adult */
	private String payment;
	
	/** the symptom's current stage of severity */
	private int symptomStage = 1;
	
	/** the number of treatment rounds patient has undergone */
	private int treatmentRound = 0;
	
/*********************************************************************
Constructor method for Adult class. Requires a number, name, age, 
and symptom to be associated with the patient.

@param id the patient's identification number
@param name the patient's name
@param age the patient's age
@param symptom the patient's symptom
@return none
*********************************************************************/
	public Adult(int number, String name, int age, String symptom, String payment) {
		super(number, name, age, symptom);
		this.payment = payment;
	}

/*********************************************************************
Returns the age group associated with an adult patient.

@param none
@return String the type of patient
*********************************************************************/
	public String type() {
		return "Adult";
	}

/*********************************************************************
Returns a random response for an adult patient.

@param none
@return String the patient's current response
*********************************************************************/
	public String response() {
		Random random = new Random();
		int randomInt = random.nextInt(3);
		
		// randomly generates 1 of 3 adult responses
		if (randomInt == 0) {
			return "I don't feel very well.";
		}
		else if (randomInt == 1) {
			return "Ouch!";
		}
		else {
			return "Hello.";
		}
	}

/*********************************************************************
Returns a list of valid symptoms for an adult patient.

@param none
@return String[] a list of the valid symptoms for an adult patient
*********************************************************************/
	public String[] validSymptoms() {
		String[] validItems = { "Fever", "Cough", "Pain", "Headache", "Bleeding" };
		return validItems;
	}
	
/*********************************************************************
Returns if the specified age is valid for an adult patient.

@param none
@return boolean true for valid age, false for invalid
*********************************************************************/
	public boolean validAge(int age) {
		if (age >= 12 && age <= 65) {
			return true;
		}
		else {
			return false;
		}
	}
		
/*********************************************************************
Returns a treatment appropriate for an adult patient with the described
symptom.

@param none
@return String suggested treatment for this patient
*********************************************************************/
	public String treatment() {
		
		// random generation for effectiveness of treatment
		Random random = new Random();
		
		// add 1 to treatmentRound to account for this session
		treatmentRound ++;
		
		// 0 for effective, 1 for ineffective
		int effectiveness = random.nextInt(2);
		
		// if treatment has been effective
		if (symptomStage == 0) {
			
			// do not increase treatment counter
			treatmentRound --;
			return "This patient has been cured and may be discharged.";
		}
		
		// if patient is beyond help
		else if (symptomStage == 4) {
			
			// do not increase treatment counter
			treatmentRound --;
			return "Servere case; treatment is no longer effective.";
		}
		
		// prescribes and returns treatment appropriate to symptom
		
		// fever can be in one of 3 stages
		else if (symptom().equalsIgnoreCase("Fever") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Take patient's temperature orally. If abnormally high, "
					+ "prescribe an appropriate (adult) fever-reducing medication. "
					+ "Patient may leave the hospital.";
		}
		else if (symptom().equalsIgnoreCase("Fever") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Administer medium dose of (adult) fever-reducing medication. "
					+ "Patient may leave the hospital.";
		}
		
		// stage 3 fever can be treated
		else if (symptom().equalsIgnoreCase("Fever") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Attempt to administer alternative medications and forms of "
					+ "treatment. Monitor patient in hospital.";
		}
		
		// coughing can be in one of 3 stages
		else if (symptom().equalsIgnoreCase("Cough") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Listen to chest for signs of abnormal breathing. If "
					+ "abnormalities exist, check for bronchitis. Prescribe "
					+ "(adult) cough medication.";
		}
		else if (symptom().equalsIgnoreCase("Cough") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Increase dosage of cough-suppressant medication. Request "
					+ "a return visit.";
		}
		
		// stage 3 can be treated
		else if (symptom().equalsIgnoreCase("Cough") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Place patient on respirator if necessary. Continue medication "
					+ "at increased levels. Monitor patient in hospital.";
		}
		
		// pain can be in one of 3 stages
		else if (symptom().equalsIgnoreCase("Pain") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Ask the patient where the pain originates. Examine "
					+ "the area further for signs of trauma, and schedule "
					+ "a return visit.";
		}
		else if (symptom().equalsIgnoreCase("Pain") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Perform scans in the affected area in order to determine the "
					+ "severity of patient's condition. Medicate and provide "
					+ "routes of treatment.";
		}

		// stage 3 can be treated
		else if (symptom().equalsIgnoreCase("Pain") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "If situation requires, operate in order to alleviate patient's pain. "
					+ "Administer pain killing medications to patient.";
		}
		
		// headache can be in one of 3 stages
		else if (symptom().equalsIgnoreCase("Headache") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Ask the patient how severe the condition is. Prescribe "
					+ "migrane medication or perform scans depending on "
					+ "response.";
		}
		else if (symptom().equalsIgnoreCase("Headache") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Perform CAT scans and keep patient in hospital for monitoring.";
		}

		// stage 3 can be treated
		else if (symptom().equalsIgnoreCase("Headache") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Recommend patient to a specialist for operation if necessary.";
		}
		
		// bleeding can be in one of 3 stages
		else if (symptom().equalsIgnoreCase("Bleeding") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Apply direct pressure, clean and dress the wound. "
					+ "Stitch small wounds if necessary. Patient may leave the hospital.";
		}
		else if (symptom().equalsIgnoreCase("Bleeding") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Stitch patient's wounds if necessary, keeping wounds dressed and clean. "
					+ "Monitor patient at hospital.";
		}
		
		// stage 3 may lead to patient being unresponsive to treatment
		else if (symptom().equalsIgnoreCase("Bleeding") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Rush the patient to surgery. Opperate as soon as possible.";
		}
		
		// if the symptom is not known
		else {
			return "This condition has no precedent!";
		}
	}
	
/*********************************************************************
Returns a payment procedure depending on how the client wishes to pay.

@param none
@return String how to bill the patient
*********************************************************************/
	public String billing() {
		
		// the amount patient will be billed for treatment
		int amount = 0;
		
		// determine payment amount
		if (symptom().equalsIgnoreCase("fever")) {
			amount = 20 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			amount = 20 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			amount = 30 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("headache")) {
			amount = 30 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			amount = 50 * treatmentRound;
		}
		
		// if the adult patient is paying in cash, bill directly
		if (payment.equalsIgnoreCase("cash")) {
			return "Bill patient (directly) $" + amount + " for services rendered.";
		}
		
		// if credit, bill patient's account
		else if (payment.equalsIgnoreCase("credit")) {
			return "Bill patient's account $" + amount + " for services rendered.";
		}
		
		// if insurance, bill patient insurance
		else if (payment.equalsIgnoreCase("insurance")) {
			return "Bill patient's insurance $" + amount + " for services rendered.";
		}
		
		// if unknown 
		else {
			return "Patient must pay $" + amount + " for services rendered.";
		}
	}
	
/*********************************************************************
Assigns and returns a doctor appropriate to the patient's ailment and 
age group.

@param none
@return String which doctor should see the patient
*********************************************************************/
	public String doctor() {
		
		// depending on condition, patients are assigned to an appropriate doctor
		if (symptom().equalsIgnoreCase("fever")) {
			return "Dr. Frederick (General Practitoner)";
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			return "Dr. Frederick (General Practitoner)";
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			return "Dr. Sampson (General Practitoner)";
		}
		else if (symptom().equalsIgnoreCase("headache")) {
			return "Dr. Winthrop (Specialist)";
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			return "Dr. Johnson (ER)";
		}
		
		// if no symptoms are present, refer to Dr. Frederick
		else {
			return "Dr. Frederick (General Practitoner)";
		}
	}
	
/*********************************************************************
Assigns and returns a priority rating for an adult patient's case.
Adult patients have an "average" rating added to their condition score.
Used for the order in which patient cases are reviewed.

@param none
@return int patient's case priority rating
*********************************************************************/
	public int priority() {
		
		// adults start with a rating of 3
		int rating = 3;
		
		// rating is increased based on the severity of their symptom
		if (symptom().equalsIgnoreCase("fever")) {
			rating += 2;
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			rating += 0;
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			rating += 2;
		}
		else if (symptom().equalsIgnoreCase("headache")) {
			rating += 1;
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			rating += 4;
		}
		
		// returns adjusted rating
		return rating;
	}
	
/*********************************************************************
Assigns and returns a section of the hospital in which an adult patient
will be seen or taken care of.

@param none
@return String the hospital section patient is assigned to
*********************************************************************/
	public String section() {
		
		// assigns an area in which to place patients based on ailment
		if (symptom().equalsIgnoreCase("fever")) {
			return "A Wing (General Appointments)";
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			return "A Wing (General Appointments)";
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			return "B Wing (Physical Therapy)";
		}
		else if (symptom().equalsIgnoreCase("headache")) {
			return "C Wing (Neurology)";
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			return "ER (Emergency Room)";
		}
		else {
			return "Lobby";
		}
	}
}