export class Usuario {
    contructor(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, contrasena, municipio, postComun) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.imagenUsuario = imagenUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.contrasena = contrasena;
        this.municipio = municipio;
        this.postComun = postComun;
    }
}

export class Administrador extends Usuario {
    constructor(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, contrasena, municipio, postComun, listaPostAnlcados) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, contrasena, municipio, postComun);
        this.listaPostAnlcados = listaPostAnlcados;
    }
}