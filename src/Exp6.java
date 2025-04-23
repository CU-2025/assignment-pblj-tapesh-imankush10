import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class Exp6 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30, 50000));
        employees.add(new Employee("Alice", 28, 60000));
        employees.add(new Employee("Bob", 35, 45000));
        employees.add(new Employee("David", 40, 70000));

        // Sort by name
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Employees sorted by name:");
        employees.forEach(System.out::println);

        // Sort by age
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("\nEmployees sorted by age:");
        employees.forEach(System.out::println);

        // Sort by salary (descending)
        employees.sort((a, b) -> Double.compare(b.getSalary(), a.getSalary()));
        System.out.println("\nEmployees sorted by salary:");
        employees.forEach(System.out::println);
    }
}
