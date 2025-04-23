import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Exp4 {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    findEmployee();
                    break;
                case 5:
                    showAllEmployees();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = input.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = input.nextDouble();
        employeeList.add(new Employee(id, name, salary));
        System.out.println("Employee added.");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = input.nextInt();
        input.nextLine();
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            System.out.print("Enter new name: ");
            emp.name = input.nextLine();
            System.out.print("Enter new salary: ");
            emp.salary = input.nextDouble();
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = input.nextInt();
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void findEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = input.nextInt();
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            System.out.println("Employee found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static Employee getEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }

    private static void showAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }
}

