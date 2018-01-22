package ru.ilka.systemintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.exception.ControllerException;
import ru.ilka.systemintegration.exception.LogicException;
import ru.ilka.systemintegration.logic.SystemLogic;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    private static final String MEDIA_TYPE_JSON = "application/json";

    @Autowired
    private SystemLogic systemLogic;

    @GetMapping(produces = MEDIA_TYPE_JSON)
    public List<ProjectSystem> getAllSystems() throws ControllerException {
        try {
            return systemLogic.getAllSystems();
        } catch (LogicException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping(value = "/{systemId:[a-zA-Z]+\\w?}", produces = MEDIA_TYPE_JSON)
    public ProjectSystem getSystemById(@PathVariable String systemId) throws ControllerException {
        try {
            return systemLogic.getSystemById(systemId);
        } catch (LogicException e) {
            throw new ControllerException(e);
        }
    }
}
