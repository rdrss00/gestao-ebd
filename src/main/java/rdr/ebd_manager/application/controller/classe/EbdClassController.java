package rdr.ebd_manager.application.controller.classe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdr.ebd_manager.usecase.classe.EbdClassUseCase;
import rdr.ebd_manager.utils.mapper.EbdClassMapper;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/class")
public class EbdClassController {

    private final EbdClassUseCase ebdClassUsecase;
    private final EbdClassMapper ebdClassMapper;

    public EbdClassController(EbdClassUseCase ebdClassUsecase, EbdClassMapper ebdClassMapper) {
        this.ebdClassUsecase = ebdClassUsecase;
        this.ebdClassMapper = ebdClassMapper;
    }

    @PostMapping
    public ResponseEntity<EbdClassResponse> createClass(@RequestBody EbdClassRequest request) {
        var classInputDto = ebdClassMapper.toInputDto(request);
        var classOutputDto = ebdClassUsecase.create(classInputDto);
        var response = ebdClassMapper.toResponse(classOutputDto);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EbdClassResponse>> getClasses() {
        var classes = ebdClassUsecase.getClasses();
        var response = ebdClassMapper.toResponseList(classes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{className}")
    public ResponseEntity<EbdClassResponse> getClasses(@PathVariable String className) {
        var ebdClass = ebdClassUsecase.getByName(className);
        var response = ebdClassMapper.toResponse(ebdClass);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{className}")
    public ResponseEntity<EbdClassResponse> UpdateClass(@PathVariable String className, @RequestBody EbdClassRequest request) {
        var classInputDto = ebdClassMapper.toInputDto(request);
        var classOutputDto = ebdClassUsecase.update(className, classInputDto);
        var response = ebdClassMapper.toResponse(classOutputDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{className}")
    public ResponseEntity<Void> deleteClass(@PathVariable String className) {
        ebdClassUsecase.deleteClass(className);
        return ResponseEntity.noContent().build();
    }
}
