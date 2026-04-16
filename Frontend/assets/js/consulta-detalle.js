document.addEventListener("DOMContentLoaded", () => {
    
    const urlParams = new URLSearchParams(window.location.search);
    const dni = urlParams.get('dni');
    const idHistoria = urlParams.get('id');

    if (!dni) {
        alert("❌ No se proporcionó un DNI");
        return;
    }

    fetch(`http://localhost:8080/api/pacientes/${dni}`)
        .then(response => {
            if (!response.ok) throw new Error('Paciente no encontrado');
            return response.json();
        })
        .then(paciente => {
            document.getElementById("dni").value = paciente.dni || "";
            document.getElementById("nombre").value = paciente.nombreCompleto || "";
            document.getElementById("telefono").value = paciente.telefono || "";
            document.getElementById("direccion").value = paciente.direccion || "";
            document.getElementById("fechaNacimiento").value = paciente.fechaNacimiento || "";
        })
        .catch(error => {
            console.error("Error:", error);
            alert("❌ Error al cargar datos del paciente");
        });

    if (idHistoria) {
        fetch(`http://localhost:8080/api/historias-clinicas/${idHistoria}`)
            .then(response => response.json())
            .then(consulta => {
                if (!consulta) return;
                document.getElementById("fechaConsulta").value = consulta.fechaConsulta 
                    ? new Date(consulta.fechaConsulta).toLocaleString() 
                    : new Date().toLocaleString();
                document.getElementById("diagnostico").value = consulta.diagnostico || "";
                document.getElementById("tratamiento").value = consulta.tratamiento || "";
                document.getElementById("observaciones").value = consulta.observaciones || "";
            })
            .catch(error => console.error("Error al cargar consulta:", error));
    } else {
        fetch(`http://localhost:8080/api/historias-clinicas?dni=${dni}`)
            .then(response => response.json())
            .then(consultas => {
                if (consultas.length === 0) return;
                const consulta = consultas[consultas.length - 1];
                document.getElementById("fechaConsulta").value = consulta.fechaConsulta 
                    ? new Date(consulta.fechaConsulta).toLocaleString() 
                    : new Date().toLocaleString();
                document.getElementById("diagnostico").value = consulta.diagnostico || "";
                document.getElementById("tratamiento").value = consulta.tratamiento || "";
                document.getElementById("observaciones").value = consulta.observaciones || "";
            })
            .catch(error => console.error("Error al cargar consultas:", error));
    }
});
