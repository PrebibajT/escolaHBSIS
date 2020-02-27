package br.com.escola.notas;

import br.com.escola.aluno.AlunoService;
import br.com.escola.aluno.Alunos;
import br.com.escola.materia.Materia;
import br.com.escola.materia.MateriaService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class NotaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotaService.class);

    private final INotasRepository iNotasRepository;
    private final AlunoService alunoService;
    private final MateriaService materiaService;


    public NotaService(INotasRepository iNotasRepository, AlunoService alunoService, MateriaService materiaService) {
        this.iNotasRepository = iNotasRepository;
        this.alunoService = alunoService;
        this.materiaService = materiaService;
    }

    public NotasDTO save(NotasDTO notasDTO) {
        LOGGER.info("Salvando nota");
        LOGGER.debug("Nota: {}", notasDTO);

        Notas notas = new Notas();

        Alunos alunosExistentes = alunoService.findById(notasDTO.getIdAluno());
        Materia materiaExistente = materiaService.findById(notasDTO.getIdMateria());

        notas.setAluno(alunosExistentes);
        notas.setMateria(materiaExistente);
        notas.setNota1(notasDTO.getNota1());
        notas.setNota2(notasDTO.getNota2());
        notas.setNota3(notasDTO.getNota3());
        notas.setMedia(calculadorMedia(notasDTO.getNota1(), notasDTO.getNota2(), notasDTO.getNota3()));

        notas = this.iNotasRepository.save(notas);

        return NotasDTO.of(notas);

    }

    public NotasDTO update(NotasDTO notasDTO, Long id) {
        Optional<Notas> notasOptional = this.iNotasRepository.findById(id);

        if (notasOptional.isPresent()) {
            Notas notasExistentes = notasOptional.get();

            LOGGER.info("Atualizando notas.... id:[{}]", notasExistentes.getId());
            LOGGER.debug("Payload: {}", notasDTO);
            LOGGER.debug("Notas existente: {}", notasExistentes);

            Alunos alunosExistentes = alunoService.findById(notasDTO.getIdAluno());
            Materia materiaExistente = materiaService.findById(notasDTO.getIdMateria());

            notasExistentes.setAluno(alunosExistentes);
            notasExistentes.setMateria(materiaExistente);
            notasExistentes.setNota1(notasDTO.getNota1());
            notasExistentes.setNota2(notasDTO.getNota2());
            notasExistentes.setNota3(notasDTO.getNota3());

            notasExistentes = this.iNotasRepository.save(notasExistentes);
            return NotasDTO.of(notasExistentes);

        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));

    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para produto de ID: [{}]", id);

        this.iNotasRepository.deleteById(id);
    }

    public Double calculadorMedia(Double n1, Double n2, Double n3) {

        return (n1 + n2 + n3) / 3;
    }

    public String exportJasper(Long idAluno) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\thiago.prebibaj\\Downloads";

        List<Notas> boletim = iNotasRepository.findByAluno(alunoService.findById(idAluno));

        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(boletim);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("criado por", "Thiago");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\boletim.pdf");

        return "Arquivo esportado para path: " + path;
    }
}

