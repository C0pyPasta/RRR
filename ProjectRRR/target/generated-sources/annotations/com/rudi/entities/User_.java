package com.rudi.entities;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ extends com.rudi.entities.AbstractEntity_ {

	
	/**
	 * @see com.rudi.entities.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.rudi.entities.User#name
	 **/
	public static volatile SingularAttribute<User, String> name;
	
	/**
	 * @see com.rudi.entities.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.rudi.entities.User#username
	 **/
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String USERNAME = "username";

}

