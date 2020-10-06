package by.hymeck.unitconverter.logic.domain.distance.units;

import by.hymeck.unitconverter.logic.domain.distance.DistanceMetricUnit;
import by.hymeck.unitconverter.logic.domain.distance.DistanceUnits;

public class MeterUnit extends DistanceMetricUnit
{
    public MeterUnit() { super(DistanceUnits.Meter); }

    @Override
    public double getDefaultValue() { return 1; }

    @Override
    public String toString() {return "m"; }
}
