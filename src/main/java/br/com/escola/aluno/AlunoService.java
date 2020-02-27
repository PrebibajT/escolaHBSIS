package br.com.escola.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);

    private final IAlunosRepository iAlunosRepository;

    public AlunoService(IAlunosRepository iAlunosRepository) {
        this.iAlunosRepository = iAlunosRepository;
    }

    public AlunosDTO save(AlunosDTO alunosDTO) {
        LOGGER.info("Salvando aluno");
        LOGGER.debug("Aluno: {}", alunosDTO);

        Alunos alunos = new Alunos();

        alunos.setNome(alunosDTO.getNome());

        alunos = this.iAlunosRepository.save(alunos);

        return AlunosDTO.of(alunos);
    }


    public Alunos findById(Long id) {
        Optional<Alunos> alunosOptional = this.iAlunosRepository.findById(id);

        if (alunosOptional.isPresent()) {
            return alunosOptional.get();
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public AlunosDTO findByIdAluno(Long id) {
        Optional<Alunos> alunosOptional = this.iAlunosRepository.findById(id);

        if (alunosOptional.isPresent()) {
            return AlunosDTO.of(alunosOptional.get());
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public AlunosDTO update(AlunosDTO alunosDTO, Long id) {
        Optional<Alunos> alunosOptional = this.iAlunosRepository.findById(id);

        if (alunosOptional.isPresent()) {
            Alunos alunosExistentes = alunosOptional.get();

            LOGGER.info("Atualizando aluno... id: [{}]", alunosExistentes.getId());
            LOGGER.debug("Payload: {}", alunosDTO);
            LOGGER.debug("Aluno Existente: {}", alunosExistentes);

            alunosExistentes.setNome(alunosDTO.getNome());

            alunosExistentes = this.iAlunosRepository.save(alunosExistentes);

            return AlunosDTO.of(alunosExistentes);


        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para aluno de ID: [{}]", id);

        this.iAlunosRepository.deleteById(id);
    }

    public List<Alunos> findAll() {
        return this.iAlunosRepository.findAll();

    }
}
