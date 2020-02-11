package br.com.escola.aluno;

import org.hibernate.mapping.UnionSubclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IAlunosRepository extends JpaRepository <Alunos, Long> {
}
