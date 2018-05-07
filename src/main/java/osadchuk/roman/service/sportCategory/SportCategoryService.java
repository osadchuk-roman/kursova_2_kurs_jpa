package osadchuk.roman.service.sportCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportCategory;
import osadchuk.roman.repository.SportCategoryRepository;

import java.util.List;

@Service
public class SportCategoryService implements ISportCategoryService {
    @Autowired
    SportCategoryRepository repository;
    @Override
    public List<SportCategory> getAll() {
        return (List<SportCategory>)repository.findAll();
    }

    @Override
    public SportCategory insert(SportCategory sportCategory) {
        return repository.save(sportCategory);
    }

    @Override
    public SportCategory update(SportCategory sportCategory) {
        return repository.save(sportCategory);
    }

    @Override
    public SportCategory getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
