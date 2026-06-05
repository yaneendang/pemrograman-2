package com.unpam.controller;

import com.unpam.model.Koneksi;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@WebServlet(name = "LaporanNilaiController", urlPatterns = {"/LaporanNilaiController"})
public class LaporanNilaiController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection conn = null;
        
        try {
            // 1. Ambil koneksi database
            conn = Koneksi.getKoneksi();
            
            // Validasi jika koneksi database putus/gagal
            if (conn == null || conn.isClosed()) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<h2 style='color:red;'>Error: Koneksi ke database gagal (NULL). Pastikan MySQL di XAMPP sudah aktif!</h2>");
                return;
            }
            
            // 2. Cari lokasi file template laporan (.jrxml)
            String jrxmlPath = getServletContext().getRealPath("/reports/NilaiReport.jrxml");
            File reportFile = new File(jrxmlPath);
            
            // Validasi jika file laporan tidak ada di folder Web Pages/reports/
            if (!reportFile.exists()) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<h2 style='color:red;'>Error: File NilaiReport.jrxml tidak ditemukan di folder Web Pages/reports/</h2>");
                return;
            }
            
            // 3. Proses compile dan pengisian data laporan ke dalam memori (Byte Array)
            JasperDesign jasperDesign = JRXmlLoader.load(reportFile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            
            // Export laporan ke bentuk bytes
            byte[] pdfBytes = net.sf.jasperreports.engine.JasperExportManager.exportReportToPdf(jasperPrint);
            
            // 4. Kirim data PDF ke browser jika berhasil dibuat
            if (pdfBytes != null && pdfBytes.length > 0) {
                response.setContentType("application/pdf");
                response.setContentLength(pdfBytes.length);
                response.setHeader("Content-Disposition", "inline; filename=LaporanNilai.pdf");
                
                OutputStream outStream = response.getOutputStream();
                outStream.write(pdfBytes);
                outStream.flush();
                outStream.close();
            } else {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<h2 style='color:orange;'>Error: Gagal membuat data PDF (Hasil render kosong / 0 bytes).</h2>");
            }
            
        } catch (Exception e) {
            // JIKA TERJADI ERROR, PAKSA TOMCAT MENAMPILKAN TEKS ERROR ASLINYA KE LAYAR BROWSER
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<div style='padding:20px; border:2px solid red; background-color:#fff5f5;'>");
            response.getWriter().write("<h2 style='color:red; margin-top:0;'>Terjadi Kesalahan Sistem Laporan!</h2>");
            response.getWriter().write("<p><b>Pesan Error:</b> <span style='font-family:monospace; color:darkred;'>" + e.toString() + "</span></p>");
            response.getWriter().write("<p>Silakan screenshot tampilan ini dan berikan ke AI untuk dianalisis.</p>");
            response.getWriter().write("</div>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}