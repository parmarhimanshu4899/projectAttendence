import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenceManager {
    private StudentManager studentManager;
    private AttendanceManager attendanceManager;

    public PersistenceManager(StudentManager studentManager, AttendanceManager attendanceManager) {
        this.studentManager = studentManager;
        this.attendanceManager = attendanceManager;
    }

    public void saveStudents(String filepath) {
        ArrayList<Student> students = studentManager.getAllStudents();
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            for(Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Students saved successfully!");
        } catch(IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public void loadStudents(String filepath) {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader = null;

        try {
            File file = new File(filepath);
            if(!file.exists()) {
                System.out.println("File not found: " + filepath);
                return;
            }

            reader = new BufferedReader(new FileReader(filepath));
            String line;
            while((line = reader.readLine()) != null) {
                Student student = Student.fromCSV(line);
                if(student != null) {
                    students.add(student);
                }
            }

            studentManager.setStudents(students);
            System.out.println("Students loaded successfully! Total: " + students.size());
        } catch(IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public void saveAttendance(String filepath) {
        ArrayList<AttendanceRecord> records = attendanceManager.getAllRecords();
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filepath));
            for(AttendanceRecord r : records) {
                writer.write(r.toString());
                writer.newLine();
            }
            System.out.println("Attendance saved successfully!");
        } catch(IOException e) {
            System.out.println("Error saving attendance: " + e.getMessage());
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public void loadAttendance(String filepath) {
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        BufferedReader reader = null;

        try {
            File file = new File(filepath);
            if(!file.exists()) {
                System.out.println("File not found: " + filepath);
                return;
            }

            reader = new BufferedReader(new FileReader(filepath));
            String line;
            while((line = reader.readLine()) != null) {
                AttendanceRecord record = AttendanceRecord.fromCSV(line);
                if(record != null) {
                    records.add(record);
                }
            }

            attendanceManager.setRecords(records);
            System.out.println("Attendance loaded successfully! Total: " + records.size());
        } catch(IOException e) {
            System.out.println("Error loading attendance: " + e.getMessage());
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
