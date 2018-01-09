package ru.ilka.systemintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.systemintegration.entity.MatrixCell;
import ru.ilka.systemintegration.exception.ControllerException;
import ru.ilka.systemintegration.exception.LogicException;
import ru.ilka.systemintegration.logic.MatrixLogic;
import ru.ilka.systemintegration.logic.SystemLogic;

@RestController
@RequestMapping("/matrix")
public class MatrixController {
    private static final String MEDIA_TYPE_JSON = "application/json";

    @Autowired
    private MatrixLogic matrixLogic;

    @Autowired
    private SystemLogic systemLogic;

    @GetMapping(produces = MEDIA_TYPE_JSON)
    public MatrixCell[][] getMatrix() throws ControllerException {
        try {
            return matrixLogic.buildAdjacencyMatrix(systemLogic.getAllSystems());
        } catch (LogicException e) {
            throw new ControllerException(e);
        }
    }

}
