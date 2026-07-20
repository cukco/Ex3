import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    abstract double calculateSalary();
    void showinfo(){
        System.out.print("Name: "+name+", Id: "+id);
    }
}
interface BonusEligible{
    double calculateBonus();
}
class FulltimeEmployee extends Employee implements BonusEligible{
    double baseSalary;
    public FulltimeEmployee(String name, int id, double baseSalary){
        super(name, id);
        this.baseSalary = baseSalary;
    }
    @Override
    double calculateSalary() {
        return baseSalary;
    }
    @Override
    public double calculateBonus(){
        return baseSalary*0.1;
    }
    @Override
    public void showinfo(){
        super.showinfo();
        System.out.print(", Base Salary: "+baseSalary);
    }
}
class ParttimeEmployee extends Employee{
    int workHours;
    double hourlyRate;
    public ParttimeEmployee(String name, int id, int workHours, double hourlyRate) {
        super(name, id);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    @Override
    double calculateSalary() {
        return workHours*hourlyRate;
    }
    @Override
    public void showinfo(){
        super.showinfo();
        System.out.print(", Work Hours: "+workHours+", Hourly Rate: "+hourlyRate);
    }
}
public class Ex3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new FulltimeEmployee("John Doe", 23, 45.6));
        employees.add(new ParttimeEmployee("Captain",29,39,3));
        employees.add(new FulltimeEmployee("Shiet Dau", 21, 100));
        employees.add(new ParttimeEmployee("Adudu",34,29,3));
        for(int i=0;i<employees.size();i++){
            employees.get(i).showinfo();
            if(employees.get(i) instanceof BonusEligible){
                System.out.println(", Bonus: "+((BonusEligible) employees.get(i)).calculateBonus());
            }else if(employees.get(i) instanceof ParttimeEmployee){
                System.out.println(", Salary: "+ employees.get(i).calculateSalary());
            }
        }
    }
}
