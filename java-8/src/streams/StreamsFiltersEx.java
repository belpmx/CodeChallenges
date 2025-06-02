package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsFiltersEx {

    public static List<Student> filterStudents(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equals("female"))
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(filterStudents());
    }
}
