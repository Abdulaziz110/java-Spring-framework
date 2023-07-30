package com.courses.restapi.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false ,nullable = false)
    private Instant creatAt;


    @UpdateTimestamp
    @Column(name = "updated_At" ,nullable = false)
    private Instant updatedAt;

    @Version
    private Integer version;
}
