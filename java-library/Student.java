
/**
 * @author Anna Quinlan, MAHS '19
 */
public class Student
{
    private String firstName, lastName;
    private boolean gradSpeaker, musician, flags;
    
    public Student (String fN, String lN, boolean grad, boolean m, boolean f){
        firstName = fN;
        lastName = lN;
        gradSpeaker = grad;
        musician = m;
        flags = f;
    }
    
    public Student (String fN, String lN){
        firstName = fN;
        lastName = lN;
        gradSpeaker = false;
        musician = false;
        flags = false;
    }
    
    public Student (String lN){
        firstName = "Null";
        lastName = lN;
        gradSpeaker = false;
        musician = false;
        flags = false;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public boolean isSpeaker(){
        return gradSpeaker;
    }
    
    public boolean isMusician(){
        return musician;
    }
    
    public boolean showFlags(){
        return flags;
    }
    
    public void updateLastName (String lN){
        lastName = lN;
    }
    
    public void updateFirstName (String fN){
        firstName = fN;
    }
    
    public void updateGradSpeaker (boolean i){
        gradSpeaker = i;
    }
    
    public void updateMusician (boolean i){
        musician = i;
    }
     
    /*public String toStringWithFlags(){
        String output = "";
        if (this.isSpeaker()){
            output+= "!Speaker ";
        }
        if (this.isMusician()){
            output+= "!Music ";
        }
        output+=getFirstName()+ " " +getLastName();
        return output;
    }*/
    
    public String toString(){
        String output = "";
        if (isSpeaker() && showFlags()){
            output+= "!Speaker ";
        }
        if (isMusician() && showFlags()){
            output+= "!Music ";
        }
        output+=getFirstName()+ " " +getLastName();
        return output;
    }
}
