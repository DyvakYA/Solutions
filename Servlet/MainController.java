package controller.servlet;

import controller.commands.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.servlet.CommandHolder.DELIMITER;
import static model.constants.AttributesHolder.COMMAND_ATTRIBUTE;
import static model.constants.UrlHolder.REDIRECTED;

public class MainController extends HttpServlet {

    private static final long serialVersionUID=1L;

    private static final Logger logger = Logger.getLogger(MainController.class);

    public MainController() {
        super();
    }

    private CommandHolder commandHolder;
    private String commandKey;

    @Override
    public void init() throws ServletException {
        commandHolder=new CommandHolder();
        super.init();
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Command command=commandHolder.findCommand(commandKey);
        String view=command.execute(request, response);
        if (!isRedirected(view)) {
            request.getRequestDispatcher(view).forward(request, response);
        }
    }

    private String getMethod(HttpServletRequest request) {
        return request.getMethod().toUpperCase();
    }

    private String getUri(HttpServletRequest request) {
        String uri=request.getRequestURI();
        logger.debug(request.getMethod().toUpperCase() + uri);
        return uri;
    }

    private boolean isRedirected(String view) {
        return REDIRECTED.equals(view);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        commandKey = getMethod(request) + DELIMITER + getUri(request);
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        commandKey=getMethod(request) + DELIMITER + request.getParameter(COMMAND_ATTRIBUTE);
        processRequest(request, response);
    }

    public void setCommandHolder(CommandHolder commandHolder) {
        this.commandHolder = commandHolder;
    }
}

