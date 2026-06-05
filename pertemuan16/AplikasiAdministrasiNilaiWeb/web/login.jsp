<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login - Aplikasi Administrasi Nilai</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');
        
        body {
            font-family: 'Inter', sans-serif;
            background: #eef2f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-card {
            background: #ffffff;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
            width: 100%;
            max-width: 380px;
            text-align: center;
            border: 1px solid #e2e8f0;
        }

        .login-card .icon-header {
            font-size: 3.5rem;
            color: #0056b3;
            margin-bottom: 10px;
        }

        .login-card h2 {
            margin: 0;
            font-size: 1.6rem;
            color: #0f172a;
            font-weight: 700;
        }

        .login-card p {
            color: #64748b;
            font-size: 0.9rem;
            margin-top: 5px;
            margin-bottom: 30px;
        }

        .input-group {
            text-align: left;
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            font-size: 0.85rem;
            font-weight: 600;
            color: #334155;
            margin-bottom: 6px;
        }

        .input-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #cbd5e1;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 0.95rem;
            transition: all 0.2s;
        }

        .input-group input:focus {
            outline: none;
            border-color: #0056b3;
            box-shadow: 0 0 0 3px rgba(0, 86, 179, 0.1);
        }

        .btn-login {
            width: 100%;
            padding: 12px;
            background: #0056b3;
            color: #ffffff;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.2s;
            margin-top: 10px;
        }

        .btn-login:hover {
            background: #004085;
        }

        .back-home {
            margin-top: 20px;
            display: inline-block;
            font-size: 0.85rem;
            color: #0056b3;
            text-decoration: none;
            font-weight: 500;
        }
        
        .back-home:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="login-card">
        <div class="icon-header">
            <i class="fa-solid fa-graduation-cap"></i>
        </div>
        <h2>Sistem Login</h2>
        <p>Aplikasi Administrasi Nilai UNPAM</p>
        
        <form action="LoginController" method="POST">
            <div class="input-group">
                <label>Username</label>
                <input type="text" name="username" placeholder="Masukkan username" required autocomplete="off">
            </div>
            
            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Masukkan password" required>
            </div>
            
            <button type="submit" class="btn-login">Masuk Aplikasi</button>
        </form>
        
        <a href="index.jsp" class="back-home"><i class="fa-solid fa-arrow-left" style="margin-right: 5px;"></i> Kembali ke Home</a>
    </div>

</body>
</html>