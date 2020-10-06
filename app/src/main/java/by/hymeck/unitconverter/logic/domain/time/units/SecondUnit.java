package by.hymeck.unitconverter.logic.domain.time.units;

import by.hymeck.unitconverter.logic.domain.time.TimeMetricUnit;
import by.hymeck.unitconverter.logic.domain.time.TimeUnits;

public class SecondUnit extends TimeMetricUnit
{
    public SecondUnit() { super(TimeUnits.Second); }

    @Override
    public double getDefaultValue() { return 1; }

    @Override
    public String toString() { return "s"; }
}
