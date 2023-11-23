public class Undergraduate extends Student{

    private String grade;
    
    public Undergraduate(String n, String id, String g) {
        super(n, id);
        grade = g;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public String print(){
    	String output = "Name: " + getName() + "   ID: " + getID() + "   Grade: " + grade + '\n';
    	return output;
    }
    
    public boolean compare (String g) {
        if (grade.equalsIgnoreCase(g)){
            return true;
        }
        return false;
    }
}
