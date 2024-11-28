/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_Server;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class TaiKhoan implements Serializable{

    private String soTaiKhoan;
    private String hoTen;
    private long soTien;
    private String matKhau;
    private boolean trangThai;

    public TaiKhoan(ResultSet rs) throws SQLException {
        this.soTaiKhoan = rs.getString("SoTaiKhoan");
        this.hoTen=  rs.getString("HoTen");
        this.soTien = rs.getLong("SoTien");
        this.matKhau = rs.getString("MatKhau");
        this.trangThai = rs.getBoolean("TrangThai");
    }

    public TaiKhoan(String soTaiKhoan, String hoTen, long soTien, String matKhau, boolean trangThai) {
        this.soTaiKhoan = soTaiKhoan;
        this.hoTen = hoTen;
        this.soTien = soTien;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
