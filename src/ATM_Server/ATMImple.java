/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_Server;

import atm_demo.DBContext;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ATMImple extends UnicastRemoteObject implements ATM_Interface, Serializable {

    public ATMImple() throws RemoteException {
        super();
    }

    @Override
    public TaiKhoan ktdangnhap(String sotk, String matkhau) throws Exception {
        String sqlCheckStatus = "SELECT * FROM Taikhoan WHERE SoTaiKhoan = ? AND MatKhau = ?";
        String sqlUpdateStatus = "UPDATE Taikhoan SET TrangThai = 1 WHERE SoTaiKhoan = ?";

        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psUpdate = null;

        try {
            conn = new DBContext().getConnection();

            // Kiểm tra thông tin đăng nhập và trạng thái tài khoản
            psCheck = conn.prepareStatement(sqlCheckStatus);
            psCheck.setString(1, sotk);
            psCheck.setString(2, matkhau);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                int trangThai = rs.getInt("TrangThai");
                if (trangThai == 1) {
                    throw new Exception("Tài khoản này đang được sử dụng trên một thiết bị khác.");
                } else {
                    // Nếu chưa đăng nhập thì cho phép đăng nhập và cập nhật trạng thái thành đang hoạt động
                    psUpdate = conn.prepareStatement(sqlUpdateStatus);
                    psUpdate.setString(1, sotk);
                    int rowsUpdated = psUpdate.executeUpdate();

                    // Trả về thông tin tài khoản nếu cập nhật trạng thái thành công
                    if (rowsUpdated > 0) {
                        return new TaiKhoan(rs);
                    }
                }
            } else {
                throw new Exception("Sai tài khoản hoặc mật khẩu!");
            }
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        } finally {
            // Đóng các tài nguyên
            if (psCheck != null) psCheck.close();
            if (psUpdate != null) psUpdate.close();
            if (conn != null) conn.close();
        }

        return null;
    }

    @Override
    public long Sodu(String hoTen) throws Exception {
        String sql = "SELECT SoTien FROM Taikhoan WHERE HoTen = ?";
        long soDuHienTai = 0;
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoTen);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                soDuHienTai = rs.getLong("SoTien");
            } else {
                throw new Exception("Tài khoản không tồn tại.");
            }
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }

        return soDuHienTai;
    }

    @Override
    public boolean ruttien(String hoTen, long sotien) throws Exception {
        String sqlSelect = "SELECT SoTien FROM Taikhoan WHERE HoTen = ?";
        long soDuHienTai = 0;

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ps.setString(1, hoTen);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                soDuHienTai = rs.getLong("SoTien");
            } else {
                throw new Exception("Tài khoản không tồn tại.");
            }
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }

        if (soDuHienTai >= sotien && soDuHienTai >= 0 && sotien >= 0) {
            soDuHienTai -= sotien;

            String sqlUpdate = "UPDATE Taikhoan SET SoTien = ? WHERE HoTen = ?";
            try {
                Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlUpdate);
                ps.setLong(1, soDuHienTai);
                ps.setString(2, hoTen);

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException ex) {
                throw new Exception("Lỗi khi cập nhật số dư trong cơ sở dữ liệu: " + ex.getMessage());
            }

        } else {
            return false;
        }
    }

    @Override
    public boolean CapNhatTrangThai_HoatDong(String sotk) throws Exception {
        String sqlUpdate = "Update Taikhoan Set TrangThai = '1' Where SoTaiKhoan = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, sotk);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }
    }

    @Override
    public boolean CapNhatTrangThai_KhongHoatDong(String hoTen) throws Exception {
        String sqlUpdate = "Update Taikhoan Set TrangThai = '0' where HoTen = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, hoTen);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }
    }

    @Override
    public boolean Naptien(String hoTen, long sotien) throws Exception {
        String sqlSelect = "SELECT SoTien FROM Taikhoan WHERE HoTen = ?";
        long soDuHienTai = 0;

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ps.setString(1, hoTen);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                soDuHienTai = rs.getLong("SoTien");
            } else {
                throw new Exception("Tài khoản không tồn tại.");
            }
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }

        if (soDuHienTai >= sotien && soDuHienTai >= 0 && sotien >= 0) {
            soDuHienTai += sotien;

            String sqlUpdate = "UPDATE Taikhoan SET SoTien = ? WHERE HoTen = ?";
            try {
                Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlUpdate);
                ps.setLong(1, soDuHienTai);
                ps.setString(2, hoTen);

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException ex) {
                throw new Exception("Lỗi khi cập nhật số dư trong cơ sở dữ liệu: " + ex.getMessage());
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean Chuyentien(String hoTenNguoiChuyen, long sotienCanChuyen, String soTaiKhoanNguoiNhan) throws Exception {
        String sqlDeduct = "UPDATE Taikhoan SET SoTien = SoTien - ? WHERE HoTen = ?";
        String sqlAdd = "UPDATE Taikhoan SET SoTien = SoTien + ? WHERE SoTaiKhoan = ?";

        try {
            Connection conn = new DBContext().getConnection();

            PreparedStatement psDeduct = conn.prepareStatement(sqlDeduct);
            psDeduct.setLong(1, sotienCanChuyen);
            psDeduct.setString(2, hoTenNguoiChuyen);
            int rowsAffectedDeduct = psDeduct.executeUpdate();

            PreparedStatement psAdd = conn.prepareStatement(sqlAdd);
            psAdd.setLong(1, sotienCanChuyen);
            psAdd.setString(2, soTaiKhoanNguoiNhan);
            int rowsAffectedAdd = psAdd.executeUpdate();

            if (rowsAffectedDeduct > 0 && rowsAffectedAdd > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi cập nhật trong cơ sở dữ liệu: " + ex.getMessage());
        }
    }

    @Override
    public boolean CapNhatTaiKhoan(String matkhau, String hoTen) throws Exception {
        String sqlUpdate = "update Taikhoan set MatKhau = ? where HoTen = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, matkhau);
            ps.setString(2, hoTen);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }
    }

    @Override
    public boolean ThemLichSu(String ngayRutTien, long soTienRutRa, String soTaiKhoan, String ghiChu, String hoTen) throws Exception {
        String sqlUpdate = """
                           Insert into ChiTietTaiKhoan (NgayRutTien, SoTienRutRa, SoTaiKhoan, GhiChu, HoTen)
                           VALUES (?, ?, ?, NULL, ?);""";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, ngayRutTien);
            ps.setLong(2, soTienRutRa);
            ps.setString(3, soTaiKhoan);
            ps.setString(4, hoTen);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new Exception("Lỗi khi truy xuất thông tin tài khoản: " + ex.getMessage());
        }
    }

    @Override
    public List<LichSu> XemLichSu(String hoTen) throws Exception {
        List<LichSu> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietTaiKhoan WHERE hoTen = ? order by Id asc";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoTen);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Date ngayRutTien = rs.getDate("NgayRutTien");
                Long soTienRutRa = rs.getLong("SoTienRutRa");
                String soTaiKhoan = rs.getString("SoTaiKhoan");
                String ghiChu = rs.getString("GhiChu");
                int iD = rs.getInt("Id");
                LichSu lichSu = new LichSu(ngayRutTien, soTienRutRa, soTaiKhoan, ghiChu, hoTen, iD);
                list.add(lichSu);
            }
            return list;
        } catch (NumberFormatException | SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ATMImple atm = new ATMImple();
        //boolean result = atm.ruttien("Tran Van Thanh", 200000);
        //Calendar calendar = Calendar.getInstance();

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String formattedDate = dateFormat.format(calendar.getTime());
        //if (result == true) {
        //System.out.println("Rut thanh cong!");
        //System.out.println("Ngay rut: " + formattedDate);
        //} else {
        //System.out.println("Rut khong thanh cong!");
        //}
        List<LichSu> list = atm.XemLichSu("Truong Bui Nguyen Duc");
        System.out.println(list.toString());
    }
}
