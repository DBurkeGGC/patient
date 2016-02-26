package patient;

import javax.swing.*;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/*********************************************************************
GUI for use with the Patient class.

@author Dale Burke
@version September 2014
*********************************************************************/
public class PatientGUI extends Application {

	/** array to hold the current patient list */
	Patient[] patientList = new Patient[100];
	
	/** current patient being serviced */
	Patient currentPatient = patientList[0];
	
/*********************************************************************
Start method for the patient program. Sets up the GUI window for use.

@param primaryStage the stage to display
@return none
*********************************************************************/
	public void start(Stage primaryStage) throws Exception {
		
		// used with the default scene
		VBox patientActions = new VBox();
		
		// used with the add scene
		VBox newPatientList = new VBox();
		
		// constructs the default scene
	    patientActions.setAlignment(Pos.CENTER);
	    patientActions.setPrefSize(225, 200);
	    
	    // initializing the buttons for the patientActions box
	    Button nextButton = new Button("Next Patient");
	    nextButton.setPrefWidth(Double.MAX_VALUE);
	    Button findButton = new Button("Find Patient");
	    findButton.setPrefWidth(Double.MAX_VALUE);
	    Button addButton = new Button("Add Patient");
	    addButton.setPrefWidth(Double.MAX_VALUE);
	    Button removeButton = new Button("Discharge Current Patient");
	    removeButton.setPrefWidth(Double.MAX_VALUE);
	    Button detailButton = new Button("Current Patient Details");
	    detailButton.setPrefWidth(Double.MAX_VALUE);
	    Button paymentButton = new Button("Current Patient Billing");
	    paymentButton.setPrefWidth(Double.MAX_VALUE);
	    Button treatmentButton = new Button("Treat Current Patient");
	    treatmentButton.setPrefWidth(Double.MAX_VALUE);
	    Button listButton = new Button("Patient List");
	    listButton.setPrefWidth(Double.MAX_VALUE);
	    Button hospitalButton = new Button("Hospital Statistics");
	    hospitalButton.setPrefWidth(Double.MAX_VALUE);
	    
	    // adds the buttons to the patientActions box
	    patientActions.getChildren().addAll(nextButton, findButton, addButton, removeButton, 
	    		detailButton, treatmentButton, paymentButton, listButton, hospitalButton);
	    
	    // constructs the scene for adding patients
	    newPatientList.setAlignment(Pos.CENTER);
	    newPatientList.setPrefSize(225,175);
	    
	    // initializes the buttons and lists for the newPatientList box
	    Button submitButton = new Button("Submit");
	    submitButton.setPrefWidth(Double.MAX_VALUE);
	    Button cancelButton = new Button("Cancel");
	    cancelButton.setPrefWidth(Double.MAX_VALUE);
	    TextField patientName = new TextField();
	    patientName.setPromptText("Patient Name");
	    patientName.setPrefWidth(Double.MAX_VALUE);
	    TextField patientGuardian = new TextField();
	    patientGuardian.setPromptText("Patient Guardian");
	    patientGuardian.setPrefWidth(Double.MAX_VALUE);
	    ComboBox<Integer> patientAge = new ComboBox<Integer>();
	    patientAge.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
	    		18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
	    		38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
	    		58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77,
	    		78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97,
	    		98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113);
	    patientAge.setPromptText("Patient Age");
	    patientAge.setPrefWidth(Double.MAX_VALUE);
	    ComboBox<String> patientType = new ComboBox<String>();
	    patientType.getItems().addAll("Infant", "Adult");
	    patientType.setPromptText("Patient Type");
	    patientType.setPrefWidth(Double.MAX_VALUE);
	    ComboBox<String> patientSymptom = new ComboBox<String>();
	    patientSymptom.setPromptText("Symptom");
	    patientSymptom.setPrefWidth(Double.MAX_VALUE);
	    ComboBox<String> paymentType = new ComboBox<String>();
	    paymentType.getItems().addAll("Insurance", "Cash", "Credit", "Other");
	    paymentType.setPromptText("Payment Type");
	    paymentType.setPrefWidth(Double.MAX_VALUE);
	    
	    // adds the buttons and lists to the newPatientList box
	    newPatientList.getChildren().addAll(patientType, patientName, patientAge,
	    		patientSymptom, paymentType, submitButton, cancelButton);

