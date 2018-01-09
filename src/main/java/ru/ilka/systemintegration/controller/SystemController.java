package ru.ilka.systemintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.exception.ControllerException;
import ru.ilka.systemintegration.exception.JsonParserException;
import ru.ilka.systemintegration.logic.SystemLogic;
import ru.ilka.systemintegration.parser.SystemIntegrationsJsonParser;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/systems")
public class SystemController {
    private static final String MEDIA_TYPE_JSON = "application/json";

    @Autowired
    private SystemIntegrationsJsonParser systemJsonParser;

    @Autowired
    private SystemLogic systemLogic;

    @GetMapping
    public List<ProjectSystem> findAllSystems() throws ControllerException {
        ArrayList<ProjectSystem> systems = null;
        try {
            systems = systemJsonParser.readSystems("data/systems.json");
        } catch (JsonParserException e) {
            throw new ControllerException(e);
        }
        systemLogic.sortSystemsInLexicalOrder(systems);
        return systems;
    }
}
