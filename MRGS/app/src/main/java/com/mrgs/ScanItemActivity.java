package com.mrgs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by andrew on 8/2/16.
 */
public class ScanItemActivity extends Activity {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PRICE = "price";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_item);
        editText = (EditText) findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String code = editText.getText().toString();

                if (!code.endsWith("x"))
                    return;

                String[] arr = code.split("-");
                if (arr.length < 2)
                    return;

                String name = arr[0];
                String price = arr[1];
                Intent data = new Intent();
                data.putExtra(EXTRA_NAME, name);
                data.putExtra(EXTRA_PRICE, price.substring(0, price.length() - 1));
                ScanItemActivity.this.setResult(OrderListActivity.RESULT_OK, data);
                ScanItemActivity.this.finish();
            }
        });
    }
}
