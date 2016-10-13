package servlets;

import frontend.AnotherFrontend;
import frontend.Frontend;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();
        AnotherFrontend anotherFrontend = new AnotherFrontend();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/authform");
        context.addServlet(new ServletHolder(anotherFrontend), "/statistics");

        Server server = new Server(8083);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
