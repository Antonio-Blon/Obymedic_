// EVENTOS EN JAVASCRIPT (DOMContentLoaded, fetch, click)
document.addEventListener("DOMContentLoaded", () => {
    
    // ============================================
    // OBTENER DNI DE LA URL
    // ============================================
    const urlParams = new URLSearchParams(window.location.search);
    const dni = urlParams.get('dni');

    if (!dni) {
        alert("❌ No se proporcionó un DNI");
        return;
    }

    const sinConsultasDiv = document.getElementById("sin-consultas-mensaje");
    const resultadoForm = document.getElementById("resultadoForm");
    const nombreInput = document.getElementById("nombre");
    const telefonoInput = document.getElementById("telefono");
    const fechaInput = document.getElementById("fecha");
    const btnNuevaConsulta = document.getElementById("btnNuevaConsulta");
    const btnNuevaConsultaMensaje = document.getElementById("btnNuevaConsultaMensaje");
    const btnMostrarConsulta = document.getElementById("btnMostrarConsulta");
    const consultasContainer = document.getElementById("consultas-container");
    const listaConsultas = document.getElementById("lista-consultas");

    // ============================================
    // FUNCIÓN PARA VERIFICAR SI EXISTEN CONSULTAS
    // ============================================
    function verificarConsultas() {
        fetch(`http://localhost:8080/api/historias-clinicas?dni=${dni}`)
            .then(response => response.json())
            .then(consultas => {
                if (consultas.length === 0) {
                    // No hay consultas → mostrar mensaje, ocultar formulario
                    sinConsultasDiv.style.display = "block";
                    resultadoForm.style.display = "none";
                } else {
                    // Hay consultas → ocultar mensaje, mostrar formulario y cargar datos
                    sinConsultasDiv.style.display = "none";
                    resultadoForm.style.display = "block";
                    cargarDatosPaciente();
                    // Opcional: mostrar la lista automáticamente
                    cargarConsultas();
                }
            })
            .catch(error => {
                console.error("Error al verificar consultas:", error);
                sinConsultasDiv.style.display = "block";
                resultadoForm.style.display = "none";
            });
    }

    // ============================================
    // CARGAR DATOS DEL PACIENTE (solo si hay consultas)
    // ============================================
    function cargarDatosPaciente() {
        fetch(`http://localhost:8080/api/pacientes/${dni}`)
            .then(response => {
                if (!response.ok) throw new Error('Paciente no encontrado');
                return response.json();
            })
            .then(paciente => {
                nombreInput.value = paciente.nombreCompleto || "";
                telefonoInput.value = paciente.telefono || "";
            })
            .catch(error => {
                console.error("Error:", error);
                nombreInput.value = "Error al cargar";
                telefonoInput.value = "";
            });
    }

    // ============================================
    // CARGAR LISTA DE CONSULTAS
    // ============================================
    function cargarConsultas() {
        fetch(`http://localhost:8080/api/historias-clinicas?dni=${dni}`)
            .then(response => response.json())
            .then(consultas => {
                if (consultas.length === 0) {
                    consultasContainer.style.display = "none";
                    fechaInput.value = "No hay consultas previas";
                    fechaInput.style.color = "#999";
                    return;
                }
                
                // Mostrar la fecha actual como la última consulta (opcional)
                const ultimaFecha = consultas[consultas.length - 1].fechaConsulta;
                fechaInput.value = ultimaFecha ? new Date(ultimaFecha).toLocaleDateString() : new Date().toLocaleDateString();
                fechaInput.style.color = "";
                
                consultasContainer.style.display = "block";
                listaConsultas.innerHTML = "";
                
                consultas.forEach(consulta => {
                    const fecha = consulta.fechaConsulta 
                        ? new Date(consulta.fechaConsulta).toLocaleString() 
                        : "Fecha no disponible";
                    
                    const card = document.createElement("div");
                    card.className = "list-group-item list-group-item-action";
                    card.style.display = "flex";
                    card.style.justifyContent = "space-between";
                    card.style.alignItems = "center";
                    card.style.cursor = "pointer";
                    
                    const link = document.createElement("a");
                    link.href = `consulta-detalle.html?dni=${dni}&id=${consulta.idHistoria}`;
                    link.style.textDecoration = "none";
                    link.style.color = "inherit";
                    link.style.flex = "1";
                    link.innerHTML = `
                        <div class="d-flex justify-content-between align-items-center">
                            <div>
                                <i class="fa-solid fa-calendar-check text-primary"></i>
                                <strong>Consulta: ${fecha}</strong>
                            </div>
                            <div>
                                <span class="badge bg-primary rounded-pill">
                                    <i class="fa-solid fa-arrow-right"></i> Ver
                                </span>
                            </div>
                        </div>
                        <div class="mt-2">
                            <small class="text-muted">
                                <i class="fa-solid fa-stethoscope"></i> Diagnóstico: 
                                ${consulta.diagnostico ? consulta.diagnostico.substring(0, 100) : "No especificado"}
                                ${consulta.diagnostico && consulta.diagnostico.length > 100 ? "..." : ""}
                            </small>
                        </div>
                    `;
                    
                    const deleteBtn = document.createElement("button");
                    deleteBtn.className = "btn btn-sm btn-danger ms-2";
                    deleteBtn.style.marginLeft = "10px";
                    deleteBtn.innerHTML = '<i class="fa-solid fa-trash-can"></i>';
                    deleteBtn.title = "Eliminar consulta";
                    deleteBtn.onclick = (e) => {
                        e.stopPropagation();
                        if (confirm(`¿Eliminar consulta del ${fecha}?`)) {
                            eliminarConsulta(consulta.idHistoria);
                        }
                    };
                    
                    card.appendChild(link);
                    card.appendChild(deleteBtn);
                    listaConsultas.appendChild(card);
                });
            })
            .catch(error => {
                console.error("Error:", error);
                alert("❌ Error al cargar el historial");
                consultasContainer.style.display = "none";
            });
    }

    // ============================================
    // ELIMINAR CONSULTA
    // ============================================
    function eliminarConsulta(idHistoria) {
        fetch(`http://localhost:8080/api/historias-clinicas/${idHistoria}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) throw new Error('Error al eliminar');
            return response.text();
        })
        .then(() => {
            alert("✅ Consulta eliminada correctamente");
            // Volver a verificar si hay consultas (para mostrar mensaje si es la última)
            verificarConsultas();
        })
        .catch(error => {
            console.error("Error al eliminar:", error);
            alert("❌ No se pudo eliminar la consulta");
        });
    }

    // ============================================
    // EVENTOS DE BOTONES
    // ============================================
    if (btnNuevaConsulta) {
        btnNuevaConsulta.addEventListener("click", () => {
            window.location.href = `registrar.html?dni=${dni}`;
        });
    }
    if (btnNuevaConsultaMensaje) {
        btnNuevaConsultaMensaje.addEventListener("click", () => {
            window.location.href = `registrar.html?dni=${dni}`;
        });
    }
    if (btnMostrarConsulta) {
        btnMostrarConsulta.addEventListener("click", () => {
            cargarConsultas();
        });
    }

    // ============================================
    // INICIALIZAR: verificar si hay consultas
    // ============================================
    verificarConsultas();
});