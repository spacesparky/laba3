public class Main{

    public static void main(String[] args) {

        Admin sam = new Admin("Sam", 20, 35, "13");
        sam.displayInfo();
        sam.setSalary(100);
        sam.displayInfo();
        Programmer bob = new Programmer();
        bob.setName("Bob");
        bob.displayInfo();
        Manager manager1 = new Manager("John", 30, 50000, 5);
        Manager manager2 = new Manager("Alice", 35, 60000, 4);
        System.out.println("Total Managers: " + Manager.getManagerCount());
        sam.work();
        Programmer peter = new Programmer("Peter",23,13,"jaba", manager1);
        peter.getManagerInfo();
    }
}
abstract class Employee {
    private String name;
    private int age;
    private int salary;

    // Default constructor
    public Employee() {
    }

    // Сonstructor with params
    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //employee overload
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public abstract void work();

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age );
        System.out.println("Зарплата: " + salary);
    }
}

class Admin extends Employee {
    private String department;

    public Admin() {
    }

    public Admin(String name, int age, int salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    //Admin overload
    public Admin(String name, int age,String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void work() {
        System.out.println(getName() + " работает администратором в отделе " + department);
    }
}

class Programmer extends Employee {
    private String programmingLanguage;

    private Manager manager;
    public Programmer() {
    }

    public Programmer(String name, int age, int salary, String programmingLanguage, Manager manager) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
        this.manager = manager;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void getManagerInfo() {
        System.out.println(getName() + " reports to Manager: " + manager.getName());
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(getName() + " программирует на языке " + programmingLanguage);
    }
}

class Manager extends Employee {
    private int numberOfProjects;

    private static int managerCount = 0;

    public Manager(String name, int age, int salary, int numberOfProjects) {
        super(name, age, salary);
        this.numberOfProjects = numberOfProjects;
        managerCount++;
    }
    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }
    @Override
    public void work() {
        System.out.println(getName() + " управляет " + numberOfProjects + " проектами");
    }
    public static int getManagerCount() {
        return managerCount;
    }

}