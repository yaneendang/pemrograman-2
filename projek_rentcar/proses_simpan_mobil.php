<?php
include 'koneksi.php'; // WAJIB ada di tiap file

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $merk = $_POST['merk'];
    $model = $_POST['model'];
    $plat = $_POST['plat_nomor'];
    $harga = $_POST['harga'];

    // Gunakan $koneksi
    $query = "INSERT INTO mobil (merk, model, plat_nomor, harga_sewa) VALUES ('$merk', '$model', '$plat', '$harga')";
    
    if (mysqli_query($koneksi, $query)) {
        header("location:index.php?menu=mobil");
    } else {
        echo "Error: " . mysqli_error($koneksi);
    }
}
?>