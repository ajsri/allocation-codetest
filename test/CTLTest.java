import org.junit.Assert;
import org.junit.Test;

public class CTLTest {
    @Test
    public void allocationsAreCorrect() {
        Manager manager = new Manager();
        Developer developer = new Developer();
        QATester qaTester = new QATester();
        
        Assert.assertEquals(manager.getAllocation(), 300);
        Assert.assertEquals(developer.getAllocation(), 1000);
        Assert.assertEquals(qaTester.getAllocation(), 500);
    }
    
    @Test
    public void managersCanBeAssignedEmployees() {
        Manager manager = new Manager();
        Assert.assertTrue(manager.getEmployees().size() == 0);
        manager.addEmployee(new Developer());
        Assert.assertTrue(manager.getEmployees().size() == 1);
    }
    
    @Test
    public void managerWithoutNestedManagersReturnsAllocation() {
        Manager manager = new Manager();
        manager.addEmployee(new Developer());
        manager.addEmployee(new QATester());
        Assert.assertEquals(manager.getTotalAllocation(), 1800);
    }
    
    @Test
    public void managersWithNestedManagersReturnsAllocation() {
        Manager nestedManager = new Manager(); //300
        Manager topDog = new Manager(); //300
        nestedManager.addEmployee(new Developer()); //1000
        nestedManager.addEmployee(new Developer()); //1000
        nestedManager.addEmployee(new QATester()); //500
        topDog.addEmployee(nestedManager);
        
        Assert.assertEquals(topDog.getTotalAllocation(), 3100);
        
    }
}
