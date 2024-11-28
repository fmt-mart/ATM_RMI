/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_Server;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class LichSu implements Serializable{

    private Date ngayRutTien;
    private long soTienRutRa;
    private String soTaiKhoan;
    private String ghiChu;
    private String hoTen;
    private int iD;

    public LichSu(Date ngayRutTien, long soTienRutRa, String soTaiKhoan, String ghiChu, String hoTen, int iD) {
        this.ngayRutTien = ngayRutTien;
        this.soTienRutRa = soTienRutRa;
        this.soTaiKhoan = soTaiKhoan;
        this.ghiChu = ghiChu;
        this.hoTen = hoTen;
        this.iD = iD;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Date getNgayRutTien() {
        return ngayRutTien;
    }

    public void setNgayRutTien(Date ngayRutTien) {
        this.ngayRutTien = ngayRutTien;
    }

    public long getSoTienRutRa() {
        return soTienRutRa;
    }

    public void setSoTienRutRa(long soTienRutRa) {
        this.soTienRutRa = soTienRutRa;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "LichSu{" + "ngayRutTien=" + ngayRutTien + ", soTienRutRa=" + soTienRutRa + ", soTaiKhoan=" + soTaiKhoan + ", ghiChu=" + ghiChu + ", hoTen=" + hoTen + '}' + "\n";
    }
}
