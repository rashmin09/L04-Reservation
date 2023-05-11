package sg.edu.rp.c346.id22035777.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView nameView, mobileView, groupSizeView;
    EditText editName, editMobile, editGroupSize;
    DatePicker dP;
    TimePicker tP;
    CheckBox tableType;
    Button confirmationButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameView = findViewById(R.id.nameView);
        mobileView = findViewById(R.id.mobileView);
        groupSizeView = findViewById(R.id.groupSizeView);
        editName = findViewById(R.id.editName);
        editMobile = findViewById(R.id.editMobile);
        editGroupSize = findViewById(R.id.editGroupSize);
        dP = findViewById(R.id.dP);
        tP = findViewById(R.id.tP);
        tableType = findViewById(R.id.tableType);
        confirmationButton = findViewById(R.id.confirmationButton);
        resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editMobile.setText("");
                editGroupSize.setText("");
                dP.updateDate(2020, 5, 1);
                tP.setHour(19);
                tP.setMinute(30);
            }
        });

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String mobile = editMobile.getText().toString();
                String groupSize = editGroupSize.getText().toString();
                int day = dP.getDayOfMonth();
                int month = dP.getMonth() + 1;
                int year = dP.getYear();
                int hour = tP.getHour();
                int minute = tP.getMinute();
                String date = day + "/" + month + "/" + year;
                String time = hour + ":" + minute;
                Context context = getApplicationContext();
                String stringText = "Name: " + name + " Mobile No.: " + mobile + " Group Size: " + groupSize + " Booking Date: " + date + " Booking Time: " + time;
                Toast.makeText(context, stringText , Toast.LENGTH_SHORT).show();
            }
        });
    }
}