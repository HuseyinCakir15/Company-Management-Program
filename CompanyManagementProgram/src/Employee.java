
/*
 *@header Hüseyin Çakır
 *@Date 15 January 2025 
 *@version 1
 */
public class Employee {

	protected String name;
	protected String surname;
	protected String department;
	protected String position;
	protected long id;
	protected long salary;
	protected long workOffDay;

	public Employee(String name, String surname, String department, String position, long id, long salary, long workOffDay) {
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.position = position;
		this.id = id;
		this.salary = salary;
		this.workOffDay = workOffDay;
	}
	
	public String toString() {
		
		return "Name: " + name + " " + surname
				+ " Department: " + department +
				" Position: " + position + " ID: " +
				id + " Salary: " + salary + " Work Off Day: "
				+ workOffDay;
	}
}
