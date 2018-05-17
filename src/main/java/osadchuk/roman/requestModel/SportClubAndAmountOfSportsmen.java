package osadchuk.roman.requestModel;

import osadchuk.roman.model.SportClub;

public class SportClubAndAmountOfSportsmen {
    SportClub sportClub;
    long amountOfSportsmen;

    public SportClubAndAmountOfSportsmen() {
    }

    public SportClubAndAmountOfSportsmen(SportClub sportClub, long amountOfSportsmen) {
        this.sportClub = sportClub;
        this.amountOfSportsmen = amountOfSportsmen;
    }

    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }

    public long getAmountOfSportsmen() {
        return amountOfSportsmen;
    }

    public void setAmountOfSportsmen(long amountOfSportsmen) {
        this.amountOfSportsmen = amountOfSportsmen;
    }
}
