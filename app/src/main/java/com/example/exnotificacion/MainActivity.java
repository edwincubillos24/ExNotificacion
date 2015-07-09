package com.example.exnotificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    EditText eTitulo,eContenido, eTicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doNotification(View view){

        String title = "", content ="", ticker = "";

        eTitulo = (EditText) findViewById(R.id.eTitulo);
        eContenido = (EditText) findViewById(R.id.eContenido);
        eTicker = (EditText) findViewById(R.id.eTicker);

        title = eTitulo.getText().toString();
        content = eContenido.getText().toString();
        ticker = eTicker.getText().toString();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle(title)
                .setContentText(content)
                .setTicker(ticker)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentInfo("Dato");

        Intent notIntent = new Intent(MainActivity.this, ResultsActivity.class);

        PendingIntent contIntent = PendingIntent.getActivity(MainActivity.this, 0, notIntent, 0);

        builder.setContentIntent(contIntent);

        NotificationManager nm =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1,builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
