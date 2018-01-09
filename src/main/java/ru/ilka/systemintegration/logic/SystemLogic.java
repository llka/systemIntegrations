package ru.ilka.systemintegration.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.systemintegration.comparator.LexicalSystemIdComparator;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.exception.JsonParserException;
import ru.ilka.systemintegration.exception.LogicException;
import ru.ilka.systemintegration.parser.SystemIntegrationsJsonParser;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemLogic {
    private static final String INPUT_FILE = "data/input.json";
    private static final String SYSTEMS_FILE = "data/systems.json";

    @Autowired
    private SystemIntegrationsJsonParser systemJsonParser;

    @Autowired
    private LexicalSystemIdComparator lexicalSystemIdComparator;

    public void sortSystemsInLexicalOrder(List<ProjectSystem> systems) {
        systems.sort(lexicalSystemIdComparator);
    }

    public List<ProjectSystem> getAllSystems() throws LogicException {
        ArrayList<ProjectSystem> systems = null;
        try {
            systems = systemJsonParser.readSystems(INPUT_FILE);
        } catch (JsonParserException e) {
            throw new LogicException(e);
        }
        sortSystemsInLexicalOrder(systems);
        return systems;
    }

    public ProjectSystem getSystemById(String systemId) throws LogicException {
        ArrayList<ProjectSystem> systems = null;
        try {
            systems = systemJsonParser.readSystems(INPUT_FILE);
        } catch (JsonParserException e) {
            throw new LogicException(e);
        }
        for (ProjectSystem system : systems) {
            if (system.getSystemId().equals(systemId)) {
                return system;
            }
        }
        throw new LogicException("There is no system with id = " + systemId);
    }
}
