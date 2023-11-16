function eliminarDiv(idPostEliminado) { //Cambiar Nombre
    confirmarEliminar(confirm("¿Seguro que quieres eliminar la publicación?"), idPostEliminado);
}
const confirmarEliminar = (confirmacion, idPostEliminado) => {
    const div = document.getElementById("Post-" + idPostEliminado);

    if (confirmacion) {
        try {
            if (eliminarPost(idPostEliminado)) {
                try {
                    if (div) {
                        div.parentNode.removeChild(div);
                    }
                } catch (err) {
                    alert(err);
                }
            }else{
                alert("No se pudo eliminar");
            }
        } catch (err) {
            alert(err);
        }
    }
}
function eliminarPost(idElemento) {
    const postEliminado = {
        idElemento
    };
    console.log(JSON.stringify(postEliminado));
    fetch("http://localhost:8080/talk-board/publicacionesV2Servlet?action=eliminar-post-comun", {
        method: "POST",
        body: JSON.stringify(postEliminado),
        headers: {
            "content-type": "application/json"
        }
    }).catch(err => {
        alert("Error al eliminar la publicacion");
    })
    return true;

}


