package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * */
    int no = 2;


    public void increment(View view) {
       // int no = 2;
        no = no + 1;

        displayQuantity(no);
    }


    public void decrement(View view) {
        //int no = 2;
        no = no - 1;
        displayQuantity(no);
    }

    public void submitOrder(View view) {
        //int no = 2;
        //display(no);
        CheckBox check = (CheckBox) findViewById(R.id.checkbox);
        boolean checked = check.isChecked();
        CheckBox check2 = (CheckBox) findViewById(R.id.checkboxchocolate);
        boolean checkedchocolate = check2.isChecked();
        //Log.v("MainActivity", "Has whipped cream : " + checked);
        int price = calculatePrice(no);
        EditText name = (EditText) findViewById(R.id.name);
        Editable getname;
        getname = name.getText();
        //displayPrice(price);
        //displayMessage("Total price is " + price + "\nThank You");
        createOrderSummary(price, checked, checkedchocolate, getname);
    }
    private int calculatePrice(int quantity) {
        return (quantity * 5);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private void createOrderSummary(int number, boolean checked, boolean checkedchocolate, Editable getname){
        displayMessage("Name: "+getname+ "\nAdd whipped cream?"+checked+"\nAdd Chocolate?"+checkedchocolate+"\nQuantity: "+no+"\nTotal: "+number+"\nThank you!" );
    }
}