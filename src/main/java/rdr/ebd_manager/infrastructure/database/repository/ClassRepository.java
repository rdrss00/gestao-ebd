package rdr.ebd_manager.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rdr.ebd_manager.infrastructure.database.entity.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    boolean existsByNameIgnoreCase(String name);
}
