create table seg_notas
(

  id          BIGINT  IDENTITY (1, 1) PRIMARY KEY     NOT NULL,
  id_materia  BIGINT    FOREIGN KEY REFERENCES seg_materia(id),
  id_aluno    BIGINT     FOREIGN KEY REFERENCES seg_alunos(id),
  nota_1      DECIMAL(8,2)                            NOT NULL,
  nota_2      DECIMAL(8,2)                            NOT NULL,
  nota_3      DECIMAL(8,2)                            NOT NULL


)