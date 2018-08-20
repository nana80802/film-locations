package at.building.co2.service;

import at.building.co2.service.model.Building;
import at.building.co2.service.model.DataSet;
import at.building.co2.service.util.CO2DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CO2ServiceImpl implements CO2Service {

    private static final Logger LOGGER = Logger.getLogger(CO2ServiceImpl.class.getName());
    @Autowired
    private CO2DataManager CO2DataManager;

    @Override
    public DataSet getAllBuildings() {
        try {
            return CO2DataManager.importOrReturnDataSet();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new DataSet();
    }

    @Override
    public DataSet getBuildingsByName(String name) {
        DataSet dataset;
        List<Building> buildings;
        try {
            dataset = new DataSet();
            buildings = new ArrayList<Building>(CO2DataManager.importOrReturnDataSet().getBuildings());
            List<Building> filteredList = buildings.stream().
                    filter(building -> building.getDepartment() != null && building.getDepartment().toLowerCase().contains(name.toLowerCase())).
                    collect(Collectors.toList());

            dataset.setBuildings(filteredList);
            return dataset;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new DataSet();
    }

}
