package com.example.umpire_buddy;

        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.os.Bundle;


        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatDialogFragment;

public class DisplayDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Example Title")
                .setMessage("This is a dialog")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
        return builder.create();
    }
}

