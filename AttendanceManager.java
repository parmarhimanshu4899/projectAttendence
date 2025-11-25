import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager {
    private ArrayList<AttendanceRecord> records;
    private Scanner scanner;
    private StudentManager studentManager;

    public AttendanceManager(StudentManager studentManager) {
        this.records = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.studentManager = studentManager;
    }

    public void markAttendance() {
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine().trim();

        if(studentManager.getStudentByRoll(rollNo) == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        if(isDuplicateRecord(rollNo, date)) {
            System.out.println("Error: Attendance already marked for this student on this date!");
            return;
        }

        System.out.print("Is student present? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        boolean present = input.equals("y") || input.equals("yes");

        AttendanceRecord record = new AttendanceRecord(rollNo, date, present);
        records.add(record);
        System.out.println("Attendance marked successfully!");
    }

    public boolean isDuplicateRecord(String rollNo, String date) {
        for(AttendanceRecord r : records) {
            if(r.getRollNo().equals(rollNo) && r.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public void listAttendanceForDate(String date) {
        ArrayList<AttendanceRecord> dateRecords = new ArrayList<>();
        for(AttendanceRecord r : records) {
            if(r.getDate().equals(date)) {
                dateRecords.add(r);
            }
        }

        if(dateRecords.isEmpty()) {
            System.out.println("No records found for date: " + date);
            return;
        }

        System.out.println("\n=== Attendance for " + date + " ===");
        System.out.println("Roll No | Status");
        System.out.println("--------|--------");
        for(AttendanceRecord r : dateRecords) {
            String status = r.isPresent() ? "Present" : "Absent";
            System.out.println(r.getRollNo() + " | " + status);
        }
    }

    public void listAttendanceForStudent(String rollNo) {
        ArrayList<AttendanceRecord> studentRecords = new ArrayList<>();
        for(AttendanceRecord r : records) {
            if(r.getRollNo().equals(rollNo)) {
                studentRecords.add(r);
            }
        }

        if(studentRecords.isEmpty()) {
            System.out.println("No records found for student: " + rollNo);
            return;
        }

        System.out.println("\n=== Attendance for Student " + rollNo + " ===");
        System.out.println("Date | Status");
        System.out.println("------|--------");
        for(AttendanceRecord r : studentRecords) {
            String status = r.isPresent() ? "Present" : "Absent";
            System.out.println(r.getDate() + " | " + status);
        }
    }

    public ArrayList<AttendanceRecord> getAllRecords() {
        return records;
    }

    public void setRecords(ArrayList<AttendanceRecord> records) {
        this.records = records;
    }
}
