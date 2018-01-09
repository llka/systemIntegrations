package ru.ilka.systemintegration.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.systemintegration.comparator.LexicalSystemIdComparator;
import ru.ilka.systemintegration.entity.ProjectSystem;

import java.util.List;

@Service
public class SystemLogic {

    @Autowired
    private LexicalSystemIdComparator lexicalSystemIdComparator;

    public void sortSystemsInLexicalOrder(List<ProjectSystem> systems){
        systems.sort(lexicalSystemIdComparator);
    }
}
