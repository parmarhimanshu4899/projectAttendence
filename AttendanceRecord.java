public class AttendanceRecord {
    private String rollNo;
    private String date;
    private boolean present;

    public AttendanceRecord(String rollNo, String date, boolean present) {
        this.rollNo = rollNo;
        this.date = date;
        this.present = present;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return rollNo + "," + date + "," + (present ? "P" : "A");
    }

    public static AttendanceRecord fromCSV(String line) {
        String[] parts = line.split(",");
        if(parts.length == 3) {
            boolean present = parts[2].trim().equals("P");
            return new AttendanceRecord(parts[0].trim(), parts[1].trim(), present);
        }
        return null;
    }
}
