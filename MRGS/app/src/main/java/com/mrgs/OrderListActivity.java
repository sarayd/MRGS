package com.mrgs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by gy on 2016. 8. 3..
 */
public class OrderListActivity extends AppCompatActivity {
    private static final int REQ_ITEM = 0;
    public static final int RESULT_OK = 0;

    private OrderAdapter adapter = new OrderAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);

        findViewById(R.id.checkout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Start Credit Card Scan Activity\n(not implemented yet)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(v.getContext(), MyScanActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.menu_add_order) {
            //Toast.makeText(this, "Start Order Scan Activity\n(not implemented yet)", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(this, ScanItemActivity.class), REQ_ITEM);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_ITEM:
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra(ScanItemActivity.EXTRA_NAME);
                    String price = data.getStringExtra(ScanItemActivity.EXTRA_PRICE);
                    Log.d("asdf", "name: " + name);
                    Log.d("asdf", "price: " + price);
                    adapter.addOrder(new Order(name, price));
                    adapter.notifyDataSetChanged();
                }
        }
    }
}
