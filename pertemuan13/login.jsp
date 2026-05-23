<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Aplikasi</title>
    <style>
        body { font-family: Arial; background: #808080; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .card { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.2); }
        input { display: block; width: 200px; margin: 10px 0; padding: 8px; }
        button { width: 100%; padding: 8px; background: #577927; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <div class="card">
        <h3>Login Administrasi Nilai</h3>
        <input type="text" placeholder="Username">
        <input type="password" placeholder="Password">
        <button onclick="window.location.href='index.jsp'">Login</button>
    </div>
</body>
</html>