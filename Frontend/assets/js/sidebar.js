document.addEventListener("DOMContentLoaded", () => {
    const hamburger = document.querySelector(".hamburger");
    const sidebar = document.querySelector(".sidebar");
    const overlay = document.querySelector(".overlay");

    function openSidebar() {
        sidebar.classList.add("open");
        overlay.classList.add("show");
    }

    function closeSidebar() {
        sidebar.classList.remove("open");
        overlay.classList.remove("show");
    }

    if (hamburger) {
        hamburger.addEventListener("click", openSidebar);
    }

    if (overlay) {
        overlay.addEventListener("click", closeSidebar);
    }

    // Marcar enlace activo y navegar (sin bloquear)
    const navLinks = document.querySelectorAll(".sidebar ul li a");

    navLinks.forEach(link => {
        link.addEventListener("click", () => {
            navLinks.forEach(l => l.classList.remove("activo"));
            link.classList.add("activo");

            if (window.innerWidth < 768) {
                closeSidebar();
            }
        });
    });

    // Marcar activo según la URL actual
    const currentPage = window.location.pathname.split("/").pop();
    navLinks.forEach(link => {
        const href = link.getAttribute("href");
        if (href === currentPage || (currentPage === "" && href === "index.html")) {
            link.classList.add("activo");
        }
    });
});