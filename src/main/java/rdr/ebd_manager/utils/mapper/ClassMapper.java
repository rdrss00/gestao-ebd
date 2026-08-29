package rdr.ebd_manager.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rdr.ebd_manager.application.controller.classe.ClassRequest;
import rdr.ebd_manager.application.controller.classe.ClassResponse;
import rdr.ebd_manager.infrastructure.database.entity.ClassEntity;
import rdr.ebd_manager.usecase.classe.dto.ClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.ClassOutputDto;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassEntity toEntity(ClassInputDto classDto);
    ClassOutputDto toDto(ClassEntity classEntity);

    ClassInputDto toInputDto(ClassRequest request);

    @Mapping(target = "outputDto.updatedAt",  ignore = true)
    ClassResponse toResponse(ClassOutputDto outputDto);
}
