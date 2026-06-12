<?php
// 1. Mulai session
session_start();

// 2. Hapus semua data session
session_destroy();

// 3. Arahkan kembali ke halaman login
header("location:login.php");
exit;
?>