import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {

		System.out.println(" Hello Welcome to Program. How Can I Help You?");
		System.out.println("<--------------------------------------------->");
		menu();
	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;

		while (exit) {
			System.out.println("\n" + "1-) Save Employee's Informations\n" + "2-) Delete Employee's Informations\n"
					+ "3-) Show Employee's Informations\n" + "Q-) Quit the System.\n");
			String choice = scanner.next();
			choice = choice.toLowerCase();
			switch (choice) {
			case "1":
				saveEmployee();
				System.out.println("\n Employee's Informations Has Been Saved Successfully.");
				System.out.println("<---------------------------------------------------->");
				break;
			case "2":
				deleteEmployee();
				System.out.println("\n Employee's Informations Has Been Deleted Successfully.");
				System.out.println("<------------------------------------------------------>");
				break;
			case "3":
				showEmployee();
				System.out.println("<------------------------------------------------------>");
				break;
			case "q":
				System.out.println("\n Quiting the Program...");
				exit = false;
				break;
			default:
				System.out.println("\n Entered Invalid Value.");
				System.out.println("<---------------------->");
			}
		}
		scanner.close();
		System.out.println("Quited the Program Saccessfully.");
	}

	public static void saveEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Employee's Information");
		System.out.print("Name: ");
		String name = scanner.next();
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		System.out.print("Surname: ");
		String surname = scanner.next();
		surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
		System.out.print("Department: ");
		String department = scanner.next();
		System.out.print("Position: ");
		String position = scanner.next();
		System.out.print("Id: ");
		long id = scanner.nextLong();
		System.out.print("Salary: ");
		long salary = scanner.nextLong();
		System.out.print("Work Off Day: ");
		long workOffDay = scanner.nextLong();

		Employee employee = new Employee(name, surname, department, position, id, salary, workOffDay);

		FileWriter writer = null;
		try {
			writer = new FileWriter("Employees.txt", true);
			writer.write(employee.toString() + "\n");
		} catch (Exception e) {
			System.out.println("An issue occurred while printing employee information.");
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e2) {
					System.out.println("An issue occurred while closing the file.");
				}
			}
		}

	}

	public static void deleteEmployee() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter the ID of the employee to delete: ");
	    long idToDelete = scanner.nextLong();

	    File inputFile = new File("Employees.txt");
	    List<String> lines = new ArrayList<>();

	    boolean isDeleted = false;

	    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	            if (currentLine.contains("ID: " + idToDelete)) {
	                System.out.println("Employee with ID " + idToDelete + " has been deleted.");
	                isDeleted = true;
	                continue;
	            }
	            lines.add(currentLine);
	        }

	        if (!isDeleted) {
	            System.out.println("No employee found with ID: " + idToDelete);
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading the file: " + e.getMessage());
	    }

	
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
	        for (String line : lines) {
	            writer.write(line);
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred while writing to the file: " + e.getMessage());
	    }
	}
	
	public static void showEmployee() {
		Scanner scanner = new Scanner(System.in);
		File inputFile = new File("Employees.txt");
		 System.out.print("Enter the ID of the employee: ");
	        long idToSearch = scanner.nextLong();
	        boolean isFound = false;

	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	            String currentLine;

	            while ((currentLine = reader.readLine()) != null) {
	                if (currentLine.contains("ID: " + idToSearch)) {
	                    System.out.println("Employee Details: " + currentLine);
	                    isFound = true;
	                    break; 
	                }
	            }

	            if (!isFound) {
	                System.out.println("No employee found with ID: " + idToSearch);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the file: " + e.getMessage());
	        }
	}

	}


