<?php
// 1. Panggil koneksi (Gunakan require_once agar aman)
require_once 'koneksi.php';

// 2. Pastikan $koneksi terdefinisi
if (!isset($koneksi)) {
    die("Error: Koneksi ke database tidak ditemukan. Periksa file koneksi.php Anda.");
}

// 3. Cek apakah tombol submit sudah ditekan
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    // 4. Tangkap dan bersihkan data
    $customer = mysqli_real_escape_string($koneksi, $_POST['customer']);
    $mobil    = mysqli_real_escape_string($koneksi, $_POST['mobil']);
    $total    = (int)$_POST['total']; 
    $tanggal  = date('Y-m-d');

    // 5. Query INSERT - Disesuaikan dengan kolom yang ada di database Anda
$query = "INSERT INTO transaksi (id_customer, id_mobil, tgl_pinjam, total_biaya, status) 
          VALUES ('$customer', '$mobil', '$tanggal', '$total', 'pinjam')";

    // 6. Eksekusi dan cek hasil menggunakan $koneksi
    if (mysqli_query($koneksi, $query)) {
        echo "<script>alert('Transaksi berhasil disimpan!'); window.location='index.php?menu=transaksi';</script>";
        exit;
    } else {
        echo "Gagal menyimpan data: " . mysqli_error($koneksi);
        echo "<br><a href='index.php?menu=transaksi'>Kembali</a>";
    }
} else {
    header("location:index.php?menu=transaksi");
    exit;
}
?>