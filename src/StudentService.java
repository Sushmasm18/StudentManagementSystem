import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    // Search by name
    public static void searchByName(List<Student> students, String name){
        students.stream().filter(s -> s.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }
    //search by email
    public static void searchByEmail(List<Student>students, String email) {
        students.stream().filter(s -> s.getEmail().equalsIgnoreCase(email))
                .forEach(System.out::println);
    }
    //  Print average marks
    public static void printAverageGrades(List<Student> students) {
        double avg = students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
        System.out.println("Average grade: " + avg);
    }

    // Count students with marks greater than threshold
    public static void countHighScorers(List<Student> students, double threshold) {
        long count = students.stream()
                .filter(s -> s.getGrade() > threshold)
                .count();
        System.out.println("Students scoring above " + threshold + ": " + count);
    }

    // Sort by marks descending
    public static void sortByMarksDescending(List<Student> students) {
        students.sort((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));
        System.out.println("Sorted by marks (desc):");
        students.forEach(System.out::println);
    }

    // Sort by name alphabetically
    public static void sortByName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);
    }

    //  Group by marks
    public static void groupByMarks(List<Student> students) {
        Map<Double, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        grouped.forEach((marks, list) -> {
            System.out.println("\nMarks: " + marks);
            list.forEach(System.out::println);
        });
    }
    }
