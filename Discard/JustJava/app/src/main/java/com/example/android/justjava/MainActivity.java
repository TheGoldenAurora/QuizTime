package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the order button is clicked.
     */
    //Increment method:
    public void increment(View view) {
        if(quantity==100)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "You can't order more than 100 coffees in one go!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }

    //Decrement method:
    public void decrement(View view){


        if(quantity==1)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "You can't order less than one coffee", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCream.isChecked();
        //Log.e("MainActivity","They want whipped cream:" + " "+hasWhippedCream);

        CheckBox chocolate = (CheckBox) findViewById(R.id.choc);
        boolean hasChoc = chocolate.isChecked();
        //Log.e("MainActivity","They want chocolate:" +" "+hasChoc);

        int price = calculatePrice(hasWhippedCream,hasChoc);

        EditText customer = (EditText)findViewById(R.id.nameEditText);
        String name = customer.getText().toString();

        String priceMessage=createOrderSummary(name,price,hasWhippedCream,hasChoc);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//        //priceMessage=priceMessage+"\nThank You!";
//        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     *@return total price
     */
    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int price = 5;

        if(whippedCream==true)
            price+=1;
        if(chocolate==true)
            price+=2;


        return (price*quantity);
    }

    private String createOrderSummary(String name, int price, boolean whippedCream, boolean choc){
        String message="Name: "+name+"\nQuantity: "+price/5+"\nThey want whipped cream: "+whippedCream+"\nThey want chocolate: "+choc+"\nTotal: $"+price+"\nThank you!";
        return message;
    }



}