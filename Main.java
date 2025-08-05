import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // View Students
                    System.out.println("\nStudent List:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    // Update Student
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            double newMarks = sc.nextDouble();
                            s.setName(newName);
                            s.setMarks(newMarks);
                            System.out.println("Student updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    found = false;
                    for (Student s : students) {
                        if (s.getId() == deleteId) {
                            students.remove(s);
                            System.out.println("Student deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

