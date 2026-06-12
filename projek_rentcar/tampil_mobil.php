<?php
include 'koneksi.php';
?>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Rekap Data Mobil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Daftar Mobil Tersedia</h2>
        <table class="table table-bordered table-hover">
            <thead class="table-primary">
                <tr>
                    <th>No</th>
                    <th>Merk</th>
                    <th>Model</th>
                    <th>Plat Nomor</th>
                    <th>Harga Sewa</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $no = 1;
                $query = mysqli_query($conn, "SELECT * FROM mobil");
                while ($data = mysqli_fetch_array($query)) {
                    echo "<tr>
                            <td>$no</td>
                            <td>$data[merk]</td>
                            <td>$data[model]</td>
                            <td>$data[plat_nomor]</td>
                            <td>Rp " . number_format($data['harga_sewa']) . "</td>
                            <td>$data[status]</td>
                          </tr>";
                    $no++;
                }
                ?>
            </tbody>
        </table>
        <a href="input_mobil.php" class="btn btn-secondary">Kembali Input</a>
    </div>
</body>
</html>