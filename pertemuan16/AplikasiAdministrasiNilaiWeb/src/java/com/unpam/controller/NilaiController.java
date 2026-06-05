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

@WebServlet("/SimpanNilai")
public class NilaiController extends HttpServlet {

    // 1. PROSES HITUNG & SIMPAN NILAI (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nim = request.getParameter("nim");
        String kodeMk = request.getParameter("kodemk");
        double tugas = Double.parseDouble(request.getParameter("tugas"));
        double uts = Double.parseDouble(request.getParameter("uts"));
        double uas = Double.parseDouble(request.getParameter("uas"));
        
        // Rumus Hitung Nilai Akhir (Misal: Tugas 30%, UTS 30%, UAS 40%)
        double nilaiAkhir = (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
        
        // Penentuan Grade
        String grade;
        if (nilaiAkhir >= 80) grade = "A";
        else if (nilaiAkhir >= 70) grade = "B";
        else if (nilaiAkhir >= 60) grade = "C";
        else if (nilaiAkhir >= 50) grade = "D";
        else grade = "E";
        
        boolean isSuccess = false;
        String errorMessage = "";
        
        Connection conn = null;
        try {
            conn = Koneksi.getKoneksi();
            if (conn != null) {
                String sql = "INSERT INTO nilai (nim, kode_mk, nilai_tugas, nilai_uts, nilai_uas, nilai_akhir, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nim);
                ps.setString(2, kodeMk);
                ps.setDouble(3, tugas);
                ps.setDouble(4, uts);
                ps.setDouble(5, uas);
                ps.setDouble(6, nilaiAkhir);
                ps.setString(7, grade);
                
                int rows = ps.executeUpdate();
                if (rows > 0) isSuccess = true;
            } else {
                errorMessage = "Koneksi database terputus.";
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<script type='text/javascript'>");
            if (isSuccess) {
                out.println("alert('Nilai Berhasil Dihitung & Disimpan!\\nNilai Akhir: " + nilaiAkhir + " (Grade: " + grade + ")');");
            } else {
                out.println("alert('Gagal Menyimpan! Error: " + errorMessage + "');");
            }
            out.println("window.location.href = 'index.jsp?page=nilai';");
            out.println("</script>");
        }
    }

    // 2. PROSES AMBIL SEMUA DATA LAPORAN NILAI (JOIN TABLE MAHASISWA & MATAKULIAH)
    public static List<Map<String, String>> getAllNilaiLaporan() {
        List<Map<String, String>> listLaporan = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Koneksi.getKoneksi();
            if (conn != null) {
                stmt = conn.createStatement();
                // Menggunakan JOIN agar nama mahasiswa dan nama mata kuliah ikut tampil di laporan
                String sql = "SELECT n.id, n.nim, m.nama_mahasiswa, n.kode_mk, mk.nama_mk, "
                           + "n.nilai_tugas, n.nilai_uts, n.nilai_uas, n.nilai_akhir, n.grade "
                           + "FROM nilai n "
                           + "LEFT JOIN mahasiswa m ON n.nim = m.nim "
                           + "LEFT JOIN matakuliah mk ON n.kode_mk = mk.kode_mk";
                
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Map<String, String> row = new HashMap<>();
                    row.put("nim", rs.getString("nim"));
                    row.put("nama_mahasiswa", rs.getString("nama_mahasiswa") != null ? rs.getString("nama_mahasiswa") : "-");
                    row.put("kode_mk", rs.getString("kode_mk"));
                    row.put("nama_mk", rs.getString("nama_mk") != null ? rs.getString("nama_mk") : "-");
                    row.put("nilai_tugas", rs.getString("nilai_tugas"));
                    row.put("nilai_uts", rs.getString("nilai_uts"));
                    row.put("nilai_uas", rs.getString("nilai_uas"));
                    row.put("nilai_akhir", rs.getString("nilai_akhir"));
                    row.put("grade", rs.getString("grade"));
                    listLaporan.add(row);
                }
            }
        } catch (Exception e) {
            System.out.println("Error Laporan: " + e.getMessage());
        }
        return listLaporan;
    }
}