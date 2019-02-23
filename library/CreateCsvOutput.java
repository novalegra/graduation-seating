/**
 * @author Anna Quinlan, MAHS '19
 */
import java.util.ArrayList;

public class CreateCsvOutput
{
    public static void outputSeatingChart (ArrayList<ArrayList<Teacher>> seatingChart, String outputFilePath, boolean showFlags){
        //instantiate the CsvWriter 
        CsvWriter writer = new CsvWriter(); 
         
        //export data to a csv file 
        writer.exportCsv(seatingChart, outputFilePath, showFlags);
    }
}
