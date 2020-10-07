package by.hymeck.unitconverter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import by.hymeck.unitconverter.R;
import by.hymeck.unitconverter.viewmodels.MassViewModel;

public class DistanceFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

    private MassViewModel massViewModel;

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
        Spinner fromSpinner = view.findViewById(R.id.spinnerFrom);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        fromSpinner.setAdapter(fromAdapter);


        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.variantsDistance, android.R.layout.simple_spinner_item);
        Spinner toSpinner = view.findViewById(R.id.spinnerTo);
        toAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        toSpinner.setAdapter(toAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        massViewModel = ViewModelProviders.of(this).get(MassViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
//        String choice = parent
//        massViewModel.setToUnit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}