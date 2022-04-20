package com.rvnu.calculation.firstparty.draftkings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestEntryResult;
import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;
import com.rvnu.models.thirdparty.draftkings.metrics.RevenueMetrics;
import org.javamoney.moneta.Money;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RevenueMetricsCalculator {
    public RevenueMetrics calculate(final Set<ContestEntryResult> results) {
        final Map<Sport, Map<LocalDate, Money>> dailyRevenueBySport = new HashMap<>();

        for (final ContestEntryResult result : results) {
            final Map<LocalDate, Money> dailyRevenue = dailyRevenueBySport.computeIfAbsent(result.sport(), (v) -> new HashMap<>());
            dailyRevenue.merge(
                    result.contestStartTime().value().atZone(ZoneId.of("UTC")).toLocalDate(),
                    result.winnings().nonTicket().getValue().add(result.winnings().ticket().getValue()),
                    Money::add
            );
        }

        return new RevenueMetrics(dailyRevenueBySport);
    }
}
