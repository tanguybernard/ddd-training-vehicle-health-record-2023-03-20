package com.zenika.vhr.maintenance.domaine.intervention;

import java.time.LocalDate;
import java.util.Objects;

public final class DateIntervention {
    private final LocalDate date;

    public DateIntervention(LocalDate dateIntervention, LocalDate dateAujourdhui) {

        if (dateIntervention.isBefore(dateAujourdhui)) {
            throw new IllegalArgumentException("Intervention interdite");
        }

        this.date = dateIntervention;
    }

    public LocalDate date() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (DateIntervention) obj;
        return Objects.equals(this.date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "DateIntervention[" + "date=" + date + ']';
    }

}
