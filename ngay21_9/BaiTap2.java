package ngay21_9;

import java.util.Scanner;

public class BaiTap2 {
	// Viết chương trình tính n! = 1 * 2 * 3 * ... * n với n nguyên dương được nhập
	// từ bàn phím.
	Scanner scanner = new Scanner(System.in);

	void checkPositiveInteger(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Value must be a positive integer.");
		}
	}

	int input_value() {
		int n = 0;
		boolean isValid = false;
		while (!isValid) {
			try {
				n = scanner.nextInt();
				checkPositiveInteger(n);
				isValid = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Value must be a positive integer.");
			}
		}
		return n;
	}

	int tinhGiaiThua(int n) {
		int gt = 1;
		for (int i = 1; i <= n; i++) {
			gt = gt * i;
		}
		return gt;
	}

	public static void main(String[] args) {
		BaiTap2 obj = new BaiTap2();
		System.out.println("Enter value for variable n (n>0): ");
		int n = obj.input_value();
		System.out.println("n! = " + obj.tinhGiaiThua(n));
	}
}
