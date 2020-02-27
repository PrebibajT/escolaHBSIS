package br.com.escola.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IAlunosRepository extends JpaRepository <Alunos, Long> {

    List<Alunos> findAll ();
}
