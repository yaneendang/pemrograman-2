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

@WebServlet("/SimpanMatakuliah")
public class MatakuliahController extends HttpServlet {

    // 1. PROSES SIMPAN MATA KULIAH
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String kodeMk = request.getParameter("kodemk");
        String namaMk = request.getParameter("namamk");
        String sksStr = request.getParameter("sks");
        
        boolean isSuccess = false;
        String errorMessage = "";
        
        Connection conn = null;
        try {
            conn = Koneksi.getKoneksi();
            if (conn != null) {
                String sql = "INSERT INTO matakuliah (kode_mk, nama_mk, sks) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, kodeMk);
                ps.setString(2, namaMk);
                ps.setInt(3, Integer.parseInt(sksStr)); // Konversi teks SKS ke Integer
                
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    isSuccess = true;
                }
            } else {
                errorMessage = "Koneksi database tidak tersedia.";
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        
        // Output Alert & Redirect Kembali
        try (PrintWriter out = response.getWriter()) {
            out.println("<script type='text/javascript'>");
            if (isSuccess) {
                out.println("alert('Mata Kuliah \"" + namaMk + "\" Berhasil Disimpan!');");
            } else {
                out.println("alert('Gagal Menyimpan! Error: " + errorMessage + "');");
            }
            out.println("window.location.href = 'index.jsp?page=matakuliah';");
            out.println("</script>");
        }
    }

    // 2. PROSES AMBIL DAFTAR MATA KULIAH
    public static List<Map<String, String>> getAllMatakuliah() {
        List<Map<String, String>> listMK = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Koneksi.getKoneksi();
            if (conn != null) {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM matakuliah";
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    Map<String, String> mk = new HashMap<>();
                    mk.put("kode_mk", rs.getString("kode_mk"));
                    mk.put("nama_mk", rs.getString("nama_mk"));
                    mk.put("sks", rs.getString("sks"));
                    listMK.add(mk);
                }
            }
        } catch (Exception e) {
            System.out.println("Error ambil data matakuliah: " + e.getMessage());
        }
        return listMK;
    }
}