package ru.ilka.systemintegration;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.ilka.systemintegration.entity.Integration;

import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.exception.JsonParserException;
import ru.ilka.systemintegration.parser.SystemJsonParser;


import java.util.ArrayList;
import java.util.HashMap;


public class Demo {
    private static Logger logger = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        HashMap<String, String> links = new HashMap<>();
        links.put("docs", "http://docs");
        links.put("api", "http://api");

        HashMap<String, String> links2 = new HashMap<>();
        links2.put("docs", "http://docs2");
        links2.put("api", "http://api2");

        ProjectSystem system1 = new ProjectSystem("Blog", "Blog", links);
        ProjectSystem system2 = new ProjectSystem("QA", "QA", links2);

        system1.addIntegrationFrom(new Integration("Blog", "QA"));
        system2.addIntegrationReceived(new Integration("Blog", "QA"));

        ArrayList<ProjectSystem> systems = new ArrayList<>();
        systems.add(system1);
        systems.add(system2);

        //logger.debug(systems);

        Gson gson = new Gson();

        SystemJsonParser jsonParser = new SystemJsonParser();
        // jsonParser.writeSystems(systems,"data/output.json");

        try {
            ArrayList<ProjectSystem> systems1 = jsonParser.readSystems("data/output.json");
            logger.info(systems1);
        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }
}
