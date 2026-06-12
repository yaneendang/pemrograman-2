<div class="card p-4">
    <h4>Laporan Rekapitulasi Sistem</h4>
    <hr>
    <?php 
    include_once 'koneksi.php'; 
    
    // Menghitung statistik
    $jml_mobil = mysqli_num_rows(mysqli_query($koneksi, "SELECT * FROM mobil"));
    $jml_cust  = mysqli_num_rows(mysqli_query($koneksi, "SELECT * FROM customer"));
    $jml_trans = mysqli_num_rows(mysqli_query($koneksi, "SELECT * FROM transaksi"));
    ?>

    <div class="row mb-4">
        <div class="col-md-4">
            <div class="card bg-primary text-white p-3">
                <h5>Total Mobil</h5>
                <h3><?php echo $jml_mobil; ?></h3>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card bg-success text-white p-3">
                <h5>Total Customer</h5>
                <h3><?php echo $jml_cust; ?></h3>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card bg-warning text-dark p-3">
                <h5>Total Transaksi</h5>
                <h3><?php echo $jml_trans; ?></h3>
            </div>
        </div>
    </div>
    
    <h5>Riwayat Transaksi</h5>
    <table class="table table-bordered table-sm">
        <thead class="table-dark">
            <tr>
                <th>Customer</th><th>Mobil</th><th>Tgl Pinjam</th><th>Tgl Kembali</th><th>Status</th>
            </tr>
        </thead>
        <tbody>
            <?php 
            $sql = "SELECT t.*, c.nama, m.merk 
                    FROM transaksi t 
                    JOIN customer c ON t.id_customer = c.id_customer 
                    JOIN mobil m ON t.id_mobil = m.id_mobil";
            $q = mysqli_query($koneksi, $sql);
            while($d = mysqli_fetch_array($q)) {
                echo "<tr>
                        <td>{$d['nama']}</td>
                        <td>{$d['merk']}</td>
                        <td>{$d['tgl_pinjam']}</td>
                        <td>" . ($d['tgl_kembali'] ? $d['tgl_kembali'] : '-') . "</td>
                        <td>" . ucfirst($d['status']) . "</td>
                      </tr>";
            }
            ?>
        </tbody>
    </table>
    
    <button onclick="window.print()" class="btn btn-secondary d-print-none">Cetak Laporan</button>
</div>