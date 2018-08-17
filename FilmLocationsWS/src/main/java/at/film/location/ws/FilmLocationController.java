package at.film.location.ws;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;

import at.film.location.service.model.Film;
import at.film.location.ws.model.FilmDto;
import at.film.location.ws.model.FilmLocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import at.film.location.service.FilmLocationService;

import at.film.location.service.model.DataSet;

@RestController
public class FilmLocationController {

    private static final Logger LOGGER = Logger.getLogger(FilmLocationController.class.getName());

    @Autowired
    private FilmLocationService filmLocationService;

    @RequestMapping(value = "/films", method = RequestMethod.GET, produces = "application/json")
    public Collection<FilmDto> getFilm() {
        LOGGER.info("call api /films - return full list");
        FilmLocationDto filmLocationDto = toFilmLocationDto(filmLocationService.getFilms());
        return filmLocationDto.getFilmLocation().values();
    }

    @RequestMapping(value = "/filmsByName", method = RequestMethod.GET, produces = "application/json")
    public Collection<FilmDto> getFilmByName(@RequestParam(value = "name", required = true) String name) {
        LOGGER.info("call api /filmsByName - return list input parameter " + name);
        FilmLocationDto filmLocationDto = toFilmLocationDto(filmLocationService.getFilmByName(name));
        return filmLocationDto.getFilmLocation().values();
    }

    private FilmLocationDto toFilmLocationDto(DataSet films) {
        FilmLocationDto filmLocationDto = new FilmLocationDto();
        for (Film film : films.getFilms()) {
            filmLocationDto.addFilm(film);
        }
        return filmLocationDto;
    }

}
