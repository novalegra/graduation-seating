"""
public static void coordinateGradRunner (String inputPath, String outputPath, String outputPreferences){
        // file format: studentFirstName [0]. studentLastName [1], teacherFirstName [2], teacherLastName [3],
        // isGradSpeaker (TRUE or FALSE) [4], isMusician (TRUE or FALSE) [4]
        // the last name of whoever the principal is MUST BE "Rick-Kennel"
        
        boolean outputPref = false;
        if (outputPreferences.equals("true") || outputPreferences.equals("True") ||outputPreferences.equals("yes") || outputPreferences.equals("Yes")){outputPref=true;}
        
        try {
            ArrayList<Teacher> teacherData = TextParser.getFileInfo(inputPath, outputPref);
            teacherData = Utils.sortStudents(teacherData);
            ArrayList<ArrayList<Teacher>> seatingChart = SortIntoRows.putStudentsInRows(teacherData);            
            
            CreateCsvOutput.outputSeatingChart(seatingChart, outputPath); 
        }
        catch(Exception e) {
            System.out.println("Error: "+e);
         }
       
        
        }
"""
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from file_utils import parse_file
from sorting_utils import sort_students, sort_students_into_rows

def graduation_sorting_runner(input_path, output_path, enable_flags):
    teachers = sort_students(
                    parse_file(input_path)
                )
    seating_chart = sort_students_into_rows(teachers)
    # function to sort teachers
    #seating_chart = put_students_into_rows(teachers)
    #create_output_csv(seating_chart, output_path)'''