public class Student {
    private String name;
    private LocalDate dob;
    public Student(String name, String dobStr) {
        this.name = name;
        DateTimeFormatter formatter;
        if (dobStr.contains("-") && dobStr.length() == 10 && dobStr.charAt(2) == '-') {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        this.dob = LocalDate.parse(dobStr, formatter);
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        Period age = Period.between(dob, LocalDate.now());
        System.out.println("Age: " + age.getYears() + " years");
    }
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "2004-08-15"); // or "15-08-2004"
        s1.displayInfo();
    }
}

class Course {
    String courseName;
    int semester;
    int marks;

    public Course(String courseName, int semester, int marks) {
        this.courseName = courseName;
        this.semester = semester;
        this.marks = marks;
    }

    public void displayCourse() {
        System.out.println("Semester " + semester + ": " + courseName + " - " + marks + " marks");
    }
}

public class StudentCourses {
    public static void main(String[] args) {
        Course[] courses = {
            new Course("Maths", 1, 85),
            new Course("Physics", 1, 72),
            new Course("Data Structures", 2, 90),
            new Course("Java", 2, 88)
        };

        System.out.println("== Course List ==");
        for (Course c : courses) {
            c.displayCourse();
        }
    }
}


