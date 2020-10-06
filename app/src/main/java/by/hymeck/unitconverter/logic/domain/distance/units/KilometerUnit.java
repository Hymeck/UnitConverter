package by.hymeck.unitconverter.logic.domain.distance.units;

import by.hymeck.unitconverter.logic.domain.distance.DistanceMetricUnit;
import by.hymeck.unitconverter.logic.domain.distance.DistanceUnits;

public class KilometerUnit extends DistanceMetricUnit
{
    public KilometerUnit() { super(DistanceUnits.Kilometer); }

    @Override
    public double getDefaultValue() { return 1000; }

    @Override
    public String toString() {return "km"; }
}
