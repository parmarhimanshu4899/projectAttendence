import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportManager {
    private StudentManager studentManager;
    private AttendanceManager attendanceManager;

    public ReportManager(StudentManager studentManager, AttendanceManager attendanceManager) {
        this.studentManager = studentManager;
        this.attendanceManager = attendanceManager;
    }

    public void studentAttendanceReport(String rollNo) {
        ArrayList<AttendanceRecord> records = attendanceManager.getAllRecords();
        ArrayList<AttendanceRecord> studentRecords = new ArrayList<>();

        for(AttendanceRecord r : records) {
            if(r.getRollNo().equals(rollNo)) {
                studentRecords.add(r);
            }
        }

        Student student = studentManager.getStudentByRoll(rollNo);
        if(student == null) {
            System.out.println("Student not found!");
            return;
        }

        int total = studentRecords.size();
        int presents = 0;
        int absents = 0;

        for(AttendanceRecord r : studentRecords) {
            if(r.isPresent()) {
                presents++;
            } else {
                absents++;
            }
        }

        double percentage = (total > 0) ? (presents * 100.0) / total : 0.0;

        System.out.println("\n=== Attendance Report for " + student.getName() + " (" + rollNo + ") ===");
        System.out.println("Total Records: " + total);
        System.out.println("Present: " + presents);
        System.out.println("Absent: " + absents);
        System.out.println("Attendance Percentage: " + String.format("%.2f", percentage) + "%");
    }

    public void classReportForDate(String date) {
        ArrayList<Student> allStudents = studentManager.getAllStudents();
        ArrayList<AttendanceRecord> dateRecords = attendanceManager.getAllRecords();

        if(allStudents.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\n=== Class Report for " + date + " ===");
        System.out.println("Roll No | Name | Status");
        System.out.println("--------|------|--------");

        for(Student s : allStudents) {
            String status = "Absent";
            for(AttendanceRecord r : dateRecords) {
                if(r.getRollNo().equals(s.getRollNo()) && r.getDate().equals(date)) {
                    status = r.isPresent() ? "Present" : "Absent";
                    break;
                }
            }
            System.out.println(s.getRollNo() + " | " + s.getName() + " | " + status);
        }
    }

    public void summaryForAllStudents() {
        ArrayList<Student> allStudents = studentManager.getAllStudents();
        ArrayList<AttendanceRecord> records = attendanceManager.getAllRecords();

        if(allStudents.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        ArrayList<StudentAttendanceSummary> summaries = new ArrayList<>();

        for(Student s : allStudents) {
            ArrayList<AttendanceRecord> studentRecords = new ArrayList<>();

            for(AttendanceRecord r : records) {
                if(r.getRollNo().equals(s.getRollNo())) {
                    studentRecords.add(r);
                }
            }

            int total = studentRecords.size();
            int presents = 0;

            for(AttendanceRecord r : studentRecords) {
                if(r.isPresent()) {
                    presents++;
                }
            }

            double percentage = (total > 0) ? (presents * 100.0) / total : 0.0;
            summaries.add(new StudentAttendanceSummary(s.getRollNo(), s.getName(), percentage));
        }

        Collections.sort(summaries, new Comparator<StudentAttendanceSummary>() {
            public int compare(StudentAttendanceSummary a, StudentAttendanceSummary b) {
                return Double.compare(b.percentage, a.percentage);
            }
        });

        System.out.println("\n=== Attendance Summary for All Students ===");
        System.out.println("Roll No | Name | Attendance %");
        System.out.println("--------|------|---------------");
        for(StudentAttendanceSummary s : summaries) {
            System.out.println(s.rollNo + " | " + s.name + " | " + String.format("%.2f", s.percentage) + "%");
        }
    }

    private static class StudentAttendanceSummary {
        String rollNo;
        String name;
        double percentage;

        StudentAttendanceSummary(String rollNo, String name, double percentage) {
            this.rollNo = rollNo;
            this.name = name;
            this.percentage = percentage;
        }
    }
}
