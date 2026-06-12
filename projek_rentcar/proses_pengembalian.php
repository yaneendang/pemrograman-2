<?php
require_once 'koneksi.php';
if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $tgl_kembali = date('Y-m-d');
    $sql = "UPDATE transaksi SET tgl_kembali='$tgl_kembali', status='kembali' WHERE id_transaksi='$id'";
    
    if (mysqli_query($koneksi, $sql)) {
        echo "<script>alert('Mobil Kembali!'); window.location='index.php?menu=transaksi';</script>";
    }
}
?>