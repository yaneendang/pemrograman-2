<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.unpam.controller.MahasiswaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="form" class="com.unpam.view.MainForm" scope="page" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form Input Mahasiswa - Universitas Pamulang</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<center>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td class="header-kampus">
                <%= form.getHeader() %>
            </td>
        </tr>
        <tr class="navbar-row">
            <td>
                <%= form.getNavbar() %>
            </td>
        </tr>
        <tr>
            <td class="main-content-zone">
                
                <div class="form-card" style="background:#ffffff; border:1px solid #e2e8f0; padding:40px; max-width:600px; margin:20px auto; border-radius:12px; box-shadow:0 4px 20px rgba(0,0,0,0.02); text-align:left;">
                    <h3 style="text-align:center; color:#0056b3; font-size:1.5rem; margin-top:0; margin-bottom:25px;">Form Input Master Data Mahasiswa</h3>
                    
                    <form action="SimpanMahasiswa" method="POST">
                        <div style="margin-bottom: 15px;">
                            <label style="display:block; font-weight:500; margin-bottom:5px;">NIM :</label>
                            <input type="text" name="nim" required style="width:100%; padding:10px; border:1px solid #cbd5e1; border-radius:6px; box-sizing:border-box;">
                        </div>
                        <div style="margin-bottom: 15px;">
                            <label style="display:block; font-weight:500; margin-bottom:5px;">Nama Mahasiswa :</label>
                            <input type="text" name="nama" required style="width:100%; padding:10px; border:1px solid #cbd5e1; border-radius:6px; box-sizing:border-box;">
                        </div>
                        <div style="margin-bottom: 25px;">
                            <label style="display:block; font-weight:500; margin-bottom:5px;">Jurusan :</label>
                            <select name="jurusan" style="width:100%; padding:10px; border:1px solid #cbd5e1; border-radius:6px; background:white;">
                                <option value="Teknik Informatika">Teknik Informatika</option>
                                <option value="Sistem Informasi">Sistem Informasi</option>
                                <option value="Teknik Elektro">Teknik Elektro</option>
                            </select>
                        </div>
                        <button type="submit" style="width:100%; padding:12px; background:#0056b3; color:white; border:none; border-radius:6px; font-weight:600; cursor:pointer; font-size:1rem;">Simpan Data</button>
                    </form>
                </div>

                <div class="table-card" style="background:#ffffff; border:1px solid #e2e8f0; padding:30px; max-width:800px; margin:30px auto; border-radius:12px; box-shadow:0 4px 20px rgba(0,0,0,0.02); text-align:left; font-family:sans-serif;">
                    <h3 style="color:#333; margin-top:0; margin-bottom:15px; font-size:1.25rem; border-left:4px solid #0056b3; padding-left:10px;">Daftar Mahasiswa Terdaftar</h3>
                    
                    <table border="1" cellpadding="10" cellspacing="0" style="width: 100%; border-collapse: collapse; border: 1px solid #e2e8f0;">
                        <thead>
                            <tr style="background-color: #0056b3; color: white; text-align: left;">
                                <th style="text-align: center; width: 8%;">No</th>
                                <th style="width: 27%;">NIM</th>
                                <th style="width: 40%;">Nama Mahasiswa</th>
                                <th style="width: 25%;">Jurusan</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                // Memanggil fungsi dari Controller
                                List<Map<String, String>> dataMhs = MahasiswaController.getAllMahasiswa();
                                
                                if (dataMhs == null || dataMhs.isEmpty()) {
                            %>
                            <tr>
                                <td colspan="4" style="text-align: center; color: #888; font-style: italic; padding: 20px;">
                                    Belum ada data mahasiswa di database.
                                </td>
                            </tr>
                            <%
                                } else {
                                    int no = 1;
                                    for (Map<String, String> mhs : dataMhs) {
                            %>
                            <tr style="background-color: <%= (no % 2 == 0) ? "#f8fafc" : "#ffffff" %>;">
                                <td style="text-align: center; font-weight: bold;"><%= no++ %></td>
                                <td><%= mhs.get("nim") %></td>
                                <td><%= mhs.get("nama_mahasiswa") %></td>
                                <td><%= mhs.get("jurusan") %></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>

            </td>
        </tr>
        <tr>
            <td class="footer-row">
                <%= form.getFooter() %>
            </td>
        </tr>
    </table>
</center>

</body>
</html>