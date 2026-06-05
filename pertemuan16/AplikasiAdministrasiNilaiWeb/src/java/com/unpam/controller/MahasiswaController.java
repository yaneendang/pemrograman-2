package com.unpam.controller;

import com.unpam.model.Koneksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SimpanMahasiswa") 
public class MahasiswaController extends HttpServlet {

    // 1. PROSES SIMPAN DATA (C - Create)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Ambil data dari form input (.jsp)
        // PERHATIKAN: pastikan "nim", "nama", "jurusan" sesuai dengan atribut name di tag <input> Anda
        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        String jurusan = request.getParameter("jurusan");
        
        boolean isSuccess = false;
        String errorMessage = "";
        
        try {
            // Hubungkan ke database
            Connection conn = Koneksi.getKoneksi();
            
            // Query SQL untuk menyimpan data ke tabel mahasiswa
            String sql = "INSERT INTO mahasiswa (nim, nama_mahasiswa, jurusan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, jurusan);
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        
        // Response setelah klik tombol simpan
        try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            if (isSuccess) {
                out.println("alert('Data Mahasiswa " + nama + " Berhasil Disimpan ke Database!');");
            } else {
                out.println("alert('Gagal Menyimpan Data! Error: " + errorMessage + "');");
            }
            // Mengembalikan user ke halaman form utama setelah klik OK pada alert
            out.println("window.location.href = 'index.jsp?page=mahasiswa';");
            out.println("</script>");
        }
    }

    // 2. PROSES TAMPIL DATA (R - Read)
    // Fungsi statis agar bisa langsung dipanggil di halaman JSP tanpa bikin objek baru
    public static List<Map<String, String>> getAllMahasiswa() {
        List<Map<String, String>> listMahasiswa = new ArrayList<>();
        try {
            Connection conn = Koneksi.getKoneksi();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM mahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Map<String, String> mhs = new HashMap<>();
                mhs.put("nim", rs.getString("nim"));
                mhs.put("nama_mahasiswa", rs.getString("nama_mahasiswa"));
                mhs.put("jurusan", rs.getString("jurusan"));
                listMahasiswa.add(mhs);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil data mahasiswa: " + e.getMessage());
        }
        return listMahasiswa;
    }
}