package at.film.location.ws.model;

import java.util.ArrayList;
import java.util.List;

public class FilmDto {

    private String title;
    private List<String> locations;

    public FilmDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLocations() {
        if (locations == null) {
            locations = new ArrayList<>();
        }
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
