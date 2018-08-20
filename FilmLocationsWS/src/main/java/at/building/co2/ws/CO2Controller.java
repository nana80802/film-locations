package at.building.co2.ws;

import at.building.co2.service.CO2Service;
import at.building.co2.service.model.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
public class CO2Controller {

    private static final Logger LOGGER = Logger.getLogger(CO2Controller.class.getName());

    @Autowired
    private CO2Service co2Service;

    @RequestMapping(value = "/buildings", method = RequestMethod.GET, produces = "application/json")
    public DataSet getBuildings() {
        LOGGER.info("call api /buildings - return full list");
        return co2Service.getAllBuildings();
    }

    @RequestMapping(value = "/buildingsByName", method = RequestMethod.GET, produces = "application/json")
    public DataSet getFilmByName(@RequestParam(value = "name", required = true) String name) {
        LOGGER.info("call api /buildingsByName - return list input parameter " + name);
        return co2Service.getBuildingsByName(name);
    }
}
