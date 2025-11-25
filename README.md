 
# Student Attendance Management System – Java (Console Application)

## 📖 Overview
This project is a console-based **Student Attendance Management System** built using **Core Java**.  
It allows storing student information, marking attendance by date, generating attendance reports, and saving/loading data using CSV files.

The system follows a modular architecture and can run on any computer with Java installed.

---

## 🎯 Features
- Add, update, delete, and list students
- Mark daily attendance (Present/Absent)
- Prevent duplicate attendance for the same date
- Generate three types of reports:
    - Student attendance report
    - Class report for a specific date
    - Attendance summary of all students
- Save and load all data using CSV files
- Fully offline — no database required

---

## 🛠 Technologies Used
| Component | Choice |
|----------|-------|
| Programming Language | Java |
| IDE Used | IntelliJ IDEA |
| Data Storage | CSV files |
| Paradigm | OOP (Object-Oriented Programming) |

---

## 📂 Project Structure

├─ src
│ ├─ Main.java
│ ├─ Menu.java
│ ├─ Student.java
│ ├─ StudentManager.java
│ ├─ AttendanceRecord.java
│ ├─ AttendanceManager.java
│ ├─ ReportManager.java
│ ├─ PersistenceManager.java
│ ├─ AppConstants.java (optional)
└─ .gitignore

yaml
Copy code

---

## ▶ How to Run the Project

### **Using IntelliJ IDEA**
1. Open IntelliJ IDEA → `File → Open`
2. Select the project folder
3. Ensure JDK (Java 8 or above) is configured
4. Open `Main.java`
5. Click **Run**

Console menu will appear like:

=== Student Attendance Management System ===

Student Registration

Mark Attendance

Attendance Report

Save Data

Load Data

Exit
Enter your choice:

yaml
Copy code

---

## 💾 Data Storage
The software automatically creates CSV files:

| File | Purpose |
|------|---------|
| `students.csv` | Stores student records |
| `attendance.csv` | Stores attendance history |

These files allow the project to continue after restart.

---

## 📌 Sample Output

Student registered successfully!
Attendance marked for 2025-01-03
Attendance saved successfully!
Attendance loaded successfully!

yaml
Copy code

---

## 🚀 Future Improvements (Optional)
- GUI interface using JavaFX / Swing
- Attendance analytics dashboard
- Export reports as PDF / Excel
- Login system for teacher & admin

---

## 👨‍💻 Author
Developed by **Himanshu Parmar **  
Course: **Java Programming**

---

## 📜 License
This project is created for educational purposes only.
