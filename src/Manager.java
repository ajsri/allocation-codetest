import java.util.ArrayList;

public class Manager extends Employee {
    private ArrayList<Employee> employees;
    public Manager() {
        super(300, true);
        this.employees = new ArrayList<>();
    }
    
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    
    public void addEmployee(Employee e) {
        this.employees.add(e);
    }
    
    public int getTotalAllocation() {
        int total = this.getAllocation();
        for(int i = 0; i < this.employees.size(); i++) {
            if(this.employees.get(i) instanceof Manager) {
                total += ((Manager) this.employees.get(i)).getTotalAllocation();
            }
            else {
                total += this.employees.get(i).getAllocation();
            }
        }
        return total;
    }
}
