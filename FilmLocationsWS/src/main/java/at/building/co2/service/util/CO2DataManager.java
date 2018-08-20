package at.building.co2.service.util;

import at.building.co2.service.model.Building;
import at.building.co2.service.model.DataSet;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CO2DataManager {


    private static final Logger LOGGER = Logger.getLogger(CO2DataManager.class.getName());

    private DataSet buildings;
    private File dataSetFile;
    private CO2Configs CO2Configs;

    @Autowired
    public CO2DataManager(CO2Configs CO2Configs) {
        super();
        this.CO2Configs = CO2Configs;
        this.dataSetFile = new File(CO2Configs.getDataSetSrc());
    }

    public CO2DataManager(String dataSetSrc) {
        super();
        this.dataSetFile = new File(dataSetSrc);
    }

    public DataSet importOrReturnDataSet() throws Exception {
        if (buildings != null) {
            LOGGER.info("Buildings are already imported, retuning the dataset.");
            return buildings;
        } else {
            LOGGER.info("Loading buildings from the dataset file");
            return importDataSet();
        }
    }

    private DataSet importDataSet() throws Exception {
        buildings = fetchBuildings();
        LOGGER.info("No. of buildings found: " + buildings.getBuildings().size());
        return buildings;
    }

    private DataSet fetchBuildings() throws Exception {
        DataSet tmp = new DataSet();
        Serializer serializer = new Persister();
        tmp = serializer.read(DataSet.class, CO2Configs.getDataSetAsInputStream());
        filterBuildings(tmp);
        return tmp;
    }

    private void filterBuildings(DataSet source) {
        List<Building> filteredList = source.getBuildings().stream().
                filter(building -> building.getDepartment() != null && building.getCo2Emission() > 0d).
                collect(Collectors.toList());
        source.setBuildings(filteredList);
    }

}
