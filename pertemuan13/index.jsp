<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href='style.css' rel='stylesheet' type='text/css' />
    <title>Informasi Nilai Mahasiswa</title>
    <style>
        /* Desain tambahan agar Form Input terlihat rapi dan selaras di tengah */
        .form-input { width: 100%; max-width: 450px; border-collapse: collapse; margin-top: 20px; }
        .form-input td { padding: 8px; text-align: left; font-family: Arial, sans-serif; }
        .form-input input[type="text"], .form-input select { width: 100%; padding: 6px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-simpan { padding: 7px 20px; background-color: #577927; color: white; border: none; cursor: pointer; border-radius: 4px; font-weight: bold; }
        .btn-simpan:hover { background-color: #697269; }
    </style>
</head>
<body bgcolor="#808080">
<%
    // 1. LINK MENU SAMPING (SIDEBAR) - Diarahkan ke page internal & login.jsp
    String menu = "<br><b>Master Data</b><br>"
                + "<a href='index.jsp?page=mahasiswa'>Mahasiswa</a><br>"
                + "<a href='index.jsp?page=matakuliah'>Mata Kuliah</a><br><br>"
                + "<b>Transaksi</b><br>"
                + "<a href='index.jsp?page=nilai'>Nilai</a><br><br>"
                + "<b>Laporan</b><br>"
                + "<a href='index.jsp?page=laporan'>Nilai</a><br><br>"
                + "<a href='login.jsp'>Login</a><br><br>";

    // 2. LINK MENU ATAS (NAVIGATION BAR) - Diarahkan ke page internal & login.jsp
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

    // 3. LOGIKA PEMILIHAN KONTEN BERDASARKAN LINK YANG DIKLIK
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
        } else if (p.equals("laporan")) {
            konten = "<br><h3>Laporan Transaksi Nilai</h3><p>Data Nilai Mahasiswa akan ditampilkan di sini pada materi integrasi database berikutnya.</p>";
        }
    }

    // Memeriksa Session User Login (Sesuai Modul Asli)
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