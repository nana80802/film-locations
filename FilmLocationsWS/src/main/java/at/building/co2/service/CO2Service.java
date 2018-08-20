package at.building.co2.service;

import at.building.co2.service.model.DataSet;

public interface CO2Service {

    public DataSet getAllBuildings();
    public DataSet getBuildingsByName(String name);

}
