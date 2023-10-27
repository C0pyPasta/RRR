package com.rudi;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import com.rudi.rest.RestEasyServices;
import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) {
        System.setProperty("wicket.configuration", "development");

        Server server = new Server();

        HttpConfiguration http_config = new HttpConfiguration();
        http_config.setOutputBufferSize(32768);

        ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(http_config));
        http.setPort(8080);
        http.setIdleTimeout(1000 * 60 * 60);

        server.addConnector(http);
        WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/rest/");
        bb.setWar("src/main/webapp");
//        bb.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        ServletHolder servlet = bb.addServlet(HttpServletDispatcher.class, "/");
        servlet.setInitParameter("javax.ws.rs.Application", RestEasyServices.class.getCanonicalName());

        // bb.getSessionHandler().setSessionCache(sessionCache);

        // uncomment next line if you want to test with JSESSIONID encoded in the urls
        // ((AbstractSessionManager)
        // bb.getSessionHandler().getSessionManager()).setUsingCookies(false);

        server.setHandler(bb);

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
        server.addEventListener(mBeanContainer);
        server.addBean(mBeanContainer);

        try
        {
            server.start();
            server.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(100);
        }
    }
}