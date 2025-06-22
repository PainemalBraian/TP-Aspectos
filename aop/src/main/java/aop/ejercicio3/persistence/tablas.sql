Create database concursos;

use concursos;

-- Crear tabla de concursos
CREATE TABLE concursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear tabla de inscripciones
CREATE TABLE inscripciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    id_concurso INT,
    FOREIGN KEY (id_concurso) REFERENCES concursos(id)
);

-- Insertar concursos
INSERT INTO concursos (nombre) VALUES
('Concurso de Fotografía'),
('Concurso de Pintura'),
('Concurso de Cocina'),
('Concurso de Escritura'),
('Concurso de Baile');

-- Insertar inscripciones
-- Asegúrate de que los IDs coincidan con los concursos ya cargados
INSERT INTO inscripciones (nombre, apellido, dni, telefono, email, id_concurso) VALUES
('Ana', 'Gómez', '12345678', '2991234567', 'ana@example.com', 1),
('Luis', 'Martínez', '23456789', '2997654321', 'luis@example.com', 2),
('Carla', 'López', '34567890', '2999988776', 'carla@example.com', 3),
('Diego', 'Fernández', '45678901', '2991122334', 'diego@example.com', 1);


-- DROP database concursos;
-- select * from inscripciones;
-- select * from concursos;