package com.rudi;

import com.rudi.dao.UserDAO;
import com.rudi.entities.User;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.rudi.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// needed for the styling used by the quickstart
		getCspSettings().blocking()
				.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
				.add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
				.add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");

		// add your configuration here
		UserDAO userDAO = new UserDAO();
		User user1 = new User("Rutger", "Rutger", "password");
		User user2 = new User("Roy", "Roy", "password");
		User user3 = new User("Roger", "Roger", "password");
		userDAO.save(user1);
		userDAO.save(user2);
		userDAO.save(user3);
	}
}
