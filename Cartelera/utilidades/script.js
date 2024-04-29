// Código JavaScript para manejar la lógica de selección de asientos

// Función para validar el formulario (puedes agregar más validaciones según necesites)
function validateForm() {
    // Aquí puedes agregar lógica de validación
    return true; // Devuelve true si el formulario es válido
}

// Event listener para el envío del formulario
document.getElementById("booking-form").addEventListener("submit", function(event) {
    if (!validateForm()) {
        event.preventDefault(); // Evita que el formulario se envíe si no es válido
    }
});
