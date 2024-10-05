package ngay21_9;

import java.util.Scanner;

public class CircleTest {
	public class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập số lượng hình tròn: ");
			int n = scanner.nextInt();
			Circle[] circles = new Circle[n];

			for (int i = 0; i < n; i++) {
				System.out.print("Nhập x, y và bán kính cho hình tròn " + (i + 1) + ": ");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				double radius = scanner.nextDouble();
				circles[i] = new Circle(x, y, radius);
			}
			System.out.printf("%-10s %-10s %-10s %-10s\n", "Đường kính", "Chu vi", "Diện tích", "Thông tin");
			for (Circle circle : circles) {
				System.out.printf("%-10.2f %-10.2f %-10.2f %-10s\n", circle.getDiameter(), circle.getCircumference(),
						circle.getArea(), circle.toString());

			}
		}
	}
}
