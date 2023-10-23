package com.rudi.rest;

import com.rudi.dao.UserDAO;
import com.rudi.entities.User;
import jakarta.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserService {

    @Inject
    private UserDAO userDAO;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "Test successful";
    }

    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(User user)
    {
        userDAO.saveUser(user);
    }

    @GET
    @Path("/checkpassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String checkPassword(String username, String password)
    {
        User user = userDAO.getByUsername("username");
        return userDAO.checkPassword(user, password) ? "Password correct" : "Password incorrect";
    }
}
