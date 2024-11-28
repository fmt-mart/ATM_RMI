/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_Client;

import ATM_Server.ATM_Interface;
import ATM_Server.TaiKhoan;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Client {

    public static void main(String[] args) {
        try {
            //Lay thanh ghi dau tren Ip va port cua may chu
            Registry registry = LocateRegistry.getRegistry("192.168.88.77", 1099);

            // Lay ra object
            ATM_Interface atm = (ATM_Interface) registry.lookup("ATM");
            //ATM_Interface atm = (ATM_Interface) Naming.lookup("rmi://localhost:1099/ATMService");

            //Thuc thi
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Kiem tra dang nhap");
                System.out.println("2. So du");
                System.out.println("3. Rut tien");

                System.out.println("Chon phuong thuc: ");
                int phuong_thuc = scanner.nextInt();

                String c = scanner.nextLine();
                System.out.println("Nhap so tai khoan: ");
                String a = scanner.nextLine();
                System.out.println("Nhap mat khau: ");
                String b = scanner.nextLine();

                TaiKhoan tk = null;
                switch (phuong_thuc) {
                    case 1 ->
                        tk = atm.ktdangnhap(a, b);
                    //case 2 -> tk = atm.(a, b);
                    //case 3 -> tk = atm.multiply(a, b);
                    default ->
                        throw new AbstractMethodError();
                }
                if (tk != null) {
                    System.out.println("Result: " + tk.getHoTen() + " " + tk.getSoTien());
                } else {
                    System.out.println("Dang nhap khong thanh cong. Vui long kiem tra lai thong tin tai khoan va mat khau.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
