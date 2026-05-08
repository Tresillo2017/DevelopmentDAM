CREATE DATABASE biblioteca_db;

USE biblioteca_db;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    precio DECIMAL(6,2),
    disponible BOOLEAN
);

INSERT INTO libros (titulo, autor, genero, precio, disponible)
VALUES 
('El Quijote', 'Miguel de Cervantes', 'Novela', 15.50, true),
('La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio', 18.90, true),
('1984', 'George Orwell', 'Ciencia ficción', 12.75, false),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', 20.00, true);

select * from libros;