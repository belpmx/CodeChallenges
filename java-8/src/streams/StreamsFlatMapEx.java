package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsFlatMapEx {
    public static List <String> printStudentActivities(){
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()//this will get rid of duplicated
                .sorted()
                //this convert the stream to a List
                .collect(toList());
        return studentActivities;
    }

    public static Long getStudentActivitiesCount(){
        Long studentActivitiesCount = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()//this will get rid of duplicated
                //this convert the stream to a List
                .count();
        return studentActivitiesCount;
    }
    public static void main(String[] args) {
        System.out.println(printStudentActivities());
        System.out.println(getStudentActivitiesCount());
    }
}
