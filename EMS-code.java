public class Main{
    public static void main(String[] args){
        Employee[] employees = new Employee[2]; //Created an array of employees with employee-type references
        employees[0] = new FullTimeEmployee("Employee1", 1234, 3000); //Created a FullTimeEmployee object referenced to Employee
        employees[1] = new PartTimeEmployee("Employee2", 5678, 26, 50); //Created a PartTimeEmployee object referenced to Employee
        
        for (Employee employee : employees){ //Used enhance loop to diplay employees info
            employee.displayInfo();
            System.out.println();
        }
    }
}

abstract class Employee{ //Abstract class so that we can't create object of this class. It's just like a base class
    private String name;
    private int id;
    
    Employee(String name, int id){ //Constructor to initialize the value passed from tha main class
        this.name = name; //this. - refers to the object
        this.id = id;
    }
    
    abstract double calculateSalary(); //abstract method so every subclass have to define this method
    
    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
    }
}

interface BonusEligible{ //Interface - every class that implement this have to define the calculateBonus method
    double calculateBonus();
}

class FullTimeEmployee extends Employee implements BonusEligible{ //"extends" is used to inherits the attributes/methods from parent class while "implements" is used to reference to interface
    private double monthlySalary;
    
    FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);//calling the parent constructor to define the name and id
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double calculateSalary(){ //overrides the abstract method from the Employee class
        return this.monthlySalary;
    }
    
    @Override
    public double calculateBonus(){  //overrides the method from the BonusEligible interface
        return this.monthlySalary * .10;
    }
    
    @Override public void displayInfo(){ //overrides the method from the Employee class
        super.displayInfo(); //invoking the parent displayInfo method
        System.out.printf("Full-Salary: $%.2f%n", calculateSalary());
        System.out.printf("Bonus: $%.2f%n", calculateBonus());
    }
}

class PartTimeEmployee extends Employee{ 
    private double hoursWorked;
    private double ratePerHour;
    
    PartTimeEmployee(String name, int id, double hoursWorked, double ratePerHour){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }
    
    @Override
    public double calculateSalary(){
        return this.hoursWorked * ratePerHour;
    }
    
    @Override public void displayInfo(){
        super.displayInfo();
        System.out.println("Part-time Salary: $" + calculateSalary());
    }
}
