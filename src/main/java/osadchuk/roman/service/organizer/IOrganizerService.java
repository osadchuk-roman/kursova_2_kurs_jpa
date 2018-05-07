package osadchuk.roman.service.organizer;

import osadchuk.roman.model.Organizer;

import java.util.List;

public interface IOrganizerService {
    List<Organizer> getAll();
    Organizer insert(Organizer organizer);
    Organizer update(Organizer organizer);
    Organizer getById(int id);
    void delete(int id);
}
