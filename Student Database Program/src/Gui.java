import javax.swing.*;
import BreezySwing.*;
public class Gui extends GBFrame {
	//input boxes
	JLabel nameLabel = addLabel ("Name:", 1, 1, 1, 1);
	JTextField nameInput = addTextField ("", 1, 2, 1, 1);
	JLabel idLabel = addLabel ("Student ID:", 2, 1, 1, 1);
	JTextField idInput = addTextField ("", 2, 2, 1, 1);
	JLabel gradeLabel = addLabel ("Grade:", 3, 1, 1, 1);
	JTextField gradeInput = addTextField ("", 3, 2, 1, 1);
	JLabel majorLabel = addLabel ("Major:", 4, 1, 1, 1);
	JTextField majorInput = addTextField ("", 4, 2, 1, 1);
	
	//input buttons
	JButton addPerson = addButton("Add Person", 5, 1, 1, 1);
	JButton addStudent = addButton("Add Student", 5, 2, 1, 1);
	JButton addUndergraduate = addButton("Add Undergraduate", 5, 3, 1, 1);
	JButton addGraduate = addButton("Add Graduate", 5, 4, 1, 1);
	
	//print buttons
	JButton printPerson = addButton("Print Persons", 6, 1, 1, 1);
	JButton printStudent = addButton("Print Students", 6, 2, 1, 1);
	JButton printUndergraduate = addButton("Print Undergraduates", 6, 3, 1, 1);
	JButton printGraduate = addButton("Print Graduates", 6, 4, 1, 1);
	
	//search
	JTextField searchGradeInput = addTextField ("", 1, 4, 1, 1);
	JButton searchGrade = addButton("Search By Grade", 2, 4, 1, 1);
	JTextField searchMajorInput = addTextField ("", 1, 5, 1, 1);
	JButton searchMajor = addButton("Search By Major", 2, 5, 1, 1);
	
	//initializing variables
	int counter = 0;
	int personCounter = 0;
	int studentCounter = 0;
	int undergraduateCounter = 0;
	int graduateCounter = 0;
	Person[] people = new Person[10];
	
