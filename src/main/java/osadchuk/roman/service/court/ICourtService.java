package osadchuk.roman.service.court;

import osadchuk.roman.model.Court;

import java.util.List;

public interface ICourtService {
    List<Court> getAll();
    Court getById(int id);
    Court insert(Court court);
    Court update(Court court);
    void delete(int id);

}
