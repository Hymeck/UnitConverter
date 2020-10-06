package by.hymeck.unitconverter.logic.domain.distance.units;

import by.hymeck.unitconverter.logic.domain.distance.DistanceMetricUnit;
import by.hymeck.unitconverter.logic.domain.distance.DistanceUnits;

public class CentimeterUnit extends DistanceMetricUnit
{
    public CentimeterUnit() { super(DistanceUnits.Centimeter); }

    @Override
    public double getDefaultValue() { return 0.01; }

    @Override
    public String toString() {return "cm"; }
}
