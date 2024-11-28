/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ATM_Server;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ATM_Interface extends Remote {

    public TaiKhoan ktdangnhap(String sotk, String matkhau) throws Exception;

    public long Sodu(String hoTen) throws Exception;

    public boolean ruttien(String hoTen, long sotien) throws Exception;

    public boolean Naptien(String hoTen, long sotien) throws Exception;

    public boolean CapNhatTrangThai_HoatDong(String sotk) throws Exception;

    public boolean CapNhatTrangThai_KhongHoatDong(String hoTen) throws Exception;

    public boolean CapNhatTaiKhoan(String matkhau, String hoTen) throws Exception;

    public boolean Chuyentien(String hoTenNguoiChuyen, long sotienCanChuyen, String hoTenNguoiNhan) throws Exception;
    
    public boolean ThemLichSu(String ngayRutTien, long soTienRutRa, String soTaiKhoan, String ghiChu, String hoTen) throws Exception;
    
    public List<LichSu> XemLichSu(String hoTen) throws Exception;
    
}
