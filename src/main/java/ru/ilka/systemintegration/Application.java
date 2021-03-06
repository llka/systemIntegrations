package ru.ilka.systemintegration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ilka.systemintegration.entity.MatrixCell;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.logic.MatrixLogic;
import ru.ilka.systemintegration.logic.SystemLogic;
import ru.ilka.systemintegration.parser.SystemIntegrationsJsonParser;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static Logger logger = LogManager.getLogger(Application.class);
    private static final String INPUT_FILE = "data/input.json";
    private static final String SYSTEMS_FILE = "data/systems.json";
    private static final String OUTPUT_FILE = "data/output.json";

    @Autowired
    private SystemIntegrationsJsonParser systemJsonParser;

    @Autowired
    private SystemLogic systemLogic;

    @Autowired
    private MatrixLogic matrixLogic;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ArrayList<ProjectSystem> systems = systemJsonParser.readSystems(INPUT_FILE);
        systems.forEach(logger::info);

        logger.debug("sorted:");
        systemLogic.sortSystemsInLexicalOrder(systems);
        systemJsonParser.writeSystems(systems, SYSTEMS_FILE);
        systems.forEach(logger::info);

        MatrixCell[][] matrix = matrixLogic.buildAdjacencyMatrix(systems);

        logger.debug("ready");
        matrixLogic.printMatrix(matrix);

        systemJsonParser.writeMatrix(matrix, OUTPUT_FILE);
    }
}
