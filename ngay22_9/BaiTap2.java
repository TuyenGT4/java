package ngay22_9;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame extends Frame {

	Label lbTieuDe;
	Label lbA;
	Label lbB;
	Label lbKQ;
	TextField txtA, txtB;
	TextField txtKetQua;
	Button btnGiai;
	Button btnXoa;
	Button btnThoat;

	public MyFrame() {
		lbTieuDe = new Label("Giải phương trình ax + b = 0");
		lbA = new Label("Hệ số A: ");
		lbB = new Label("Hệ số B: ");
		lbKQ = new Label("Kết quả: ");
		txtA = new TextField(10);
		txtB = new TextField(10);
		txtKetQua = new TextField(10);
		txtKetQua.setEditable(false); // Đặt TextField Kết quả là không chỉnh sửa
		btnGiai = new Button("Giải PT");
		btnXoa = new Button("Xóa");
		btnThoat = new Button("Thoát");

		this.setLayout(new FlowLayout());
		this.add(lbTieuDe);
		this.add(lbA);
		this.add(txtA);
		this.add(lbB);
		this.add(txtB);
		this.add(lbKQ);
		this.add(txtKetQua);
		this.add(btnGiai);
		this.add(btnXoa);
		this.add(btnThoat);

		this.setSize(225, 200);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Sự kiện cho nút Giải PT
		btnGiai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a = Double.parseDouble(txtA.getText());
					double b = Double.parseDouble(txtB.getText());

					if (a != 0) {
						double x = -b / a;
						txtKetQua.setText("x = " + x);
					} else {
						if (b == 0) {
							txtKetQua.setText("Vô số nghiệm!");
						} else {
							txtKetQua.setText("Vô nghiệm!");
						}
					}
				} catch (NumberFormatException ex) {
					txtKetQua.setText("Vui lòng nhập số liệu cụ thể!");
				}
			}
		});

		// Sự kiện cho nút Xóa
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(""); // Xóa nội dung TextField A
				txtB.setText(""); // Xóa nội dung TextField B
				txtKetQua.setText(""); // Xóa kết quả
			}
		});

		// Sự kiện cho nút Thoát
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Thoát chương trình
			}
		});

		this.setVisible(true);
	}
}

public class BaiTap2 {
	public static void main(String[] args) {
		MyFrame frmGiaiPT = new MyFrame();
	}
}
