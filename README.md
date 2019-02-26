This program takes an input .csv file; this can be easily exported from an Excel/Google Drive spreadsheet.
It will correctly sort a maximum of ~740 students and teachers.

To get proper results, the .csv data format MUST be:               
Student First Name, Student Last Name, Teacher First Name, Teacher Last Name, if student is a graduation speaker (true or false, case doesn't matter), if student is a musician (choir, band, etc; true or false, case doesn't matter)                                                                               
* the algorithm will split students being handed a diploma by the principal into groups of 8, and distribute them throughout the rows. If you want to take advantage of this feature, the name of the "teacher" MUST be Simone Rick-Kennel, regardless of who the current principal is
                                                                                        
EXAMPLE INPUTS INTO CSV FILE:                                                                                  
A student named Jamie Montoya, who is a graduation speaker and will get her diploma from Patty Kim                                                                                  
Jamie, Montoya, Patty, Kim, true,  false                                                                                       

A student named Alex Wong, who will get his diploma from James Smith                                                                                 
Alex,  Wong,    James,   Smith,  false, false  

A student named Hannah Smith, who is in band and will get her diploma from the principal                                                                                
Hannah,  Smith,   Simone,   Rick-Kennel,  false, true

INSTRUCTIONS:
  1. Run the "void main (String [] args)" of the GradRunner class.
  2. You'll be asked for the input and export file path. Enter the FULL direct file path; backslashes are important. On Mac, you can find this by right-clicking, selecting "Get Info", and looking under the "General" header for "Where".
        (example for Mac: /Users/yourUserName/Downloads/yourDataSpreadsheet.csv )
  3. You'll be asked if you want to flag if a student is a speaker or a musician. Do this if you want to easily visualize where everyone is; enter "true" to enable (the "true" MUST be all lowercase).
  4. You'll be asked if you want to print to the console. This is another way to view the data without having to open the .csv export file. Enter "true" to enable (the "true" MUST be all lowercase).
  5. If you've done everything right, a .csv export file with the seating arrangement will be placed into wherever you specified in step 2!

COMMON ISSUES:
  If no file is output by the program, try these solutions:
    - check input path (if it is invalid, the program won't run)
    - check that input file has the inputs in the correct order
    - check that input file is a .csv file
    - check output path (if it is invalid, the program can't export the file anywhere!)
    - check that output path is a .csv file