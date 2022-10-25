package Lockers;

import java.io.IOException;
import java.util.Scanner;

public class Application {

	Scanner s = new Scanner(System.in);
	FileAccess dao = new FileAccess();

	public void introDisp() {

		System.out.println();
		System.out.println("-------Welcome to LockedMe.Com-------");
		System.out.println();
		System.out.println("Application developed by Aniketh Sahu");
		System.out.println();

	}

	public void exitDisp() {

		System.out.println();
		System.out.println("Application closed successfully.");
		System.out.println();
	}

	public void mainMenu() {

		System.out.println("               Main Menu               ");
		System.out.println();
		System.out.println("Choose from the desired operation to be performed:");
		System.out.println("1.View All The Products");
		System.out.println("2.More Options");
		System.out.println("3.Exit The Application");

	}

	public void subMenu() {

		System.out.println("               Sub Menu               ");
		System.out.println();
		System.out.println("Choose from the following options:");
		System.out.println("1.Add a file");
		System.out.println("2.Delete a file");
		System.out.println("3.Search a file");
		System.out.println("4.Go to the main menu");
		System.out.println();
	}

	public void mainMenuOp() {

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

			case 1:
				System.out.println();

				try {
					dao.listAllFiles(Main.path);
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

				System.out.println("\n***********************************\n");

				break;

			case 2:

				System.out.println();
				subMenuOp();
				break;

			case 3:

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
				mainMenu();

			}

		}

		while (true);

	}

	public void subMenuOp() {

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

			case 1:
				System.out.println("\n==> Adding a File...");
				System.out.println("Please enter a file name : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.createNewFile(Main.path, fileName);
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

				System.out.println("\n**********************************\n");
				break;

			case 2:
				System.out.println("\n==> Deleting a File...");
				System.out.println("Please enter a file name to Delete : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.deleteFile(Main.path, fileName);
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

				System.out.println("\n***********************************\n");
				break;

			case 3:
				System.out.println("\n==> Searching a File...");
				System.out.println("Please enter a file name to Search : ");
				file = s.nextLine();
				fileName = file.trim();
				try {
					dao.searchFile(Main.path, fileName);
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
				System.out.println("\n***********************************\n");
				break;

			case 4:
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
