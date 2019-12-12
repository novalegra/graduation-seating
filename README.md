# How To Use
This program takes an input .csv file, which can be easily exported from an Excel/Google Drive spreadsheet.
It will correctly sort a maximum of ~740 students and teachers.

To get proper results, the .csv data format MUST be:               
Student First Name, Student Last Name, Teacher First Name, Teacher Last Name, if student "has priority"                                                                           
* the algorithm will split students being handed a diploma by the principal into groups of 8, and distribute them throughout the rows. If you want to take advantage of this feature, the name of the "teacher" MUST be Simone Rick-Kennel, regardless of who the current principal is
                                                                                        
# Example Inputs into CSV File

![Alt text](https://github.com/novalegra/graduation-seating/blob/python-wip/sample_file.png "Graduation using the graduation-seating algorithm")

A student named Jamie Montoya, who will get her diploma from Patty Kim and should sit up front.                                                                                  
Jamie, Montoya, Patty, Kim, True                                                                                    

A student named Alex Wong, who will get his diploma from James Smith and doesn't need to sit up front.                                                                          
Alex,  Wong,    James,   Smith,  False

A student named Hannah Smith, will get her diploma from the principal and needs to sit up front.                                                                   
Hannah,  Smith,   Simone,   Rick-Kennel,  False

# Instructions
  1. Download the Github ".zip" file.
  2. Unzip file by clicking on it.


COMMON ISSUES:
  If no file is output by the program, try these solutions:
    - check input path (if it is invalid, the program won't run)
    - check that input file has the inputs in the correct order
    - check that input file is a .csv file
    - check output path (if it is invalid, the program can't export the file anywhere!)
    - check that output path is a .csv file
![Alt text](https://github.com/novalegra/graduation-seating/blob/master/RAM_1036.jpg "Graduation using the graduation-seating algorithm")
