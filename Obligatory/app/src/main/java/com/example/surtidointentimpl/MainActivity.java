package com.example.surtidointentimpl;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements OnClickListener {

	private static final int RESULT_LOAD_IMAGE = 0;
	private Intent in;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		Button btn5 = (Button) findViewById(R.id.button5);
		Button btn6 = (Button) findViewById(R.id.button6);
		Button btn7 = (Button) findViewById(R.id.button7);
		Button btn8 = (Button) findViewById(R.id.button8);
		Button btn9 = (Button) findViewById(R.id.button9);
		Button btn10 = (Button) findViewById(R.id.button10);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn10.setOnClickListener(this);

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode,resultCode,data);
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
			Uri path = data.getData();
			ImageView image = (ImageView) findViewById(R.id.image);
			image.setImageURI(path);
		}
	}

	@SuppressWarnings("deprecation")
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button1:
				Toast.makeText(this, "Seleccionado Localizacion por coordenadas", Toast.LENGTH_LONG).show();
				String lat = "41.60788";
				String lon = "0.623333";
				in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + lat + ',' + lon));
				startActivity(in);
				break;
			case R.id.button2:
				Toast.makeText(this, "Seleccionado Localizacion por direccion", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + "Carrer de Jaume II, 69, Lleida"));
				startActivity(in);
				break;
			case R.id.button3:
				Toast.makeText(this, "Accediendo a la web", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eps.udl.cat/"));
				startActivity(in);
				break;
			case R.id.button4:
				Toast.makeText(this, "Buscando en Google", Toast.LENGTH_LONG).show();
				//in = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=" + "escola politecnica superior UdL"));
				in = new Intent(Intent.ACTION_WEB_SEARCH);
				in.putExtra(SearchManager.QUERY, "escola politecnica superior UdL");
				startActivity(in);
				break;
			case R.id.button5:
				Toast.makeText(this, "Marcando el Tlfn.", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
				startActivity(in);
				break;
			case R.id.button6:
				Toast.makeText(this, "Accediendo a contactos", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_VIEW);
				in.setData(People.CONTENT_URI);
				startActivity(in);
				break;
			case R.id.button7:
				Toast.makeText(this, "Llamando al Tlfn.", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:666666666"));
				startActivity(in);
				break;
			case R.id.button8:
				Toast.makeText(this, "Enviando SMS", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:22322"));
				in.putExtra("sms_body","GOL");
				startActivity(in);
				break;
			case R.id.button9:
				Toast.makeText(this, "Enviando eMail", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:eps@udl.com"));
				in.putExtra(Intent.EXTRA_SUBJECT, "demo");
				in.putExtra(Intent.EXTRA_TEXT, "blablablablablablala");
				startActivity(in);
				break;
			case R.id.button10:
				Toast.makeText(this, "Accediendo a la Galeria", Toast.LENGTH_LONG).show();
				in = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivityForResult(in, RESULT_LOAD_IMAGE);
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	public Action getIndexApiAction() {
		Thing object = new Thing.Builder()
				.setName("Main Page") // TODO: Define a title for the content shown.
				// TODO: Make sure this auto-generated URL is correct.
				.setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
				.build();
		return new Action.Builder(Action.TYPE_VIEW)
				.setObject(object)
				.setActionStatus(Action.STATUS_TYPE_COMPLETED)
				.build();
	}

	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		AppIndex.AppIndexApi.start(client, getIndexApiAction());
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		AppIndex.AppIndexApi.end(client, getIndexApiAction());
		client.disconnect();
	}
}
