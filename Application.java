package Lockers;

import java.io.IOException;
import java.util.Scanner;

public class Application {

	Scanner s = new Scanner(System.in);
	FileAccess dao = new FileAccess();
	String path = "C:\\Users\\anike\\Desktop\\New folder";

	public void introDisp() // To display the Application and Developer Information
	{

		System.out.println();
		System.out.println("-------Welcome to LockedMe.com-------");
		System.out.println();
		System.out.println("Application developed by Aniketh Sahu.");
		System.out.println();

	}

	public void exitDisp() // To display the termination text
	{

		System.out.println();
		System.out.println("Application closed successfully.");
		System.out.println();
	}

	public void mainMenu() // To display the main menu items i.e. first set of selections
	{

		System.out.println("          -----MAIN MENU-----          ");
		System.out.println();
		System.out.println("-> Choose from the desired operation to be performed:");
		System.out.println();
		System.out.println("1.View All The Products");
		System.out.println("2.More Options");
		System.out.println("3.Exit The Application");
		System.out.println();
		System.out.println("Enter your choice:");
		System.out.println();

	}

	public void subMenu() // To display the sub-menu items i.e. second set of selections
	{

		System.out.println("          -----SUB MENU-----          ");
		System.out.println();
		System.out.println("-> Choose from the following options:");
		System.out.println();
		System.out.println("1.Add a file");
		System.out.println("2.Delete a file");
		System.out.println("3.Search a file");
		System.out.println("4.Go to the main menu");
		System.out.println();
		System.out.println("Enter your choice:");
		System.out.println();
	}

	public void mainMenuOp() // To perform the main menu operations
	{

		int choice = 0;
		char choice1 = 0;
		do {

			mainMenu();

			try {
				choice = Integer.parseInt(s.nextLine());
			}

			catch (NumberFormatException e) {

				System.out.println("\nInvalid Input \nValid Input Integers:(1-3)\n");
				mainMenuOp();

			}

			switch (choice) {

			case 1: // To list all the contents of the user specified file
				System.out.println();
				try {
					dao.listAllFiles(path);
				}

				catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("\n----------------------------------\n");

				break;

			case 2: // To display the sub-menu options

				System.out.println();
				subMenuOp();
				break;

			case 3: // To exit the program

				System.out.println("\n Are you sure you want to exit ? ");
				System.out.println("  (Y) ==> Yes    (N) ==> No        ");
				choice1 = s.nextLine().toUpperCase().charAt(0);
				if (choice1 == 'Y') {
					System.out.println("\n");
					exitDisp();
					System.exit(1);
				}

				else if (choice1 == 'N') {
					System.out.println("\n");
					mainMenu();
				}

				else {
					System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
					mainMenu();
				}

			default:
				System.out.println("\nInvalid Input \nValid Input Integers:(1-3)\n");
				mainMenuOp();

			}

		}

		while (true);

	}

	public void subMenuOp() // To perform the sub-menu operations
	{

		String file = null;
		String fileName = null;
		int choice = 0;

		do {

			subMenu();

			try {
				choice = Integer.parseInt(s.nextLine());
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid Input \nValid Input Integers:(1-4)");
				subMenu();
			}

			switch (choice) {

			case 1: // Adding a file
				System.out.println("\nTo add a File");
				System.out.println("Please enter the file name to be added : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.createNewFile(path, fileName);
				}

				catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

				catch (IOException e) {
					System.out.println("Error occurred while adding file..");
					System.out.println("Please try again...");
				}

				catch (Exception e) {
					System.out.println("Error occurred while adding file..");
					System.out.println("Please try again...");
				}

				System.out.println("\n---------------------------------\n");
				break;

			case 2: // Deleting a file
				System.out.println("\nTo delete a File");
				System.out.println("Please enter the file name to be deleted : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.deleteFile(path, fileName);
				}

				catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

				catch (IOException e) {
					System.out.println("Error occurred while Deleting File..");
					System.out.println("Please try again...");
				}

				catch (Exception e) {
					System.out.println("Error occurred while Deleting File..");
					System.out.println("Please try again...");
				}

				System.out.println("\n---------------------------------\n");
				break;

			case 3: // Searching a file
				System.out.println("\nTo search a File");
				System.out.println("Please enter the file name to be searched : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.searchFile(path, fileName);
				}

				catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n---------------------------------\n");
				break;

			case 4: // To show the main menu options
				mainMenuOp();
				break;

			default:
				System.out.println("Invalid Input \nValid Input Integers:(1-4)");
				subMenuOp();

			}

			file = null;
			fileName = null;

		} while (true);

	}
}
