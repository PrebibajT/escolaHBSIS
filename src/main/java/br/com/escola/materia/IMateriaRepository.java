package br.com.escola.materia;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IMateriaRepository extends JpaRepository <Materia, Long> {

    List<Materia> findAll ();
}
