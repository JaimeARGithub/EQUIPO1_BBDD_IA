--SCRIPT DE CREACI�N DE TABLAS
CREATE TABLE TIPOS(
    IdTipo NUMBER(2) NOT NULL,
    Tipo VARCHAR2(50),
    Descripcion VARCHAR2(300),
    CONSTRAINT PK_TIPOS PRIMARY KEY(IdTipo)
);

CREATE TABLE IAS(
    IdIA NUMBER(3) NOT NULL,
    Nombre VARCHAR2(50),
    Modelo VARCHAR2(50),
    Usos NUMBER(3),
    Popularidad VARCHAR2(30),
    IdTipo NUMBER(2),
    CONSTRAINT PK_IAS PRIMARY KEY(IdIA),
    CONSTRAINT FK_IDTIPO FOREIGN KEY(IdTipo) REFERENCES TIPOS(IdTipo)
);

CREATE TABLE PROMPTS(
    IdPrompt NUMBER(3) NOT NULL,
    Texto VARCHAR2(500),
    CONSTRAINT PK_PROMPTS PRIMARY KEY(IdPrompt)
);

CREATE TABLE IAS_PROMPTS(
    IdRegistro NUMBER(5) NOT NULL,
    IdIA NUMBER(3),
    IdPrompt NUMBER(3),
    CONSTRAINT PK_IAS_PROMPTS PRIMARY KEY(IdRegistro),
    CONSTRAINT FK_IDIA FOREIGN KEY(IdIA) REFERENCES IAS(IdIA),
    CONSTRAINT FK_IDPROMPT FOREIGN KEY(IdPrompt) REFERENCES PROMPTS(IdPrompt)
);
/