	public void buttonClicked(JButton buttonObj) {
		if (counter < 10) { //makes sure there are no more than 10 people
			if (buttonObj == addPerson) {
				if (nameInput.getText().isBlank()) { //checks if all fields are filled
					messageBox("Please fill in all of the required fields (Name)");
				}
				else {
					personCounter++;
					people[counter] = new Person(nameInput.getText());
					counter++;
					//clears text fields
					nameInput.setText("");
					idInput.setText("");
					gradeInput.setText("");
					majorInput.setText("");
					searchGradeInput.setText("");
					searchMajorInput.setText("");
					messageBox("Person added to database");
				}
			}
			
			if (buttonObj == addStudent) {
				if (nameInput.getText().isBlank() || idInput.getText().isBlank()) { //checks if all fields are filled
					messageBox("Please fill in all of the required fields (Name, ID)");
				}
				else {
					studentCounter++;
					people[counter] = new Student(nameInput.getText(), idInput.getText());
					counter++;
					//clears text fields
					nameInput.setText("");
					idInput.setText("");
					gradeInput.setText("");
					majorInput.setText("");
					searchGradeInput.setText("");
					searchMajorInput.setText("");
					messageBox("Student added to database");
				}
			}
			
			if (buttonObj == addUndergraduate) {
				if (nameInput.getText().isBlank() || idInput.getText().isBlank() || gradeInput.getText().isBlank()) { //checks if all fields are filled
					messageBox("Please fill in all of the required fields (Name, ID, Grade)");
				}
				else {
					undergraduateCounter++;
					people[counter] = new Undergraduate(nameInput.getText(), idInput.getText(), gradeInput.getText());
					counter++;
					//clears text fields
					nameInput.setText("");
					idInput.setText("");
					gradeInput.setText("");
					majorInput.setText("");
					searchGradeInput.setText("");
					searchMajorInput.setText("");
					messageBox("Undergraduate added to database");
				}
			}
			
			if (buttonObj == addGraduate) {
				if (nameInput.getText().isBlank() || idInput.getText().isBlank() || majorInput.getText().isBlank()) { //checks if all fields are filled
					messageBox("Please fill in all of the required fields (Name, ID, Major)");
				}
				else {
					graduateCounter++;
					people[counter] = new Graduate(nameInput.getText(), idInput.getText(), majorInput.getText());
					counter++;
					//clears text fields
					nameInput.setText("");
					idInput.setText("");
					gradeInput.setText("");
					majorInput.setText("");
					searchGradeInput.setText("");
					searchMajorInput.setText("");
					messageBox("Graduate added to database");
				}
			}
		}
		else if (buttonObj == addPerson || buttonObj == addStudent || buttonObj == addUndergraduate || buttonObj == addGraduate){
			messageBox("You cannot input more than 10 people");
			//clears text fields
			nameInput.setText("");
			idInput.setText("");
			gradeInput.setText("");
			majorInput.setText("");
		}
		
		if (buttonObj == printPerson) {
			String messageBoxOutput = "";
			if (personCounter != 0) {
				for (int i = 0; i < counter; i++) {
					messageBoxOutput += people[i].print();
				}
			}
			else {
				messageBoxOutput = "There are no persons";
			}
			messageBox(messageBoxOutput);
		}
		
		if (buttonObj == printStudent) {
			System.out.println(people[0].getName());
			String messageBoxOutput = "";
			if (studentCounter != 0) {
				for (int i = 0; i < counter; i++) {
					if (people[i] instanceof Student) {
						messageBoxOutput += people[i].print();
					}
				}
			}
			else {
				messageBoxOutput = "There are no students";
			}
			messageBox(messageBoxOutput);
		}
		
		if (buttonObj == printUndergraduate) {
			String messageBoxOutput = "";
			if (undergraduateCounter != 0) {
				for (int i = 0; i < counter; i++) {
					if (people[i] instanceof Undergraduate) {
						messageBoxOutput += people[i].print();
					}
				}
			}
			else {
				messageBoxOutput = "There are no undergraduates";
			}
			messageBox(messageBoxOutput);
		}
		
		if (buttonObj == printGraduate) {
			String messageBoxOutput = "";
			if (graduateCounter != 0) {
				for (int i = 0; i < counter; i++) {
					if (people[i] instanceof Graduate) {
						messageBoxOutput += people[i].print();
					}
				}
			}
			else {
				messageBoxOutput = "There are no graduates";
			}
			messageBox(messageBoxOutput);
		}
		
		if (buttonObj == searchGrade) {
			String messageBoxOutput = "";
			for (int i = 0; i < counter; i++) {
				if (people[i] instanceof Undergraduate && people[i].compare(searchGradeInput.getText())) {
					messageBoxOutput += people[i].print();
				}
			}
			if (messageBoxOutput == "") {
				messageBoxOutput = "Nobody matches this search";
			}
			//clears text fields
			nameInput.setText("");
			idInput.setText("");
			gradeInput.setText("");
			majorInput.setText("");
			searchGradeInput.setText("");
			searchMajorInput.setText("");
			messageBox(messageBoxOutput);
		}
		
		if (buttonObj == searchMajor) {
			String messageBoxOutput = "";
			for (int i = 0; i < counter; i++) {
				if (people[i] instanceof Graduate && people[i].compare(searchMajorInput.getText())) {
					messageBoxOutput += people[i].print();
				}
			}
			if (messageBoxOutput == "") {
				messageBoxOutput = "Nobody matches this search";
			}
			//clears text fields
			nameInput.setText("");
			idInput.setText("");
			gradeInput.setText("");
			majorInput.setText("");
			searchGradeInput.setText("");
			searchMajorInput.setText("");
			messageBox(messageBoxOutput);
		}
	}
	
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Student Database");
		frm.setSize(700, 500);
		frm.setVisible(true);
	}
}
