CREATE TABLE empresas (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          cuit VARCHAR(255) DEFAULT NULL,
                          fecha_adhesion DATETIME(6) DEFAULT NULL,
                          razon_social VARCHAR(255) DEFAULT NULL,
                          status BOOLEAN DEFAULT NULL,
                          PRIMARY KEY (id)
);

CREATE TABLE transferencias (
                                id INT NOT NULL AUTO_INCREMENT,
                                cuenta_credito VARCHAR(255) DEFAULT NULL,
                                cuenta_debito VARCHAR(255) DEFAULT NULL,
                                fecha_creacion DATETIME(6) DEFAULT NULL,
                                id_empresa BIGINT DEFAULT NULL,
                                PRIMARY KEY (id)
);