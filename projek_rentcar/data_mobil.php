<div class="row">
    <div class="col-md-4">
        <div class="card p-3 shadow-sm">
            <h5>Input Mobil Baru</h5>
            <form action="proses_simpan_mobil.php" method="POST">
                <input type="text" name="merk" class="form-control mb-2" placeholder="Merk" required>
                <input type="text" name="model" class="form-control mb-2" placeholder="Model" required>
                <input type="text" name="plat_nomor" class="form-control mb-2" placeholder="Plat Nomor" required>
                <input type="number" name="harga" class="form-control mb-2" placeholder="Harga Sewa" required>
                <button type="submit" class="btn btn-primary w-100">Simpan Data</button>
            </form>
        </div>
    </div>

    <div class="col-md-8">
        <div class="card p-3 shadow-sm">
            <h5>Daftar Mobil</h5>
            <div class="table-responsive">
                <table class="table table-sm table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>Merk</th><th>Model</th><th>Plat</th><th>Harga</th><th>Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php 
                        include 'koneksi.php'; // Panggil file koneksi
                        $q = mysqli_query($koneksi, "SELECT * FROM mobil"); // Gunakan $koneksi
                        while($d = mysqli_fetch_array($q)) {
                            echo "<tr>
                                    <td>{$d['merk']}</td>
                                    <td>{$d['model']}</td>
                                    <td>{$d['plat_nomor']}</td>
                                    <td>Rp " . number_format($d['harga_sewa']) . "</td>
                                    <td>
                                        <a href='index.php?menu=edit_mobil&id={$d['id_mobil']}' class='btn btn-warning btn-sm'>Edit</a>
                                        <a href='hapus_mobil.php?id={$d['id_mobil']}' class='btn btn-danger btn-sm' onclick=\"return confirm('Yakin ingin hapus?')\">Hapus</a>
                                    </td>
                                  </tr>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>