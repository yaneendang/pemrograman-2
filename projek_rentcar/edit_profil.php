<div class="card p-4">
    <h4>Edit Profil Admin</h4>
    <hr>
    <form action="proses_edit_profil.php" method="POST">
        <div class="mb-3">
            <label>Nama Admin</label>
            <input type="text" name="nama" class="form-control" value="<?php echo $_SESSION['username']; ?>">
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control" value="admin@lovitarentcar.com">
        </div>
        <button type="submit" class="btn btn-success">Simpan Perubahan</button>
        <a href="index.php?menu=profil" class="btn btn-secondary">Batal</a>
    </form>
</div>