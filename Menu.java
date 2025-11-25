
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    static StudentManager studentManager = new StudentManager();
    static AttendanceManager attendanceManager = new AttendanceManager(studentManager);
    static ReportManager reportManager = new ReportManager(studentManager, attendanceManager);
    static PersistenceManager persistenceManager = new PersistenceManager(studentManager, attendanceManager);

    public static void showMainMenu() {
        boolean running = true;

        while(running) {
            System.out.println("\n=== Student Attendance Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Attendance Report");
            System.out.println("4. Save Data");
            System.out.println("5. Load Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch(choice) {
                case "1":
                    handleStudentRegistration();
                    break;
                case "2":
                    handleMarkAttendance();
                    break;
                case "3":
                    handleAttendanceReport();
                    break;
                case "4":
                    handleSaveData();
                    break;
                case "5":
                    handleLoadData();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handleStudentRegistration() {
        System.out.println("-- Register a new student ");
        studentManager.addStudent();
    }

    private static void handleMarkAttendance() {
        System.out.println(">> Attendance marking statred");
        attendanceManager.markAttendance();
    }

    private static void handleAttendanceReport() {
        System.out.println("-- Viewing reports --");
        System.out.println("1. Student Attendance Report");
        System.out.println("2. Class Report for Date");
        System.out.println("3. Summary for All Students");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch(choice) {
            case "1":
                System.out.print("Enter Roll No: ");
                String rollNo = scanner.nextLine().trim();
                reportManager.studentAttendanceReport(rollNo);
                break;
            case "2":
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = scanner.nextLine().trim();
                reportManager.classReportForDate(date);
                break;
            case "3":
                reportManager.summaryForAllStudents();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleSaveData() {
        System.out.println(">> Save Data Module");
        persistenceManager.saveStudents("students.csv");
        persistenceManager.saveAttendance("attendance.csv");
        System.out.println("Data stored successfully. You can now reopen later.");
    }

    private static void handleLoadData() {
        System.out.println(">> Load Data Module");
        persistenceManager.loadStudents("students.csv");
        persistenceManager.loadAttendance("attendance.csv");
        System.out.println("Data restored from storage.");
    }
}