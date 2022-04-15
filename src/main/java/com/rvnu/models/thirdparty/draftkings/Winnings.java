package com.rvnu.models.thirdparty.draftkings;

import org.javamoney.moneta.Money;

import java.util.Objects;

public class Winnings {
    private final Money nonTicket;
    private final Money ticket;

    public Winnings(final Money nonTicket, final Money ticket) {
        this.nonTicket = nonTicket;
        this.ticket = ticket;
    }

    public Money getNonTicket() {
        return nonTicket;
    }

    public Money getTicket() {
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
