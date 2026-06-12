<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Mobil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container-fluid mt-4">
        <h2 class="mb-4 text-center">Dashboard Kelola Mobil</h2>
        <div class="row">
            <div class="col-md-4">
                <div class="card p-4">
                    <h4>Input Mobil Baru</h4>
                    <form action="proses_simpan_mobil.php" method="POST">
                        <div class="mb-3">
                            <label>Merk</label>
                            <input type="text" name="merk" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Model</label>
                            <input type="text" name="model" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Plat Nomor</label>
                            <input type="text" name="plat_nomor" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Harga Sewa</label>
                            <input type="number" name="harga" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Simpan Data</button>
                    </form>
                </div>
            </div>

            <div class="col-md-8">
                <div class="card p-4">
                    <h4>Daftar Mobil</h4>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Merk</th>
                                <th>Model</th>
                                <th>Plat</th>
                                <th>Harga</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            include 'koneksi.php';
                            $query = mysqli_query($conn, "SELECT * FROM mobil");
                            while ($data = mysqli_fetch_array($query)) {
                                echo "<tr>
                                        <td>{$data['merk']}</td>
                                        <td>{$data['model']}</td>
                                        <td>{$data['plat_nomor']}</td>
                                        <td>Rp " . number_format($data['harga_sewa']) . "</td>
                                      </tr>";
                            }
                            ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>