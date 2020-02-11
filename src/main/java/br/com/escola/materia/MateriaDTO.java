package br.com.escola.materia;

import javax.validation.constraints.NotNull;

public class MateriaDTO {
    private Long id;
    @NotNull(message = "A diciplina não deve ser nula")
    private String disciplina;

    public MateriaDTO(){
    }

    public MateriaDTO(Long id, String diciplina){
        this.id = id;
        this.disciplina = diciplina;

    }

    public static MateriaDTO of(Materia materia) {
        return new MateriaDTO(
                materia.getId(),
                materia.getDisciplina()

        );

    }

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
                ", diciplina='" + disciplina + '\'' +
                '}';
    }

}
