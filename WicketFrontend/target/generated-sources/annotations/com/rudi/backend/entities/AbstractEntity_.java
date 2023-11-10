package com.rudi.backend.entities;

import jakarta.persistence.metamodel.MappedSuperclassType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AbstractEntity.class)
public abstract class AbstractEntity_ {

	
	/**
	 * @see com.rudi.backend.entities.AbstractEntity#Id
	 **/
	public static volatile SingularAttribute<AbstractEntity, Long> Id;
	
	/**
	 * @see com.rudi.backend.entities.AbstractEntity
	 **/
	public static volatile MappedSuperclassType<AbstractEntity> class_;

	public static final String ID = "Id";

}

