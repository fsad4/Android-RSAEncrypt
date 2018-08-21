package app.rsa_example.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

	static {
		System.loadLibrary("libso");
	}

	native char[] Encrypt(String plain);

	native char[] Decrypt(String encrypted);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String plain = "RSA Encrypt";
		System.out.println("\nPlain Text\t"+ plain);

		String encrypted_text = new String(Encrypt(plain));
		System.out.println("\nEncrypted Text\t"+ encrypted_text);

		String decrypted_text = new String(Decrypt(encrypted_text));
		System.out.println("\nDecrypted Text\t"+ decrypted_text);
	}
}
