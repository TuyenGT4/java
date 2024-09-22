package ngay22_9;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame4 extends Frame {

	Label lbTieuDe;
	Label lbCD; // Nhãn cho Chiều Dài
	Label lbCR; // Nhãn cho Chiều Rộng
	Label lbKQ; // Nhãn cho Kết Quả
	Label lbCV; // Nhãn cho Chu Vi
	Label lbDT; // Nhãn cho Diện Tích
	TextField txtCD, txtCR, txtCV, txtDT;
	Button btnTH; // Nút Thực hiện
	Button btnXoa; // Nút Xóa
	Button btnThoat; // Nút Thoát
	CheckboxGroup cbg; // Nhóm RadioButton để chọn loại hình khối
	Checkbox cbHCN, cbHV, cbHT; // RadioButtons cho các loại hình khối

	public MyFrame4() {
		// Tạo các thành phần giao diện
		lbTieuDe = new Label("Tính chu vi và diện tích");
		lbCD = new Label("Nhập CD: ");
		lbCR = new Label("Nhập CR: ");
		txtCD = new TextField(10);
		txtCR = new TextField(10);
		lbKQ = new Label("Kết Quả:");
		lbCV = new Label("Chu vi:");
		lbDT = new Label("Diện tích:");
		txtCV = new TextField(10);
		txtDT = new TextField(10);
		txtCV.setEditable(false); // Chỉ đọc
		txtDT.setEditable(false); // Chỉ đọc
		btnTH = new Button("Thực hiện");
		btnXoa = new Button("Xóa");
		btnThoat = new Button("Thoát");

		// Nhóm RadioButton cho các loại hình khối
		cbg = new CheckboxGroup();
		cbHCN = new Checkbox("Hình chữ nhật", cbg, true);
		cbHV = new Checkbox("Hình vuông", cbg, false);
		cbHT = new Checkbox("Hình tròn", cbg, false);

		// Sắp xếp các thành phần trên giao diện
		this.setLayout(new FlowLayout());
		this.add(lbTieuDe);
		this.add(new Label()); // Không có thành phần nào, chỉ tạo khoảng trống
		this.add(cbHCN);
		this.add(cbHV);
		this.add(cbHT);
		this.add(new Label()); // Khoảng trống
		this.add(lbCD);
		this.add(txtCD);
		this.add(lbCR);
		this.add(txtCR);
		this.add(lbKQ);
		this.add(new Label());
		this.add(lbCV);
		this.add(txtCV);
		this.add(lbDT);
		this.add(txtDT);
		this.add(btnTH);
		this.add(btnXoa);
		this.add(btnThoat);

		this.setSize(400, 300);
		this.setVisible(true);

		// Xử lý sự kiện đóng cửa sổ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Xử lý sự kiện cho nút "Thực hiện"
		btnTH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedShape = cbg.getSelectedCheckbox().getLabel();
					if (selectedShape.equals("Hình chữ nhật")) {
						// Tính chu vi và diện tích hình chữ nhật
						double cd = Double.parseDouble(txtCD.getText());
						double cr = Double.parseDouble(txtCR.getText());
						double chuVi = 2 * (cd + cr);
						double dienTich = cd * cr;
						txtCV.setText(String.valueOf(chuVi));
						txtDT.setText(String.valueOf(dienTich));
					} else if (selectedShape.equals("Hình vuông")) {
						// Tính chu vi và diện tích hình vuông
						double cd = Double.parseDouble(txtCD.getText());
						double chuVi = 4 * cd;
						double dienTich = cd * cd;
						txtCV.setText(String.valueOf(chuVi));
						txtDT.setText(String.valueOf(dienTich));
					} else if (selectedShape.equals("Hình tròn")) {
						// Tính chu vi và diện tích hình tròn
						double r = Double.parseDouble(txtCD.getText());
						double chuVi = 2 * Math.PI * r;
						double dienTich = Math.PI * r * r;
						txtCV.setText(String.format("%.2f", chuVi));
						txtDT.setText(String.format("%.2f", dienTich));
					}
				} catch (NumberFormatException ex) {
					txtCV.setText("Lỗi nhập liệu");
					txtDT.setText("Lỗi nhập liệu");
				}
			}
		});

		// Xử lý sự kiện cho nút "Xóa"
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCD.setText("");
				txtCR.setText("");
				txtCV.setText("");
				txtDT.setText("");
			}
		});

		// Xử lý sự kiện cho nút "Thoát"
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}

public class BaiTap4 {
	public static void main(String[] args) {
		MyFrame4 frmKiemTraSCP = new MyFrame4();
	}
}
