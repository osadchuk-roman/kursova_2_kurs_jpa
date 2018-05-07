package osadchuk.roman.service.gym;

import osadchuk.roman.model.Gym;

import java.util.List;

public interface IGymService {
    List<Gym> getAll();
    Gym insert(Gym gym);
    Gym update(Gym gym);
    Gym getById(int id);
    void delete(int id);
}
