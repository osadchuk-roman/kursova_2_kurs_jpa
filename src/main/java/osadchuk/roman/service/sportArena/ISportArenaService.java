package osadchuk.roman.service.sportArena;

import osadchuk.roman.model.SportArena;

import java.util.List;

public interface ISportArenaService {
    List<SportArena> getAll();
    SportArena insert(SportArena sportArena);
    SportArena update(SportArena sportArena);
    SportArena getById(int id);
    void delete(int id);
}
