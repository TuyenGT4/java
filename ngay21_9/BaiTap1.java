package ngay21_9;

import java.util.Scanner;

public class BaiTap1 {
	Scanner scanner = new Scanner(System.in);

	void checkPositiveInteger(int n) throws Exception {
		if (n <= 0) {
			throw new Exception("Value must be a positive integer.");
		}
	}

	int input_value() {
		int n = 0;
		boolean check = false;
		while (!check) {
			try {
				n = scanner.nextInt();
				checkPositiveInteger(n);
				check = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Value must be a positive integer.");
				scanner.nextLine();
			}

		}
		return n;
	}

	int findUCLN(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else if (a < b) {
				b = b - a;
			}

		}
		return a;
	}

	int findBCNN(int a, int b) {
		return (a * b) / findUCLN(a, b);
	}

	public static void main(String[] args) {
		BaiTap1 obj = new BaiTap1();
		System.out.println("Enter value for variable a (a>0): ");
		int a = obj.input_value();
		System.out.println("Enter value for variable b (b>0): ");
		int b = obj.input_value();
		System.out.printf("UCLN(%d, %d) = %d va BCNN(%d, %d) = %d", a, b, obj.findUCLN(a, b), a, b, obj.findBCNN(a, b));
	}

}
