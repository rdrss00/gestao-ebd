package rdr.ebd_manager.usecase.classe;

import org.springframework.stereotype.Service;
import rdr.ebd_manager.infrastructure.database.repository.ClassRepository;
import rdr.ebd_manager.usecase.classe.dto.ClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.ClassOutputDto;
import rdr.ebd_manager.utils.mapper.ClassMapper;

import java.time.LocalDateTime;

@Service
public class ClassUsecaseImpl implements ClassUsecase {

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;

    public ClassUsecaseImpl(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    @Override
    public ClassOutputDto createClass(ClassInputDto classDto) {
        var classEntity = classMapper.toEntity(classDto);
        classEntity.setCreatedAt(LocalDateTime.now());
        classEntity.setUpdatedAt(LocalDateTime.now());
        var classSaved = classRepository.save(classEntity);
        return classMapper.toDto(classSaved);
    }
}
