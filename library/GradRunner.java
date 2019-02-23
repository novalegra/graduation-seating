

/**
 *
 * @author Anna Quinlan, MAHS '19
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GradRunner
{
    public static void coordinateGradRunner (String inputPath, String outputPath, String outputPreferences){
        // file format: studentFirstName [0]. studentLastName [1], teacherFirstName [2], teacherLastName [3],
        // isGradSpeaker (TRUE or FALSE) [4], isMusician (TRUE or FALSE) [4]
        // the last name of whoever the principal is MUST BE "Rick-Kennel"
        
        boolean outputPref = false;
        if (outputPreferences.equals("true") || outputPreferences.equals("True") ||outputPreferences.equals("yes") || outputPreferences.equals("Yes")){outputPref=true;}
        
        try {
            ArrayList<Teacher> teacherData = TextParser.getFileInfo(inputPath);
            teacherData = Utils.sortStudents(teacherData);
            ArrayList<ArrayList<Teacher>> seatingChart = SortIntoRows.putStudentsInRows(teacherData);            
            
            CreateCsvOutput.outputSeatingChart(seatingChart, outputPath, outputPref); 
        }
        catch(Exception e) {
            System.out.println("Error: "+e);
         }
       
        
        }
    
    public static void testGradRunner (){
        // file format: studentFirstName [0]. studentLastName [1], teacherFirstName [2], teacherLastName [3],
        // isGradSpeaker (TRUE or FALSE) [4], isMusician (TRUE or FALSE) [4]
        // the last name of whoever the principal is MUST BE "Rick-Kennel"
        Scanner key = new Scanner (System.in);
        
        System.out.println("Flag music/speakers?");
        boolean outputPref = key.nextBoolean();
        boolean printToTerminal = true;
        String inputPath = "/Users/annaquinlan/mockDataSmall.csv";
        String outputPath = "/Users/annaquinlan/mockExport.csv";
        
        try {
            ArrayList<Teacher> teacherData = TextParser.getFileInfo(inputPath);
            teacherData = Utils.sortStudents(teacherData);
            ArrayList<ArrayList<Teacher>> seatingChart = SortIntoRows.putStudentsInRows(teacherData);  
            
            if (printToTerminal){
                Utils.visualizeSeating(seatingChart);
            }
            CreateCsvOutput.outputSeatingChart(seatingChart, outputPath, outputPref); 
        }
        catch(Exception e) {
            System.out.println("Error: "+e);
         }
       
        
    }
        
    public static void main (String[] args){
        testGradRunner();
    }
}

