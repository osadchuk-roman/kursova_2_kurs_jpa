package osadchuk.roman.service.sportCategory;

import osadchuk.roman.model.SportCategory;

import java.util.List;

public interface ISportCategoryService {
    List<SportCategory> getAll();
    SportCategory insert(SportCategory sportCategory);
    SportCategory update(SportCategory sportCategory);
    SportCategory getById(int id);
    void delete(int id);
}
