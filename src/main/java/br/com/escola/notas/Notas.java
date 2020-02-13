package br.com.escola.notas;

import br.com.escola.aluno.Alunos;
import br.com.escola.materia.Materia;

import javax.persistence.*;

@Entity
@Table(name = "seg_notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_materia", referencedColumnName="id")
    private Materia materia;

    @ManyToOne
    @JoinColumn (name = "id_aluno", referencedColumnName="id")
    private Alunos aluno;

    @Column(name = "nota_1", nullable = false)
    private Double nota1;

    @Column(name = "nota_2", nullable = false )
    private Double nota2;

    @Column(name = "nota_3", nullable = false)
    private Double nota3;

    @Column(name = "media" , nullable = false)
    private Double media;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
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
                ", materia=" + materia +
                ", aluno=" + aluno +
                ", nota_1=" + nota1 +
                ", nota_2=" + nota2 +
                ", nota_3=" + nota3 +
                ", media="  + media +
                '}';
    }
}
