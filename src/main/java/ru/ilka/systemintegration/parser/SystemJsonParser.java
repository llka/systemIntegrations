package ru.ilka.systemintegration.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.ilka.systemintegration.entity.ProjectSystem;
import ru.ilka.systemintegration.exception.JsonParserException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemJsonParser {
    private static Logger logger = LogManager.getLogger(SystemJsonParser.class);
    private Gson gson;

    public SystemJsonParser() {
        this.gson = new Gson();
    }

    public ArrayList<ProjectSystem> readSystems(String jsonFileName) throws JsonParserException {
        ArrayList<ProjectSystem> systemsFromJson = new ArrayList<>();
        try (FileReader fileReader = new FileReader(jsonFileName)) {
            systemsFromJson = gson.fromJson(fileReader, new TypeToken<ArrayList<ProjectSystem>>() {
            }.getType());
        } catch (IOException e) {
            throw new JsonParserException(e);
        }
        return systemsFromJson;
    }

    public void writeSystems(List<ProjectSystem> systems, String fileName) {
        String jsonInString = gson.toJson(systems);
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonInString);
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            logger.error("Can not write to json file", e);
        }
    }
}
