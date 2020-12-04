CREATE TABLE IF NOT EXISTS "usuarios" (
	documento VARCHAR(50) NOT NULL,
	nombres VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	correo VARCHAR(50)NOT NULL,
	telefono INT NOT NULL,
	rol VARCHAR(30) NOT NULL,
	estado VARCHAR(30)NOT NULL,
	contraseña VARCHAR(30) NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "laboratorios" (
	idlaboratorio SERIAL PRIMARY KEY,
	nombre VARCHAR(30)NOT NULL,
	informacion VARCHAR(100)NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "equipos"(
	idEquipo SERIAL PRIMARY KEY,
	ip VARCHAR(30)NOT NULL,
	informacion VARCHAR(100)NOT NULL,
	activo BOOLEAN NOT NULL,
	laboratorio INT
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "elementos"(
	idElemento SERIAL PRIMARY KEY,
	tipo VARCHAR(30)NOT NULL,
	marca VARCHAR(30)NOT NULL,
	activo BOOLEAN NOT NULL,
	equipo INT
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "novedades"(
	idNovedad SERIAL PRIMARY KEY,
	fecha DATE NOT NULL,
	titulo VARCHAR(20)NOT NULL,
	detalle VARCHAR(100) NOT NULL,
	responsable VARCHAR(50),
	equipo INT,
	elemento INT,
	laboratorio INT
);

---------------------------------------------------------------------
ALTER TABLE "usuarios" ADD CONSTRAINT PK_Personal PRIMARY KEY(documento);
---------------------------------------------------------------------
ALTER TABLE "usuarios" ADD CONSTRAINT UK_Personal UNIQUE (correo,telefono);
ALTER TABLE "equipos" ADD CONSTRAINT UK_Equipos UNIQUE (ip);
---------------------------------------------------------------------
ALTER TABLE "novedades" ADD CONSTRAINT FK_Novedades_Per FOREIGN KEY(responsable) REFERENCES "usuarios"(documento);
ALTER TABLE "equipos" ADD CONSTRAINT FK_Equipos_Lab FOREIGN KEY(laboratorio) REFERENCES "laboratorios"(idLaboratorio);
ALTER TABLE "elementos" ADD CONSTRAINT FK_elementos_Eq FOREIGN KEY(equipo) REFERENCES "equipos"(idEquipo);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_Eq FOREIGN KEY(equipo) REFERENCES "equipos"(idEquipo);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_elem FOREIGN KEY(elemento) REFERENCES "elementos"(idElemento);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_Lab FOREIGN KEY(laboratorio) REFERENCES "laboratorios"(idLaboratorio);
------------------------------------------------------------------------