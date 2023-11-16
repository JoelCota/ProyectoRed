window.onload = function(){

    function obtenerDatosBuscador(){
        
        const inputBuscador = document.getElementById("buscador-input");
        
        const valueBuscador = inputBuscador.value;
        
        console.log(valueBuscador);
        
    }

    const btnBuscar = document.getElementById("buscador-button");
    
    btnBuscar.onclick = obtenerDatosBuscador;
    
    

}