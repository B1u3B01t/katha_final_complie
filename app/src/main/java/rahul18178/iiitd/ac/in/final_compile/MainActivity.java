package rahul18178.iiitd.ac.in.final_compile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.button);
        next();

    }
    public void next()
    {
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_next();
            }
        });
    }
    public void open_next()
    {
        Intent intent1 = new Intent(MainActivity.this, class_2_student_details.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent1);
    }
}
