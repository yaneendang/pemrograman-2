<div class="row">
    <div class="col-md-4">
        <div class="card p-3 shadow-sm">
            <h5>Input Data Customer</h5>
            <form action="proses_simpan_customer.php" method="POST">
                <div class="mb-3">
                    <label>Nama Lengkap</label>
                    <input type="text" name="nama" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>NIK</label>
                    <input type="text" name="nik" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Nomor HP</label>
                    <input type="text" name="no_hp" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Simpan Data</button>
            </form>
        </div>
    </div>

    <div class="col-md-8">
        <div class="card p-3 shadow-sm">
            <h5>Daftar Customer</h5>
            <table class="table table-sm table-striped">
                <thead class="table-dark">
                    <tr><th>Nama</th><th>NIK</th><th>No HP</th></tr>
                </thead>
                <tbody>
                    <?php 
                    // Pastikan panggil koneksi.php
                    include 'koneksi.php';
                    
                    // GANTI $conn MENJADI $koneksi
                    $q = mysqli_query($koneksi, "SELECT * FROM customer");
                    
                    while($d = mysqli_fetch_array($q)) {
                        echo "<tr>
                                <td>{$d['nama']}</td>
                                <td>{$d['nik']}</td>
                                <td>{$d['no_hp']}</td>
                              </tr>";
                    }
                    ?>
                </tbody>
            </table>
        </div>
    </div>
</div>