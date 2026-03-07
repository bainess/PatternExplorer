package proxy;

import java.util.HashMap;

public class FilmService implements FilmServiceInt{
    HashMap<Long, Film> films = new HashMap<>();

    public FilmService() {}

    @Override
    public void saveFilm(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public Film getFilm(Long id) {
        return films.get(id);
    }
}
