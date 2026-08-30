package rdr.ebd_manager.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rdr.ebd_manager.application.controller.classe.EbdClassRequest;
import rdr.ebd_manager.application.controller.classe.EbdClassResponse;
import rdr.ebd_manager.infrastructure.database.entity.EbdClassEntity;
import rdr.ebd_manager.usecase.classe.dto.EbdClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.EbdClassOutputDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EbdClassMapper {
    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "createdAt",  ignore = true)
    @Mapping(target = "updatedAt",  ignore = true)
    EbdClassEntity toEntity(EbdClassInputDto classDto);

    EbdClassOutputDto toDto(EbdClassEntity ebdClassEntity);

    EbdClassInputDto toInputDto(EbdClassRequest request);

    @Mapping(target = "outputDto.updatedAt",  ignore = true)
    EbdClassResponse toResponse(EbdClassOutputDto outputDto);

    @Mapping(target = "outputDto.updatedAt",  ignore = true)
    List<EbdClassResponse> toResponseList(List<EbdClassOutputDto> outputDtoList);
}
