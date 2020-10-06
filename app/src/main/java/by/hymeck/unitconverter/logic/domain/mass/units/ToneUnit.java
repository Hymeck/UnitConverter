package by.hymeck.unitconverter.logic.domain.mass.units;

import by.hymeck.unitconverter.logic.domain.mass.MassMetricUnit;
import by.hymeck.unitconverter.logic.domain.mass.MassUnits;

public class ToneUnit extends MassMetricUnit
{
    public ToneUnit() { super(MassUnits.Tone); }

    @Override
    public double getDefaultValue() {return 1000; }

    @Override
    public String toString() { return "t";}
}
