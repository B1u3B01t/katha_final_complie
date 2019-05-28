package rahul18178.iiitd.ac.in.final_compile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class class_2_all_activities extends AppCompatActivity {


    Button Listening_Button;
    Button Speaking_Button;
    Button StoryTelling_Button;
    Button Reading_Button;
    Button Writing_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_2_all_activities);

        Listening_Button = (Button) findViewById(R.id.Listening_Button);
        Speaking_Button = (Button) findViewById(R.id.Speaking_Button);
        StoryTelling_Button = (Button) findViewById(R.id.StoryTelling_Button);
        Reading_Button = (Button) findViewById(R.id.Reading_Button);
        Writing_Button = (Button) findViewById(R.id.Writing_Button);



        Next_Listening_Button();
        Next_Speaking_Button();
        Next_StoryTelling();
        Next_Reading();
        Next_Writing();





    }
    public void Next_Listening_Button()
    {
        Listening_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_listening();
            }
        });
    }
    public void open_class_2_listening()
    {
        Intent intent = new Intent(this, class_2_listening.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void Next_Speaking_Button()
    {
        Speaking_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_speaking();
            }
        });
    }
    public void open_class_2_speaking()
    {
        Intent intent = new Intent(this, class_2_speaking.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void Next_StoryTelling()
    {
        StoryTelling_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_storytelling();
            }
        });
    }
    public void open_class_2_storytelling()
    {
        Intent intent = new Intent(this, class_2_storytelling.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void Next_Reading()
    {
        Reading_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_reading();
            }
        });
    }
    public void open_class_2_reading()
    {
        Intent intent = new Intent(this, class_2_reading.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void Next_Writing()
    {
        Writing_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open_class_2_writing();
            }
        });
    }
    public void open_class_2_writing()
    {
        Intent intent = new Intent(this, class_2_writing.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
}
