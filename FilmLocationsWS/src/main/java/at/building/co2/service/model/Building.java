package at.building.co2.service.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "row", strict = false)
public class Building {

    @Element(required = false, name = "department")
    private String department;
    @Element(required = false, name = "source_type")
    private String sourceType;
    @Element(required = false, name = "emissions_mtco2e")
    private double co2Emission;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public double getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(double co2Emission) {
        this.co2Emission = co2Emission;
    }
}
