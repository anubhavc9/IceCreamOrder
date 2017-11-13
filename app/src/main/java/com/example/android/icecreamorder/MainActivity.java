package com.example.android.icecreamorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    boolean isChoco = false;
    boolean isStraw = false;
    boolean isNuts = false;
    boolean isJelly = false;
    int price=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity != 10)
            displayQuantity(++quantity);

    }

    public void decrement(View view) {
        if (quantity != 0)
            displayQuantity(--quantity);

    }

    private void displayQuantity(int value) {
        TextView numberOfIceCreamTextView = (TextView) findViewById(R.id.iceCream_number);
        numberOfIceCreamTextView.setText(" " + value);

    }

    public String orderSummary() {
        EditText name = (EditText) findViewById(R.id.name);
        String CustomerName = name.getText().toString();
        String detail = "Name: " + CustomerName + "\n";
        if (isChoco == true) {
            detail += "You have ordered Chocolate treat on top " + "\n";
            price+=15;
        }
        else {
            detail += "You have ordered Strawberry treat on top "  + "\n";
            price+=10;
        }
        detail += "With Toppings: "+"\n";
        detail += "Nuts: " + getNuts() + "\n";
        detail += "Jelly: "+ getJelly() + "\n";
        detail += "Quantity: " + quantity + "\n";
        price=price*quantity;
        if(getNuts()==true)
        {
            price+=5;
        }
        if(getJelly()==true)
        {
            price+=10;
        }
        detail+= "Your total amount is : "+price+"\n";
        return detail;

    }

    public void order(View v) {
        Intent i=new Intent(this,fileIntent.class);
        i.putExtra("key",orderSummary() );
        startActivity(i);
         }
    public String credits()
    {
        String str ="This app is created by "+"\n\n\n";
        str+="Akshit Tayal 16502"+"\n";
        str+="Anubhav Kandiyal 16506"+"\n";
        str+="Vansh Rajpal 16542"+"\n";
        return str;
    }
    public void credit(View x) {
        Intent i=new Intent(this,creditsintent.class);
        i.putExtra("key",credits());
        startActivity(i);
    }

    public void OnRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.choclolate:
                if (checked)
                    isChoco = true;
                break;
            case R.id.strawberry:
                if (checked)
                    isStraw = true;
                break;
        }
    }

    public boolean getNuts() {
        CheckBox check = (CheckBox) findViewById(R.id.nuts);
        return check.isChecked();

    }
    public boolean getJelly(){
        CheckBox check = (CheckBox) findViewById(R.id.jelly);
        return check.isChecked();
    }
}
