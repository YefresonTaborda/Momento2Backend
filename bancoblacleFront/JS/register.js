document.getElementById('registerForm').addEventListener('submit', (event) => {
    event.preventDefault();

    const nombre = document.getElementById('registerNombre').value;
    const apellido = document.getElementById('registerApellido').value;
    const direccion = document.getElementById('registerDireccion').value;
    const nroIdentificacion = document.getElementById('registerNroIdentificacion').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPassword').value;

    // Generar número de cuenta aleatorio
    const numeroCuenta = Math.floor(1000000000 + Math.random() * 9000000000);

    // Crear objeto usuario
    const usuario = {
        nombre,
        apellido,
        direccion,
        nroIdentificacion,
        email,
        password,
        numeroCuenta
    };

    // Guardar el objeto usuario en el localStorage
    localStorage.setItem('usuario', JSON.stringify(usuario));

    // Mostrar mensaje de confirmación y redirigir a la página de inicio de sesión
    alert('Cuenta creada exitosamente. Serás redirigido a la página de inicio de sesión.');
    window.location.href = '../html/login.html'; // Ajusta la ruta si es necesario
});
