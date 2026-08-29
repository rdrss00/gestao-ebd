package rdr.ebd_manager.usecase.classe;

import rdr.ebd_manager.usecase.classe.dto.ClassInputDto;
import rdr.ebd_manager.usecase.classe.dto.ClassOutputDto;

public interface ClassUsecase {
    public ClassOutputDto createClass(ClassInputDto classDto);
}
