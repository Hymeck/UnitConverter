package by.hymeck.unitconverter.fragments;

import androidx.appcompat.widget.AppCompatTextView;
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
import android.widget.TextView;

import by.hymeck.unitconverter.R;
import by.hymeck.unitconverter.viewmodels.MassViewModel;

public class MassFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

    private MassViewModel mViewModel;

    public static MassFragment newInstance()
    {
        return new MassFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_mass, container, false);


        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.variantsMass, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        Spinner fromSpinner = view.findViewById(R.id.spinnerFrom);
        fromSpinner.setAdapter(fromAdapter);
        fromSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.variantsMass, android.R.layout.simple_spinner_item);
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


//        EditText textFrom = view.findViewById(R.id.textFrom);
//        EditText textTo = view.findViewById(R.id.textTo);
//        mViewModel.getFrom().observe(requireActivity(), textFrom::setText);
//        mViewModel.getTo().observe(requireActivity(), textTo::setText);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MassViewModel.class);
        EditText textFrom = getView().findViewById(R.id.valueFrom);
        EditText textTo = getView().findViewById(R.id.valueTo);
        mViewModel.getFrom().observe(requireActivity(), textFrom::setText);
        mViewModel.getTo().observe(requireActivity(), textTo::setText);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Spinner spin = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;
        String choice = parent.getItemAtPosition(position).toString();
        if(spin.getId() == R.id.spinnerFrom)
        {
            mViewModel.setFromUnit(choice);
        }
        else if(spin2.getId() == R.id.spinnerTo)
        {
            mViewModel.setToUnit(choice);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}