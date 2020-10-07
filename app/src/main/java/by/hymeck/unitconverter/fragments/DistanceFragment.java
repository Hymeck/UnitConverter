package by.hymeck.unitconverter.fragments;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import by.hymeck.unitconverter.R;
import by.hymeck.unitconverter.viewmodels.DistanceViewModel;

public class DistanceFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

    private DistanceViewModel mViewModel;

    public static DistanceFragment newInstance()
    {
        return new DistanceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);


        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.variantsDistance, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        Spinner fromSpinner = view.findViewById(R.id.spinnerFrom);
        fromSpinner.setAdapter(fromAdapter);
        fromSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.variantsDistance, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        Spinner toSpinner = view.findViewById(R.id.spinnerTo);
        toSpinner.setAdapter(toAdapter);
        toSpinner.setOnItemSelectedListener(this);

        view.findViewById(R.id.button0).setOnClickListener(item -> mViewModel.input("0"));
        view.findViewById(R.id.button1).setOnClickListener(item -> mViewModel.input("1"));
        view.findViewById(R.id.button2).setOnClickListener(item -> mViewModel.input("2"));
        view.findViewById(R.id.button3).setOnClickListener(item -> mViewModel.input("3"));
        view.findViewById(R.id.button4).setOnClickListener(item -> mViewModel.input("4"));
        view.findViewById(R.id.button5).setOnClickListener(item -> mViewModel.input("5"));
        view.findViewById(R.id.button6).setOnClickListener(item -> mViewModel.input("6"));
        view.findViewById(R.id.button7).setOnClickListener(item -> mViewModel.input("7"));
        view.findViewById(R.id.button8).setOnClickListener(item -> mViewModel.input("8"));
        view.findViewById(R.id.button9).setOnClickListener(item -> mViewModel.input("9"));
        view.findViewById(R.id.buttonConvert).setOnClickListener(item -> mViewModel.convert());
        view.findViewById(R.id.buttonPeriod).setOnClickListener(item -> mViewModel.setPeriod());
        view.findViewById(R.id.buttonErase).setOnClickListener(item -> mViewModel.erase());
        view.findViewById(R.id.buttonClear).setOnClickListener(item -> mViewModel.clear());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DistanceViewModel.class);
        EditText textFrom = getView().findViewById(R.id.valueFrom);
        EditText textTo = getView().findViewById(R.id.valueTo);
        mViewModel.getFrom().observe(requireActivity(), textFrom::setText);
        mViewModel.getTo().observe(requireActivity(), textTo::setText);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Spinner spinner = (Spinner)parent;
        String choice = parent.getItemAtPosition(position).toString();

        if(spinner.getId() == R.id.spinnerFrom)
            mViewModel.setFromUnit(choice);

        else if(spinner.getId() == R.id.spinnerTo)
            mViewModel.setToUnit(choice);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}