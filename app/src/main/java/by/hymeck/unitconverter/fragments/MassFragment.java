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
import android.widget.Spinner;

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
                R.array.massVariants, android.R.layout.simple_spinner_item);
        Spinner fromMassSpinner = view.findViewById(R.id.spinnerFromMassVariants);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        fromMassSpinner.setAdapter(fromAdapter);


        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.massVariants, android.R.layout.simple_spinner_item);
        Spinner toMassSpinner = view.findViewById(R.id.spinnerToMassVariants);
        toAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        toMassSpinner.setAdapter(toAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MassViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}