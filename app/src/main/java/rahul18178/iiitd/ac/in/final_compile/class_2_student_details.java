package rahul18178.iiitd.ac.in.final_compile;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class class_2_student_details extends AppCompatActivity {

    EditText nameInput;
    EditText IDEditText;
    EditText Marks;

    Button SubmitButton;
    Button RetrieveButton;
    Button NextButton;
    Button UpdateButton;


    private static final String TAG = "class_2_student_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_2_student_details);
        GlobalClass.myDb = new DatabaseHelper(this);

        nameInput = (EditText) findViewById(R.id.Name_EditText);
        IDEditText = (EditText) findViewById(R.id.ID_EditText);
        Marks = (EditText) findViewById(R.id.Marks_EditText);

        SubmitButton = (Button) findViewById(R.id.Save_Button);
        RetrieveButton = (Button) findViewById(R.id.Retrieve_Button);
        NextButton = (Button) findViewById(R.id.Next_Button);
        UpdateButton = (Button) findViewById(R.id.Update_Button);

        AddData();
        viewAll();
        Next();
        Update_Data();



    }
    public void showMsg(String title, String Msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Msg);
        builder.show();

    }

    private void showToast(String text)
    {
        Toast.makeText(class_2_student_details.this, text, Toast.LENGTH_SHORT).show();
    }
    public void Next()
    {
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: going next");
                showToast("going next");
                open_class_2_all_activities();
            }
        });
    }
    public void open_class_2_all_activities()
    {
        Intent intent = new Intent(class_2_student_details.this, class_2_all_activities.class);
        //intent.putExtra("data", getMyDb());
        startActivity(intent);
    }
    public void AddData()
    {
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean isInserted =  GlobalClass.myDb.insertData(nameInput.getText().toString(), "0");
                if (isInserted == true)
                {
                    Toast.makeText(class_2_student_details.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(class_2_student_details.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void viewAll()
    {
        RetrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = GlobalClass.myDb.getAllData();
                if (res.getCount() == 0)
                {
                    //show meassage
                    showMsg("ERROR", "NO DATA FOUND");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("NAME : "+res.getString(1)+"\n");
                    buffer.append("MARKS : "+res.getString(2)+"\n\n");

                }
                // show all data
                showMsg("DATA", buffer.toString() );
            }
        });
    }
    public void Update_Data()
    {
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = GlobalClass.myDb.updateData(IDEditText.getText().toString(),nameInput.getText().toString(),Marks.getText().toString());
                if (isUpdate == true)
                {
                    Toast.makeText(class_2_student_details.this, "Data updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(class_2_student_details.this, "Data Not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
