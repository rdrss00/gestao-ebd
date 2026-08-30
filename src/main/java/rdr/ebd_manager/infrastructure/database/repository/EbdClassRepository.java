package rdr.ebd_manager.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rdr.ebd_manager.infrastructure.database.entity.EbdClassEntity;

import java.util.Optional;

@Repository
public interface EbdClassRepository extends JpaRepository<EbdClassEntity, Long> {
    boolean existsByNameIgnoreCase(String name);

    Optional<EbdClassEntity> findByNameIgnoreCase(String name);
}
