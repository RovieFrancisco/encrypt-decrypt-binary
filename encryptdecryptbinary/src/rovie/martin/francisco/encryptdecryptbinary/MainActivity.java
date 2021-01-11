package rovie.martin.francisco.encryptdecryptbinary;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.input);
        final EditText output = (EditText) findViewById(R.id.output);

        Button encrypt = (Button) findViewById(R.id.encrypt);
        Button decrypt = (Button) findViewById(R.id.decrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.getText().toString().equals("")) {
                     output.setText(Encrypt(input.getText().toString()));
                     input.setText("");
                }
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.getText().toString().equals("")) {
                     output.setText(Decrypt(input.getText().toString().split(" ")));
                     input.setText("");
                }
            }
        });
    }

    public String Encrypt(String input) {
        String result = "";

        for (int x = 0; x < input.length(); x++) {
            String add = Integer.toBinaryString(input.charAt(x));

            while (add.length() != 8) {
                add = "0" + add;
            }

            result += (add + " ");
        }

        return result;
    }

    public String Decrypt(String[] input) {
        try {
            String result = "";

            for (int x = 0; x < input.length; x++) {
                result += ((char) Integer.parseInt(input[x], 2));
            }

            return result;
        }
        catch (NumberFormatException e) {
            return "";
        }
    }
}