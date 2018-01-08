package ru.ilka.systemintegration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.parser.SystemJsonParser;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static Logger logger = LogManager.getLogger(Application.class);

    @Autowired
    private SystemJsonParser systemJsonParser;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ArrayList<ProjectSystem> systems = systemJsonParser.readSystems("data/systems.json");
        systems.forEach(logger::info);
    }
}
