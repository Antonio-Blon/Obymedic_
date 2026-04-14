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

    // ============================================
    // CARGAR DATOS DEL PACIENTE
    // ============================================
    fetch(`http://localhost:8080/api/pacientes/${dni}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Paciente no encontrado');
            }
            return response.json();
        })
        .then(paciente => {
            document.getElementById("nombre").value = paciente.nombreCompleto || "";
            document.getElementById("telefono").value = paciente.telefono || "";
            const fechaActual = new Date().toLocaleDateString();
            document.getElementById("fecha").value = fechaActual;
        })
        .catch(error => {
            console.error("Error:", error);
            alert("❌ Paciente no encontrado");
            document.getElementById("nombre").value = "No encontrado";
            document.getElementById("telefono").value = "";
            document.getElementById("fecha").value = "";
        });

    // ============================================
    // BOTÓN: NUEVA CONSULTA
    // ============================================
    const btnNuevaConsulta = document.getElementById("btnNuevaConsulta");
    if (btnNuevaConsulta) {
        btnNuevaConsulta.addEventListener("click", () => {
            window.location.href = `registrar.html?dni=${dni}`;
        });
    }

    // ============================================
    // BOTÓN: MOSTRAR CONSULTA (muestra lista de consultas)
    // ============================================
    const btnMostrarConsulta = document.getElementById("btnMostrarConsulta");
    const consultasContainer = document.getElementById("consultas-container");
    const listaConsultas = document.getElementById("lista-consultas");

    // Función para cargar y mostrar consultas
    function cargarConsultas() {
        fetch(`http://localhost:8080/api/historias-clinicas?dni=${dni}`)
            .then(response => response.json())
            .then(consultas => {
                if (consultas.length === 0) {
                    consultasContainer.style.display = "none";
                    return;
                }
                
                consultasContainer.style.display = "block";
                listaConsultas.innerHTML = "";
                
                consultas.forEach(consulta => {
                    const fecha = consulta.fechaConsulta 
                        ? new Date(consulta.fechaConsulta).toLocaleString() 
                        : "Fecha no disponible";
                    
                    // Crear tarjeta con botón de eliminar
                    const card = document.createElement("div");
                    card.className = "list-group-item list-group-item-action";
                    card.style.display = "flex";
                    card.style.justifyContent = "space-between";
                    card.style.alignItems = "center";
                    card.style.cursor = "pointer";
                    
                    // Parte izquierda: enlace al detalle
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
                    
                    // Botón de eliminar
                    const deleteBtn = document.createElement("button");
                    deleteBtn.className = "btn btn-sm btn-danger ms-2";
                    deleteBtn.style.marginLeft = "10px";
                    deleteBtn.innerHTML = '<i class="fa-solid fa-trash-can"></i>';
                    deleteBtn.title = "Eliminar consulta";
                    deleteBtn.onclick = (e) => {
                        e.stopPropagation(); // Evita que se active el enlace
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

    // Función para eliminar consulta
    function eliminarConsulta(idHistoria) {
        fetch(`http://localhost:8080/api/historias-clinicas/${idHistoria}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al eliminar la consulta');
            }
            // Si la respuesta es 204 No Content, no hay JSON
            return response.text();
        })
        .then(() => {
            alert("✅ Consulta eliminada correctamente");
            cargarConsultas(); // Recargar la lista
        })
        .catch(error => {
            console.error("Error al eliminar:", error);
            alert("❌ No se pudo eliminar la consulta. Asegúrate de que el backend tenga el endpoint DELETE.");
        });
    }

    if (btnMostrarConsulta) {
        btnMostrarConsulta.addEventListener("click", () => {
            cargarConsultas();
        });
    }
});