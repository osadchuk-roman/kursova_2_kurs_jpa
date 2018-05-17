package osadchuk.roman.requestModel;

import osadchuk.roman.model.Organizer;

public class OrganizerAndAmountOfCompetitions
{
    Organizer organizer;
    long amountOfCompetitions;

    public OrganizerAndAmountOfCompetitions() {
    }

    public OrganizerAndAmountOfCompetitions(Organizer organizer, long amountOfCompetitions) {

        this.organizer = organizer;
        this.amountOfCompetitions = amountOfCompetitions;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public long getAmountOfCompetitions() {
        return amountOfCompetitions;
    }

    public void setAmountOfCompetitions(long amountOfCompetitions) {
        this.amountOfCompetitions = amountOfCompetitions;
    }
}
