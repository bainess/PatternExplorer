package proxy;

import builder.User;

import java.util.HashMap;

public class FilmServiceProxy implements FilmServiceInt{
    HashMap<Long, User> authorisedUsers = new HashMap<>();
    private FilmService service;
    private User user;
    public FilmServiceProxy(User user) {
        this.user = user;
        this.service = new FilmService();
    }

    @Override
    public void saveFilm(Film film) {
        service.saveFilm(film);
    }


    @Override
    public Film getFilm(Long id) {
        if (!user.getRole().equals(Role.ADMIN)) {
            System.out.println("Access denied");
        }
        return service.getFilm(id);
    }
}
