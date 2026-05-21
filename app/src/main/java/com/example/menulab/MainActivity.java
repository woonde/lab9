package com.example.menulab; // ← оставь свой package, который создала Android Studio

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNumber;
    private int currentNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumber = findViewById(R.id.textViewNumber);
        textViewNumber.setText(String.valueOf(currentNumber));

        registerForContextMenu(textViewNumber);
    }

    // ========== ГЛАВНОЕ МЕНЮ (OptionsMenu): изменение цвета текста ==========

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_text_red) {
            textViewNumber.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.action_text_green) {
            textViewNumber.setTextColor(Color.GREEN);
            return true;
        } else if (id == R.id.action_text_blue) {
            textViewNumber.setTextColor(Color.BLUE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // ========== КОНТЕКСТНОЕ МЕНЮ (ContextMenu): +10 / -10 ==========

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Изменить число");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.context_increase) {
            currentNumber += 10;
            textViewNumber.setText(String.valueOf(currentNumber));
            return true;
        } else if (id == R.id.context_decrease) {
            currentNumber -= 10;
            textViewNumber.setText(String.valueOf(currentNumber));
            return true;
        }

        return super.onContextItemSelected(item);
    }
}