import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//https://www.hackerrank.com/challenges/java-priority-queue/problem
public class PriorityQueue {
    class Student {
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }
    }

    class Priorities {

        List<Student> getStudents(List<String> events) {
            java.util.PriorityQueue<Student> pQueue = new java.util.PriorityQueue<>(Comparator.comparing
                            (Student::getCGPA).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getID));
            for(String event:events) {
                if (event.charAt(0) == 'E') {//ENTER
                    String[] record = event.split(" ");
                    Student student = new Student(Integer.valueOf(record[3]), record[1], Double.valueOf(record[2]));
                    pQueue.add(student);

                } else {
                    pQueue.poll();
                }
            }
            List<Student> result = new ArrayList<>();
            //manually fill the List to make sure that the order is correct
            while (!pQueue.isEmpty()){
                Student student = pQueue.poll();
                result.add(student);
            }
            return result;
        }
    }
}

