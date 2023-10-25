package com.rudi.backend.entities;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ extends com.rudi.backend.entities.AbstractEntity_ {

	
	/**
	 * @see com.rudi.backend.entities.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.rudi.backend.entities.User#name
	 **/
	public static volatile SingularAttribute<User, String> name;
	
	/**
	 * @see com.rudi.backend.entities.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.rudi.backend.entities.User#username
	 **/
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String USERNAME = "username";

}

