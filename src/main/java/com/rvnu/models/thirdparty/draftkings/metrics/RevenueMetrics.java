package com.rvnu.models.thirdparty.draftkings.metrics;

import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;
import org.javamoney.moneta.Money;

import java.time.LocalDate;
import java.util.Map;

public record RevenueMetrics(Map<Sport, Map<LocalDate, Money>> dailyRevenueBySport) {
}
