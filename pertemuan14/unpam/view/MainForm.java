package com.unpam.view;

public class MainForm {
    
    // Template Header dengan Ikon Toga Wisuda
    public String getHeader() {
        return "<div class='header-container'>"
             + "    <div class='header-logo'>"
             + "        <i class='fa-solid fa-graduation-cap'></i>"
             + "    </div>"
             + "    <div class='header-text'>"
             + "        <h2>Informasi Nilai Mahasiswa</h2>"
             + "        <h1>UNIVERSITAS PAMULANG</h1>"
             + "        <p>Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten</p>"
             + "    </div>"
             + "</div>";
    }
    
    // Template Navbar Navigasi Atas dengan Dropdown & Ikon Modern
    public String getNavbar() {
        return "<nav>"
             + "    <ul>"
             + "        <li><a href='index.jsp'><i class='fa-solid fa-house'></i> Home</a></li>"
             + "        <li>"
             + "            <a href='#'><i class='fa-solid fa-folder'></i> Master Data</a>"
             + "            <ul>"
             + "                <li><a href='dataMahasiswa.jsp'>Mahasiswa</a></li>"
             + "                <li><a href='#'>Mata Kuliah</a></li>"
             + "            </ul>"
             + "        </li>"
             + "        <li>"
             + "            <a href='#'><i class='fa-solid fa-chart-pie'></i> Transaksi</a>"
             + "            <ul>"
             + "                <li><a href='#'>Nilai</a></li>"
             + "            </ul>"
             + "        </li>"
             + "        <li>"
             + "            <a href='#'><i class='fa-solid fa-print'></i> Laporan</a>"
             + "            <ul>"
             + "                <li><a href='#'>Nilai</a></li>"
             + "            </ul>"
             + "        </li>"
             + "        <li><a href='login.jsp'><i class='fa-solid fa-lock'></i> Login</a></li>"
             + "        <li><a href='LogoutController'><i class='fa-solid fa-right-from-bracket'></i> Logout</a></li>"
             + "    </ul>"
             + "</nav>";
    }
    
    // Template Footer Aplikasi
    public String getFooter() {
        return "© 2026 Universitas Pamulang. All rights reserved.";
    }
}