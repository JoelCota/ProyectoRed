window.onload = function() {

    function equalsIgnoreCase(str1, str2) {
        return str1.toLowerCase() === str2.toLowerCase();
    }

    function editarPost(idPost) {

        const idSpanContenidoPost = "contenido-post-" + idPost;

        let spanContenidoPost = document.getElementById(idSpanContenidoPost);

        spanContenidoPost.contentEditable = "true";
        spanContenidoPost.focus();
    }

    function mostrarBotonActualizar(idPost) {
        let botonActualizar = document.getElementById(`actualizar-post-${idPost}`);
        botonActualizar.removeAttribute("hidden");
        realizarPeticion(idPost);
        habilitarEditarPost(idPost);
    }

    function realizarPeticion(idPost) {
        if ("editar-") {

        }
    }

    const habilitarEditarPost = idPost => {
        const spanContenidoPost = document.getElementById(`contenido-post-${idPost}`);
        const spanTituloPost = document.getElementById(`titulo-post-${idPost}`);
        spanContenidoPost.contentEditable = "true";
        spanTituloPost.contentEditable = "true";
        spanTituloPost.focus();
    }

    const realizarPeticionEdicionPost = idPost => {
        const spanContenidoPost = document.getElementById(`contenido-post-${idPost}`).value;
        const spanTituloPost = document.getElementById(`titulo-post-${idPost}`).value;

        const postEditado = {
            idPost,
            "tituloNuevo": spanTituloPost,
            "contenidoNuevo": spanContenidoPost
        }

        fetch("http://localhost:8080/talk-board/publicacionesV2Servlet?action=editar-post", {
                method: "POST",
                body: JSON.stringify(postEditado),
                headers: {
                    "content-type": "application/json"
                }
            })
            .catch(err => {
                throw Error(err);
            })

    }

    opcionesPostComun.forEach(function(opcion) {

        const liElement = opcion.querySelector('li');

        opcion.addEventListener('click', function() {

            const liId = liElement.id;

            const idPost = extraerNumeroDeCadena(liId);

            editarPost(idPost);
            mostrarBotonActualizar(idPost);
        });
    });
};