package by.hymeck.unitconverter.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import by.hymeck.unitconverter.logic.domain.time.*;
import by.hymeck.unitconverter.logic.domain.time.units.*;


public class TimeViewModel extends ViewModel
{
    private static final String emptyField = "";

    private final MutableLiveData<String> from = new MutableLiveData<>(emptyField);
    private final MutableLiveData<String> to = new MutableLiveData<>(emptyField);

    private final TimeConverter timeConverter = new TimeConverter();

    private MutableLiveData<TimeUnits> fromUnit = new MutableLiveData<>(TimeUnits.Second);
    private MutableLiveData<TimeUnits> toUnit = new MutableLiveData<>(TimeUnits.Second);


    public void input(String digit) { from.setValue(from.getValue() + digit); }

    public LiveData<String> getFrom()
    {
        return from;
    }

    public LiveData<String> getTo()
    {
        return to;
    }

    public void setPeriod()
    {
        String value = from.getValue();
        if (!value.contains("."))
        {
            if (value.equals(emptyField))
                from.setValue("0.");

            else
                from.setValue(value + ".");
        }
    }

    public void erase()
    {
        String value = from.getValue();
        int length = value.length();

        if (length > 1)
            from.setValue(value.substring(0, length - 1));

        else
            clear();
    }

    public void clear()
    {
        from.setValue(emptyField);
        to.postValue(emptyField);
    }

    public void convert()
    {
        if(from.getValue().equals(emptyField))
            return;

        double value = Double.parseDouble(from.getValue());
        TimeMetricUnit fromUnit = getTimeMetricUnit(this.fromUnit.getValue());
        Time from = new Time(fromUnit, value);

        TimeMetricUnit toUnit = getTimeMetricUnit(this.toUnit.getValue());
        Time to = timeConverter.Convert(from, toUnit);

        String convertedValue = String.format("%.5f", to.value);
        this.to.postValue(convertedValue);
    }

    public void setFromUnit(String unit)
    {
        TimeUnits u = TimeUnits.valueOf(unit);
        if (u == fromUnit.getValue())
            return;

        fromUnit.postValue(u);

        if (from.getValue().equals(emptyField))
            return;

        TimeMetricUnit timeMetricUnit = getTimeMetricUnit(u);
        double value = Double.parseDouble(from.getValue());
        Time from = new Time(timeMetricUnit, value);

        timeMetricUnit = getTimeMetricUnit(toUnit.getValue());
        Time to = timeConverter.Convert(from, timeMetricUnit);

        String convertedValue = String.format("%.5f", to.value);
        this.to.postValue(convertedValue);
    }

    public void setToUnit(String unit)
    {
        TimeUnits u = TimeUnits.valueOf(unit);
        if (u == toUnit.getValue())
            return;

        toUnit.postValue(u);

        if (from.getValue().equals(emptyField))
            return;

        double fromValue = Double.parseDouble(from.getValue());
        TimeMetricUnit distanceMetricUnit = getTimeMetricUnit(fromUnit.getValue());
        Time from = new Time(distanceMetricUnit, fromValue);

        TimeMetricUnit convertedUnit = getTimeMetricUnit(u);
        Time to = timeConverter.Convert(from, convertedUnit);

        String convertedValue = String.format("%.5f", to.value);
        this.to.postValue(convertedValue);
    }

    private TimeMetricUnit getTimeMetricUnit(TimeUnits timeUnits)
    {
        TimeMetricUnit timeMetricUnit;

        switch (timeUnits)
        {
            case Second:
                timeMetricUnit = new SecondUnit();
                break;

            case Minute:
                timeMetricUnit = new MinuteUnit();
                break;

            case Hour:
                timeMetricUnit = new HourUnit();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + timeUnits);
        }

        return timeMetricUnit;
    }
}