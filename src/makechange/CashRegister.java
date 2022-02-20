package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		int countTwentyDollars = 0; // count the $20 bills
		int countTenDollars = 0; // count the $10 bills
		int countFiveDollars = 0; // count the $5 bills
		int countOneDollar = 0; // count the $20 bills

		int countQuarters = 0; // count the ...
		int countDimes = 0; // count the ...
		int countNickels = 0; // count the ...
		int countPennies = 0; // count the ...

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter price of item : ");
		int itemPriceInt = (int) (sc.nextDouble() * 100);

		System.out.println("Enter amount tendered (paid) by customer: ");
		int amountPaidInt = (int) (sc.nextDouble() * 100);

		// change to penny math early to fix floating point math problems.

		int runningChange = (amountPaidInt - itemPriceInt);

		// get the cases out of the way early where we don't need the change logic.

		if (runningChange < 0) {
			System.out.println("Error: Customer did not provide enough money.");
		} else if (runningChange == 0) {
			System.out.println("Error: Customer paid with exact change. No change required.");
		}

		else {

			// use a loop until change is no longer required. Doing simple if conditionals
			// in sequence.

			while (runningChange > 0) {

				if (runningChange % (20 * 100) >= 0) {
					countTwentyDollars = (int) (runningChange / (20 * 100));
					runningChange = runningChange - (countTwentyDollars * 20 * 100);
				}

				if (runningChange % (10 * 100) >= 0) {
					countTenDollars = (int) (runningChange / (10 * 100));
					runningChange = runningChange - (countTenDollars * 10 * 100);
				}

				if (runningChange % (5 * 100) >= 0) {
					countFiveDollars = (int) (runningChange / (5 * 100));
					runningChange = runningChange - (countFiveDollars * 5 * 100);
				}

				if (runningChange % (100) >= 0) {
					countOneDollar = (int) (runningChange / 100);
					runningChange = runningChange - (countOneDollar * 100);
				}

				if (runningChange % 25 >= 0) {
					countQuarters = (int) (runningChange / 25);
					runningChange = runningChange - (countQuarters * 25);
				}

				if (runningChange % 10 >= 0) {
					countDimes = (int) (runningChange / 10);
					runningChange = runningChange - (countDimes * 10);
				}

				if (runningChange % 5 >= 0) {
					countNickels = (int) (runningChange / 5);
					runningChange = runningChange - (countNickels * 5);
				}

				if (runningChange % 1 >= 0) {
					countPennies = (int) (runningChange / 1);
					runningChange = runningChange - (countPennies * 1);
				}

			}

			// clean up output

			System.out.println("Give customer this change: ");

			if (countTwentyDollars != 0) {
				System.out.print(countTwentyDollars + " twenty dollar bill" + (countTwentyDollars == 1 ? ", " : "s, "));
			}

			if (countTenDollars != 0) {
				System.out.print(countTenDollars + " ten dollar bill" + (countTenDollars == 1 ? ", " : "s, "));
			}

			if (countFiveDollars != 0) {
				System.out.print(countFiveDollars + " five dollar bill" + (countFiveDollars == 1 ? ", " : "s, "));
			}

			if (countOneDollar != 0) {
				System.out.print(countOneDollar + " one dollar bill" + (countOneDollar == 1 ? ", " : "s, "));
			}

			if (countQuarters != 0) {
				System.out.print(countQuarters + " quarter" + (countQuarters == 1 ? ", " : "s, "));
			}

			if (countDimes != 0) {
				System.out.print(countDimes + " dime" + (countDimes == 1 ? ", " : "s, "));
			}

			if (countNickels != 0) {
				System.out.print(countNickels + " nickel" + (countNickels == 1 ? ", " : "s, "));
			}

			if (countPennies != 0) {
				System.out.print(countPennies + " penn" + (countPennies == 1 ? "y. " : "ies. "));
			}
			sc.close();
		}
	}
}

/*
 *
 * X Amount: .67, Tendered: .50, Result: Error message Amount: .67, Tendered:
 * X 1.00, Result: 1 quarter, 1 nickel, 3 pennies. Amount: .59, Tendered: 1.00,
 * X Result: 1 quarter, 1 dime, 1 nickel, 1 penny. Amount: 3.96, Tendered: 20.00,
 * X Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
 *  Amount: any amount less than 20.00, Tendered: anything greater than amount:
 * correct denominations for correct change.
 *
 */
