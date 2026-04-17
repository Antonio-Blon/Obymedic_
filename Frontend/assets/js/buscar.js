// EVENTOS EN JAVASCRIPT (CLICK, KEY)
document.addEventListener("DOMContentLoaded", () => {
    const btnBuscar = document.getElementById("btnBuscar");
    const dniInput = document.getElementById("dni");

    if (btnBuscar && dniInput) {
        btnBuscar.addEventListener("click", () => {
            const dni = dniInput.value.trim();

            if (!dni) {
                alert(" Ingrese un DNI válido");
                return;
            }

            // Redirigir a resultado.html con el DNI en la URL
            window.location.href = `resultado.html?dni=${dni}`;
        });

        // Permitir buscar con tecla Enter
        dniInput.addEventListener("keypress", (event) => {
            if (event.key === "Enter") {
                btnBuscar.click();
            }
        });
    }
});
