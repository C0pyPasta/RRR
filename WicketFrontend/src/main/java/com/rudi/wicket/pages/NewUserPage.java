package com.rudi.wicket.pages;

import com.rudi.backend.dao.UserDAO;
import com.rudi.backend.entities.User;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

public class NewUserPage extends WebPage {
    private UserDAO userDAO;
    public NewUserPage()
    {
        this.userDAO = new UserDAO();
        add(new FeedbackPanel("feedback"));
        CompoundPropertyModel model = new CompoundPropertyModel(new User());
        PasswordTextField passwordField = new PasswordTextField("password");
        PasswordTextField confirmPasswordField = new PasswordTextField("confirmPassword");
        Form form = new Form<User>("newUserForm", model)
        {
            @Override
            public void onSubmit()
            {
//                if(!passwordField.getValue().equals(confirmPasswordField.getValue()))
//                {
//                    error("Passwords do not match.");
//                    return;
//                }

                User user = getModelObject();
                if(userDAO.getByUsername(user.getUsername()) == null)
                {
                    userDAO.saveUser(user);
                    error("User created");
                } else {
                    error("Username already exists.");
                }
            }
        };
        add(form);
        form.add(new TextField("name")
                .setRequired(true)
                .add(StringValidator.lengthBetween(5, 25)));
        form.add(new TextField("username")
                .setRequired(true)
                .add(StringValidator.lengthBetween(5, 25)));
        form.add(passwordField.add(StringValidator.lengthBetween(8, 20)));
//        form.add(confirmPasswordField.add(StringValidator.lengthBetween(8, 20)));

        form.add(new Button("createUserButton"));
        add(new Link<Void>("backButton")
        {
            @Override
            public void onClick()
            {
                setResponsePage(LoginPage.class);
            }
        });
    }
}
