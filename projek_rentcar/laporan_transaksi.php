<?php
// Pastikan file koneksi dipanggil
include 'koneksi.php'; 
?>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Laporan Transaksi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Laporan Transaksi Penyewaan</h2>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th><th>Customer</th><th>Mobil</th>
                    <th>Tgl Pinjam</th><th>Tgl Kembali</th><th>Total Biaya</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $sql = "SELECT transaksi.*, customer.nama, mobil.merk, mobil.model 
                        FROM transaksi 
                        JOIN customer ON transaksi.id_customer = customer.id_customer 
                        JOIN mobil ON transaksi.id_mobil = mobil.id_mobil";
                
                // GANTI $conn MENJADI $koneksi
                $result = mysqli_query($koneksi, $sql);
                
                if ($result) {
                    while($row = mysqli_fetch_assoc($result)) {
                        echo "<tr>
                                <td>{$row['id_transaksi']}</td>
                                <td>{$row['nama']}</td>
                                <td>{$row['merk']} {$row['model']}</td>
                                <td>{$row['tgl_pinjam']}</td>
                                <td>{$row['tgl_kembali']}</td>
                                <td>Rp " . number_format($row['total_biaya']) . "</td>
                              </tr>";
                    }
                } else {
                    echo "<tr><td colspan='6'>Gagal mengambil data atau data kosong.</td></tr>";
                }
                ?>
            </tbody>
        </table>
        <button onclick="window.print()" class="btn btn-secondary">Cetak Laporan</button>
    </div>
</body>
</html>