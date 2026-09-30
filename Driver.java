package lab2;

import java.util.Scanner;

public class Driver {
	public static final double TEST_PRINCIPAL = 50000;
	public static void main(String[] args) {
		Interest[] arr = new Interest[5];
		Scanner s = new Scanner(System.in);
		System.out.print("Investments\n-----------");
		for (int i=0;i<arr.length;i++)
		{
			System.out.printf("%nInvestment %d of %d%n", i + 1, arr.length);
			double annualInterestRate = readPositiveDouble(s, "Annual interest rate (as a decimal, e.g. 0.05): ");
			double totalInvestmentYears = readPositiveDouble(s, "Total years of investment: ");
			String interestType = readInterestType(s);
			if (interestType.equalsIgnoreCase("s")) 
			{
				arr[i] = new Interest(annualInterestRate, totalInvestmentYears);
				continue;
			}
			int periodsPerYear = readPositiveInt(s, "Compounding periods per year: ");
			arr[i] = new Interest(annualInterestRate, totalInvestmentYears, periodsPerYear);
		}
		System.out.println("\nResults");
		System.out.println("-------");
		for (int i=0;i<arr.length;i++)
		{
			System.out.printf("Investment %d: $%,.2f accrues $%,.2f of interest%n", i + 1, TEST_PRINCIPAL, arr[i].Calculate(TEST_PRINCIPAL));
		}
	}

	private static double readPositiveDouble(Scanner s, String prompt) {
		while (true) {
			System.out.print(prompt);
			if (s.hasNextDouble()) {
				double value = s.nextDouble();
				if (Double.isFinite(value) && value > 0) {
					return value;
				}
			} else {
				s.next();
			}
			System.out.println("Invalid input. Please enter a number greater than zero.");
		}
	}

	private static int readPositiveInt(Scanner s, String prompt) {
		while (true) {
			System.out.print(prompt);
			if (s.hasNextInt()) {
				int value = s.nextInt();
				if (value > 0) {
					return value;
				}
			} else {
				s.next();
			}
			System.out.println("Invalid input. Please enter a whole number greater than zero.");
		}
	}

	private static String readInterestType(Scanner s) {
		while (true) {
			System.out.print("Compound or simple? (c/s): ");
			String value = s.next();
			if (value.equalsIgnoreCase("c") || value.equalsIgnoreCase("s")) {
				return value;
			}
			System.out.println("Invalid input. Please enter 'c' or 's'.");
		}
	}

}
