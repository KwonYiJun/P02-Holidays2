package holidays.android.myapplicationdev.com.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.R.attr.type;

/**
 * Created by 15031795 on 25/4/2017.
 */

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> al;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R. id. lvHolidays);
        tv = (TextView) findViewById(R.id.textView2);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tv.setText(type);

        al = new ArrayList<Holiday>();

        if (type.equalsIgnoreCase("Secular")){
            al.add(new Holiday("New Year's Day", "1 Jan 2017", true, R.drawable.newyear));
            al.add(new Holiday("Labour Day", "1 May 2017", true, R.drawable.labourday));
        } else {
            al.add(new Holiday("Chinese New Year", "28-29 Jan 2017", false, R.drawable.cny));
            al.add(new Holiday("Good Friday", "14 April 2017", false, R.drawable.goodfriday));
        }

        aa = new HolidayAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoli = al.get(position);
                Toast.makeText(SecondActivity.this, selectedHoli.getName()
                                + ": " + selectedHoli.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}

