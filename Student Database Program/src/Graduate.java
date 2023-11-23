public class Graduate extends Student{
    
    private String major;
    
    public Graduate(String n, String id, String m) {
        super(n, id);
        major = m;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public String print(){
    	String output = "Name: " + getName() + "   ID: " + getID() + "   Major: " + major + '\n';
    	return output;
    }
    
    public boolean compare (String m) {
        if (major.equalsIgnoreCase(m)){
            return true;
        }
        return false;
    }
}
