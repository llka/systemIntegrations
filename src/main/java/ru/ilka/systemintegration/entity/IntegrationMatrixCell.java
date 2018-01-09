package ru.ilka.systemintegration.entity;

public class IntegrationMatrixCell extends MatrixCell {
    private Integration integration;

    public IntegrationMatrixCell(Integration integration) {
        this.integration = integration;
    }

    public IntegrationMatrixCell(Coordinates coordinates, String displayedInfo, Integration integration) {
        super(coordinates, displayedInfo);
        this.integration = integration;
    }

    public IntegrationMatrixCell(int x, int y, String displayedInfo, Integration integration) {
        super(x, y, displayedInfo);
        this.integration = integration;
    }

    public Integration getIntegration() {
        return integration;
    }

    public void setIntegration(Integration integration) {
        this.integration = integration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        IntegrationMatrixCell that = (IntegrationMatrixCell) o;

        return integration.equals(that.integration);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + integration.hashCode();
        return result;
    }
}
