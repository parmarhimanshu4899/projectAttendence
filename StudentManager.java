import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine().trim();

        if(getStudentByRoll(rollNo) != null) {
            System.out.println("Error: Roll No already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Class Name: ");
        String className = scanner.nextLine().trim();

        Student student = new Student(rollNo, name, className);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    public Student getStudentByRoll(String rollNo) {
        for(Student s : students) {
            if(s.getRollNo().equals(rollNo)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(String rollNo) {
        Student student = getStudentByRoll(rollNo);
        if(student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name (current: " + student.getName() + "): ");
        String newName = scanner.nextLine().trim();
        if(!newName.isEmpty()) {
            student.setName(newName);
        }

        System.out.print("Enter New Class (current: " + student.getClassName() + "): ");
        String newClass = scanner.nextLine().trim();
        if(!newClass.isEmpty()) {
            student.setClassName(newClass);
        }

        System.out.println("Student updated successfully!");
    }

    public void deleteStudent(String rollNo) {
        Student student = getStudentByRoll(rollNo);
        if(student == null) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully!");
    }

    public void listAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\n=== Student List ===");
        System.out.println("Roll No | Name | Class");
        System.out.println("------|------|-------");
        for(Student s : students) {
            System.out.println(s.getRollNo() + " | " + s.getName() + " | " + s.getClassName());
        }
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
