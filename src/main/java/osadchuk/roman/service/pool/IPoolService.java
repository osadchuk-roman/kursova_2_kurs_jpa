package osadchuk.roman.service.pool;

import osadchuk.roman.model.Pool;

import java.util.List;

public interface IPoolService {
    List<Pool> getAll();
    Pool insert(Pool pool);
    Pool update(Pool pool);
    Pool getById(int id);
    void delete(int id);
}
