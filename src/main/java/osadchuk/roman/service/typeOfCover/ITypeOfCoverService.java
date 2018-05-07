package osadchuk.roman.service.typeOfCover;

import osadchuk.roman.model.TypeOfCover;

import java.util.List;

public interface ITypeOfCoverService {
    List<TypeOfCover> getAll();
    TypeOfCover insert(TypeOfCover typeOfCover);
    TypeOfCover update(TypeOfCover typeOfCover);
    TypeOfCover getById(int id);
    void delete(int id);
}
