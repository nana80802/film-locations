package at.film.location.ws.model;

import at.film.location.service.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmLocationDto {

    private Map<String, FilmDto> filmLocation;

    public FilmLocationDto() {
        filmLocation = new HashMap<>();
    }

    public void addFilm(Film film) {
        FilmDto filmDto;
        if (filmLocation.containsKey(film.getTitle())) {
            filmDto = filmLocation.get(film.getTitle());
        } else {
            filmDto = new FilmDto();
            filmDto.setTitle(film.getTitle());
        }
        filmDto.getLocations().add(film.getLocations());
        filmLocation.put(film.getTitle(), filmDto);
    }

    public Map<String, FilmDto> getFilmLocation() {
        return filmLocation;
    }
}
