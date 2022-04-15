package com.rvnu.models.thirdparty.draftkings;

import java.math.BigDecimal;
import java.util.Objects;

public class Winnings {
    private final BigDecimal nonTicket;
    private final BigDecimal ticket;

    public Winnings(final BigDecimal nonTicket, final BigDecimal ticket) {
        this.nonTicket = nonTicket;
        this.ticket = ticket;
    }

    public BigDecimal getNonTicket() {
        return nonTicket;
    }

    public BigDecimal getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winnings winnings = (Winnings) o;
        return Objects.equals(nonTicket, winnings.nonTicket) && Objects.equals(ticket, winnings.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonTicket, ticket);
    }

    @Override
    public String toString() {
        return "Winnings{" +
                "nonTicket=" + nonTicket +
                ", ticket=" + ticket +
                '}';
    }
}
