
CREATE TABLE empresas (
    id_empresa SERIAL PRIMARY key,
    razao_social VARCHAR(255) NOT NULL,
    cnpj VARCHAR(20) NOT NULL UNIQUE,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE vagas (
    id_vaga SERIAL PRIMARY key,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    salario DECIMAL(10, 2),
    data_publicacao DATE NOT NULL,
    data_expiracao DATE,
    empresa_id INT,
    FOREIGN KEY (empresa_id) REFERENCES empresas(id_empresa)
);

CREATE TABLE candidatos (
    id_candidato SERIAL PRIMARY key,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    data_nascimento DATE,
    experiencia TEXT
);

CREATE TABLE candidaturas (
    id_candidatura SERIAL PRIMARY key,
    candidato_id INT,
    vaga_id INT,
    data_candidatura DATE NOT NULL,
    status VARCHAR(50),
    FOREIGN KEY (candidato_id) REFERENCES candidatos(id_candidato),
    FOREIGN KEY (vaga_id) REFERENCES vagas(id_vaga)
);


drop table  empresas;
drop table  candidatos;
drop table  vagas;
drop table  candidaturas;

commit;


INSERT INTO empresas (razao_social, cnpj, endereco, telefone, email)
VALUES ('Empresa Exemplo', '12.345.678/0001-99', 'Rua Exemplo, 123', '(11) 98765-4321', 'contato@empresaexemplo.com');

INSERT INTO vagas (titulo, descricao, salario, data_publicacao, data_expiracao, empresa_id)
VALUES ('Desenvolvedor Backend', 'Trabalhar com desenvolvimento de APIs', 5000.00, '2024-08-01', '2024-09-01', 1);

INSERT INTO candidatos (nome, cpf, email, telefone, endereco, data_nascimento, experiencia)
VALUES ('João Silva', '123.456.789-10', 'joao.silva@email.com', '(11) 91234-5678', 'Rua dos Desenvolvedores, 456', '1990-05-15', '3 anos de experiência em desenvolvimento web');

INSERT INTO candidaturas (candidato_id, vaga_id, data_candidatura, status)
VALUES (1, 1, '2024-08-01', 'Pendente');



select * from  empresas;
select * from  candidatos;
select * from  vagas;
select * from  candidaturas;