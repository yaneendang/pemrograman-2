<?php
session_start();
include 'koneksi.php';

$username = $_POST['username'];
$password = $_POST['password'];

// Cek di tabel user
$query = mysqli_query($conn, "SELECT * FROM user WHERE username='$username' AND password='$password'");
$cek = mysqli_num_rows($query);

if($cek > 0) {
    $_SESSION['username'] = $username;
    // Arahkan ke dashboard utama (index.php) bukan lagi ke input_mobil.php
    header("location:index.php"); 
} else {
    echo "<script>alert('Login Gagal!'); window.location='login.php';</script>";
}
?>