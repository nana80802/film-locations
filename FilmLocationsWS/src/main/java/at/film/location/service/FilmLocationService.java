package at.film.location.service;

import at.film.location.service.model.DataSet;


public interface FilmLocationService {
	
	public DataSet getFilms();
	public DataSet getFilmByName(String name);

}
