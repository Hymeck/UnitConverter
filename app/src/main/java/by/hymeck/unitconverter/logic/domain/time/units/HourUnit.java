package by.hymeck.unitconverter.logic.domain.time.units;

import by.hymeck.unitconverter.logic.domain.time.TimeMetricUnit;
import by.hymeck.unitconverter.logic.domain.time.TimeUnits;

public class HourUnit extends TimeMetricUnit
{
    public HourUnit() { super(TimeUnits.Hour); }

    @Override
    public double getDefaultValue() { return 3600; }

    @Override
    public String toString() { return "h";}
}
