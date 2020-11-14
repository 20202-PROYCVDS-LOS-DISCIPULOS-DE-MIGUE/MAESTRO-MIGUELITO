CREATE TABLE IF NOT EXISTS "usuarios" (
	documento INT NOT NULL,
	nombres VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	correo VARCHAR(50)NOT NULL,
	telefono INT NOT NULL,
	rol VARCHAR(30) NOT NULL,
	estado VARCHAR(30)NOT NULL,
	constraseña VARCHAR(30) NOT NULL,
	laboratorioAsignado INT NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "laboratorios" (
	idLaboratorio INT NOT NULL,
	nombre VARCHAR(30)NOT NULL,
	cantidadEquipos INT NOT NULL,
	informacion VARCHAR(100)NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "equipos"(
	idEquipo INT NOT NULL,
	ip VARCHAR(30)NOT NULL,
	informacion VARCHAR(100)NOT NULL,
	activo BOOLEAN NOT NULL,
	laboratorio INT NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "elementos"(
	idElemento INT NOT NULL,
	tipo VARCHAR(30)NOT NULL,
	marca VARCHAR(30)NOT NULL,
	activo BOOLEAN NOT NULL,
	Equipo INT NOT NULL
);
---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "novedades"(
	idNovedad INT NOT NULL,
	fecha DATE NOT NULL,
	titulo VARCHAR(20)NOT NULL,
	detalle VARCHAR(100) NOT NULL,
	responsable INT NOT NULL,
	Registro INT NOT NULL
);

---------------------------------------------------------------------
ALTER TABLE "usuarios" ADD CONSTRAINT PK_Personal PRIMARY KEY(documento);
ALTER TABLE "laboratorios" ADD CONSTRAINT PK_Laboratorios PRIMARY KEY(idLaboratorio);
ALTER TABLE "equipos" ADD CONSTRAINT PK_Equipos PRIMARY KEY(IdEquipo);
ALTER TABLE "elementos" ADD CONSTRAINT PK_Elementos PRIMARY KEY(IdElemento);
ALTER TABLE "novedades" ADD CONSTRAINT PK_Novedades PRIMARY KEY(IdNovedad);
---------------------------------------------------------------------
ALTER TABLE "usuarios" ADD CONSTRAINT UK_Personal UNIQUE (Correo,Telefono);
ALTER TABLE "equipos" ADD CONSTRAINT UK_Equipos UNIQUE (Ip);
---------------------------------------------------------------------
ALTER TABLE "novedades" ADD CONSTRAINT FK_Novedades_Per FOREIGN KEY(responsable) REFERENCES "usuarios"(documento);
ALTER TABLE "usuarios" ADD CONSTRAINT FK_Personal_Lab FOREIGN KEY(laboratorioAsignado) REFERENCES "laboratorios"(idLaboratorio);
ALTER TABLE "equipos" ADD CONSTRAINT FK_Equipos_Lab FOREIGN KEY(Laboratorio) REFERENCES "laboratorios"(idLaboratorio);
ALTER TABLE "elementos" ADD CONSTRAINT FK_elementos_Eq FOREIGN KEY(equipo) REFERENCES "equipos"(idEquipo);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_Eq FOREIGN KEY(registro) REFERENCES "equipos"(idEquipo);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_elem FOREIGN KEY(registro) REFERENCES "elementos"(idElemento);
ALTER TABLE "novedades" ADD CONSTRAINT FK_novedades_Lab FOREIGN KEY(registro) REFERENCES "laboratorios"(idLaboratorio);