	    // creates the default scene and add scene from their respective boxes
	    Scene defaultScene = new Scene(patientActions);
	    Scene addScene = new Scene(newPatientList);
	    
	    // sets the stage title and default scene
	    primaryStage.setTitle("Patient Project");
	    primaryStage.setScene(defaultScene);
	    primaryStage.show();
	    		
	    // assigns an action to the nextButton
	    nextButton.setOnAction(e -> {
	    	
	    	// move to next patient, or indicate no patient exists
	    	if (nextPatient() == false) {
	    		System.out.println("No patient data exists.");
	    	}
	    });
	    
	    // assigns an action to the findButton
	    findButton.setOnAction(e -> {
	    	
	    	// haven't coded this yet
	    	System.out.println("Not yet available.");
	    });
	    
	    // assigns an action to the addButton
	    addButton.setOnAction(e -> {
	    	
	    	// switch to the add a patient scene
	    	primaryStage.setScene(addScene);
	    });
	    
	    // assigns an action to the removeButton
	    removeButton.setOnAction(e -> {
	    	
	    	// can't remove patients if none exist
	    	if (currentPatient == null) {
	    		System.out.println("No patient data exists.");
	    	}
	    	else {
	    		
	    		// store the current patient number
		    	int temp = currentPatient.number();
		    	
		    	// move to next patient
	    		nextPatient();
	    		
	    		// indicate patient has been discharged
	    		System.out.println("Current patient (" + patientList[temp].name() + ") successfully discharged.");
	    		
	    		// if patient index did not move
	    		if (currentPatient.number() == temp) {
	    			
	    			// null the list
	    			patientList[temp] = null;
	    			currentPatient = null;
	    		}
	    		else {
	    			
	    			// otherwise, null (discharge) the patient
	    			patientList[temp] = null;
	    		}
	    	}
	    });
	    
	    // assigns an action to the detailButton
	    detailButton.setOnAction(e -> {
	    	
	    	// if there is a current patient
	    	if (currentPatient != null) {
	    		
	    		// print out its information
	    		toString(currentPatient);
	    	}
	    	else {
	    		System.out.println("No patient data exists.");
	    	}
	    });
	    
	    // assigns an action to the paymentButton
	    paymentButton.setOnAction(e -> {
	    	
	    	// if there is a current patient
	    	if (currentPatient != null) {
	    		
	    		// calculate its bill and print out how to bill it
		    	System.out.println(currentPatient.billing());
	    	}
	    	else {
	    		System.out.println("No patient data exists.");
	    	}
	    });
	    
	    // assigns an action to the treatment button
	    treatmentButton.setOnAction(e -> {
	    	
	    	// if there is a current patient
	    	if (currentPatient != null) {
	    		
	    		// run the treatment method on it
		    	System.out.println(currentPatient.treatment());	
	    	}
	    	else {
	    		System.out.println("No patient data exists.");
	    	}
	    });
	    
	    // assigns an action to the listButton
	    listButton.setOnAction(e -> {
	    	
	    	// if there is a current patient
	    	if (currentPatient != null) {
	    		
	    		// get its index number
		    	int placeholder = currentPatient.number();
		    	System.out.println("---------------------------------------------------------\n\nPATIENT "
						+ "LIST\n");
		    	
		    	// print out the current patient
		    	System.out.println(currentPatient.name());
		    	
		    	// go to next patient
		    	nextPatient();
		    	
		    	// loops through and prints out patient names until reaching the initial index
		    	while (currentPatient.number() != placeholder) {
		    		System.out.println(currentPatient.name());
		    		nextPatient();
		    	}
				System.out.println("\n---------------------------------------------------------\n");
	    	}
	    	else {
	    		System.out.println("No patient data exists.");
	    	}
	    });
	    
