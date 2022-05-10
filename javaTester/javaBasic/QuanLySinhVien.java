package javaBasic;

public class QuanLySinhVien {
	private int maSinhVien;
	private String hoTen;
	private Float diemLyThuyet, diemThucHanh;
	
	public static void main(String[] args) {
		QuanLySinhVien hososinhvien = new QuanLySinhVien();
		hososinhvien.setMaSinhVien(01);
		hososinhvien.setHoTen("Nguyen Van Nam");
		hososinhvien.setDiemLyThuyet(6.0f);
		hososinhvien.setDiemThucHanh(8.0f);
		hososinhvien.showThongTin();
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}


	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public Float getDiemLyThuyet() {
		return diemLyThuyet;
	}


	public void setDiemLyThuyet(Float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}


	public Float getDiemThucHanh() {
		return diemThucHanh;
	}


	public void setDiemThucHanh(Float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}
	
	public void showThongTin() {
		System.out.println("Mã Học Sinh: " + maSinhVien);
		System.out.println("Họ Tên: " + hoTen);
		System.out.println("Điểm Thực Hành: " + diemThucHanh);
		System.out.println("Điểm Lý Thuyết: " + diemLyThuyet);
	}

}
