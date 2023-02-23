INSERT INTO categorias(nombre, descripcion) VALUES ('HISTORIA','Libros sobre Historia');
INSERT INTO categorias(nombre, descripcion) VALUES ('NOVELA','Novelas historicas, psicologicas, politicas');
INSERT INTO categorias(nombre, descripcion) VALUES ('PSICOLOGIA','Libros de Psicología');
INSERT INTO categorias(nombre, descripcion) VALUES ('FILOSOFIA','Libros de Filosofía');
INSERT INTO categorias(nombre, descripcion) VALUES ('POLITICA','Libros de Política');
INSERT INTO categorias(nombre, descripcion) VALUES ('ESOTERISMO','Libros sobre esoterismo, religión, teología');

INSERT INTO autores(nombre, apellido) VALUES ('ARTURO', 'PEREZ REVERTE');
INSERT INTO autores(nombre, apellido) VALUES ('ANABEL', 'HERNANDEZ');
INSERT INTO autores(nombre, apellido) VALUES ('SANTIAGO', 'POSTEGUILLO');
INSERT INTO autores(nombre, apellido) VALUES ('GEORGE', 'ORWEL');
INSERT INTO autores(nombre, apellido) VALUES ('JUAN SOTO', 'IVARS');
INSERT INTO autores(nombre, apellido) VALUES ('PIO', 'MOA');
INSERT INTO autores(nombre, apellido) VALUES ('JONATHAN', 'BLACK');
INSERT INTO autores(nombre, apellido) VALUES ('JACOB', 'BOEHME');
INSERT INTO autores(nombre, apellido) VALUES ('ARTHUR', 'SCHOPENHAUER');
INSERT INTO autores(nombre, apellido) VALUES ('DAVID', 'HUME');
INSERT INTO autores(nombre, apellido) VALUES ('JON', 'KABAT-ZIN');
INSERT INTO autores(nombre, apellido) VALUES ('ALVIN', 'MONTAÑEZ SCHILANSKY');

INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('LOS ASESINOS DEL EMPERADOR', 'Trilogia de Trajano Volumen I', now(), 2, 3);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('CIRCO MAXIMO', 'Trilogia de Trajano Volumen II', now(), 2, 3);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('NADIE SE VA A REIR', 'La increible historia de un juicio a la ironia', now(), 5, 5);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('1984', 'La increible historia de un juicio pais futurista reinado por el comunismo', now(), 2, 4);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('EL CAPITAN ALATRISTE', 'Las aventuras del capitan alatriste Volumen I', now(), 2, 1);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('LA HISTORIA SECRETA DEL MUNDO', 'El mundo que nos rodea, los edificios, monumentos, las obras de arte , la literatura, los nombres de los dias de la semana, y hasta los cuentos infantiles encierran una filosofia secreta. Este libros nos da las claves para interpretarla', now(), 6, 7);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('LA LEGION PERDIDA', 'Trilogia de Trajano Volumen III', now(), 2, 3);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('TRATADO CIELO E INVIERNO', 'Tratado sobre el cielo y el infierno', now(), 6, 8);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('ARTE CONOCERTE A SI MISMO', 'El arte de conocerce a sí mismo', now(), 4, 9);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('SOBRE EL CONOCIMIENTO HUMANO', 'Investigación sobre el conocimiento humano', now(), 4, 10);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('SOBRE PRINCIPIO DE LA MORAL', 'Investigación sobre los principios de la moral', now(), 4, 10);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('MINDFULNESS PRINCIPIANTES', 'Mindfulness para principiantes', now(), 4, 11);
INSERT INTO libros (nombre, descripcion, create_at, categoria_id, autor_id) VALUES ('TEMPLO DE LA HUMANIDAD', 'Las Altas enseñanzas de la masoneria', now(), 6, 12);

INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('EL GUARDIAN DEL RIN', '1', 'Dos meses antes del día marcado para el asesinato del emperador Domiciano', 1);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('EL ASCO', '2', '18 de julio de 96dc hora prima', 1);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('LA VOZ DE LA EXPERIENCIA', '3', 'Moguntiacum, Germania Superior', 1);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('UNA PETICION DESESPERADA', '1', 'Febrero 101dc', 2);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('UNA MISION IMPOSIBLE', '2', 'Febrero 101dc', 2);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('EL DESTIERRO DE UN SENADOR', '3', 'Moseia Inferior', 2);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('INTRODUCCION', '0', 'Introducción', 6);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('EN EL PRINCIPIO' , '1', 'Dios observa atentamente su reflejo. El universo a través del espejo', 6);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('CORTO PASEO POR LOS BOSQUES DE LA ANTIGUEDAD', '2', 'Pongamos en la mente de los pobladores del pasado.', 6);
INSERT INTO capitulos(nombre, numero, descripcion, libro_id) VALUES ('EL JARDIN DE EDEN', '3', 'El cógido del Génesis. Entra en escena el señor de las tinieblas. El humano vegetal', 6);

INSERT INTO citas_libros(descripcion, create_at, pagina, libro_id) VALUES ('El Cita de Jung', now(), '65', 6);

INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Rarezas', '13', 'Rarezas', 7);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Doctrinas Secretas', '15, 16', 'Doctrinas Secretas', 7);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Experimento del gato de shrodinger', '31', 'Experimento del gato de shrodinger', 8);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Sobre los efectos psicosomáticos', '32', 'Sobre los efectos psicosomáticos', 8);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Sobre el bioritmo', '51', 'Sobre el bioritmo', 9);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Sobre el hombre antiguo', '56', 'Sobre el hombre antiguo', 9);
INSERT INTO marcas_libros(descripcion, paginas, resumen, capitulo_id) VALUES ('Conciencia Mental', '57', 'Conciencia Mental', 9);