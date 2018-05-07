package osadchuk.roman.service.stadium;

import osadchuk.roman.model.Stadium;

import java.util.List;

public interface IStadiumService {
    List<Stadium> getAll();
    Stadium insert(Stadium stadium);
    Stadium update(Stadium stadium);
    Stadium getById(int id);
    void delete(int id);
}
