package osadchuk.roman.service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.*;
import osadchuk.roman.repository.*;
import osadchuk.roman.requestModel.OrganizerAndAmountOfCompetitions;
import osadchuk.roman.requestModel.SportClubAndAmountOfSportsmen;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService implements IRequestService {
    @Autowired
    SportBuildingRepository sportBuildingRepository;
    @Autowired
    SportBuildingSportRepository sportBuildingSportRepository;
    @Autowired
    SportsmanSportCoachRepository sportsmanSportCoachRepository;
    @Autowired
    CompetitionRepository competitionRepository;
    @Autowired
    SportsmanCompetitionRepository sportsmanCompetitionRepository;
    @Autowired
    SportsmanRepository sportsmanRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Override//1.1
    public List<SportBuilding> getSportBuildingByType(int typeId) {
        return sportBuildingRepository.getSportBuildingByType(typeId);
        //return null;
    }

    @Override//1.2
    public List<SportBuilding> getSportBuildingByTypeAndSport(int typeId, int sportId) {
        return sportBuildingSportRepository.getSportBuildingByTypeAndSport(typeId,sportId);
    }

    @Override//2.1
    public List<Sportsman> getSportsmanBySport(int sportId) {
        return sportsmanSportCoachRepository.getSportsmanBySport(sportId);
    }

    @Override//2.2
    public List<SportsmanSportCoach> getSportsmanBySportAndCategory(int sportId, int sportCategoryId) {
        return sportsmanSportCoachRepository.getSportsmanBySportAndSportCategory(sportId,sportCategoryId);
    }

    @Override//3.1
    public List<Sportsman> getSportsmanByCoach(int coachId) {

        return sportsmanSportCoachRepository.getSportsmanByCoach(coachId);
    }

    @Override//3.2
    public List<SportsmanSportCoach> getSportsmanByCoachAndCategory(int coachId, int sportCategoryId) {
        return sportsmanSportCoachRepository.getSportsmanByCoachAndSportCategory(coachId,sportCategoryId);
    }

    @Override//3.3
    public List<Sportsman> getSportsmanBySportClub(int sportClubId) {
        return sportsmanRepository.getSportsmanBySportClub(sportClubId);
    }

    @Override//4
    public List<SportsmanSportCoach> getSportsmenAndTheirSports() {

        return sportsmanSportCoachRepository.getSportsmenAndTheirSport();
    }

    @Override//5
    public List<SportsmanSportCoach> getCoachesBySportsman(int sportsmanId) {
        return sportsmanSportCoachRepository.getCoachesBySportsman(sportsmanId);
    }

    @Override//6.1
    public List<Competition> getCompetitionsByDateInterval(Date firstDate, Date secondDate) {
        return competitionRepository.getCompetitionByDateInterval(firstDate,secondDate);
    }

    @Override//6.2
    public List<Competition> getCompetitionsByDateIntervalAndOrganizer(
            Date firstDate, Date secondDate, int organizerId) {
        return competitionRepository.getCompetitionByDateIntervalAndOrganizer(firstDate,secondDate,organizerId);
    }

    @Override//7.1
    public List<SportsmanCompetition> getWinnersByCompetition(int competitionId) {
        return sportsmanCompetitionRepository.getWinnersByCompetition(competitionId);
    }

    @Override//7.2
    public List<SportsmanCompetition> getAllParticipantsByCompetition(int competitionId) {
        return sportsmanCompetitionRepository.getAllParticipantsByCompetition(competitionId);
    }

    @Override//8.1
    public List<Competition> getCompetitionsByBuilding(int sportBuildingId) {
        return competitionRepository.getCompetitionsByBuilding(sportBuildingId);
    }

    @Override//8.2
    public List<Competition> getCompetitionsBySport(int sportId) {
        return competitionRepository.getCompetitionsSport(sportId);
    }

    @Override//9
    public List<SportClubAndAmountOfSportsmen> getSportClubAndSportsmenByDateInterval(
            Date firstDate, Date secondDate) {
        List<SportClub> sportClubs =
                sportsmanCompetitionRepository.getSportClubByDateInterval(firstDate,secondDate);
        List<Long> amountOfSportsmen =
                sportsmanCompetitionRepository.getAmountOfSportsmenByDateInterval(firstDate,secondDate);
        List<SportClubAndAmountOfSportsmen> list = new ArrayList<>();
        for (int i = 0; i < sportClubs.size(); i++) {
            list.add(new SportClubAndAmountOfSportsmen(
                    sportClubs.get(i),
                    amountOfSportsmen.get(i)
            ));
        }

        return list;
    }

    @Override//10
    public List<Coach> getCoachesBySport(int sportId) {
        return sportsmanSportCoachRepository.getCoachesBySport(sportId);
    }

    @Override//11
    public List<Sportsman> getSportsmenNotCompetitionParticipantsByDateInterval(
            Date firstDate, Date secondDate) {
        return sportsmanRepository.getSportsmenNotCompetitionParticipantsByDateInterval(
                firstDate,secondDate);
    }

    @Override//12
    public List<OrganizerAndAmountOfCompetitions> getOrganizerCompetitionsByDateInterval(Date firstDate, Date secondDate) {
        List<Organizer>organizers=competitionRepository.getOrganizerByDateInterval(firstDate,secondDate);
        List<Long> amountOfCompetitions =
                competitionRepository.getAmountOfCompetitionsByDateInterval(firstDate,secondDate);
        List<OrganizerAndAmountOfCompetitions> list=new ArrayList<>();
        for (int i = 0; i <organizers.size() ; i++) {
            list.add(new OrganizerAndAmountOfCompetitions(organizers.get(i),amountOfCompetitions.get(i)));
        }

        return list;
    }

    @Override//13
    public List<Competition> getSportBuildingByDateInterval(Date firstDate, Date secondDate) {
        return competitionRepository.getSportBuildingByDateInterval(firstDate,secondDate);
    }
}
