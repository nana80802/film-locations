package at.film.location.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.film.location.service.model.DataSet;
import at.film.location.service.model.Film;
import at.film.location.util.DataManager;

@Service
public class FilmLocationServiceImpl implements FilmLocationService {

    private static final Logger LOGGER = Logger.getLogger(FilmLocationServiceImpl.class.getName());
    @Autowired
    private DataManager dataManager;

    @Override
    public DataSet getFilms() {
        try {
            return dataManager.importOrReturnDataSet();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new DataSet();
    }

    @Override
    public DataSet getFilmByName(String name) {
        DataSet dataset;
        List<Film> films;
        try {
            dataset = new DataSet();
            films = new ArrayList<Film>(dataManager.importOrReturnDataSet().getFilms());
            List<Film> filteredList = films.stream().
                    filter(film -> film.getTitle() != null && film.getTitle().toLowerCase().contains(name.toLowerCase())).
                    collect(Collectors.toList());

            dataset.setFilms(filteredList);
            return dataset;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return new DataSet();
    }

}
