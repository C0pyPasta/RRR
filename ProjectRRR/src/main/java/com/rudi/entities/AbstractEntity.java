package com.rudi.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    public AbstractEntity()
    {

    }

    public Long getId()
    {
        return this.Id;
    }

    public void setId(Long Id)
    {
        this.Id = Id;
    }
}
