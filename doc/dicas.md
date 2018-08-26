# Modelo - Criar base SqLite

```

create table usuarios (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(100) NOT NULL,
    version INTEGER NOT NULL
);
insert into usuarios( nome, version ) values ( "ADMIN", 0 );
insert into usuarios( nome, version ) values ( "ANALISTA", 0 );

 -- Empresas --
create table empresas (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    razao_social VARCHAR(250) NOT NULL,
    version INTEGER NOT NULL
);
insert into empresas( razao_social, version ) values ( "EMPRESA MODELO", 0 );

```