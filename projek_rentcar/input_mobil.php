<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Input Data Mobil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Input Data Mobil</h2>
        <form action="proses_simpan_mobil.php" method="POST">
            <div class="mb-3">
                <label>Merk Mobil</label>
                <input type="text" name="merk" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Model Mobil</label>
                <input type="text" name="model" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Plat Nomor</label>
                <input type="text" name="plat_nomor" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Harga Sewa per Hari</label>
                <input type="number" name="harga" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Simpan Data</button>
        </form>
    </div>
</body>
</html>