package by.hymeck.unitconverter.logic.core;

public abstract class Magnitude
{
    public final MagnitudeMetricUnit unit;
    public final double value;

    protected Magnitude(MagnitudeMetricUnit unit, double value)
    {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public String toString() { return value + " " + unit.toString();}
}