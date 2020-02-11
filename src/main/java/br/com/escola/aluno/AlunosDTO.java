package br.com.escola.aluno;

import javax.validation.constraints.NotNull;

public class AlunosDTO {
    private Long id;
    @NotNull(message = "nome não deve ser nulo")
    private String nome;

    public AlunosDTO() {

    }

    public AlunosDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static AlunosDTO of(Alunos alunos) {
        return new AlunosDTO(
                alunos.getId(),
                alunos.getNome()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

