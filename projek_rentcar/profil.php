<div class="container mt-4">
    <div class="card p-4 shadow-sm">
        <h4 class="mb-4">Profil Admin</h4>
        <hr>
        <div class="row">
            <div class="col-md-3 text-center">
                <div class="bg-secondary text-white p-5 rounded mb-3">
                    <i class="bi bi-person-circle" style="font-size: 3rem;"></i>
                </div>
            </div>
            
            <div class="col-md-9">
                <table class="table table-borderless">
                    <tr>
                        <th width="200">Nama Admin</th>
                        <td>: <?php echo $_SESSION['username']; ?></td>
                    </tr>
                    <tr>
                        <th>Status</th>
                        <td>: Administrator Utama</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>: admin@lovitarentcar.com</td>
                    </tr>
                </table>
                
                <a href="index.php?menu=edit_profil" class="btn btn-primary">
                    <i class="bi bi-pencil-square"></i> Edit Profil
                </a>
            </div>
        </div>
    </div>
</div>