public class Student {
    private String rollNo;
    private String name;
    private String className;

    public Student(String rollNo, String name, String className) {
        this.rollNo = rollNo;
        this.name = name;
        this.className = className;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + className;
    }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",");
        if(parts.length == 3) {
            return new Student(parts[0].trim(), parts[1].trim(), parts[2].trim());
        }
        return null;
    }
}
