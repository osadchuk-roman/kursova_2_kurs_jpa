package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.KindOfSport;

@Repository
public interface KindOfSportRepository extends JpaRepository<KindOfSport,Integer> {
}
