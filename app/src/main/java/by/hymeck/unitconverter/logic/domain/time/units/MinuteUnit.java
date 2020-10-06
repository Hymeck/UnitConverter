package by.hymeck.unitconverter.logic.domain.time.units;

import by.hymeck.unitconverter.logic.domain.time.TimeMetricUnit;
import by.hymeck.unitconverter.logic.domain.time.TimeUnits;

public class MinuteUnit extends TimeMetricUnit
{
    public MinuteUnit() { super(TimeUnits.Minute); }

    @Override
    public double getDefaultValue() { return 60; }

    @Override
    public String toString() { return "m"; }
}
