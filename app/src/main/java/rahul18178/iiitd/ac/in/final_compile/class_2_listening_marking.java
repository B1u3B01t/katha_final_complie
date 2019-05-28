package rahul18178.iiitd.ac.in.final_compile;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class class_2_listening_marking extends AppCompatActivity {


    public String total_marks="0";
    RadioButton marks0;
    RadioButton marks1;
    RadioButton marks2;
    RadioButton marks3;
    RadioButton marks4;
    RadioButton marks5;

    Button UpdateMarksButton;
    public String id;
    public String name;
    public String marks;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_2_listening_marking);

        final String DATABASE_NAME =  "Student.db";
        final String TABLE_NAME =  "student_table";
        final String COL_0 =  "ID";
        final String COL_1 =  "NAME";
        final String COL_2 =  "MARKS";


        UpdateMarksButton = (Button) findViewById(R.id.update_marks_Button);
        marks0 = (RadioButton) findViewById(R.id.radioButton0);
        marks1 = (RadioButton) findViewById(R.id.radioButton1);
        marks2 = (RadioButton) findViewById(R.id.radioButton2);
        marks3 = (RadioButton) findViewById(R.id.radioButton3);
        marks4 = (RadioButton) findViewById(R.id.radioButton4);
        marks5 = (RadioButton) findViewById(R.id.radioButton5);

        SQLiteDatabase db = GlobalClass.myDb.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * " +
                "    FROM    student_table" +
                "    WHERE   ID = (SELECT MAX(ID)  FROM student_table)", null);

        check_marks0();
        check_marks1();
        check_marks2();
        check_marks3();
        check_marks4();
        check_marks5();

        res.moveToNext();
        //Update_and_move_to_menu();
        updateData();

        id = res.getString(0);
        name = res.getString(1);


    }

    public void check_marks0()
    {
        marks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks1.isChecked())
                {
                    total_marks = "0";
                }
            }
        });
    }
    public void check_marks1()
    {
        marks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks1.isChecked())
                {
                    total_marks = "1";
                }
            }
        });
    }
    public void check_marks2()
    {
        marks2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks2.isChecked())
                {
                    total_marks = "2";
                }
            }
        });
    }
    public void check_marks3()
    {
        marks3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks3.isChecked())
                {
                    total_marks = "3";
                }
            }
        });
    }
    public void check_marks4()
    {
        marks4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks4.isChecked())
                {
                    total_marks = "4";
                }
            }
        });
    }
    public void check_marks5()
    {
        marks5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marks5.isChecked())
                {
                    total_marks = "5";
                }
            }
        });
    }
    public void updateData()
    {
        UpdateMarksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate2 = GlobalClass.myDb.updateData(id,name,total_marks);
                if (isUpdate2 == true)
                {
                    Toast.makeText(class_2_listening_marking.this, total_marks, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(class_2_listening_marking.this, "Data Not updated", Toast.LENGTH_SHORT).show();
                }
                open_class_2_all_activities();

            }
        });
    }
    public void open_class_2_all_activities()
    {
        Intent intent = new Intent(this, class_2_all_activities.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void showMsg2(String title, String Msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Msg);
        builder.show();

    }
}
