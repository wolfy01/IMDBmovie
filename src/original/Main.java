package original;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out
				.println("Do you want to Register or Sign In (Press 1 or 2):\n1. Register\n2. Sign In\n3. Close app.");
		int num = s.nextInt();
		s.nextLine();
		if (num == 1) {
			System.out.println("Enter your email address:");
			String email = s.nextLine();
			saveEmailToFile(email);
			System.out.println("Account successfully created.");
		} else if (num == 2) {
			System.out.println("Enter your email address:");
			String email = s.nextLine();
			if (isEmailPresent(email)) {
				System.out.println("Sign in successful.");
				user_do ud = new user_do();
				ud.menus(email);
			} else {
				System.out.println("Email address not found. Please register first.");
			}
		} else if (num == 3) {
			System.out.println("Bye.");

		} else {
			System.out.println("Invalid choice.");
		}

		s.close();
	}

	private static void saveEmailToFile(String email) {
		try {
			FileWriter writer = new FileWriter("users.txt", true); // Append mode
			writer.write(email + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while saving the email address.");
			e.printStackTrace();
		}
	}

	private static boolean isEmailPresent(String email) {
		try {
			File file = new File("users.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.equals(email)) {
					scanner.close();
					return true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return false;
	}
}
