public class Student
{
    private String name;
    private int id;
    private int age;
    private String email;
    private double grade;

    //constructors

    public Student(String name, int id, int age, String email, double grade) {
        this.name = name;
        this.id = id;
        this.age= age;
        this.email= email;
        this.grade = grade;
    }
    //getters
    public String getName() {
        return name;
    }

    public String getEmail() {  return email; }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public double getGrade() {
        return grade;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    //toString() to print student info
    @Override
    public String toString() {
        return "Student [ Name=" + name + ", Email=" + email + ", ID=" + id + ", Age=" + age + ", Grade=" + grade + "]";
    }
}