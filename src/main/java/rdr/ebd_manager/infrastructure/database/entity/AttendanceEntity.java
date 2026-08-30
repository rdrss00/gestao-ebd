package rdr.ebd_manager.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attendance")
public class AttendanceEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ebd_class_id")
    private EbdClassEntity ebdClassEntity;
    private LocalDateTime createdAt;

    public AttendanceEntity(EbdClassEntity ebdClassEntity) {
        this.ebdClassEntity = ebdClassEntity;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EbdClassEntity getClassEntity() {
        return ebdClassEntity;
    }

    public void setClassEntity(EbdClassEntity ebdClassEntity) {
        this.ebdClassEntity = ebdClassEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
