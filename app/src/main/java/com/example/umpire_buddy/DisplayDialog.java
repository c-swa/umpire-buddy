package com.example.umpire_buddy;

        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.os.Bundle;


        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatDialogFragment;

public class DisplayDialog extends AppCompatDialogFragment {

    private String title;
    private String message;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
        return builder.create();
    }

    public DisplayDialog(String passed_title, String passed_message){
        title = passed_title;
        message = passed_message;
    }
}


