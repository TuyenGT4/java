package BaiThucHanh_04;

public class LoaiSanPham {
	private String maLoai, tenLoai;

	public LoaiSanPham(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "DanhSachLoaiSanPham [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
}
