<html>
<head>
    <title>Web Productos - Panel de Control</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        .card { border: 1px solid #ccc; padding: 20px; border-radius: 10px; width: 400px; background: #f9f9f9; }
        .btn { display: inline-block; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; margin-top: 10px; }
        .btn:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="card">
        <h1>WebProductos 🚀</h1>
        <p>El servidor está activo. Para verificar que la conexión a la base de datos y la API funcionan, haz clic abajo:</p>
        <a href="api/productos" class="btn">Ver Lista de Productos (JSON)</a>
        <p style="font-size: 0.8em; color: #666; margin-top: 20px;">
            Ruta actual: <code>/api/productos</code>
        </p>
    </div>
</body>
</html>
