package kz.attractor.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import kz.attractor.java.server.BasicServer;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.ResponseCodes;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;


import static java.util.stream.Collectors.joining;

public class Lesson44Server extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();
    private final ArrayList<User> users = new ArrayList<>();
    public static final String MAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::freemarkerSampleHandler);
        registerGet("/user", this::freemarkerUserHandler);
        registerGet("/books", this::freemarkerBookHandler);
        registerGet("/home", this::freemarkerHomeHandler);

    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

            cfg.setDirectoryForTemplateLoading(new File("data"));

            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void freemarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange,"index.html", getSampleDataModel());
    }
    public void freemarkerHomeHandler(HttpExchange exchange) {
        renderTemplate(exchange,"mainPage.html", getSampleDataModel());
    }
    private void freemarkerBookHandler(HttpExchange exchange) {
        renderTemplate(exchange,"books.ftl", getBookDataModel());
    }

    private void freemarkerUserHandler(HttpExchange exchange) {
        renderTemplate(exchange,"user.ftl", getUserDataModel());
    }

    private void sendFileRegistration(HttpExchange exchange) {
        this.sendFile(exchange,  makeFilePath("register.ftl"), ContentType.TEXT_HTML);
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile,Object dataModel) {
    try {
        Template temp = freemarker.getTemplate(templateFile);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {

            temp.process(dataModel, writer);
            writer.flush();

            var data = stream.toByteArray();

            sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
        }
    } catch (IOException | TemplateException e) {
        e.printStackTrace();
    }
}

    private SampleDataModel getSampleDataModel() {
        return new SampleDataModel();
    }

    private BookDataModel getBookDataModel(){
        return new BookDataModel();
    }

    private UserDataModel getUserDataModel(){
        return new UserDataModel();
    }






}
