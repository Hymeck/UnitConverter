package by.hymeck.unitconverter.logic.domain.mass.units;

import by.hymeck.unitconverter.logic.domain.mass.MassMetricUnit;
import by.hymeck.unitconverter.logic.domain.mass.MassUnits;

public class KilogramUnit extends MassMetricUnit
{
    public KilogramUnit()
    {
        super(MassUnits.Kilogram);
    }

    @Override
    public double getDefaultValue()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return "kg";
    }
}
