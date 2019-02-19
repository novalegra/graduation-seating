/**
 * @author Anna Quinlan, MAHS '19
 */
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
public class Utils
    {
        // sorts data by if there's a speaker or musician in the teacher's diploma list
        public static ArrayList<Teacher> sortBySpeakerMusician (ArrayList<Teacher> data){
            
            Collections.sort(data, new Comparator<Teacher>() {
               @Override
               public int compare(Teacher t1, Teacher t2) {
                  if ( (t1.containsSpeaker() || t1.containsMusician() ) && ! (t2.containsSpeaker() || t2.containsMusician() ) ){
                      return -1;
                    }
                  else if ( ! (t1.containsSpeaker() || t1.containsMusician()) && (t2.containsSpeaker() || t2.containsMusician()) ){
                      return 1;
                    }
                  else {return 0;}
               }});
               
            return data;
            }
            
        
        public static ArrayList<Teacher> sortTeachersAlphabetically (ArrayList<Teacher> data){
            Collections.sort(data, new Comparator<Teacher>() {
                    @Override
                    public int compare(Teacher t1, Teacher t2) {
                        return t1.getLastName().compareTo(t2.getLastName());
                }
            });
            return data;
    }
    
    // make sure all teachers also get a seat, and that they're first in the list
    public static ArrayList<Teacher> addTeachersToCount (ArrayList<Teacher> data){
        for (Teacher t: data){
            t.addTeacher();
        }
        
        return data;
    }
    
    public static ArrayList<Teacher> sortStudents (ArrayList<Teacher> data){
        //for (int i=0; i<data.size();i++){
        //    data.get(i).sortByLastName();
        //}
        data = Utils.sortTeachersAlphabetically (data);
        data = Utils.sortBySpeakerMusician (data);
        
        return data;
    }
    
    public static void visualizeSeating (ArrayList<ArrayList<Teacher>> seatingChart){
        int count = 1;
        for (ArrayList<Teacher> row: seatingChart){
            System.out.println("Row "+count+": ("+SortIntoRows.numberOfStudentsInRow(row)+" people)\n");
            System.out.println (row);
            count++;
        }
    }
    
    
    
    
    public static ArrayList<Teacher> dealWithSimone (Teacher simoneDiplomas){
        
        //remove principal, he/she doesn't need a seat because she sits up front
        simoneDiplomas.removeStudent(0);
        ArrayList<Teacher> finalOutput = new ArrayList<Teacher>();
        ArrayList<Student> simoneKidsIntermediate = new ArrayList<Student>();
        
        while (simoneDiplomas.getNumberOfStudents()>0){
            if (simoneKidsIntermediate.size()>=8){
                Teacher t = new Teacher ("Simone", "1 Rick-Kennel");
                for (int i=0;i<simoneKidsIntermediate.size();i++){
                    t.addInstantiatedStudent(simoneKidsIntermediate.get(i));
                }
                t.sortByLastName();
                finalOutput.add(t);
                simoneKidsIntermediate.clear();
            }
            simoneKidsIntermediate.add(simoneDiplomas.getStudent(0));
            simoneDiplomas.removeStudent(0);
        }
        return finalOutput;
    }
}
