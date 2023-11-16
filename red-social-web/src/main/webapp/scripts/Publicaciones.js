export class Post {
    constructor(id, fechaCreacion, contenido, titulo, fechaEdicion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
        this.titulo = titulo;
        this.fechaEdicion = fechaEdicion;
    }
}

export class Comun extends Post {
    constructor(id, fechaCreacion, contenido, titulo, fechaEdicion, comentarios) {
        super(id, fechaCreacion, contenido, titulo, fechaEdicion);
        this.comentarios = comentarios;
        this.usuario = usuario;
    }
}

export class Anclado extends Post {
    constructor(id, fechaCreacion, contenido, titulo, fechaEdicion, administrador) {
        super(id, fechaCreacion, contenido, titulo, fechaEdicion);
        this.administrador = administrador;
    }
}