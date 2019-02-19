/**
 * @author Anna Quinlan, MAHS '19
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Teacher
{
    private ArrayList<Student> students;
    private String firstName, lastName;
    public Teacher (String first, String last){
        students = new ArrayList<Student>();
        firstName = first;
        lastName = last;
    }
    
    public void addStudent (String fN, String lN, boolean grad, boolean music){
        students.add(new Student(fN, lN, grad, music));
    }
    
    public void addInstantiatedStudent (Student stud){
        students.add(stud);
    }
    
    public void removeStudent (int index){
        students.remove(index);
    }
    
    public void addTeacher (){
        students.add(0, new Student(firstName, lastName));
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getNumberOfStudents(){
        return students.size();
    }
    
    public Student getStudent(int position){
        return students.get(position);
    }
    
    public void sortByLastName (){
        
        Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student t1, Student t2) {
                    return t1.getLastName().compareTo(t2.getLastName());
            }
        });
    }
   
    public boolean containsSpeaker(){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).isSpeaker()){return true;}
        }
        return false;
    }
    
    public boolean containsMusician(){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).isMusician()){return true;}
        }
        return false;
    }
    
    public boolean isPrincipal(){
        if (lastName.equals("Rick-Kennel")){return true;}
        if (lastName.equals("1 Rick-Kennel")){return true;}
        return false;
    }
    
    public String toStringWithFlags (){
        String output="";
        for (int i=0; i<students.size()-1; i++){
            output+= students.get(i).toStringWithFlags()+", ";
        }
        output+=students.get(students.size()-1);
        return output+"\n";
    }
    
    public String toString (){
        String output="";
        if (isPrincipal()){
            output+="!Principal ";
        }
        for (int i=0; i<students.size()-1; i++){
            output+= students.get(i)+", ";
        }
        output+=students.get(students.size()-1);
        return output+"\n";
    }
}
