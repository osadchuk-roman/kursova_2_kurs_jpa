package osadchuk.roman.service.sportsman;

import osadchuk.roman.model.Sportsman;

import java.util.List;

public interface ISportsmanService {
    List<Sportsman> getAll();
    Sportsman insert(Sportsman sportsman);
    Sportsman update(Sportsman sportsman);
    Sportsman getById(int id);
    void delete(int id);
}
