package com.rudi.rest;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    public String test()
    {
        return "Test successful";
    }

    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(String jsonResponse)
    {
        UserDAO userDAO = new UserDAO();  //beetje raar, @Inject werkt niet?
        Gson gson = new Gson();
        User userToSave = gson.fromJson(jsonResponse, User.class);

        userDAO.saveUser(userToSave);
    }

    @POST
    @Path("/checkpassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String checkPassword(String jsonResponse)
    {
        UserDAO userDAO = new UserDAO();  //beetje raar, @Inject werkt niet?
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(jsonResponse);
        String username = object.get("username").toString().replace("\"", "");
        String password = object.get("password").toString().replace("\"", "");

        User user = userDAO.getByUsername(username);
        return userDAO.checkPassword(user, password) ? "Password correct" : "Password incorrect";
    }
}
