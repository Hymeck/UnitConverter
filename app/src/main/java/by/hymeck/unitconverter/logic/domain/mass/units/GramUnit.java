package by.hymeck.unitconverter.logic.domain.mass.units;

import by.hymeck.unitconverter.logic.domain.mass.MassMetricUnit;
import by.hymeck.unitconverter.logic.domain.mass.MassUnits;

public class GramUnit extends MassMetricUnit
{
    public GramUnit() {super(MassUnits.Gram);}

    @Override
    public double getDefaultValue() {return 0.001;}

    @Override
    public String toString() { return "g";}
}
