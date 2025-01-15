package de.toxic2302.inventorymanagementsystem.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @JsonIgnore
    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @JsonIgnore
    @CreatedBy
    @Column(length = 20)
    private String createdBy;

    @JsonIgnore
    @LastModifiedDate
    @Column
    private LocalDateTime modifiedAt;

    @JsonIgnore
    @LastModifiedBy
    @Column(length = 20)
    private String modifiedBy;

    public BaseEntity() {}
}
