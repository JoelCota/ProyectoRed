
//Esta funcion debe regresar true o false, para validar si la cadena está vacía
function isStringEmpty(parameter) {
    try {

        if (typeof (parameter) !== 'string') {
            //El parametro debe ser string
            throw Error('Solo pueden validarse mensajes');
        }

        //Regresa verdadero si la cadena está vacía, false en caso contrario
        return (typeof parameter == 'string' && parameter.trim().length == 0);
    } catch (error) {
        console.log(error);
    }
}

//Se espera recibir un post (publicación)
function validarCrearPost(post) {

    let errores = [];

    //Se valida que contenga título
    const titulo = post.titulo;

    if (isStringEmpty(titulo)) {
        //El título está vacío
        errores.push("El título está vacío");
    }

    //Validar contenido del post
    const contenido = post.contenido;

    if (isStringEmpty(contenido)) {
        //El contenido está vacío
        errores.push("El contenido del post está vacío");
    }

    if (errores.length > 0) {

        let mensajeError = "Valores inválidos\n";

        for (let i = 0; i < errores.length; i++) {
            mensajeError += " -" + errores[i] + "\n";
        }

        alert(mensajeError);
    }
}

window.onload = function () {


    //Funcion que crea el post
    const crearPost = () => {

        const titulo = document.getElementById("titulo").value;
        const contenido = document.getElementById("contenido").value;

        console.log(typeof (titulo));

        const post = {
            titulo,
            contenido
        };

        validarCrearPost(post);
        //Enviar datos al server con fetchapi
        console.table(post);
    };

    function mostrarAlerta() {
        alert('alerta');
    }

    const crearPostButton = document.getElementById("crear-post-button");

    crearPostButton.onclick = crearPost;
}
