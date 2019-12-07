/**
 * @author Anna Quinlan, MAHS '19
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class TextParser
{

    public static ArrayList<Teacher> getFileInfo (String file, boolean outputFlags){
        
        // make into scanner to input path
        String csvFile = file;
        String line = "";
        String cvsSplitBy = ",";
        
        // contains last name of teachers: THIS WILL NOT WORK IF SOME TEACHERS HAVE THE SAME LAST NAME
        // these two lists are designed so that the teacher's info is at the same index for both lists
        ArrayList<String> teachersInstantiated = new ArrayList<String>();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        
        
        // read text file and create teachers/students
        int teacherPosition;
        boolean speaker, music;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] user = line.split(cvsSplitBy);
                
                // if there's no data, assume the student isn't speaker/music
                speaker=false;
                music=false;
                
                // don't error if it didn't get put in
                try {
                    if (user[4].toLowerCase().equals("true") ){speaker=true;}
                } catch (Exception e) {;}
                try {
                    if (user[5].toLowerCase().equals("true")){music=true;}
                } catch (Exception e) {;}
                
                //if teacher class already exists
                if (teachersInstantiated.contains(user[3])){
                    teacherPosition = teachersInstantiated.indexOf(user[3]);
                    teachers.get(teacherPosition).addStudent(user[0], user[1], speaker, music, outputFlags);
                }
                // instantiate teacher then add student
                else{
                    Teacher t = new Teacher (user[2], user[3]);
                    t.addStudent(user[0], user[1], speaker, music, outputFlags);
                    teachers.add(t);
                    teachersInstantiated.add(user[3]);
                }
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i=0; i<teachers.size();i++){
            teachers.get(i).sortByLastName();
        }
        
        for (Teacher t:teachers){
            t.addTeacher();
        }
        
        
        //System.out.println(teachers);
        return teachers;
    }
}
