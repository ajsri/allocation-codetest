public class Employee {
    private int allocation;
    private boolean isManager;
    
    public Employee(int allocation, boolean isManager) {
        this.allocation = allocation;
        this.isManager = isManager;
    }
    
    public int getAllocation() {
        return allocation;
    }
    
    public boolean isManager() {
        return isManager;
    }
}
