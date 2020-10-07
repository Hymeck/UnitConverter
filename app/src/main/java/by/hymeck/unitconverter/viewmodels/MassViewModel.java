package by.hymeck.unitconverter.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import by.hymeck.unitconverter.logic.domain.mass.Mass;
import by.hymeck.unitconverter.logic.domain.mass.MassConverter;
import by.hymeck.unitconverter.logic.domain.mass.MassMetricUnit;
import by.hymeck.unitconverter.logic.domain.mass.MassUnits;
import by.hymeck.unitconverter.logic.domain.mass.units.GramUnit;
import by.hymeck.unitconverter.logic.domain.mass.units.KilogramUnit;
import by.hymeck.unitconverter.logic.domain.mass.units.ToneUnit;


public class MassViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private static final String emptyField = "";

    private final MutableLiveData<String> from = new MutableLiveData<>(emptyField);
    private final MutableLiveData<String> to = new MutableLiveData<>(emptyField);

    private final MassConverter massConverter = new MassConverter();

    private MutableLiveData<MassUnits> fromUnit = new MutableLiveData<>(MassUnits.Gram);
    private MutableLiveData<MassUnits> toUnit = new MutableLiveData<>(MassUnits.Gram);


    public void input(String digit)
    {
        from.setValue(from.getValue() + digit);
//        convert();
    }

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
            // TODO: convert?
        }
    }

    public void erase()
    {
        String value = from.getValue();
        int length = value.length();

        if (length > 1)
        {
            from.setValue(value.substring(0, length - 1));
//            convert();
        }

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
        MassMetricUnit fromUnit = getMassMetricUnit(this.fromUnit.getValue());
        Mass from = new Mass(fromUnit, value);

        MassMetricUnit toUnit = getMassMetricUnit(this.toUnit.getValue());
        Mass to = massConverter.Convert(from, toUnit);

        this.to.postValue(Double.toString(to.value));
    }

    public void setFromUnit(String unit)
    {
        MassUnits u = MassUnits.valueOf(unit);
        if (u == fromUnit.getValue())
            return;

        fromUnit.postValue(u);

        if (from.getValue().equals(emptyField))
            return;

        MassMetricUnit massMetricUnit = getMassMetricUnit(u);
        double value = Double.parseDouble(from.getValue());
        Mass from = new Mass(massMetricUnit, value);

        massMetricUnit = getMassMetricUnit(toUnit.getValue());
        Mass to = massConverter.Convert(from, massMetricUnit);
        this.to.setValue(Double.toString(to.value));
    }

    public void setToUnit(String unit)
    {
        MassUnits u = MassUnits.valueOf(unit);
        if (u == toUnit.getValue())
            return;

        toUnit.postValue(u);

        if (from.getValue().equals(emptyField))
            return;

        double fromValue = Double.parseDouble(from.getValue());
        MassMetricUnit fromMassMetricUnit = getMassMetricUnit(fromUnit.getValue());
        Mass from = new Mass(fromMassMetricUnit, fromValue);

        double value = Double.parseDouble(to.getValue());

        MassMetricUnit convertedUnit = getMassMetricUnit(u);
        Mass to = massConverter.Convert(from, convertedUnit);

        this.to.setValue(Double.toString(to.value));
    }

    private MassMetricUnit getMassMetricUnit(MassUnits massUnits)
    {
        MassMetricUnit massMetricUnit;
        switch (massUnits)
        {
            case Gram:
                massMetricUnit = new GramUnit();
                break;

            case Kilogram:
                massMetricUnit = new KilogramUnit();
                break;

            case Tone:
                massMetricUnit = new ToneUnit();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + massUnits);
        }

        return massMetricUnit;
    }
}