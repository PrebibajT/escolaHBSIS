package br.com.escola.materia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaService.class);

    private final IMateriaRepository iMateriaRepository;

    public MateriaService(IMateriaRepository iMateriaRepository) {
        this.iMateriaRepository = iMateriaRepository;
    }

    public MateriaDTO save(MateriaDTO materiaDTO) {
        LOGGER.info("Salvando matéria");
        LOGGER.debug("Matéria: {}", materiaDTO);

        Materia materia = new Materia();

        materia.setDisciplina(materiaDTO.getDisciplina());

        materia = this.iMateriaRepository.save(materia);

        return MateriaDTO.of(materia);
    }

    public Materia findById(Long id) {
        Optional<Materia> materiaOptional = this.iMateriaRepository.findById(id);

        if (materiaOptional.isPresent()) {
            return materiaOptional.get();
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public MateriaDTO findByIdMateria(Long id) {
        Optional<Materia> materiaOptional = this.iMateriaRepository.findById(id);

        if (materiaOptional.isPresent()) {
            return MateriaDTO.of(materiaOptional.get());
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public MateriaDTO update(MateriaDTO materiaDTO, Long id) {
        Optional<Materia> materiaOptional = this.iMateriaRepository.findById(id);

        if (materiaOptional.isPresent()) {
            Materia materiaExistente = materiaOptional.get();

            LOGGER.info("Atualizando matéria... id: [{}]", materiaExistente.getId());
            LOGGER.debug("Payload: {}", materiaDTO);
            LOGGER.debug("Matéria Existente: {}", materiaExistente);

            materiaExistente.setDisciplina(materiaDTO.getDisciplina());

            materiaExistente = this.iMateriaRepository.save(materiaExistente);

            return MateriaDTO.of(materiaExistente);


        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para matéria de ID: [{}]", id);

        this.iMateriaRepository.deleteById(id);
    }

    public List<Materia> findAll() {
        return this.iMateriaRepository.findAll();

    }
}
