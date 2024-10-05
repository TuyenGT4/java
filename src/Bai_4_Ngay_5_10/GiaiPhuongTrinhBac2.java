package Bai_4_Ngay_5_10;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBac2 extends JFrame {
	private JTextField txtSoA, txtSoB, txtSoC, txtKetQua;
	private JButton btnGiai, btnXoaTrang, btnThoat;
	private JLabel lblTieuDe;

	public GiaiPhuongTrinhBac2() {
		setTitle("Solve the quadratic equation."); // hiện thị content ở thanh tiêu đề của cửa sổ ứng dụng
		setLayout(null); // chỉ định layout manager cho container, khi mà gán bằng null thì layout sẽ tự
							// phải set up
		JLabel lblTitle = new JLabel("Giai phuong trinh bac 2");
		lblTitle.setBounds(90, 0, 180, 30);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add(lblTitle);

		JLabel lblA = new JLabel("a: ");
		lblA.setBounds(55, 30, 50, 30);
		add(lblA);

		txtSoA = new JTextField();
		txtSoA.setBounds(80, 30, 200, 30);
		add(txtSoA);

		JLabel lblB = new JLabel("b:");
		lblB.setBounds(55, 70, 50, 30);
		add(lblB);

		txtSoB = new JTextField();
		txtSoB.setBounds(80, 70, 200, 30);
		add(txtSoB);

		JLabel lblC = new JLabel("c:");
		lblC.setBounds(55, 110, 50, 30);
		add(lblC);

		txtSoC = new JTextField();
		txtSoC.setBounds(80, 110, 200, 30);
		add(txtSoC);

		JLabel lblKetQua = new JLabel("Ket qua");
		lblKetQua.setBounds(40, 140, 200, 30);
		lblKetQua.setHorizontalAlignment(JLabel.CENTER);
		add(lblKetQua);

		txtKetQua = new JTextField();
		txtKetQua.setBounds(30, 170, 280, 30);
		txtKetQua.setEditable(false);
		add(txtKetQua);

		btnGiai = new JButton("Giải");
		btnGiai.setBounds(30, 210, 80, 30);
		add(btnGiai);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(120, 210, 100, 30);
		add(btnXoaTrang);

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(230, 210, 80, 30);
		add(btnThoat);

		// Xử lý sự kiện nút Giải
		btnGiai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double a = Double.parseDouble(txtSoA.getText());
					double b = Double.parseDouble(txtSoB.getText());
					double c = Double.parseDouble(txtSoC.getText());

					String ketQua = "";
					if (a == 0) {
						// Phương trình bậc nhất: bx + c = 0
						if (b != 0) {
							double x = -c / b;
							ketQua = "Phuong trinh bac nhat co nghiem: x = " + x;
						} else {
							if (c == 0) {
								ketQua = "Phuong trinh vo so nghiem.";
							} else {
								ketQua = "Phuong trinh vo nghiem.";
							}
						}
					} else {
						// Phương trình bậc hai: ax^2 + bx + c = 0
						double delta = b * b - 4 * a * c;

						if (delta < 0) {
							ketQua = "Phuong trinh vo nghiem.";
						} else if (delta == 0) {
							double x = -b / (2 * a);
							ketQua = "Phuong trinh co nghiem kep: x = " + x;
						} else {
							double x1 = (-b + Math.sqrt(delta)) / (2 * a);
							double x2 = (-b - Math.sqrt(delta)) / (2 * a);
							ketQua = "Phuong trinh co hai nghiem: x1 = " + x1 + ", x2 = " + x2;
						}
					}

					txtKetQua.setText(ketQua);

				} catch (NumberFormatException ex) {
					txtKetQua.setText("Vui long nhap so hop le!");
				}
			}
		});

		// Xử lý sự kiện nút Xóa trắng
		btnXoaTrang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtSoA.setText("");
				txtSoB.setText("");
				txtSoC.setText("");
				txtKetQua.setText("");
			}
		});

		// Xử lý sự kiện nút Thoát
		btnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Thoát chương trình
			}
		});

		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		GiaiPhuongTrinhBac2 obj = new GiaiPhuongTrinhBac2();
	}
}
