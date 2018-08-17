package at.film.location.util;

import java.io.File;
import java.util.logging.Logger;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.film.location.service.model.DataSet;

@Component
public class DataManager {

	
	private static final Logger LOGGER = Logger.getLogger( DataManager.class.getName() );
	
	private DataSet films;
	private File dataSetFile;
	private Configs configs;

	@Autowired
	public DataManager(Configs configs) {
		super();
		this.configs = configs;
		this.dataSetFile = new File(configs.getDataSetSrc());
	}

	public DataManager(String dataSetSrc) {
		super();
		this.dataSetFile = new File(dataSetSrc);
	}

	public DataSet importOrReturnDataSet() throws Exception {
		if (films != null) {
			LOGGER.info("Films are already imported, retuning the dataset.");
			return films;
		} else {
			LOGGER.info("Loading films from the dataset file");
			return importDataSet();
		}
	}

	private DataSet importDataSet() throws Exception {
		films = fetchFilms();
		LOGGER.info("No. of films found: " + films.getFilms().size());
		return films;
	}

	private DataSet fetchFilms() throws Exception {
		DataSet tmp = new DataSet();
		Serializer serializer = new Persister();
		tmp = serializer.read(DataSet.class, configs.getDataSetAsInputStream());
		return tmp;
	}

}
