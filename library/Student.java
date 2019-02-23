
/**
 * @author Anna Quinlan, MAHS '19
 */
public class Student
{
    private String firstName, lastName;
    private boolean gradSpeaker, musician;
    
    public Student (String fN, String lN, boolean grad, boolean m){
        firstName = fN;
        lastName = lN;
        gradSpeaker = grad;
        musician = m;
    }
    
    public Student (String fN, String lN){
        firstName = fN;
        lastName = lN;
        gradSpeaker = false;
        musician = false;
    }
    
    public Student (String lN){
        firstName = "Null";
        lastName = lN;
        gradSpeaker = false;
        musician = false;
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
     
    public String toStringWithFlags(){
        if (isSpeaker()){
            return "!Speaker "+ getFirstName()+ " " +getLastName();
        }
        else if (isMusician()){
            return "!Music "+ getFirstName()+ " " +getLastName();
        }
        return getFirstName()+ " " +getLastName();
    }
    
    public String toString(){
        if (isSpeaker()){
            return "!Speaker "+ getFirstName()+ " " +getLastName();
        }
        else if (isMusician()){
            return "!Music "+ getFirstName()+ " " +getLastName();
        }
        return getFirstName()+ " " +getLastName();
    }
}
