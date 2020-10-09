package by.hymeck.unitconverter.full.debug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import by.hymeck.unitconverter.R;
import by.hymeck.unitconverter.viewmodels.DistanceViewModel;

public class DistanceFragment extends by.hymeck.unitconverter.fragments.DistanceFragment
{
    Spinner spinnerFrom;
    Spinner spinnerTo;

    public DistanceFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        spinnerFrom = view.findViewById(R.id.spinnerFrom);
        spinnerTo = view.findViewById(R.id.spinnerTo);

        EditText from = view.findViewById(R.id.valueFrom);
        from.setOnLongClickListener(v -> {
            setDataToClipboard(from.getText().toString());
            return true;
        });

        EditText to = view.findViewById(R.id.valueTo);
        to.setOnLongClickListener(v -> {
            setDataToClipboard(to.getText().toString());
            return true;
        });

        view.findViewById(R.id.buttonSwap).setOnClickListener(item -> { swapSpinnerItems(); mViewModel.swap();});
        return view;
    }

    private void swapSpinnerItems()
    {
        int itemFrom = spinnerFrom.getSelectedItemPosition();
        int itemTo = spinnerTo.getSelectedItemPosition();

        if (itemFrom == itemTo)
            return;

        spinnerTo.setSelection(itemFrom);
        spinnerFrom.setSelection(itemTo);
    }

    public void setDataToClipboard(String text)
    {
        if (text.equals(""))
            return;

        ClipboardManager clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(requireActivity().getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }

    public static DistanceFragment newInstance() { return new DistanceFragment(); }
}