package ru.ilka.systemintegration.comparator;

import org.springframework.stereotype.Service;
import ru.ilka.systemintegration.entity.ProjectSystem;
import java.util.Comparator;

@Service
public class LexicalSystemIdComparator implements Comparator<ProjectSystem> {
    @Override
    public int compare(ProjectSystem system1, ProjectSystem system2) {
        return system1.getSystemId().compareToIgnoreCase(system2.getSystemId());
    }
}
