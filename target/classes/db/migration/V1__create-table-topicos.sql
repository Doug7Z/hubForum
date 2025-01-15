CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    dataCriacao DATETIME NOT NULL,
    statusTopico VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL
);
