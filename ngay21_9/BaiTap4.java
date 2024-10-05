package ngay21_9;

import java.util.Scanner;

public class BaiTap4 {
	/*
	 * Cho ma trận số nguyên cấp n x m. Cài đặt các hàm thực hiện các chức năng sau:
	 * a) Nhập ma trận. b) In ma trận. c) Tìm phần tử nhỏ nhất. d) Tìm phần tử lẻ
	 * lớn nhất. e) Tìm dòng có tổng lớn nhất.
	 */
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

	int[][] input_arr(int n, int m) {
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("A[%d][%d]: ", i, j);
				arr[i][j] = scanner.nextInt();
			}
		}
		return arr;
	}

	void display_arr(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	int findMinElement(int[][] arr, int n, int m) {
		int min = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
				}
			}
		}
		return min;
	}

	int findMaxOddElement(int[][] arr, int n, int m) {
		int max = Integer.MIN_VALUE;
		boolean isValid = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < arr[i][j] && arr[i][j] % 2 != 0) {
					max = arr[i][j];
					isValid = true;
				}
			}
		}
		return isValid ? max : -1;
	}

	int findTheRowWithTheLargestSum(int[][] arr, int n, int m) {
		int maxSum = Integer.MIN_VALUE;
		int row = -1;
		for (int i = 0; i < n; i++) {
			int sumRow = 0;
			for (int j = 0; j < m; j++) {
				sumRow += arr[i][j];
			}
			if (sumRow > maxSum) {
				row = i;
				maxSum = sumRow;
			}
		}
		return row + 1;
	}

	public static void main(String[] args) {
		BaiTap4 obj = new BaiTap4();
		System.out.println("Enter value for variable n (n>0): ");
		int n = obj.input_value();
		System.out.println("Enter value for variable m (m>0): ");
		int m = obj.input_value();
		int[][] arr;
		System.out.println("Nhap mang: ");
		arr = obj.input_arr(n, m);
		System.out.println("Hien thi mang:");
		obj.display_arr(arr, n, m);
		System.out.println("Phan tu nho nhat: " + obj.findMinElement(arr, n, m));
		System.out.println("Phan tu le lon nhat la: " + obj.findMaxOddElement(arr, n, m));
		System.out.println("Dong co tong lon nhat la: " + obj.findTheRowWithTheLargestSum(arr, n, m));
	}
}
