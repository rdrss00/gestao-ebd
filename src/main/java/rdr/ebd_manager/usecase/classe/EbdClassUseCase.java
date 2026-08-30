package rdr.ebd_manager.usecase.classe;

import rdr.ebd_manager.usecase.classe.dto.EbdClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.EbdClassOutputDto;

import java.util.List;
import java.util.Optional;

public interface EbdClassUseCase {
    EbdClassOutputDto create(EbdClassInputDto classDto);
    List<EbdClassOutputDto> getClasses();
    EbdClassOutputDto update(String className, EbdClassInputDto classDto);
    EbdClassOutputDto getByName(String className);
    void deleteClass(String className);
}
