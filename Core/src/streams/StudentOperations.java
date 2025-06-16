package streams;

import streams.meta.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentOperations {

    public static void main(String [] args){

        List<Student> studentList = Stream.of(
                new Student(1,"Jose", 20, "male", "Math", "Cortazar",10, Arrays.asList("3310204050","22558877441")),
                new Student(2,"Miguel", 30, "male", "Arts", "Celaya",50, Arrays.asList("410204050","22558877442")),
                new Student(3,"Paty", 102, "female", "Arts", "Cortazar",30, Arrays.asList("53310204050","22558877443")),
                new Student(4,"Ana", 21, "female", "Math", "Leon",80, Arrays.asList("63310204050","22558877445")),
                new Student(5,"Lupe", 40, "female", "Letters", "Leon",1, Arrays.asList("73310204050","22558877446")),
                new Student(6,"Ramiro", 25, "male", "Biology", "Monterrey",2, Arrays.asList("83310204050","22558877448")),
                new Student(7,"Juan", 33, "male", "Social", "Guadalajara",35, Arrays.asList("39310204050","225588777449")),
                new Student(8,"Rosa", 56, "female", "Social", "Tlaxcala",8, Arrays.asList("35310204050","22588779744")),
                new Student(9,"Mele", 42, "female", "Biology", "Puebla",50, Arrays.asList("36310204050","2258897744")),
                new Student(10,"Fer", 78, "male", "Social", "Cortazar",99, Arrays.asList("36310204050","25588777944"))
        ).collect(Collectors.toList());


        // 1. Find the list of students whose rank is in between 50 and 100
        List<Student> rank = studentList.stream()
                .filter(student -> student.getRank() >= 50 && student.getRank() <= 100)
                .collect(Collectors.toList());
        System.out.println("Students on range 50 to 100 ");
        System.out.println(rank);

        //2. Find the Students who lives in Leon and sort them by their names
       List <Student> cities= studentList.stream()
                .filter(student-> student.getCity().equals("Leon"))
                .sorted(Comparator.comparing(Student::getFirstName,Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("Students living on Leon");
        System.out.println(cities);

        // 3. Find all departments names and sort it a to z

        List<String> departments = studentList.stream()
                .map(student -> student.getDepartment())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Department List");
        System.out.println(departments);

        //4.  Get all the contact numbers distinct
        List<String> contacts = studentList.stream()
                .flatMap(student -> student.getContacts().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Contact List");
        System.out.println(contacts);

        //5.  Group The Student By Department Names
        Map<String, List<Student>> studentByDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println("Student by department");
        System.out.println(studentByDepartment);

        //6. Find the department who is having maximum number of students
        String Entry;
        Map.Entry<String, Long> departmentWithMaxStudents = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Student by department");
        System.out.println(departmentWithMaxStudents);

        //7. Find the average age of male and female students

        Map <String, Double> averageByGender= studentList.stream()
                .collect(
                        Collectors.groupingBy(Student::getGender,
                                Collectors.averagingInt(Student::getAge)));

        System.out.println("Average of gender");
        System.out.println(averageByGender);




        //8. Find the highest rank in each department

        Map<String, Optional<Student>> highestRank = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println("Highest rank in each department "+highestRank);
        //9 .Find the student who has second rank

        Student secondRank = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();

        System.out.println("Second Rank " +secondRank);
    }
}
