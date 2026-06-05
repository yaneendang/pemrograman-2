package com.unpam.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        try {
            // Mengecek jika koneksi belum dibuat, atau sebelumnya sempat terputus/tertutup
            if (koneksi == null || koneksi.isClosed()) {
                
                // Driver modern khusus untuk Driver Connector/J versi 9.x yang baru Anda pasang
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // URL Koneksi ke phpMyAdmin Anda
                // Pastikan nama database di phpMyAdmin Anda adalah: db_universitas_pamulang
               String url = "jdbc:mysql://localhost:3306/db_universitas_pamulang";
String user = "root";
String pass = ""; // kosongkan jika XAMPP bawaan standar
                
                // Proses pembuatan koneksi fisik
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi ke Database UNPAM Berhasil Aktif!");
            }
        } catch (Exception e) {
            // Menampilkan log error ke konsol NetBeans jika sewaktu-waktu MySQL XAMPP mati
            System.out.println("Koneksi Gagal Terbentuk: " + e.getMessage());
            koneksi = null; 
        }
        return koneksi;
    }
}