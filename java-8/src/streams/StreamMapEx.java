package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamMapEx {
    public static List<String> nameList(){
        List <String> studentList = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(toList());
        return studentList;
    }

    public static Set<String> nameSet(){
        Set <String> studentList = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                //Here is a Set instead of a list
                .collect(Collectors.toSet());
        return studentList;
    }

    public static void main(String[] args) {
        System.out.println(nameList());
        System.out.println(nameSet());
    }
}
