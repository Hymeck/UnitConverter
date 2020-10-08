package by.hymeck.unitconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.hymeck.unitconverter.R;

public class NumpadFragment extends Fragment
{
    public NumpadFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.numpad, container, false);
    }
}
