const opcionesPost = document.querySelectorAll('.Opciones-details li');
const opcionesRespuesta = document.querySelectorAll('.comentario');
const btnActualizar = document.querySelectorAll(".button-actualizar");

const botonesEnviarComentarios = document.querySelectorAll(".Enviar-comentario");

const extraerNumeroDeCadena = (cadena) => Number(cadena.match(/\d+/g)[0]);

const isStringEmpty = string => {
    if (typeof string !== "string") {
        throw Error("Sólo pueden validarse mensajes.");
    }

    return string.trim().length === 0;
}

const obtenerIdPost = () => {
    opcionesPost.forEach(liElement => {
        liElement.addEventListener('click', () => {
            const liId = liElement.id;

            const action = liId.split('-')[0];
            const postId = Number(liId.split('-')[1]);

            console.log({ action, postId });
            mostrarBotonActualizarPosts(postId);
        });
    });
}

const obtenerIdComentarios = () => {
    opcionesRespuesta.forEach(opcion => {
        const liElement = opcion.querySelector('li');

        opcion.addEventListener('click', () => {
            const liId = extraerNumeroDeCadena(liElement.id);

            mostrarBotonActualizarPosts(liId);
        });
    });
}

const mostrarBotonActualizarPosts = idPost => {
    let botonActualizar = document.getElementById(`actualizar-post-${idPost}`);
    botonActualizar.removeAttribute("hidden");
    botonActualizar.addEventListener("click", () => realizarPeticionEdicionPost(idPost));
    habilitarEditarPost(idPost);
}

const habilitarEditarPost = idPost => {
    const spanContenidoPost = document.getElementById(`contenido-post-${idPost}`);
    const spanTituloPost = document.getElementById(`titulo-post-${idPost}`);
    spanContenidoPost.contentEditable = "true";
    spanTituloPost.contentEditable = "true";
    spanTituloPost.focus();
}

const comentarPublicaciones = () => {
    botonesEnviarComentarios.forEach(opcion => {
        opcion.addEventListener("click", () => {
            const boton = opcion.querySelector("button");
            const idPost = extraerNumeroDeCadena(boton.id);

            confirmarComentario(idPost, confirm("¿Seguro que quieres comentar la publicación?"));
        });
    });
}

const confirmarComentario = (idPost, confirmacion) => {
    if (confirmacion) {
        try {
            const inputComentario = document.getElementById(`input-comentar-post-${idPost}`);

            crearComentario(idPost, inputComentario.value);
        } catch (err) {
            alert(err);
        }
    }
}

const crearComentario = (idPost, contenido) => {
    if (!idPost) {
        throw Error("No es posible crear el comentario, no existe el post a comentar.");
    }

    if (isStringEmpty(contenido)) {
        throw Error("No se puede publicar un comentario vacío.");
    }

    try {
        guardarComentario({ idPost, "contenidoComentario": contenido });
        window.location.href = "http://localhost:8080/talk-board/posts?action=ver-publicaciones";
    } catch (err) {
        throw Error(err);
    }
}

const guardarComentario = comentario => {
    fetch("http://localhost:8080/talk-board/comentarioV2Servlet?action=comentar", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
        })
        .then(response => {
            return response.json();
        })
        .then(comentario => {
            console.log(comentario);
        })
        .catch(err => {
            throw Error(err);
        })
}

const realizarPeticionEdicionPost = idPost => {
    const spanContenidoPost = document.getElementById(`contenido-post-${idPost}`).innerText;
    const spanTituloPost = document.getElementById(`titulo-post-${idPost}`).innerText;

    console.log(spanContenidoPost);
    console.log(spanTituloPost);

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

const init = () => {
    obtenerIdPost();
    obtenerIdComentarios();
    comentarPublicaciones();
}

window.onload = init;