

/**
 * Write a description of class GradRunner here.
 *
 * @author Anna Quinlan, MAHS '19
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GradRunner
{
    public static void main (String[] args){
        // file format: studentFirstName [0]. studentLastName [1], teacherFirstName [2], teacherLastName [3],
        // isGradSpeaker (TRUE or FALSE) [4], isMusician (TRUE or FALSE) [4]
        // the last name of whoever the principal is MUST BE "Rick-Kennel"
        Scanner keyboard = new Scanner (System.in);
        
        String inputPath = keyboard.next();
        
        System.out.print("Output file path: ");
        String outputPath = keyboard.next();
        
        System.out.print("Output with a flag for speakers/musicians? (true/false): ");
        boolean outputPref = false;
        try{ outputPref = keyboard.nextBoolean();
        } catch (Exception e) {
            System.out.println("Your input isn\'t \'true\' or \'false\', assuming you typed false");
        }
        
        System.out.print("Print the seating arrangement to the viewer? (true/false): ");
        boolean printToTerminal = false;
        try{ printToTerminal = keyboard.nextBoolean();
        } catch (Exception e) {
            System.out.println("Your input isn\'t \'true\' or \'false\', assuming you typed false");
        }
        
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
}

