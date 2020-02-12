package br.com.escola.notas;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/notas")
public class NotasRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotasRest.class);

    private final NotaService notaService;

    @Autowired
    public NotasRest(NotaService notaService) {
        this.notaService = notaService;
    }


    @PostMapping
    public NotasDTO save(@RequestBody NotasDTO notasDTO) {
        LOGGER.info("Recebendo solicitação de persistência de notas");
        LOGGER.debug("Payload: {}", notasDTO);

        return this.notaService.save(notasDTO);
    }

    @PutMapping("/{id}")
    public NotasDTO update(@PathVariable("id") Long id, @RequestBody NotasDTO notasDTO) {
        LOGGER.info("Recebendo Update para notas de ID: {}", id);
        LOGGER.debug("Payload: {}", notasDTO);

        return this.notaService.update(notasDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para matéria de ID: {}", id);

        this.notaService.delete(id);

    }

    @GetMapping("/report/{format}/{idAluno}")
    public String generateReport(@PathVariable("format")String format, @PathVariable("idAluno")Long idAluno) throws FileNotFoundException, JRException {
        return notaService.exportJasper(format, idAluno);
    }



}