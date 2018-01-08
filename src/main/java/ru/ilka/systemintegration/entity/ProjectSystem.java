package ru.ilka.systemintegration.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectSystem {
    private String fullName;
    private String systemId;
    private Map<String, String> links;
    private ArrayList<Integration> integrationsFrom;
    private ArrayList<Integration> integrationsReceived;

    public ProjectSystem() {
        this.links = new HashMap<>();
        this.integrationsFrom = new ArrayList<>();
        this.integrationsReceived = new ArrayList<>();
    }

    public ProjectSystem(String fullName, String systemId, Map<String, String> links) {
        this.fullName = fullName;
        this.systemId = systemId;
        this.links = links;
        this.integrationsFrom = new ArrayList<>();
        this.integrationsReceived = new ArrayList<>();
    }

    public ProjectSystem(String fullName, String systemId, Map<String, String> links, ArrayList<Integration> integrationsFrom, ArrayList<Integration> integrationsReceived) {
        this.fullName = fullName;
        this.systemId = systemId;
        this.links = links;
        this.integrationsFrom = integrationsFrom;
        this.integrationsReceived = integrationsReceived;
    }

    public String getLinkUrl(String title) {
        return links.get(title);
    }

    public void addLink(String title, String url) {
        links.put(title, url);
    }

    public void removeLink(String title) {
        links.remove(title);
    }

    public void changeLinkUrl(String title, String newUrl) {
        links.replace(title, newUrl);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(HashMap<String, String> links) {
        this.links = links;
    }

    public ArrayList<Integration> getIntegrationsFrom() {
        return integrationsFrom;
    }

    public void setIntegrationsFrom(ArrayList<Integration> integrationsFrom) {
        this.integrationsFrom = integrationsFrom;
    }

    public ArrayList<Integration> getIntegrationsReceived() {
        return integrationsReceived;
    }

    public void setIntegrationsReceived(ArrayList<Integration> integrationsReceived) {
        this.integrationsReceived = integrationsReceived;
    }

    public void addIntegrationFrom(Integration integration) {
        integrationsFrom.add(integration);
    }

    public void removeIntegrationFrom(Integration integration) {
        integrationsFrom.remove(integration);
    }

    public void addIntegrationReceived(Integration integration) {
        integrationsReceived.add(integration);
    }

    public void removeIntegrationReceived(Integration integration) {
        integrationsReceived.remove(integration);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectSystem system = (ProjectSystem) o;

        if (!fullName.equals(system.fullName)) return false;
        if (!systemId.equals(system.systemId)) return false;
        return links.equals(system.links);
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + systemId.hashCode();
        result = 31 * result + links.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProjectSystem{" +
                "fullName='" + fullName + '\'' +
                ", systemId='" + systemId + '\'' +
                ", links=" + links +
                '}';
    }
}
