package rdr.ebd_manager.usecase.classe;

import org.springframework.stereotype.Service;
import rdr.ebd_manager.config.exception.EbdClassAlreadyExistsException;
import rdr.ebd_manager.config.exception.EbdClassNotFoundException;
import rdr.ebd_manager.infrastructure.database.repository.EbdClassRepository;
import rdr.ebd_manager.usecase.classe.dto.EbdClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.EbdClassOutputDto;
import rdr.ebd_manager.utils.mapper.EbdClassMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EbdClassUseCaseImpl implements EbdClassUseCase {

    private final EbdClassRepository ebdClassRepository;
    private final EbdClassMapper ebdClassMapper;

    public EbdClassUseCaseImpl(EbdClassRepository ebdClassRepository, EbdClassMapper ebdClassMapper) {
        this.ebdClassRepository = ebdClassRepository;
        this.ebdClassMapper = ebdClassMapper;
    }

    @Override
    public EbdClassOutputDto create(EbdClassInputDto classDto) {
        validateClass(classDto);
        var classEntity = ebdClassMapper.toEntity(classDto);
        classEntity.setCreatedAt(LocalDateTime.now());
        classEntity.setUpdatedAt(LocalDateTime.now());
        var classSaved = ebdClassRepository.save(classEntity);
        return ebdClassMapper.toDto(classSaved);
    }

    @Override
    public List<EbdClassOutputDto> getClasses() {
        return ebdClassRepository.findAll().stream()
                .map(ebdClassMapper::toDto)
                .toList();
    }

    @Override
    public EbdClassOutputDto update(String className, EbdClassInputDto classDto) {
        var classEntity = ebdClassRepository.findByNameIgnoreCase(className).orElseThrow(
                () -> new EbdClassNotFoundException("Class with name " + className + " not found.")
        );
        classEntity.setName(classDto.getName());
        classEntity.setDescription(classDto.getDescription());
        classEntity.setUpdatedAt(LocalDateTime.now());
        var classSaved = ebdClassRepository.save(classEntity);
        return ebdClassMapper.toDto(classSaved);
    }

    @Override
    public EbdClassOutputDto getByName(String className) {
        var ebdClass = ebdClassRepository.findByNameIgnoreCase(className).orElseThrow(
                () -> new EbdClassNotFoundException("Class with name " + className + " not found.")
        );
        return ebdClassMapper.toDto(ebdClass);
    }

    @Override
    public void deleteClass(String className) {
        var classEntity = ebdClassRepository.findByNameIgnoreCase(className).orElseThrow(
                () -> new EbdClassNotFoundException("Class with name " + className + " not found.")
        );
        ebdClassRepository.delete(classEntity);
    }


    private void validateClass(EbdClassInputDto classDto) {
        var exists = ebdClassRepository.existsByNameIgnoreCase(classDto.getName());
        if (exists) {
            throw new EbdClassAlreadyExistsException("Class with name " + classDto.getName() + " already exists.");
        }
    }
}
