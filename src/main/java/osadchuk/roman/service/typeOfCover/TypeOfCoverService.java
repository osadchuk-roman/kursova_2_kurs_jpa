package osadchuk.roman.service.typeOfCover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.repository.TypeOfCoverRepository;

import java.util.List;

@Service
public class TypeOfCoverService implements ITypeOfCoverService {
    @Autowired
    TypeOfCoverRepository repository;
    @Override
    public List<TypeOfCover> getAll() {
        return (List<TypeOfCover>)repository.findAll();
    }

    @Override
    public TypeOfCover insert(TypeOfCover typeOfCover) {
        return repository.save(typeOfCover);
    }

    @Override
    public TypeOfCover update(TypeOfCover typeOfCover) {
        return repository.save(typeOfCover);
    }

    @Override
    public TypeOfCover getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
