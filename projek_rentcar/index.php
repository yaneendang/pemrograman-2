<?php
// 1. Mulai session dan proteksi halaman
session_start();
if(!isset($_SESSION['username'])){
    header("location:login.php");
    exit;
}
include 'koneksi.php';
?>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Admin - LOVITARENTCAR</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        .sidebar { height: 100vh; background: #343a40; color: white; padding-top: 20px; }
        .sidebar a { color: white; display: block; padding: 15px; text-decoration: none; }
        .sidebar a:hover { background: #495057; }
    </style>
</head>
<body>
    <div class="row g-0">
        <div class="col-md-2 sidebar">
            <h4 class="text-center" style="font-weight: bold; letter-spacing: 1px;">LOVITARENTCAR</h4>
            <hr>
            <a href="index.php?menu=dashboard">Dashboard</a>
            <a href="index.php?menu=mobil">Data Mobil</a>
            <a href="index.php?menu=customer">Data Customer</a>
            <a href="index.php?menu=transaksi">Data Transaksi</a>
            <a href="index.php?menu=laporan">Laporan</a>
            
        </div>

        <div class="col-md-10">
            <div class="bg-light p-3 border-bottom d-flex justify-content-end align-items-center">
                <a href="index.php?menu=profil" class="btn btn-sm btn-outline-dark me-2">
                    <i class="bi bi-person-circle"></i> Profil
                </a>
                <a href="logout.php" class="btn btn-sm btn-danger">
                    <i class="bi bi-box-arrow-right"></i> Logout
                </a>
            </div>

            <div class="p-4">
                <?php
                // Logika Navigasi
                $menu = isset($_GET['menu']) ? $_GET['menu'] : 'dashboard';

                if ($menu == 'dashboard') include 'dashboard.php';
                elseif ($menu == 'mobil') include 'data_mobil.php';
                elseif ($menu == 'customer') include 'data_customer.php';
                elseif ($menu == 'laporan') include 'laporan.php';
                elseif ($menu == 'profil') include 'profil.php';
                elseif ($menu == 'edit_profil') include 'edit_profil.php';
                elseif ($menu == 'edit_mobil') include 'edit_mobil.php';
                // Tambahkan di dalam blok if-else Anda
                elseif ($menu == 'transaksi') include 'data_transaksi.php';
                elseif ($menu == 'tambah_transaksi') include 'tambah_transaksi.php';
                else echo "<h3>Halaman tidak ditemukan.</h3>";
                ?>
            </div>
        </div>
    </div>
</body>
</html>