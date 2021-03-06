DROP DATABASE WDA;
CREATE DATABASE IF NOT EXISTS WDA;

USE WDA;

CREATE TABLE IF NOT EXISTS TB_FUNCIONARIO (

PK_ID BIGINT NOT NULL AUTO_INCREMENT,
NOME  VARCHAR(100),
NRDOC CHAR(30),
TELEFONE VARCHAR(80),
DT_NASCIMENTO DATE NULL,
ENDERECO VARCHAR(120),
BAIRRO VARCHAR(60),
CIDADE VARCHAR(80),
CEP CHAR(9),
EMAIL VARCHAR(150),
SEXO VARCHAR(15),
RE INT(40),
CARGO VARCHAR(80),
SALARIO NUMERIC(13,2),
TG_INATIVO TINYINT DEFAULT 0,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
PRIMARY KEY (PK_ID)
);

CREATE TABLE IF NOT EXISTS TS_LOGIN ( 

PK_ID BIGINT NOT NULL AUTO_INCREMENT,
LOGIN VARCHAR(150),
SENHA VARCHAR(150),
PERMISSAO VARCHAR(60),
FK_FUNCIONARIO BIGINT NOT NULL,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
TG_INATIVO TINYINT DEFAULT 0,
PRIMARY KEY (PK_ID),
FOREIGN KEY (FK_FUNCIONARIO) REFERENCES TB_FUNCIONARIO ( PK_ID )

);


CREATE TABLE IF NOT EXISTS TB_PRODUTO (

PK_ID BIGINT NOT NULL AUTO_INCREMENT,
PRODUTO  VARCHAR(150),
VL_UNITARIO NUMERIC(13,2),
QUANTIDADE INTEGER,
IMAGEM VARCHAR (50),
TG_INATIVO TINYINT DEFAULT 0,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
PRIMARY KEY (PK_ID)
);

CREATE TABLE IF NOT EXISTS TB_TIPOPAGAMENTO (
PK_ID BIGINT NOT NULL AUTO_INCREMENT,
TIPOPAGAMENTO VARCHAR(80),
TG_INATIVO TINYINT DEFAULT 0,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
PRIMARY KEY (PK_ID)
);

CREATE TABLE IF NOT EXISTS TB_VENDA (
    
PK_ID BIGINT NOT NULL AUTO_INCREMENT,
FK_CAIXA BIGINT NOT NULL,
FK_TIPOPAGAMENTO BIGINT NOT NULL,
VL_TOTAL NUMERIC(13,2),
QUANTIDADE NUMERIC(6),
TAXAJUROS NUMERIC(10),
NR_PARCELAS INTEGER,
TG_INATIVO TINYINT DEFAULT 0,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
PRIMARY KEY (PK_ID),
FOREIGN KEY (FK_CAIXA) REFERENCES TS_LOGIN (PK_ID),
FOREIGN KEY (FK_TIPOPAGAMENTO)REFERENCES TB_TIPOPAGAMENTO (PK_ID)
);

CREATE TABLE IF NOT EXISTS TB_ITEMVENDA (

PK_ID BIGINT NOT NULL AUTO_INCREMENT,
FK_VENDA BIGINT NOT NULL,
FK_PRODUTO BIGINT NOT NULL,
TG_INATIVO TINYINT,
DH_INCLUSAO DATETIME,
DH_ALTERACAO DATETIME,
PRIMARY KEY (PK_ID),
FOREIGN KEY (FK_VENDA) REFERENCES TB_VENDA (PK_ID),
FOREIGN KEY (FK_PRODUTO) REFERENCES TB_PRODUTO (PK_ID)

);

INSERT INTO TB_TIPOPAGAMENTO (TIPOPAGAMENTO, DH_INCLUSAO)
VALUES('DINHEIRO', NOW());

INSERT INTO TB_TIPOPAGAMENTO (TIPOPAGAMENTO, DH_INCLUSAO)
VALUES('CARTÃO DE CRÉDITO', NOW());

