public class Person {
	
    private String name;
    
    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getID() {
        return null;
    }
    
    public String getGrade() {
        return null;
    }
    
    public String getMajor() {
        return null;
    }

    
    public String print(){
    	String output = "Name: " + name + '\n';
    	return output;
    }

	public boolean compare(String text) {
		return false;
	}
}
