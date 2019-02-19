/**
 * @author Anna Quinlan, MAHS '19
 */
import java.util.ArrayList;

public class CreateCsvOutput
{
    public static void outputSeatingChart (ArrayList<ArrayList<Teacher>> seatingChart, String outputFilePath, boolean showFlags){
        //Instantiate the CsvWriter 
        CsvWriter writer = new CsvWriter(); 
         
        //export them to a csv file 
        writer.exportCsv(seatingChart, outputFilePath, showFlags);//"/Users/annaquinlan/Downloads/testExport.csv");
    }
}