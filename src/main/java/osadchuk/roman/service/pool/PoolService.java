package osadchuk.roman.service.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Pool;
import osadchuk.roman.repository.PoolRepository;

import java.util.List;

@Service
public class PoolService implements IPoolService {
    @Autowired
    PoolRepository repository;
    @Override
    public List<Pool> getAll() {
        return (List<Pool>)repository.findAll();
    }

    @Override
    public Pool insert(Pool pool) {
        return repository.save(pool);
    }

    @Override
    public Pool update(Pool pool) {
        return repository.save(pool);
    }

    @Override
    public Pool getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
