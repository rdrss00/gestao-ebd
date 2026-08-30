package rdr.ebd_manager.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
    @ManyToOne
    @JoinColumn(name = "ebd_class_id")
    private EbdClassEntity ebdClassEntity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EnrollmentEntity(StudentEntity studentEntity, EbdClassEntity ebdClassEntity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.studentEntity = studentEntity;
        this.ebdClassEntity = ebdClassEntity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
