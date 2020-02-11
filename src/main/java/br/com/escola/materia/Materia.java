package br.com.escola.materia;

import javax.persistence.*;

@Entity
@Table(name = "seg_materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "disciplina", nullable = false, length = 150)
    private String disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }

}
