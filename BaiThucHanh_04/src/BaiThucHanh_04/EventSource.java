package BaiThucHanh_04;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EventSource extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DanhSachLoaiSanPham danhsach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventSource frame = new EventSource();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventSource() {
		setTitle("Quản lý danh mục loại sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH MỤC LOẠI SẢN PHẨM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(147, 11, 271, 42);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(103, 85, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(103, 130, 200, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mã loại: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(42, 91, 68, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên loại: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(42, 136, 68, 14);
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 7));
		panel.setBounds(10, 171, 566, 36);
		contentPane.add(panel);

		JButton btnNewButton = new JButton("Thêm");
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Xóa");
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Sửa");
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Lưu");
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("K. lưu");
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Thoát\r\n");
		panel.add(btnNewButton_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 566, 183);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "M\u00E3 lo\u1EA1i", "T\u00EAn lo\u1EA1i" }));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);

		// xử lý event khi nhấn nút thêm: lấy dữ liệu từ người dùng nhập vào -> lưu vào
		// obj loaisanpam -> thêm vào arraylist danhsachloaisanpham -> cập nhật vào
		// table
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maLoai, tenLoai;
				maLoai = lblNewLabel_1.getText();
				tenLoai = lblNewLabel_2.getText();
				LoaiSanPham obj = new LoaiSanPham(maLoai, tenLoai);
				danhsach.themThongTin(obj);
			}
		});
	}
}
