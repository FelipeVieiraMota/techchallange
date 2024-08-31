
-- Postgres database --

-- Limpar a base de dados
drop table  empresa;
drop table  candidato;
drop table  vagas;
drop table  candidaturas;

commit;

-- Executar essas queries antes de subir a API
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

commit;
---------------------------------


-- Todas as empresas que pagam acima de 8000 por vaga
select 
	e.id_empresa, 
	e.razao_social as "Razão Social", 
	v.titulo as "Vaga", 
	v.salario as "Salario", 
	TO_CHAR(v.data_publicacao, 'dd/MM/YYYY') as "Publicação",
	TO_CHAR(v.data_expiracao, 'dd/MM/YYYY') as "Expiracão"
from vagas v 
	join empresa e on v.empresa_id = e.id_empresa
where salario > 8000
order by v.salario desc;
------------------------------------------------------------------------


select 
	e.id_empresa as "Numero de identificação por empresa",
	e.razao_social as "Razão Social da empresa",
	v.id_vaga as "Numero de identificação por vaga",
	v.titulo 
from empresa e 
	join vagas v on e.id_empresa = v.empresa_id
group by e.id_empresa, v.id_vaga
order by 
	e.id_empresa desc,
	v.id_vaga desc

------------------------------------------------------------------------

select 
	count(v.id_vaga) as "Quantidade de vagas em aberto por empresa", 
	e.id_empresa as "Numero de identificação por empresa",
	e.razao_social as "Razão Social da empresa"
from empresa e 
	join vagas v on e.id_empresa = v.empresa_id
group by e.id_empresa
order by 
	count(e.id_empresa) desc, 
	e.id_empresa desc

