package com.modprobe.profit;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class SelectLangaugeActivity extends AppCompatActivity {

    public String[] languages = {"English","हिंदी","मराठी","ગુજરાતી","தமிழ்"};
    public String[] locale_strings = {"en","hi","mr","gu","ta"};
    SharedPreferences sp;
    SharedPreferences.Editor editor = AppController.getInstance().prefs.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        ListView select_language_listview =  (ListView)findViewById(R.id.select_language_listview);
        final TextView select_language_textview = (TextView)findViewById(R.id.select_language_textview);
        final Button select_language_button = (Button)findViewById(R.id.select_language_button);

        select_language_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //commit shared preferences
                //start tabbed fragment
                //remove current fragment4
                editor.commit();
                finish();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,languages){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        select_language_listview.setItemsCanFocus(true);
        select_language_listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        select_language_listview.setAdapter(adapter);
        select_language_listview.setClickable(true);
        select_language_listview.setSelection(0);
        select_language_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //Toast.makeText(getActivity(), "Select Locale is" + locale_strings[position], Toast.LENGTH_SHORT).show();
                Locale locale = new Locale(locale_strings[position]);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getResources().updateConfiguration(config,getResources().getDisplayMetrics());
//                getSupportActionBar().setTitle(R.string.app_name);
                select_language_textview.setText(R.string.select_language);
                select_language_button.setText(R.string.okay);
                onConfigurationChanged(config);
                //set into shared preferences
                editor.putString(Constants.LANGUAGE_KEY, locale_strings[position]);
                //Intent refresh = new Intent(getContext(), MainActivity.class);
                //refresh.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //refresh.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //getContext().startActivity(refresh);
            }


        });
    }
}