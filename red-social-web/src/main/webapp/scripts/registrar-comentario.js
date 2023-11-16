

//Esto sucederá después de que cargue el dom.
window.onunload = function () {

    const extraerNumeroDeCadena = (cadena) => Number(cadena.match(/\d+/g)[0]);
    const opcionesRespuesta = document.querySelector('.btn-enviar-comentario');

//    let formComentario = document.getElementById("comentarioForm");
//
//    formComentario.addEventListener('submit', function (e) {
//        //Evita que el formulario se envíe de manera predeterminada
//        e.preventDefault();
//
//        //Realiza una paetición ajax
//        fetch('/posts', {
//            method: 'POST',
//            body: new FormData(formComentario)
//        })
//            //Esto sucederá después 
//            .then(function (response) {
//                return response.json(); //Parsear la respuesta a JSON
//            })
//            .then(function (data) {
//                //Redirigir a la página deseada
//                window.location.href = data.redirectUrl;
//            }).catch(function (error) {
//                throw Error(error);
//            });
//    });

    opcionesRespuesta.forEach(function (opcion) {
        const btnElement = opcion.querySelector('button');

        opcion.addEventListener('click', function () {
            const btnId = btnElement.id;

            console.log(extraerNumeroDeCadena(btnId));

        });
    });

};