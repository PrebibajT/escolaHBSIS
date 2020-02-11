package br.com.escola.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunosRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunosRest.class);

    private final AlunoService alunoService;

    @Autowired
    public AlunosRest(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping
    public AlunosDTO save(@RequestBody AlunosDTO alunosDTO) {
        LOGGER.info("Recebendo solicitação de persistência de aluno...");
        LOGGER.debug("Payaload: {}", alunosDTO);

        return this.alunoService.save(alunosDTO);
    }

    @PutMapping("/{id}")
    public AlunosDTO update(@PathVariable("id") Long id, @RequestBody AlunosDTO alunosDTO) {
        LOGGER.info("Recebendo Update para aluno de ID: {}", id);
        LOGGER.debug("Payload: {}", alunosDTO);

        return this.alunoService.update(alunosDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para aluno de ID: {}", id);

        this.alunoService.delete(id);
    }


}