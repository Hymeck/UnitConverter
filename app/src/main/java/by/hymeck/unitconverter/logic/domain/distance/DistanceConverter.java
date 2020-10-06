package by.hymeck.unitconverter.logic.domain.distance;

import by.hymeck.unitconverter.logic.core.IConverter;

public class DistanceConverter implements IConverter<Distance, DistanceMetricUnit>
{
    @Override
    public Distance Convert(Distance from, DistanceMetricUnit to)
    {
        double value = from.value;
        double fromValue = from.unit.getDefaultValue();
        double toValue = to.getDefaultValue();
        double factor = fromValue / toValue;
        return new Distance(to, value * factor);
    }
}
