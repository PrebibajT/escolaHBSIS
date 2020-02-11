package br.com.escola.notas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface INotasRepository extends JpaRepository <Notas, Long> {
}
