package rdr.ebd_manager.application.controller.classe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rdr.ebd_manager.usecase.classe.ClassUsecase;
import rdr.ebd_manager.utils.mapper.ClassMapper;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassUsecase classUsecase;
    private final ClassMapper classMapper;

    public ClassController(ClassUsecase classUsecase, ClassMapper classMapper) {
        this.classUsecase = classUsecase;
        this.classMapper = classMapper;
    }

    @PostMapping
    public ResponseEntity<ClassResponse> createClass(@RequestBody ClassRequest request) {
        var classInputDto = classMapper.toInputDto(request);
        var classOutputDto = classUsecase.createClass(classInputDto);
        var response = classMapper.toResponse(classOutputDto);
        return ResponseEntity.status(CREATED).body(response);
    }
}
