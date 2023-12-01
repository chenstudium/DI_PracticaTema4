-- Crear la BD
CREATE DATABASE tiendecitakc
CHARSET utf8mb4
COLLATE utf8mb4_spanish2_ci;
-- Activar la nueva BD
USE tiendecitakc;
-- Crear la Tabla artículos
CREATE TABLE articulos (
    idArticulo INT AUTO_INCREMENT,
    descripcionArticulo VARCHAR(50),
    precioArticulo DECIMAL(10 , 2 ),
    cantidadArticulo INT,
    PRIMARY KEY (idArticulo)
);
-- Tickets
CREATE TABLE tickets (
    idTicket INT AUTO_INCREMENT,
    fechaTicket DATE,
    totalTicket DECIMAL(10 , 2 ),
    PRIMARY KEY (idTicket)
);
-- LineaTickets
CREATE TABLE lineastickets (
    idLineaTicket INT AUTO_INCREMENT,
    idTicketFK INT,
    idArticuloFK INT,
    cantidad INT,
    PRIMARY KEY (idLineaTicket),
    FOREIGN KEY (idTicketFK)
        REFERENCES tickets (idTicket),
    FOREIGN KEY (idArticuloFK)
        REFERENCES articulos (idArticulo)
);
SELECT * FROM articulos;
SELECT * FROM tickets;
SELECT * FROM lineastickets;