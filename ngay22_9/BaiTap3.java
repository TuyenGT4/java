package ngay22_9;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;

class MyFrame3 extends Frame {
	Label lbTieude;
	Label lbN;
	Label lbKQ;
	TextField txtN;
	Button btnKT;

	public MyFrame3() {
		lbTieude = new Label("Kiểm tra có phải số chính phương");
		lbN = new Label("Nhập số nguyên n:");
		lbKQ = new Label("");
		txtN = new TextField(10);
		btnKT = new Button("Kiểm tra");

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Sắp xếp theo chiều dọc
		this.add(lbTieude);
		this.add(lbN);
		this.add(txtN);
		this.add(btnKT);
		this.add(lbKQ);

		this.setSize(300, 150);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		btnKT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int n = Integer.parseInt(txtN.getText());
					if (isPerfectSquare(n)) {
						lbKQ.setText(n + " là số chính phương.");
					} else {
						lbKQ.setText(n + " không phải số chính phương.");
					}
				} catch (NumberFormatException ex) {
					lbKQ.setText("Vui lòng nhập số nguyên hợp lệ!");
				}
			}
		});

		this.setVisible(true);
	}

	// Hàm kiểm tra số chính phương
	private boolean isPerfectSquare(int n) {
		if (n < 0)
			return false; // Số âm không thể là số chính phương
		int sqrt = (int) Math.sqrt(n);
		return (sqrt * sqrt) == n; // Kiểm tra xem căn bậc hai có phải là số nguyên
	}
}

public class BaiTap3 {
	public static void main(String[] args) {
		MyFrame3 frmKiemTraSCP = new MyFrame3();
	}
}
