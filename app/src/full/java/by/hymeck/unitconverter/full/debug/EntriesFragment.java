package by.hymeck.unitconverter.full.debug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import by.hymeck.unitconverter.R;

public class EntriesFragment extends Fragment
{

    public EntriesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.entries, container, false);

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

        return view;
    }

    public void setDataToClipboard(String text)
    {
        ClipboardManager clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(requireActivity().getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
}