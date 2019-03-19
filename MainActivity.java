package nl.hr.myapplication80;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cocacola = findViewById(R.id.addBtn); // find reference by id called addbtn store as addbtn
        cocacola.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText hello = findViewById(R.id.firstNumEditText); // i want to edit fnet
                EditText tea = findViewById(R.id.secondNumEditText); //
                TextView party = findViewById(R.id.resultTextView); //

                int num1 = Integer.parseInt(hello.getText().toString());
                int num2 = Integer.parseInt(tea.getText().toString());
                int result = num1 + num2;
                party.setText(result + "");

            }
        });
    }
}
