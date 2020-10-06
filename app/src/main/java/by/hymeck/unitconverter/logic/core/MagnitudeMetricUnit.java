package by.hymeck.unitconverter.logic.core;

public abstract class MagnitudeMetricUnit
{
    public final Enum unit;

    protected MagnitudeMetricUnit(Enum unit)
    {
        this.unit = unit;
    }
    public abstract double getDefaultValue();
}
