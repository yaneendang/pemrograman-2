<?php
session_start();
include 'koneksi.php';

$nama_baru = $_POST['nama'];
// Tambahkan query UPDATE ke database di sini jika perlu
// Contoh: mysqli_query($conn, "UPDATE admin SET username='$nama_baru' WHERE ...");

$_SESSION['username'] = $nama_baru; // Update session agar nama langsung berubah
header("location:index.php?menu=profil");
?>