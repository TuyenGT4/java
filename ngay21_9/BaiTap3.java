package ngay21_9;

import java.util.Scanner;

public class BaiTap3 {
	// Viết chương trình tính tổng S = 1 + 1/22 + 1/32 + ... + 1/n2 với n nguyên
	// dương được nhập từ bàn phím
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

	double tinhTongS(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + 1.0 / (Math.pow((double) i, 2.0));
		}
		return sum;
	}

	public static void main(String[] args) {
		BaiTap3 obj = new BaiTap3();
		System.out.println("Enter value for variable n (n>0): ");
		int n = obj.input_value();
		System.out.println("Tong S = " + obj.tinhTongS(n));
	}
}
