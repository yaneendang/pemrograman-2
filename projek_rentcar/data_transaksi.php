<?php
require_once 'koneksi.php'; 
?>

<a href="index.php?menu=tambah_transaksi" class="btn btn-primary mb-3">+ Tambah Transaksi</a>

<table class="table table-bordered">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Customer</th>
            <th>Mobil</th>
            <th>Status</th>
            <th>Aksi</th>
        </tr>
    </thead>
    <tbody>
        <?php
        // Menggunakan JOIN untuk menampilkan Nama, bukan sekadar ID angka
        $sql = "SELECT t.*, c.nama AS nama_customer, m.merk, m.model 
                FROM transaksi t
                JOIN customer c ON t.id_customer = c.id_customer
                JOIN mobil m ON t.id_mobil = m.id_mobil";
        
        $query = mysqli_query($koneksi, $sql);
        
        if (mysqli_num_rows($query) > 0) {
            while($d = mysqli_fetch_array($query)) {
                echo "<tr>
                        <td>{$d['id_transaksi']}</td>
                        <td>{$d['nama_customer']}</td>
                        <td>{$d['merk']} {$d['model']}</td>
                        <td>" . ucfirst($d['status']) . "</td>
                        <td>
                            " . ($d['status'] == 'pinjam' ? 
                            "<a href='proses_pengembalian.php?id={$d['id_transaksi']}' class='btn btn-warning btn-sm'>Kembalikan</a>" : 
                            "<span class='text-success'>Selesai</span>") . "
                        </td>
                      </tr>";
            }
        } else {
            echo "<tr><td colspan='5' class='text-center'>Belum ada transaksi. Silakan tambah data.</td></tr>";
        }
        ?>
    </tbody>
</table>