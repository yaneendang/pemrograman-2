<?php 
require_once 'koneksi.php'; 

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Tangkap data dari dropdown (mengirim ID)
    $id_cust = mysqli_real_escape_string($koneksi, $_POST['id_customer']);
    $id_mob  = mysqli_real_escape_string($koneksi, $_POST['id_mobil']);
    $tgl     = date('Y-m-d');
    
    // Query yang sudah benar (menggunakan variabel yang sesuai)
    $query = "INSERT INTO transaksi (id_customer, id_mobil, tgl_pinjam, status) 
              VALUES ('$id_cust', '$id_mob', '$tgl', 'pinjam')";
    
    if (mysqli_query($koneksi, $query)) {
        echo "<script>alert('Berhasil Sewa!'); window.location='index.php?menu=transaksi';</script>";
    } else {
        echo "Error: " . mysqli_error($koneksi);
    }
}
?>

<div class="card p-4">
    <h4>Form Penyewaan</h4>
    <form method="POST">
        <label>Pilih Customer</label>
        <select name="id_customer" class="form-control mb-2" required>
            <?php
            $q = mysqli_query($koneksi, "SELECT * FROM customer");
            while($d = mysqli_fetch_array($q)) {
                echo "<option value='".$d['id_customer']."'>".$d['nama']."</option>";
            }
            ?>
        </select>

        <label>Pilih Mobil</label>
        <select name="id_mobil" class="form-control mb-2" required>
            <?php
            $q = mysqli_query($koneksi, "SELECT * FROM mobil");
            while($d = mysqli_fetch_array($q)) {
                echo "<option value='".$d['id_mobil']."'>".$d['merk']." - ".$d['model']."</option>";
            }
            ?>
        </select>
        
        <button type="submit" class="btn btn-primary">Mulai Sewa</button>
    </form>
</div>