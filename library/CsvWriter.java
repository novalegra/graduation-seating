


/** 
 * 
 * @author Anna Quinlan, MAHS '19, with starting code from Matthias Schoepe
 */

import java.io.FileWriter; 
import java.io.IOException; 
import java.util.List; 
import java.util.ArrayList; 


public class CsvWriter { 

    private final String CRLF = "\r\n"; 
    private String delimiter = ","; 

    public void setDelimiter(String delimiter) { 
        this.delimiter = delimiter; 
    } 

    public void exportCsv(ArrayList<ArrayList<Teacher>> twoDimensionalData, String filename, boolean showFlags) { 
        try { 
            FileWriter writer = new FileWriter(filename); 

            for (int i = 0; i < twoDimensionalData.size(); i++) { 
                for (int j = 0; j < twoDimensionalData.get(i).size(); j++) { 
                    if (showFlags){
                            writer.append( 
                                twoDimensionalData.get(i).get(j).toStringWithFlags() 
                                );
                            }
                    else {
                        writer.append( 
                                twoDimensionalData.get(i).get(j).toString() 
                                );
                        }
                    //Don't forget the delimiter 
                    if (j < twoDimensionalData.get(i).size() - 1) { 
                        writer.append(delimiter); 
                    } 
                } 
                //Add delimiter and end of the line 
                if (i < twoDimensionalData.size() - 1) { 
                    writer.append(delimiter + CRLF); 
                } 
            } 

            writer.flush(); 
            writer.close(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 