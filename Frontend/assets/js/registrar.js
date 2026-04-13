// EVENTOS EN JAVASCRIPT (CLICK, CARGAR, KEY)
document.addEventListener("DOMContentLoaded", () => {
    
    // ============================================
    // CALCULAR EDAD AUTOMATICAMENTE
    // ============================================
    const fechaNacimiento = document.getElementById("fecha_nacimiento");
    const edadInput = document.getElementById("edad");

    if (fechaNacimiento && edadInput) {
        fechaNacimiento.addEventListener("change", () => {
            const fechaNac = new Date(fechaNacimiento.value);
            const hoy = new Date();
            let edad = hoy.getFullYear() - fechaNac.getFullYear();
            const mes = hoy.getMonth() - fechaNac.getMonth();
            if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNac.getDate())) {
                edad--;
            }
            edadInput.value = edad > 0 ? edad : "";
        });
    }

    // ============================================
    // ESTABLECER FECHA ACTUAL EN FECHA CONSULTA
    // ============================================
    const fechaConsulta = document.getElementById("fecha_consulta");
    if (fechaConsulta) {
        const hoy = new Date().toISOString().split("T")[0];
        fechaConsulta.value = hoy;
    }

    // ============================================
    // REGISTRAR CONSULTA (GUARDAR EN BD)
    // ============================================
    const btnRegistrar = document.getElementById("btn-registrar");

    if (btnRegistrar) {
        btnRegistrar.addEventListener("click", (event) => {
            event.preventDefault();

            // Obtener valores del formulario
            const dni = document.getElementById("dni")?.value;
            const nombreCompleto = document.getElementById("nombre_completo")?.value;
            const telefono = document.getElementById("telefono")?.value;
            const direccion = document.getElementById("direccion")?.value;
            const fechaNacimientoValue = document.getElementById("fecha_nacimiento")?.value;
            const diagnostico = document.getElementById("diagnostico")?.value;
            const tratamiento = document.getElementById("tratamiento")?.value;
            const observaciones = document.getElementById("examenes_auxiliares")?.value;

            // VALIDACIONES
            if (!dni || dni.trim() === "") {
                alert("❌ El DNI es obligatorio");
                return;
            }

            if (!nombreCompleto || nombreCompleto.trim() === "") {
                alert("❌ El nombre y apellidos es obligatorio");
                return;
            }

            // Datos del Paciente (tabla: paciente)
            const pacienteData = {
                dni: parseInt(dni),
                nombreCompleto: nombreCompleto,
                telefono: telefono || "",
                direccion: direccion || "",
                fechaNacimiento: fechaNacimientoValue || null
            };

            // Datos de la Historia Clinica (tabla: historia_clinica)
            const historiaData = {
                dni: parseInt(dni),
                diagnostico: diagnostico || "",
                tratamiento: tratamiento || "",
                observaciones: observaciones || ""
            };

            console.log("Paciente a guardar:", pacienteData);
            console.log("Historia a guardar:", historiaData);

            // PASO 1: Guardar o actualizar PACIENTE
            fetch('http://localhost:8080/api/pacientes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(pacienteData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al guardar paciente: ' + response.status);
                }
                return response.json();
            })
            .then(pacienteGuardado => {
                console.log("✅ Paciente guardado:", pacienteGuardado);

                // PASO 2: Guardar HISTORIA CLINICA
                return fetch('http://localhost:8080/api/historias-clinicas', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(historiaData)
                });
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al guardar consulta: ' + response.status);
                }
                return response.json();
            })
            .then(consultaGuardada => {
                console.log("✅ Consulta guardada:", consultaGuardada);
                alert("✅ Consulta registrada correctamente");
                window.location.href = 'ver.html';
            })
            .catch(error => {
                console.error("❌ Error:", error);
                alert("❌ Error al registrar: " + error.message);
            });
        });
    }
});