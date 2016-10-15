package id.sch.smktelkom_mlg.learn.formsmb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTelp, etAlamat, etEmail, etTahun, etTanggal, etBulan;
    TextView tvHasil;
    Button btOK;
    RadioButton rbL, rbP;
    Spinner spRayon;
    CheckBox syarat;


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
        rbL = (RadioButton) findViewById(R.id.radioButtonPria);
        rbP = (RadioButton) findViewById(R.id.radioButtonWanita);
        spRayon = (Spinner) findViewById(R.id.spinnerRayon);
        syarat = (CheckBox) findViewById(R.id.checkBoxSyarat);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        etBulan = (EditText) findViewById(R.id.editTextBulan);

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
            String panggil = null;
            String sk = null;
            String rayon = spRayon.getSelectedItem().toString();

            int usia = Integer.parseInt(etTahun.getText().toString());
            usia = 2016 - usia;

            if (rbL.isChecked()) {
                panggil = "Bapak";
            } else if (rbP.isChecked()) {
                panggil = "Ibu";
            }

            if (syarat.isChecked()) {
                sk = "Menyetujui";
            } else {
                sk = "tidak menyetujui";
            }

            tvHasil.setText("Anda " + panggil + " " + nama + " berusia " + usia + " tahun, dengan nomor" +
                    " yang dapat dihubungi " + telp + " dan Email " +
                    email + " yang bertempat tinggal di " + alamat + ". Telah memilih" +
                    "rayon " + rayon + " serta " + sk + " syarat dan ketentuan");
        }

    }

    private Boolean isValid() {
        Boolean valid = true;

        String nama = etNama.getText().toString();
        String telp = etTelp.getText().toString();
        String alamat = etAlamat.getText().toString();
        String email = etEmail.getText().toString();
        String tahun = etTahun.getText().toString();
        String tanggal = etTanggal.getText().toString();
        String bulan = etBulan.getText().toString();

        if (tahun.isEmpty() || bulan.isEmpty() || tanggal.isEmpty()) {
            etTahun.setError("Kapan Anda Lahir?");
            valid = false;
        }

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
