package br.com.escola.materia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepository extends JpaRepository <Materia, Long> {
}
