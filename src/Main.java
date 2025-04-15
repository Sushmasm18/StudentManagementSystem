import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>(); // ArrayList to hold Student objects

        while (true) {
            // Display the menu
            System.out.println("==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.print("Enter your choice: ");
            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // To handle the newline character

            //ArrayList<Student> studentList = new ArrayList<>();
            switch (choice) {
                case 1:
                    // Add Student
                    System.out.println("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Student Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter Student Age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter Student Grade: ");
                    double grade = scanner.nextDouble();

                    // Create a new student and add to list
                    Student student = new Student(name, id, age, email, grade); // Correct order
                    studentList.add(student);
                    System.out.println("Student added successfully!\n");
                    break;

                case 2:
                    // View All Students
                    if (studentList.isEmpty()){
                        System.out.println("No students found.");
                    }
                    else {
                        System.out.println("All Stusents:");
                        studentList.forEach(System.out::println);
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Exiting the system...");
                    //scanner.close();
                    return;

                case 4:
                    System.out.println("Available students:");
                    studentList.forEach(System.out::println);

                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    boolean found = false;

                    for (Student s : studentList) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new email: ");
                            String newEmail = scanner.nextLine();

                            s.setName(newName);
                            s.setEmail(newEmail);

                            System.out.println("Student updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    boolean deleted = false;

                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId() == deleteId) {
                            studentList.remove(i);
                            System.out.println("Student deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student deleted successfully!");
                    }
                    else {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice, please try again!\n");
            }
        }
    }
}