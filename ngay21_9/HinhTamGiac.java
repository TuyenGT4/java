package ngay21_9;

public class HinhTamGiac {
	private int ma, mb, mc;

	// Hàm khởi tạo không đối số
	public HinhTamGiac() {
	}

	// Hàm khởi tạo với ba cạnh, kèm theo kiểm tra các điều kiện
	public HinhTamGiac(int ma, int mb, int mc) {
		// Kiểm tra giá trị âm
		if (ma < 0 || mb < 0 || mc < 0) {
			System.out.println("Cạnh không được là số âm. Đặt giá trị mặc định là 0.");
			this.ma = this.mb = this.mc = 0;
		}
		// Kiểm tra điều kiện tam giác
		else if (!laTamGiac(ma, mb, mc)) {
			System.out.println("Không phải là hình tam giác. Đặt giá trị các cạnh là 0.");
			this.ma = this.mb = this.mc = 0;
		} else {
			this.ma = ma;
			this.mb = mb;
			this.mc = mc;
		}
	}

	// Getter cho cạnh A
	public int getCanhA() {
		return ma;
	}

	// Getter cho cạnh B
	public int getCanhB() {
		return mb;
	}

	// Getter cho cạnh C
	public int getCanhC() {
		return mc;
	}

	// Setter cho cạnh A với kiểm tra
	public void setCanhA(int ma) {
		if (ma > 0 && laTamGiac(ma, this.mb, this.mc)) {
			this.ma = ma;
		} else {
			System.out.println("Không thể gán cạnh A. Giá trị không hợp lệ hoặc không lập thành tam giác.");
		}
	}

	// Setter cho cạnh B với kiểm tra
	public void setCanhB(int mb) {
		if (mb > 0 && laTamGiac(this.ma, mb, this.mc)) {
			this.mb = mb;
		} else {
			System.out.println("Không thể gán cạnh B. Giá trị không hợp lệ hoặc không lập thành tam giác.");
		}
	}

	// Setter cho cạnh C với kiểm tra
	public void setCanhC(int mc) {
		if (mc > 0 && laTamGiac(this.ma, this.mb, mc)) {
			this.mc = mc;
		} else {
			System.out.println("Không thể gán cạnh C. Giá trị không hợp lệ hoặc không lập thành tam giác.");
		}
	}

	// Kiểm tra ba cạnh có lập thành một hình tam giác không
	public boolean laTamGiac() {
		return (ma + mb > mc) && (ma + mc > mb) && (mb + mc > ma);
	}

	// Kiểm tra các giá trị cụ thể có lập thành hình tam giác không
	public boolean laTamGiac(int a, int b, int c) {
		return (a + b > c) && (a + c > b) && (b + c > a);
	}

	// Hàm tính chu vi tam giác
	public int getChuVi() {
		if (laTamGiac()) {
			return ma + mb + mc;
		} else {
			System.out.println("Không phải tam giác, không thể tính chu vi.");
			return 0;
		}
	}

	// Hàm tính diện tích tam giác theo công thức Heron
	public double getDienTich() {
		if (laTamGiac()) {
			double nuaChuVi = (double) getChuVi() / 2;
			return Math.sqrt(nuaChuVi * (nuaChuVi - ma) * (nuaChuVi - mb) * (nuaChuVi - mc));
		} else {
			System.out.println("Không phải tam giác, không thể tính diện tích.");
			return 0;
		}
	}

	public static void main(String[] args) {

		HinhTamGiac htg1 = new HinhTamGiac(3, 4, 5); // Tam giác hợp lệ
		System.out.println("Chu vi: " + htg1.getChuVi());
		System.out.println("Diện tích: " + htg1.getDienTich());

		HinhTamGiac htg2 = new HinhTamGiac(-1, 4, 5); // Cạnh âm
		HinhTamGiac htg3 = new HinhTamGiac(1, 2, 3); // Không lập thành tam giác

		htg1.setCanhA(10);
		htg1.setCanhA(2);
		System.out.println("Chu vi sau khi đổi cạnh A: " + htg1.getChuVi());
	}
}