	    // assigns an action to the hospitalButton
	    hospitalButton.setOnAction(e -> {
	    	
	    	// create counters for the various wings of the hospital
	    	int wingA = 0, wingB = 0, wingC = 0, wingD = 0, emergency = 0, lobby = 0;
	    	
	    	// if there is at least one patient
	    	if (currentPatient != null) {
	    		
	    		// get its index number
		    	int placeholder = currentPatient.number();
		    	
		    	// add one to the section it was from
		    	if (currentPatient.section().equalsIgnoreCase("A Wing (General Appointments)")) {
		    		wingA ++;
		    	}
		    	else if (currentPatient.section().equalsIgnoreCase("B Wing (Physical Therapy)")) {
		    		wingB ++;
		    	}
		    	else if (currentPatient.section().equalsIgnoreCase("C Wing (Neurology)")) {
		    		wingC ++;
		    	}
		    	else if (currentPatient.section().equalsIgnoreCase("D Wing (Pediatrics)")) {
		    		wingD ++;
		    	}
		    	else if (currentPatient.section().equalsIgnoreCase("ER (Emergency Room)")) {
		    		emergency ++;
		    	}
		    	else if (currentPatient.section().equalsIgnoreCase("Lobby")) {
		    		lobby ++;
		    	}
		    	
		    	// move to next patient
		    	nextPatient();
		    	
		    	// begin looping through patient list until reaching the initial index
		    	while (currentPatient.number() != placeholder) {
		    		
		    		// add one to the area where each patient was assigned
		    		if (currentPatient.section().equalsIgnoreCase("A Wing (General Appointments)")) {
			    		wingA ++;
			    	}
			    	else if (currentPatient.section().equalsIgnoreCase("B Wing (Physical Therapy)")) {
			    		wingB ++;
			    	}
			    	else if (currentPatient.section().equalsIgnoreCase("C Wing (Neurology)")) {
			    		wingC ++;
			    	}
			    	else if (currentPatient.section().equalsIgnoreCase("D Wing (Pediatrics)")) {
			    		wingD ++;
			    	}
			    	else if (currentPatient.section().equalsIgnoreCase("ER (Emergency Room)")) {
			    		emergency ++;
			    	}
			    	else if (currentPatient.section().equalsIgnoreCase("Lobby")) {
			    		lobby ++;
			    	}
		    		nextPatient();
		    	}
	    	}
	    	
	    	// print out a count of how many patients each wing currently holds (0  for all if no patients)
	    	System.out.println("\n---------------------------------------------------------\n\nHOSPITAL "
					+ "PATIENT COUNT\n");
	    	System.out.println("Lobby: " + lobby);
	    	System.out.println("A Wing (General Appointments): " + wingA);
	    	System.out.println("B Wing (Physical Therapy): " + wingB);
	    	System.out.println("C Wing (Neurology): " + wingC);
	    	System.out.println("D Wing (Pediatrics): " + wingD);
	    	System.out.println("ER (Emergency Room): " + emergency);
			System.out.println("\n---------------------------------------------------------\n");
	    });
	    
	    // assigns an action for the submit button
	    submitButton.setOnAction(e -> {
	    	
	    	// if all information is present in all fields
	    	if (patientType.getValue() != null && patientName.getText().length() > 0 && patientAge.getValue() != null &&
	    			patientType.getValue() != null && patientSymptom.getValue() != null && paymentType.getValue() != null) {
	    		
	    		// determine patient type
	    		if (patientType.getValue().toString().equals("Infant")) {
	    			
	    			// add additional information requirement on guardian for infants
	    			if (patientGuardian.getText().length() == 0) {
	    				System.out.println("Please enter the name of this patient's legal guardian.");
	    			}
	    			else {
	    				
	    				// check infant age
	    				if (patientAge.getValue() >= 5) {
	    					System.out.println("This patient is not an infant.");
	    				}
	    				else {
	    					
	    					// if at least one spot exists in list
	    					if (patientList[99] == null) {
	    						
	    						// set a counter for patient position
	    						int i = 0;
	    						
	    						// create an infant
	    						Infant temp = new Infant(100, patientName.getText(), patientGuardian.getText(),
	    								patientAge.getValue(), patientSymptom.getValue(), paymentType.getValue());
	    						
	    						// find the first open spot in the list
	    						while (patientList[i] != null) {
	    							i++;
		    					}
	    						
	    						// assign the index number as the patient's ID number
	    						temp.setNumber(i);
	    						
	    						// insert the patient into the list
	    						patientList[i] = temp;
	    						
	    						// make the new patient the current
	    						currentPatient = temp;
	    						
	    						// indicate success
	    						System.out.println("Patient added successfully.");
	    						
	    						// clear text fields
	    						patientName.clear();
	    						patientGuardian.clear();
	    						
	    						// go back to the main menu
	    				    	primaryStage.setScene(defaultScene);
	    					}
	    					else {
	    						
	    						//indicate list is full
	    						System.out.println("Patient list full.");
	    					}
	    				}
	    			}
	    		}
	    		
	    		// determine patient type
	    		else if (patientType.getValue().toString().equals("Adult")) {
	    			if (patientAge.getValue() <= 12) {
    					System.out.println("This patient is not an adult.");
    				}
    				else {
    					
    					// if at least one spot exists in list 
    					if (patientList[99] == null) {
    						
    						// set a counter for patient position
    						int i = 0;
    						
    						// create an adult
    						Adult temp = new Adult(100, patientName.getText(), patientAge.getValue(), 
    								patientSymptom.getValue(), paymentType.getValue());
    						
    						// find the first open spot in the list
    						while (patientList[i] != null) {
    							i++;
    						}
    						
    						// assign the index number as the patient's ID number
    						temp.setNumber(i);
    						
    						// insert the patient into the list
    						patientList[i] = temp;
    						
    						// make the new patient the current
    						currentPatient = temp;
    						
    						// indicate success
    						System.out.println("Patient added successfully.");
    						
    						// clear text fields
    						patientName.clear();
    						patientGuardian.clear();
    						
    						// go back to the main menu
    				    	primaryStage.setScene(defaultScene);
    					}
    					else {
    						System.out.println("Patient list full.");
    					}
    				}
	    		}
	    	}
    		else {
    			System.out.println("Please enter a value for all fields.");
    		}
	    });
	    
