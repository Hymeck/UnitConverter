package by.hymeck.unitconverter.full.debug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import by.hymeck.unitconverter.R;

public class MassFragment extends by.hymeck.unitconverter.fragments.MassFragment
{

//    Button swapButton;
    Spinner spinnerFrom;
    Spinner spinnerTo;

    public MassFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_mass, container, false);

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

    public static MassFragment newInstance() { return new MassFragment(); }
}
