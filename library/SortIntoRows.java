
/**
 * @author Anna Quinlan, MAHS '19
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortIntoRows
{

    public static ArrayList<ArrayList<Teacher>> putStudentsInRows (ArrayList<Teacher> data){
        ArrayList<ArrayList<Teacher>> overallSeatingChart = new ArrayList<ArrayList<Teacher>>();
        
        // each ArrayList is a row of seating
        ArrayList<Teacher> r1 = new ArrayList<Teacher>();
        ArrayList<Teacher> r2 = new ArrayList<Teacher>();
        ArrayList<Teacher> r3 = new ArrayList<Teacher>();
        ArrayList<Teacher> r4 = new ArrayList<Teacher>();
        ArrayList<Teacher> r5 = new ArrayList<Teacher>();
        ArrayList<Teacher> r6 = new ArrayList<Teacher>();
        ArrayList<Teacher> r7 = new ArrayList<Teacher>();
        ArrayList<Teacher> r8 = new ArrayList<Teacher>();
        ArrayList<Teacher> r9 = new ArrayList<Teacher>();
        ArrayList<Teacher> r10 = new ArrayList<Teacher>();
        ArrayList<Teacher> r11 = new ArrayList<Teacher>();
        ArrayList<Teacher> r12 = new ArrayList<Teacher>();
        
        data = Utils.sortStudents(data);
        int index=-1;
        // find index of principal
        for (int q=0; q<data.size(); q++){
            if (data.get(q).isPrincipal() == true){
                index = q;
                break;
            }
        }
        // sort principal's students into rows
        if (index != -1){
            ArrayList<Teacher> smallerSimoneGroups = Utils.dealWithSimone(data.get(index));
                
                int row=5;
                for (int j=0; j<smallerSimoneGroups.size(); j++){
                    if (row==5){
                        r5.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==6){
                        r6.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==7){
                        r7.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==8){
                        r8.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==9){
                        r9.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==10){
                        r10.add(smallerSimoneGroups.get(j)); row++; continue;
                    } else if (row==11){
                        r11.add(smallerSimoneGroups.get(j)); row++; continue;
                    }
                    r12.add(smallerSimoneGroups.get(j)); row++;
                }
            }        
        for (int i=0; i<data.size(); i++){
            if (data.get(i).isPrincipal() == true){
                continue;
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r1) < 41){
                r1.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r2) < 45){
                r2.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r3) < 49){
                r3.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r4) < 53){
                r4.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r5) < 56){
                r5.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r6) < 60){
                r6.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r7) < 64){
                r7.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r8) < 68){
                r8.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r9) < 70){
                r9.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r10) < 74){
                r10.add(data.get(i));
            }
            else if (data.get(i).getNumberOfStudents() + numberOfStudentsInRow(r11) < 78){
                r11.add(data.get(i));
            }
            else {
                r12.add(data.get(i));
            }
        }
        
        overallSeatingChart.add(r1);
        overallSeatingChart.add(r2);
        overallSeatingChart.add(r3);
        overallSeatingChart.add(r4);
        overallSeatingChart.add(r5);
        overallSeatingChart.add(r6);
        overallSeatingChart.add(r7);
        overallSeatingChart.add(r8);
        overallSeatingChart.add(r9);
        overallSeatingChart.add(r10);
        overallSeatingChart.add(r11);
        overallSeatingChart.add(r12);
        
        return overallSeatingChart;
    }
    
    public static int numberOfStudentsInRow (ArrayList<Teacher> data){
        int count=0;
        for (int i=0; i<data.size(); i++){
            count+=data.get(i).getNumberOfStudents();
        }
        return count;
    }
}

