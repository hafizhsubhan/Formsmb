package id.sch.smktelkom_mlg.learn.formsmb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTelp, etAlamat, etEmail;
    TextView tvHasil;
    Button btOK;
    RadioGroup rgKelamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelp = (EditText) findViewById(R.id.editTextTelp);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        btOK = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgKelamin = (RadioGroup) findViewById(R.id.radioGroupKelamin);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProccess();
            }
        });


    }

    private void doProccess() {

        if (isValid()) {
            String nama = etNama.getText().toString();
            String telp = etTelp.getText().toString();
            String alamat = etAlamat.getText().toString();
            String email = etEmail.getText().toString();


            tvHasil.setText("Anda bernama " + nama + " dengan nomor" +
                    " yang dapat dihubungi " + telp + " dan Email " +
                    email + " yang bertempat tinggal di " + alamat);
        }

    }

    private Boolean isValid() {
        Boolean valid = true;

        String nama = etNama.getText().toString();
        String telp = etTelp.getText().toString();
        String alamat = etAlamat.getText().toString();
        String email = etEmail.getText().toString();


        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi!");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (telp.isEmpty() || telp.length() < 12) {
            etTelp.setError("Periksa kembali Telepon Anda, pastikan digit 12!");
            valid = false;
        } else {
            etTelp.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi!");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email Belum Diisi!");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        return valid;



    }
}
