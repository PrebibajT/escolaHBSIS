package br.com.escola.materia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/materia")
public class MateriaRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaRest.class);

    private final MateriaService materiaService;

    @Autowired
    public MateriaRest(MateriaService materiaService) {
        this.materiaService = materiaService;
    }


    @PostMapping
    public MateriaDTO save(@RequestBody MateriaDTO materiaDTO) {
        LOGGER.info("Recebendo solicitação de persistência de matéria...");
        LOGGER.debug("Payaload: {}", materiaDTO);

        return this.materiaService.save(materiaDTO);
    }

    @PutMapping("/{id}")
    public MateriaDTO update(@PathVariable("id") Long id, @RequestBody MateriaDTO materiaDTO) {
        LOGGER.info("Recebendo Update para matéria de ID: {}", id);
        LOGGER.debug("Payload: {}", materiaDTO);

        return this.materiaService.update(materiaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para matéria de ID: {}", id);

        this.materiaService.delete(id);
    }

    @GetMapping("/{id}")
    public MateriaDTO find(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo find para aluno de ID: {}", id);

        return this.materiaService.findByIdMateria(id);

    }

    @GetMapping
    public List<Materia> findAll() {
        LOGGER.info("Recebendo findAll para materia");

        return this.materiaService.findAll();
    }

}