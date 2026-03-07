package proxy;

public interface FilmServiceInt {
    Film getFilm(Long id);

    void saveFilm(Film film);
}
