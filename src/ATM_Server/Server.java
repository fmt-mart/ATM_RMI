/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_Server;

import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Lenovo
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {
        /**
         * try { //Tao ra thanh ghi o server Registry registry =
         * LocateRegistry.createRegistry(1099);
         *
         * //Tao calculator ATM_Interface ATMSkeleton = new ATMImple();
         *
         * //Dang ki object cho thanh ghi registry.rebind("ATM", ATMSkeleton);
         * while (true) { System.out.println("Server is runing.............");
         * Thread.sleep(1000); } } catch (Exception e) { }
         */

        try {
            LocateRegistry.createRegistry(1099); // Tạo registry trên cổng
            ATM_Interface atm = new ATMImple(); // Đối tượng RMI
            Naming.rebind("rmi://localhost:1099/ATM", atm); // Đăng ký đối tượng 
            while (true) {
                System.out.println("ATM Server is running...");
                Thread.sleep(1000);
            }
        } catch (MalformedURLException | RemoteException e) {
        }
    }
}
