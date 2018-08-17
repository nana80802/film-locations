package at.film.location.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import at.film.location.service.model.DataSet;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DataManagerTest {

	//@Test
	public void importOrReturnDataSetTest() throws Exception {
		DataManager dataManager = new DataManager("/dataset.xml");
		DataSet dataSet = dataManager.importOrReturnDataSet();
		assertNotNull(dataSet);
		assertThat(dataSet.getFilms().size() > 0);
	}

}
