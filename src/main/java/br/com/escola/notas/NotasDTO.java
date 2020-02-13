package br.com.escola.notas;

import javax.validation.constraints.NotNull;

public class NotasDTO {
    private Long id;
    @NotNull(message = "O id da matéria não deve ser nula")
    private Long idMateria;
    @NotNull(message = "O id do aluno não deve ser nula")
    private Long idAluno;
    @NotNull(message = "A primeira nota não deve ser nula")
    private Double nota1;
    @NotNull(message = "A segunda nota não deve ser nula")
    private Double nota2;
    @NotNull(message = "A terceira nota não deve ser nula")
    private Double nota3;
    @NotNull(message = "A media nota não deve ser nula")
    private Double media;

    public NotasDTO() {

    }

    public NotasDTO(Long id, Long idMateria, Long idAluno, Double nota1, Double nota2, Double nota3, Double media) {
        this.id = id;
        this.idMateria = idMateria;
        this.idAluno = idAluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public static NotasDTO of (Notas notas){
        return new NotasDTO(
                notas.getId(),
                notas.getMateria().getId(),
                notas.getAluno().getId(),
                notas.getNota1(),
                notas.getNota2(),
                notas.getNota3(),
                notas.getMedia()
        );

    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", materia=" + idMateria +
                ", aluno=" + idAluno +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", media=" + media +
                '}';
    }

}
