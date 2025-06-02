package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        //student name and the activities in a map

        Predicate<Student> studentPredicate = (student -> student.getGradeLevel()>=3);
        Predicate<Student> studentGpaPredicate =(student -> student.getGpa()>=3.9);
        /*
        1. Map Object is created as Name and list of activities
        2. Use method to get the object with all the studented
        3. apply stream to the new collection
        4. apply filter to precompute the output
        5. collect method that uses a Collectors to get the object as a Map
         */

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .peek(student -> System.out.println(student))
                .filter(studentPredicate)
                .peek(student -> System.out.println("1st filter"+student))
                .filter(studentGpaPredicate)
                .peek(student -> System.out.println("2st filter"+student))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentMap);

    }


}
