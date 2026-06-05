<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.unpam.controller.MahasiswaController" %>
<%@ page import="com.unpam.controller.MatakuliahController" %>
<%@ page import="com.unpam.controller.NilaiController" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href='style.css' rel='stylesheet' type='text/css' />
    <title>Informasi Nilai Mahasiswa</title>
    <style>
        .form-input { width: 100%; max-width: 450px; border-collapse: collapse; margin-top: 20px; }
        .form-input td { padding: 8px; text-align: left; font-family: Arial, sans-serif; }
        .form-input input[type="text"], .form-input select { width: 100%; padding: 6px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-simpan { padding: 7px 20px; background-color: #577927; color: white; border: none; cursor: pointer; border-radius: 4px; font-weight: bold; }
        .btn-simpan:hover { background-color: #697269; }
        
        .tabel-data { width: 95%; border-collapse: collapse; margin-top: 30px; font-family: Arial, sans-serif; font-size: 13px; }
        .tabel-data th { background-color: #577927; color: white; padding: 10px; text-align: left; border: 1px solid #ddd; }
        .tabel-data td { padding: 8px; border: 1px solid #ddd; text-align: left; }
        .tabel-data tr:nth-child(even) { background-color: #f9f9f9; }
        
        /* Style Tambahan untuk Tombol Cetak Laporan PDF */
        .btn-cetak { 
            padding: 10px 20px; 
            background-color: #d32f2f; 
            color: white; 
            text-decoration: none; 
            border-radius: 4px; 
            font-weight: bold; 
            display: inline-block; 
            box-shadow: 1px 1px 4px rgba(0,0,0,0.2); 
            margin-bottom: 15px;
        }
        .btn-cetak:hover { background-color: #b71c1c; color: white; }
    </style>
</head>
<body bgcolor="#808080">
<%
    String menu = "<br><b>Master Data</b><br>"
                + "<a href='index.jsp?page=mahasiswa'>Mahasiswa</a><br>"
                + "<a href='index.jsp?page=matakuliah'>Mata Kuliah</a><br><br>"
                + "<b>Transaksi</b><br>"
                + "<a href='index.jsp?page=nilai'>Nilai</a><br><br>"
                + "<b>Laporan</b><br>"
                + "<a href='index.jsp?page=laporan'>Nilai</a><br><br>"
                + "<a href='login.jsp'>Login</a><br><br>";

    String topMenu = "<nav><ul>"
                + "<li><a href='index.jsp'>Home</a></li>"
                + "<li><a href=#>Master Data</a>"
                + "<ul>"
                + "<li><a href='index.jsp?page=mahasiswa'>Mahasiswa</a></li>"
                + "<li><a href='index.jsp?page=matakuliah'>Mata Kuliah</a></li>"
                + "</ul>"
                + "</li>"
                + "<li><a href=#>Transaksi</a>"
                + "<ul>"
                + "<li><a href='index.jsp?page=nilai'>Nilai</a></li>"
                + "</ul>"
                + "</li>"
                + "<li><a href=#>Laporan</a>"
                + "<ul>"
                + "<li><a href='index.jsp?page=laporan'>Nilai</a></li>"
                + "</ul>"
                + "</li>"
                + "<li><a href='login.jsp'>Login</a></li>"
                + "</ul>"
                + "</nav>";

    String konten = "<br><h1>Selamat Datang</h1>";
    String p = request.getParameter("page");
    
    if (p != null) {
        if (p.equals("mahasiswa")) {
            konten = "<br><h3>Form Input Master Data Mahasiswa</h3>"
                   + "<form action='SimpanMahasiswa' method='POST'>"
                   + "<table class='form-input'>"
                   + "<tr><td width='120'>NIM</td><td width='10'>:</td><td><input type='text' name='nim' required></td></tr>"
                   + "<tr><td>Nama Mahasiswa</td><td>:</td><td><input type='text' name='nama' required></td></tr>"
                   + "<tr><td>Jurusan</td><td>:</td><td>"
                   + "  <select name='jurusan'>"
                   + "      <option value='Teknik Informatika'>Teknik Informatika</option>"
                   + "      <option value='Sistem Informasi'>Sistem Informasi</option>"
                   + "  </select>"
                   + "</td></tr>"
                   + "<tr><td></td><td></td><td><br><input type='submit' class='btn-simpan' value='Simpan Data'></td></tr>"
                   + "</table>"
                   + "</form>";
            
            konten += "<br><hr style='border: 0; border-top: 1px dashed #ccc; width: 95%;'><br>"
                    + "<h3>Daftar Mahasiswa Terdaftar</h3>"
                    + "<table class='tabel-data'>"
                    + "<thead><tr><th style='text-align:center; width:40px;'>No</th><th>NIM</th><th>Nama Mahasiswa</th><th>Jurusan</th></tr></thead>"
                    + "<tbody>";
            
            List<Map<String, String>> dataMhs = MahasiswaController.getAllMahasiswa();
            if (dataMhs == null || dataMhs.isEmpty()) {
                konten += "<tr><td colspan='4' style='text-align:center; color:gray; font-style:italic;'>Belum ada data mahasiswa.</td></tr>";
            } else {
                int no = 1;
                for (Map<String, String> mhs : dataMhs) {
                    konten += "<tr><td style='text-align:center;'>" + (no++) + "</td><td>" + mhs.get("nim") + "</td><td>" + mhs.get("nama_mahasiswa") + "</td><td>" + mhs.get("jurusan") + "</td></tr>";
                }
            }
            konten += "</tbody></table><br>";

        } else if (p.equals("matakuliah")) {
            konten = "<br><h3>Form Input Master Mata Kuliah</h3>"
                   + "<form action='SimpanMatakuliah' method='POST'>"
                   + "<table class='form-input'>"
                   + "<tr><td width='120'>Kode MK</td><td width='10'>:</td><td><input type='text' name='kodemk' required></td></tr>"
                   + "<tr><td>Nama Mata Kuliah</td><td>:</td><td><input type='text' name='namamk' required></td></tr>"
                   + "<tr><td>SKS</td><td>:</td><td><input type='text' name='sks' style='width:60px;' required></td></tr>"
                   + "<tr><td></td><td></td><td><br><input type='submit' class='btn-simpan' value='Simpan MK'></td></tr>"
                   + "</table>"
                   + "</form>";
            
            konten += "<br><hr style='border: 0; border-top: 1px dashed #ccc; width: 95%;'><br>"
                    + "<h3>Daftar Mata Kuliah Terdaftar</h3>"
                    + "<table class='tabel-data'>"
                    + "<thead><tr><th style='text-align:center; width:40px;'>No</th><th>Kode MK</th><th>Nama Mata Kuliah</th><th style='text-align:center; width:80px;'>SKS</th></tr></thead>"
                    + "<tbody>";
            
            List<Map<String, String>> dataMK = MatakuliahController.getAllMatakuliah();
            if (dataMK == null || dataMK.isEmpty()) {
                konten += "<tr><td colspan='4' style='text-align:center; color:gray; font-style:italic;'>Belum ada data mata kuliah.</td></tr>";
            } else {
                int no = 1;
                for (Map<String, String> mk : dataMK) {
                    konten += "<tr><td style='text-align:center;'>" + (no++) + "</td><td>" + mk.get("kode_mk") + "</td><td>" + mk.get("nama_mk") + "</td><td style='text-align:center;'>" + mk.get("sks") + "</td></tr>";
                }
            }
            konten += "</tbody></table><br>";

        } else if (p.equals("nilai")) {
            konten = "<br><h3>Form Input Transaksi Nilai</h3>"
                   + "<form action='SimpanNilai' method='POST'>"
                   + "<table class='form-input'>"
                   + "<tr><td width='120'>NIM</td><td width='10'>:</td><td><input type='text' name='nim' required></td></tr>"
                   + "<tr><td>Kode MK</td><td>:</td><td><input type='text' name='kodemk' required></td></tr>"
                   + "<tr><td>Nilai Tugas</td><td>:</td><td><input type='text' name='tugas' required></td></tr>"
                   + "<tr><td>Nilai UTS</td><td>:</td><td><input type='text' name='uts' required></td></tr>"
                   + "<tr><td>Nilai UAS</td><td>:</td><td><input type='text' name='uas' required></td></tr>"
                   + "<tr><td></td><td></td><td><br><input type='submit' class='btn-simpan' value='Hitung & Simpan'></td></tr>"
                   + "</table>"
                   + "</form>";
            
            konten += "<br><hr style='border: 0; border-top: 1px dashed #ccc; width: 95%;'><br>"
                    + "<h3>Log Nilai Terinput Terbaru</h3>"
                    + "<table class='tabel-data'>"
                    + "<thead><tr><th style='text-align:center; width:40px;'>No</th><th>NIM</th><th>Kode MK</th><th>Nilai Akhir</th><th style='text-align:center;'>Grade</th></tr></thead>"
                    + "<tbody>";
            
            List<Map<String, String>> dataLog = NilaiController.getAllNilaiLaporan();
            if (dataLog == null || dataLog.isEmpty()) {
                konten += "<tr><td colspan='5' style='text-align:center; color:gray; font-style:italic;'>Belum ada entri transaksi nilai.</td></tr>";
            } else {
                int no = 1;
                for (Map<String, String> row : dataLog) {
                    konten += "<tr><td style='text-align:center;'>" + (no++) + "</td><td>" + row.get("nim") + "</td><td>" + row.get("kode_mk") + "</td><td>" + row.get("nilai_akhir") + "</td><td style='text-align:center; font-weight:bold;'>" + row.get("grade") + "</td></tr>";
                }
            }
            konten += "</tbody></table><br>";

        } else if (p.equals("laporan")) {
            // Halaman Utama Laporan Transaksi Nilai Lengkap + Tombol Akses Cetak PDF
            konten = "<br><h3>Laporan Transaksi Nilai Lengkap</h3>"
                   + "<div style='text-align:left; width:95%;'>"
                   + "  <a href='LaporanNilaiController' target='_blank' class='btn-cetak'>🖨️ PDF - Cetak Laporan Nilai</a>"
                   + "</div>"
                   + "<table class='tabel-data' style='width:98%; margin-top:10px;'>"
                   + "<thead>"
                   + "<tr>"
                   + "<th style='text-align:center;'>No</th>"
                   + "<th>NIM</th>"
                   + "<th>Nama Mahasiswa</th>"
                   + "<th>Kode MK</th>"
                   + "<th>Nama Mata Kuliah</th>"
                   + "<th style='text-align:center;'>Tugas</th>"
                   + "<th style='text-align:center;'>UTS</th>"
                   + "<th style='text-align:center;'>UAS</th>"
                   + "<th style='text-align:center;'>Nilai Akhir</th>"
                   + "<th style='text-align:center;'>Grade</th>"
                   + "</tr>"
                   + "</thead>"
                   + "<tbody>";
            
            List<Map<String, String>> laporanNilai = NilaiController.getAllNilaiLaporan();
            if (laporanNilai == null || laporanNilai.isEmpty()) {
                konten += "<tr><td colspan='10' style='text-align:center; color:gray; font-style:italic;'>Tidak ada data laporan nilai.</td></tr>";
            } else {
                int no = 1;
                for (Map<String, String> row : laporanNilai) {
                    konten += "<tr>"
                            + "<td style='text-align:center;'>" + (no++) + "</td>"
                            + "<td>" + row.get("nim") + "</td>"
                            + "<td>" + row.get("nama_mahasiswa") + "</td>"
                            + "<td>" + row.get("kode_mk") + "</td>"
                            + "<td>" + row.get("nama_mk") + "</td>"
                            + "<td style='text-align:center;'>" + row.get("nilai_tugas") + "</td>"
                            + "<td style='text-align:center;'>" + row.get("nilai_uts") + "</td>"
                            + "<td style='text-align:center;'>" + row.get("nilai_uas") + "</td>"
                            + "<td style='text-align:center; font-weight:bold; color:#577927;'>" + row.get("nilai_akhir") + "</td>"
                            + "<td style='text-align:center; font-weight:bold;'>" + row.get("grade") + "</td>"
                            + "</tr>";
                }
            }
            konten += "</tbody></table><br>";
        }
    }

    String userName = "";
    if (!session.isNew()) {
        try {
            userName = session.getAttribute("userName").toString();
        } catch (Exception ex) {}

        if (!((userName == null) || userName.equals(""))) {
            konten += "<h2>" + userName + "</h2>";
            try { menu = session.getAttribute("menu").toString(); } catch (Exception ex) {}
            try { topMenu = session.getAttribute("topMenu").toString(); } catch (Exception ex) {}
        }
    }
%>

<center>
    <table width="80%" bgcolor="#eeeeee">
        <tr>
            <td colspan="2" align="center">
                <br>
                <h2 style="margin-bottom:0px; margin-top:0px;">Informasi Nilai Mahasiswa</h2>
                <h1 style="margin-bottom:0px; margin-top:0px;">UNIVERSITAS PAMULANG</h1>
                <h4 style="margin-bottom:0px; margin-top:0px;">Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten</h4>
                <br>
            </td>
        </tr>
        
        <tr height="400">
            <td width="200" align="center" valign="top" bgcolor="#eeffee">
                <br>
                <div id='menu'>
                    <%=menu %>
                </div>
            </td>
            
            <td align="center" valign="top" bgcolor="#ffffff">
                <%=topMenu %>
                <br>
                <%=konten %>
            </td>
        </tr>
        
        <tr>
            <td colspan="2" align="center" bgcolor="#eeeeff">
                <small>
                    Copyright &copy; 2016 Universitas Pamulang<br>
                    Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten<br>
                </small>
            </td>
        </tr>
    </table>
</center>
</body>
</html>