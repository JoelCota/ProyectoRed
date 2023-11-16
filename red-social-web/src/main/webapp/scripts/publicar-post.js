const inputTitulo = document.getElementById("titulo");
const textAreaContenido = document.getElementById("contenido");
const btnGuardarPost = document.getElementById("btn-guardar-post");
const anclarPost = document.getElementById("anclar");

const isStringEmpty = string => {
    if (typeof string !== "string") {
        throw Error("Sólo pueden validarse mensajes.");
    }

    return string.trim().length === 0;
}

const confirmarPublicacion = (confirmacion) => {
    if (confirmacion) {
        try {
            btnGuardarPost.disabled = true;
            crearPublicacion(inputTitulo.value, textAreaContenido.value);
            window.location.href = "./posts?action=ver-publicaciones";
        } catch (err) {
            alert(err);
            btnGuardarPost.disabled = false;
        }
    }
}

const crearPublicacion = (titulo, contenido) => {
    if (isStringEmpty(titulo)) {
        throw Error("Agregue algún título.");
    }

    if (isStringEmpty(contenido)) {
        throw Error("Agregue algún contenido.");
    }

    const post = { "tituloPost": titulo, "contenidoPost": contenido };

    try {
        if (anclarPost !== null && typeof anclarPost !== "undefined" && anclarPost.checked) {
            guardarPublicacionAnclada(post);
        } else {
            guardarPublicacionComun(post);
        }
    } catch (err) {
        throw Error(err);
    }
}

const guardarPublicacionComun = (post) => {
    fetch("http://localhost:8080/talk-board/publicacionesV2Servlet?action=crear-post-comun", {
        method: "POST",
        body: JSON.stringify(post),
        headers: {
            "content-type": "application/json"
        }
    })
    .catch(err => {
        throw Error(err);
    });
}

const guardarPublicacionAnclada = (post) => {
    fetch("http://localhost:8080/talk-board/publicacionesV2Servlet?action=crear-post-anclado", {
        method: "POST",
        body: JSON.stringify(post),
        headers: {
            "content-type": "application/json"
        }
    })
    .catch(err => {
        throw Error(err);
    })
}

const presionarBtnGuardarPublicacion = () => {
    confirmarPublicacion(confirm("¿Seguro que quieres crear la publicación?"));
}

window.onload = () => {
    btnGuardarPost.onclick = presionarBtnGuardarPublicacion;
}