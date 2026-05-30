package com.unpam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SimpanNilai")
public class MahasiswaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Mengambil data inputan form
        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        String jurusan = request.getParameter("jurusan");
        
        try (PrintWriter out = response.getWriter()) {
            if (nim == null || nim.trim().isEmpty() || nama == null || nama.trim().isEmpty()) {
                out.println("<script>alert('NIM dan Nama tidak boleh kosong!');window.history.back();</script>");
                return;
            }
            
            // (Opsional) Tempat menulis fungsi koneksi database / JDBC MySQL untuk simpan data
            
            // Pop-up sukses dan redirect ke halaman utama
            out.println("<script>");
            out.println("alert('Data Mahasiswa " + nama + " (" + nim + ") Berhasil Disimpan!');");
            out.println("window.location.href = 'index.jsp';");
            out.println("</script>");
        }
    }
}