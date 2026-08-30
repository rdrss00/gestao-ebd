package rdr.ebd_manager.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ebd_class_id")
    private EbdClassEntity ebdClassEntity;
    private String name;
    private String phone;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentEntity(Integer id, EbdClassEntity ebdClassEntity, String name, String phone, Integer age, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.ebdClassEntity = ebdClassEntity;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