	    // assigns an action for the cancelButton
	    cancelButton.setOnAction( e -> {
	    	
	    	// go back to the default scene
	    	primaryStage.setScene(defaultScene);
	    });
	    
	    patientType.setOnAction(e -> {
	    	if (patientType.getValue() != null && patientType.getValue().equals("Infant")) {
	    		patientSymptom.getItems().clear();
	    		patientSymptom.getItems().addAll( "Fever", "Cough", "Pain", "Bleeding" );
	    		newPatientList.getChildren().clear();
	    		newPatientList.getChildren().addAll(patientType, patientName, patientGuardian,
	    				patientAge, patientSymptom, paymentType, submitButton, cancelButton);
	    	    primaryStage.sizeToScene();
	    	}
	    	else if (patientType.getValue() != null && patientType.getValue().equals("Adult")) {
	    		patientSymptom.getItems().clear();
	    		patientSymptom.getItems().addAll( "Fever", "Cough", "Pain", "Headache", "Bleeding" );
	    		patientGuardian.clear();
	    		newPatientList.getChildren().clear();
	    		newPatientList.getChildren().addAll(patientType, patientName, patientAge,
	    				patientSymptom, paymentType, submitButton, cancelButton);
	    	    primaryStage.sizeToScene();
	    	}
	    });   
	}
	
	public void toString(Patient p) {
		System.out.println("\n---------------------------------------------------------\n\nCURRENT "
				+ "PATIENT DETAILS\n");
		System.out.println("Identification Number: " + p.number());
		System.out.println("Patient Name: " + p.name());
		if (p.type().equalsIgnoreCase("infant")) {
			System.out.println("Patient Legal Guardian: " + ((Infant) p).parent());
		}
		System.out.println("Patient Age: " + p.age());
		System.out.println("Patient Symptom: " + p.symptom());
		System.out.print("Priority Level: ");
		if (p.priority() >= 7) {
			System.out.println("High");
		}
		else if (p.priority() < 7 && p.priority() >= 5) {
			System.out.println("Normal");
		}
		else if (p.priority() < 5) {
			System.out.println("Low");
		}
		System.out.println("Assigned Doctor: " + p.doctor());
		System.out.println("Assigned Location: " + p.section());
		System.out.println("\n---------------------------------------------------------\n");
	}
	
	public boolean nextPatient() {
    	if (currentPatient == null) {
    		return false;
    	}
    	else {		
    		int current = currentPatient.number();
    		do {
    			current ++;
    			if (current == 100) {
    				current = 0;
    			}
    		}
    		while (patientList[current] == null);
	    	currentPatient = patientList[current];	
	    	return true;
    	}
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}