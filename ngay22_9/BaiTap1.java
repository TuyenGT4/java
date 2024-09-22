package ngay22_9;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai1 {

	// Lớp MyAction để xử lý sự kiện khi nhấn nút
	class MyAction implements ActionListener {
		private Frame frm; // Biến để lưu tham chiếu đến Frame
		private Label lnInKQ; // Nhãn để hiển thị kết quả
		private Button btnYes, btnNo, btnMaybe; // Các nút cần tham chiếu

		// Hàm khởi tạo để truyền tham chiếu Frame, Label và các nút
		public MyAction(Frame frm, Label lnInKQ, Button btnYes, Button btnNo, Button btnMaybe) {
			this.frm = frm;
			this.lnInKQ = lnInKQ;
			this.btnYes = btnYes;
			this.btnNo = btnNo;
			this.btnMaybe = btnMaybe;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Button btn = (Button) e.getSource(); // Lấy đối tượng nguồn sự kiện
			// Xử lý sự kiện cho từng nút
			if (e.getSource() == btnYes) {
				lnInKQ.setText("You pressed " + btn.getLabel() + " Button");
			} else if (e.getSource() == btnNo) {
				lnInKQ.setText("You pressed " + btn.getLabel() + " Button");
			} else if (e.getSource() == btnMaybe) {
				lnInKQ.setText("You pressed " + btn.getLabel() + " Button");
			}
		}
	}

	class Demobtn extends Frame {
		Button btnYes, btnNo, btnMaybe;
		Label lnInKQ;

		public Demobtn() {
			this.setLayout(new FlowLayout());

			// Khởi tạo các nút và nhãn
			btnYes = new Button("Yes");
			btnNo = new Button("No");
			btnMaybe = new Button("Maybe");
			lnInKQ = new Label("You pressed ... Button");

			// Thêm các nút và nhãn vào Frame
			this.add(btnYes);
			this.add(btnNo);
			this.add(btnMaybe);
			this.add(lnInKQ);

			// Tạo đối tượng MyAction và truyền các tham chiếu
			MyAction actionHandler = new MyAction(this, lnInKQ, btnYes, btnNo, btnMaybe);

			// Thêm ActionListener cho các nút
			btnYes.addActionListener(actionHandler);
			btnNo.addActionListener(actionHandler);
			btnMaybe.addActionListener(actionHandler);

			// Thiết lập kích thước và hiển thị Frame
			this.setSize(400, 200);
			this.setVisible(true);

			// Xử lý sự kiện đóng cửa sổ
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
		}
	}

	public static void main(String[] args) {
		// Khởi tạo và hiển thị cửa sổ DemoButton
		bai1 outer = new bai1(); // Để tham chiếu đến lớp bên ngoài
		Demobtn Demo = outer.new Demobtn();
	}
}
