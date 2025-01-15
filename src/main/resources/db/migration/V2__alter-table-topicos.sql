ALTER TABLE Topico
    CHANGE COLUMN dataCriacao data_criacao DATETIME NOT NULL,
    CHANGE COLUMN statusTopico status_topico VARCHAR(255) NOT NULL;