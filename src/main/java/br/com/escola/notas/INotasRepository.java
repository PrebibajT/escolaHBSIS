package br.com.escola.notas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotasRepository extends JpaRepository <Notas, Long> {

  @Query(value = "SELECT * FROM seg_notas WHERE id_aluno = :idAluno", nativeQuery = true)
  List<Notas> findByIdAluno(
          @Param("idAluno") Long idAluno

  );


}
