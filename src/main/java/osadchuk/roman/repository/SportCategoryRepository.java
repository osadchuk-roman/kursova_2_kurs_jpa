package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportCategory;

@Repository
public interface SportCategoryRepository extends JpaRepository<SportCategory,Integer> {
}
