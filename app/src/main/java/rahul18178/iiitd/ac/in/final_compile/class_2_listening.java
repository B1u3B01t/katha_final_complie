package rahul18178.iiitd.ac.in.final_compile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class class_2_listening extends AppCompatActivity {

    Button Next_to_marking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_2_listening);

        Next_to_marking = (Button) findViewById(R.id.next_to_marking_Button);

        Next_to_marking();
    }

    public void Next_to_marking()
    {
        Next_to_marking.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_listening_marking();
            }
        });
    }
    public void open_class_2_listening_marking()
    {
        Intent intent = new Intent(this, class_2_listening_marking.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
}
