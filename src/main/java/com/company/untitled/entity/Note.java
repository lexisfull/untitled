package com.company.untitled.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.data.DbView;
import jakarta.persistence.*;

import java.util.UUID;

@DbView
@JmixEntity
@Table(name = "NOTE", indexes = {
        @Index(name = "IDX_NOTE_REDACTOR", columnList = "REDACTOR_ID")
})
@Entity
public class Note {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", length = 25)
    private String name;

    @Column(name = "TEXT")
    private String text;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "REDACTOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User redactor;

    public User getRedactor() {
        return redactor;
    }

    public void setRedactor(User redactor) {
        this.redactor = redactor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}