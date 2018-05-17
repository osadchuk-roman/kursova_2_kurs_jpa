package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Organizer;

import java.sql.Date;
import java.util.List;

@Repository

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
    @Query("select com.organizer,count(com.organizer.id) from Organizer org left join Competition com " +
            "on org.id = com.organizer.id " +
            "where com.date between :date1 and :date2")
    List<Organizer> getOrOrganizerCompetitionsByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);
}
