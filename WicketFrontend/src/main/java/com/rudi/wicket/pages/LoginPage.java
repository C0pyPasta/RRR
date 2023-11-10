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

public class LoginPage extends WebPage {
    private UserDAO userDAO;
    public LoginPage()
    {
        this.userDAO = new UserDAO();
        add(new FeedbackPanel("feedback"));
        CompoundPropertyModel model = new CompoundPropertyModel(new User());
        Form form = new Form<User>("loginForm", model)
        {
            @Override
            public void onSubmit()
            {
                User user = getModelObject();
                if(userDAO.getByUsername(user.getUsername()) == null)
                {
                    error("Username not found");
                    return;
                }
                if(userDAO.checkPassword(userDAO.getByUsername(user.getUsername()), user.getPassword()))
                {
                    setResponsePage(HomePage.class);
                } else {
                    error("Password incorrect");
                }
            }
        };
        add(form);
        form.add(new TextField("username")
                .setRequired(true));
        form.add(new PasswordTextField("password"));

        form.add(new Button("loginButton"));

        add(new Link<Void>("newUserPage")
        {
            @Override
            public void onClick() {
                setResponsePage(NewUserPage.class);
            }
        });
    }
}
