package assessQno1A2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



public class Employee implements Comparable {
	EmployeeBO emp=new EmployeeBO();
	AgeComparator age1=new AgeComparator();
	List<Employee> d=new ArrayList<Employee>();
private int id;
private String name;
public Employee() {
	super();
}
private String department;
private Date dateOfJoining;
private int age;
private int salary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public Date getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
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
public Employee(int id, String name, String department, Date dateOfJoining, int age, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.department = department;
	this.dateOfJoining = dateOfJoining;
	this.age = age;
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dateOfJoining=" + dateOfJoining
			+ ", age=" + age + ", salary=" + salary + "]"+"\n";
}
@Override
public int compareTo(Object o) {
Employee sal=(Employee)o;
if(this.getSalary()==sal.salary) {
	return 0;

}
else if(this.getSalary()>sal.salary) {
	return 1;
}
else {
	return -1;
}
	
}
public void AddEmployee(int id,String name,String department,Date date,int salary,int age) {
	
	d.add(new Employee(id, name,department,date,salary,age));
}
public void ViewEmployee() {
	Collections.sort(d);
	System.out.println(d.toString());
	
}
public void getList() {
	
	emp.printEmploye(d);
}
public void SORTBYAGE() {
	age1.Sortbyage(d);
}
}
