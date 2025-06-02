package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsComparatorEx {

        public static List<Student> sortStudentByName(){
           return  StudentDataBase.getAllStudents()
                    .stream()
                    .sorted(Comparator.comparing(Student::getName))
                    .collect(toList());
        }


    public static List<Student> sortStudentByGpa(){
        return  StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println("Students sorted by Name: ");
            sortStudentByName().forEach(System.out::println);

        System.out.println("Students sorted by GPA: ");
        sortStudentByGpa().forEach(System.out::println);
    }
}
