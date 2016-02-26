package patient;

import java.util.Random;

/*********************************************************************
Defines an infant patient; subclass of Patient.

@author Dale Burke
@version September 2014
*********************************************************************/
public class Infant extends Patient {
	
	/** type of payment for an infant */
	private String payment;
	
	/** the parent or guardian responsible for the infant */
	private String parent;
	
	/** the symptom's current stage of severity */
	private int symptomStage = 1;
	
	/** the number of treatment rounds patient has undergone */
	private int treatmentRound = 0;
	
/*********************************************************************
Constructor method for Infant class. Requires a number, name, parent,
age, and symptom to be associated with the patient.

@param id the patient's identification number
@param name the patient's name
@param parent the patient's legal guardian
@param age the patient's age
@param symptom the patient's symptom
@return none
*********************************************************************/
	public Infant(int number, String name, String parent, int age, 
			String symptom, String payment) {
		super(number, name, age, symptom);
		this.parent = parent;
		this.payment = payment;
	}

/*********************************************************************
Returns the age group associated with an infant patient.

@param none
@return String the type of patient
*********************************************************************/
	public String type() {
		return "Infant";
	}
	
/*********************************************************************
Returns the name of the infant's legal guardian.

@param none
@return String the name of the infant's legal guardian
*********************************************************************/
	public String parent() {
		return parent;
	}

/*********************************************************************
Returns a random response for an infant patient.

@param none
@return String the patient's current response
*********************************************************************/
	public String response() {
		Random random = new Random();
		int randomInt = random.nextInt(3);
		
		// randomly generates 1 of 3 infant responses
		if (randomInt == 0) {
			return "(Patient is drooling.)";
		}
		else if (randomInt == 1) {
			return "Waaah!";
		}
		else {
			return "Goo goo.";
		}
	}

/*********************************************************************
Returns a list of valid symptoms for an infant patient.

@param none
@return String[] a list of the valid symptoms for an infant patient
*********************************************************************/
	public String[] validSymptoms() {
		
		// lists the valid symptoms for an infant
		String[] validItems = { "Fever", "Cough", "Pain", "Bleeding" };
		return validItems;
	}

/*********************************************************************
Returns if the specified age is valid for an infant patient.

@param none
@return boolean true for valid age, false for invalid
*********************************************************************/
	public boolean validAge(int age) {
		
		// valid ages for an infant are 0 through 4
		if (age >= 0 && age <= 4) {
			return true;
		}
		else {
			return false;
		}
	}
		
/*********************************************************************
Returns a treatment appropriate for an infant patient with the described
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
			return "Take patient's temperature with infant thermometer. If abnormally high, "
					+ "prescribe an appropriate (infant) fever-reducing medication. "
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
			return "Keep patient in hospital for observation. Administer medium dose of "
					+ "(infant) fever-reducing medication.";
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
					+ "abnormalities exist, prescribe an infant respiratory "
					+ "medication. Patient may leave the hospital.";
		}
		else if (symptom().equalsIgnoreCase("Cough") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Keep patient in hospital for observation. Increase dosage of "
					+ "cough-suppressant medication.";
		}
		
		// stage 3 can be treated
		else if (symptom().equalsIgnoreCase("Cough") && symptomStage == 3) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Place patient on respirator. Continue medication at increased "
					+ "levels. Monitor patient in hospital.";
		}
		
		// pain can be in one of 2 stages
		else if (symptom().equalsIgnoreCase("Pain") && symptomStage == 1) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Examine infant to locate where the pain originates. "
					+ "Perform simple scans and request a return visit "
					+ "to determine if condition improves or worsens.";
		}
		
		// stage 2 can be treated
		else if (symptom().equalsIgnoreCase("Pain") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			return "Recommend a specialist for the infant and / or provide "
			+ "treatment recommendations.";
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
			return "Apply direct pressure (lightly), clean and dress the wound. "
					+ "Continue to monitor the situation at hospital if sufficent wounds "
					+ "exist.";
		}
		else if (symptom().equalsIgnoreCase("Bleeding") && symptomStage == 2) {
			
			// determine if treatment was effective
			if (effectiveness == 0) {
				symptomStage --;
			}
			else {
				symptomStage ++;
			}
			return "Stitch applicable wounds if bleeding persists. Monitor the "
					+ "situation at hospital for internal issues.";
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
			return "Rush the patient to surgery. Opperate as soon as "
					+ "possible.";
		}
		
		// if the symptom is not known
		else {
			return "This condition has no precedent!";
		}
	}
	
/*********************************************************************
Returns a payment procedure depending on how the patient's legal guardian
wishes to pay.

@param none
@return String how to bill the patient's guardian
*********************************************************************/
	public String billing() {
		
		// the amount patient's guardian will be billed for treatment
		int amount = 0;
		
		// determine payment amount based on symptom and number of rounds to cure
		if (symptom().equalsIgnoreCase("fever")) {
			amount = 25 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			amount = 25 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			amount = 20 * treatmentRound;
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			amount = 40 * treatmentRound;
		}
		
		// if the infant's guardian is paying in cash, bill directly
		if (payment.equalsIgnoreCase("cash")) {
			return "Bill " + parent + " (directly) $" + amount + " for services rendered.";
		}
		
		// if credit, bill patient's account
		else if (payment.equalsIgnoreCase("credit")) {
			return "Bill " + parent + "'s account $" + amount + " for services rendered.";
		}
		
		// if insurance, bill patient insurance
		else if (payment.equalsIgnoreCase("insurance")) {
			return "Bill " + parent + "'s insurance $" + amount + " for services rendered.";
		}
		
		// if unknown 
		else {
			return "" + parent + " must pay $" + amount + " for services rendered.";
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
		if (symptom().equalsIgnoreCase("Fever")) {
			return "Dr. Mars (Pediatrician)";
		}
		else if (symptom().equalsIgnoreCase("Cough")) {
			return "Dr. Hoover (Pediatrician)";
		}
		else if (symptom().equalsIgnoreCase("Pain")) {
			return "Dr. Larian (Infant Specialist)";
		}
		else if (symptom().equalsIgnoreCase("Bleeding")) {
			return "Dr. Torvald (Infant Specialist)";
		}
		
		// if no known symptoms are present, refer to Dr. Mars
		else {
			return "Dr. Mars (Pediatrician)";
		}
	}
	
/*********************************************************************
Assigns and returns a priority rating for an infant patient's case.
Infant patients have a "high" rating added to their condition score.
Used for the order in which patient cases are reviewed.

@param none
@return int patient's case priority rating
*********************************************************************/
	public int priority() {
		
		// infants start with a rating of 4
		int rating = 4;
		
		// rating is increased based on the severity of their symptom
		if (symptom().equalsIgnoreCase("fever")) {
			rating += 3;
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			rating += 2;
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			rating += 2;
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			rating += 4;
		}
		
		// returns adjusted rating
		return rating;
	}
	
/*********************************************************************
Assigns and returns a section of the hospital in which an infant patient
will be seen or taken care of.

@param none
@return String the hospital section patient is assigned to
*********************************************************************/
	public String section() {
		
		// assigns an area in which to place patients based on ailment
		if (symptom().equalsIgnoreCase("fever")) {
			return "D Wing (Pediatrics)";
		}
		else if (symptom().equalsIgnoreCase("cough")) {
			return "D Wing (Pediatrics)";
		}
		else if (symptom().equalsIgnoreCase("pain")) {
			return "D Wing (Pediatrics)";
		}
		else if (symptom().equalsIgnoreCase("bleeding")) {
			return "ER (Emergency Room)";
		}
		else {
			return "Lobby";
		}
	}
}