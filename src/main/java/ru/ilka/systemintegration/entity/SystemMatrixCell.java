package ru.ilka.systemintegration.entity;

public class SystemMatrixCell extends MatrixCell {
    private ProjectSystem system;

    public SystemMatrixCell(ProjectSystem system) {
        this.system = system;
    }

    public SystemMatrixCell(Coordinates coordinates, String displayedInfo, ProjectSystem system) {
        super(coordinates, displayedInfo);
        this.system = system;
    }

    public SystemMatrixCell(int x, int y, String displayedInfo, ProjectSystem system) {
        super(x, y, displayedInfo);
        this.system = system;
    }

    public ProjectSystem getSystem() {
        return system;
    }

    public void setSystem(ProjectSystem system) {
        this.system = system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SystemMatrixCell that = (SystemMatrixCell) o;

        return system != null ? system.equals(that.system) : that.system == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (system != null ? system.hashCode() : 0);
        return result;
    }
}
