<?php
// 1. Panggil koneksi dengan benar
include 'koneksi.php';

// 2. Pastikan Anda menggunakan variabel $koneksi (bukan $conn)
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    // 3. Tangkap data dari form
    $nama  = $_POST['nama'];
    $nik   = $_POST['nik'];
    $no_hp = $_POST['no_hp'];

    // 4. Gunakan $koneksi untuk query
    $sql = "INSERT INTO customer (nama, nik, no_hp) VALUES ('$nama', '$nik', '$no_hp')";

    // 5. Cek eksekusi dengan variabel $koneksi
    if (mysqli_query($koneksi, $sql)) {
        echo "<script>alert('Customer berhasil ditambahkan!'); window.location='index.php?menu=customer';</script>";
    } else {
        echo "Error: " . mysqli_error($koneksi);
    }
}
?>