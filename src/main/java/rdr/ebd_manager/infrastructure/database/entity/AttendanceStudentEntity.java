package rdr.ebd_manager.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attendance_student")
public class AttendanceStudentEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "attendance_id")
    private AttendanceEntity attendance;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
    private String status;
    private Boolean book;
    private Boolean bible;
    private Double offering;
    private LocalDateTime createdAt;

    public AttendanceStudentEntity(AttendanceEntity attendance, StudentEntity student, String status, Boolean book, Boolean bible, Double offering) {
        this.attendance = attendance;
        this.student = student;
        this.status = status;
        this.book = book;
        this.bible = bible;
        this.offering = offering;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AttendanceEntity getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceEntity attendance) {
        this.attendance = attendance;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getBook() {
        return book;
    }

    public void setBook(Boolean book) {
        this.book = book;
    }

    public Boolean getBible() {
        return bible;
    }

    public void setBible(Boolean bible) {
        this.bible = bible;
    }

    public Double getOffering() {
        return offering;
    }

    public void setOffering(Double offering) {
        this.offering = offering;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
