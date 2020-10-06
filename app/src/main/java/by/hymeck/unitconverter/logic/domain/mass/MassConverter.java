package by.hymeck.unitconverter.logic.domain.mass;


import by.hymeck.unitconverter.logic.core.IConverter;

public class MassConverter implements IConverter<Mass, MassMetricUnit>
{
    @Override
    // TODO: make method static
    public Mass Convert(Mass from, MassMetricUnit to)
    {
        double value = from.value;
        double fromValue = from.unit.getDefaultValue();
        double toValue = to.getDefaultValue();
        double factor = fromValue / toValue;
        return new Mass(to, value * factor);
    }
}