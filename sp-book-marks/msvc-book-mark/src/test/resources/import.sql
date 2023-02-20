INSERT INTO categorias(nombre, descripcion) VALUES ('HISTORIA','Libros sobre Historia');
INSERT INTO categorias(nombre, descripcion) VALUES ('NOVELA','Novelas historicas, psicologicas, politicas');
INSERT INTO categorias(nombre, descripcion) VALUES ('PSICOLOGIA','Libros de Psicología');
INSERT INTO categorias(nombre, descripcion) VALUES ('FILOSOFIA','Libros de Filosofía');
INSERT INTO categorias(nombre, descripcion) VALUES ('POLITICA','Libros de Política');

INSERT INTO autores(nombre, apellido) VALUES ('ARTURO', 'PEREZ REVERTE');
INSERT INTO autores(nombre, apellido) VALUES ('ANABEL', 'HERNANDEZ');
INSERT INTO autores(nombre, apellido) VALUES ('SANTIAGO', 'POSTEGUILLO');
INSERT INTO autores(nombre, apellido) VALUES ('GEORGE', 'ORWEL');
INSERT INTO autores(nombre, apellido) VALUES ('JUAN SOTO', 'IVARS');
INSERT INTO autores(nombre, apellido) VALUES ('PIO', 'MOA');

INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('LOS ASESINOS DEL EMPERADOR', 'Trilogia de Trajano Volumen I', now(), 2, 3);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('CIRCO MAXIMO', 'Trilogia de Trajano Volumen II', now(), 2, 3);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('NADIE SE VA A REIR', 'La increible historia de un juicio a la ironia', now(), 5, 5);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('1984', 'La increible historia de un juicio pais futurista reinado por el comunismo', now(), 2, 4);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('EL CAPITAN ALATRISTE', 'Las aventuras del capitan alatriste Volumen I', now(), 2, 1);