INSERT INTO TB_TIPOPAGAMENTO (TIPOPAGAMENTO, DH_INCLUSAO)
VALUES('CARTÃO DE DÉBITO', NOW());

INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE, IMAGEM, TG_INATIVO, DH_INCLUSAO)
VALUES ("CENOURA",3.60,500,"cenoura.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("MORTADELA",2.50,500,"mortadela.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("LEITE",4.50,500,"leite.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("QUEIJO",2.50,500,"queijo.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("MACARRÃO",6.50,500,"macarrao.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("FARINHA",2.50,500,"farinha.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("BOLACHA",1.50,500,"bolacha.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("SALGADINHO",1.50,500,"salgadinho.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("TOALHA DE PAPEL",3.50,500,"toalha-papel.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("SABÃO EM PÓ",7.50,500,"sabao-po.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("VASSOURA",6.50,500,"vassoura.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("LAMINA DE BARBEAR",6.50,500,"lamina-barbear.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("ESCOVA DE DENTES",6.50,500,"escova-dentes.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("SALSICHA",6.50,500,"salsicha.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("CARNE",6.50,500,"carne.png",0,NOW());
INSERT INTO TB_PRODUTO (PRODUTO, VL_UNITARIO, QUANTIDADE,IMAGEM,TG_INATIVO, DH_INCLUSAO)
VALUES ("BANANA",6.50,500,"banana.png",0,NOW());

INSERT INTO TB_VENDA (FK_CAIXA,FK_TIPOPAGAMENTO,VL_TOTAL,DH_INCLUSAO)
VALUES(1,1,32.50,CAST('2018-11-04 19:00:00'AS DATETIME));
INSERT INTO TB_VENDA (FK_CAIXA,FK_TIPOPAGAMENTO,VL_TOTAL,DH_INCLUSAO)
VALUES(1,1,18,CAST('2018-11-20 19:00:00'AS DATETIME));
INSERT INTO TB_VENDA (FK_CAIXA,FK_TIPOPAGAMENTO,VL_TOTAL,DH_INCLUSAO)
VALUES(1,1,10.80,CAST('2018-11-30 19:00:00'AS DATETIME));
INSERT INTO TB_VENDA (FK_CAIXA,FK_TIPOPAGAMENTO,VL_TOTAL,DH_INCLUSAO)
VALUES(1,1,15,CAST('2018-11-15 19:00:00'AS DATETIME));
INSERT INTO TB_VENDA (FK_CAIXA,FK_TIPOPAGAMENTO,VL_TOTAL,DH_INCLUSAO)
VALUES(1,1,15,CAST('2018-11-25 19:00:00'AS DATETIME));

INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(1,16,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(1,16,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(1,16,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(1,16,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(1,16,0,NOW());

INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(2,3,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(2,3,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(2,3,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(2,3,0,NOW());


INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(3,1,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(3,1,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(3,1,0,NOW());

INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(4,6,0,NOW());


INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());
INSERT INTO TB_ITEMVENDA (FK_VENDA,FK_PRODUTO,TG_INATIVO,DH_INCLUSAO)
VALUES(5,4,0,NOW());



INSERT INTO TB_FUNCIONARIO
(NOME,NRDOC,TELEFONE,DT_NASCIMENTO,ENDERECO,BAIRRO,CIDADE,CEP,EMAIL,SEXO,CARGO,DH_INCLUSAO)
VALUES
('DIRETOR','36227199079','5555-5555','1996/01/06','ENDERECO 1','BAIRRO 1','CIDADE 1','CEP 1','EMAIL 1','MASCULINO','DIRETOR',NOW());

INSERT INTO TS_LOGIN
(LOGIN,SENHA,PERMISSAO,FK_FUNCIONARIO,TG_INATIVO,DH_INCLUSAO)
VALUES ('DIRETOR','12345','GERENTE',1,0,NOW());

