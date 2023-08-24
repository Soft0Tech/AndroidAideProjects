package com.mycompany.mTools;
import android.app.*;
import android.os.*;
import android.webkit.*;

public class WebViewActivity extends Activity
{
		private WebView webView;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.webwiew);

			ActionBar ab = getActionBar();
			ab.hide();
			// Initialize the WebView
			webView = findViewById(R.id.webView);

			// Configure WebView settings
			WebSettings webSettings = webView.getSettings();
			webSettings.setJavaScriptEnabled(true); // Enable JavaScript if needed

			// Set a WebChromeClient for better web page loading and progress tracking
			webView.setWebViewClient(new WebViewClient());

			// Load a URL or web content into the WebView
			webView.loadUrl("https://bangla.bdnews24.com/"); // Replace with the desired URL
		}

		@Override
		public void onBackPressed()
		{
			if(webView.canGoBack()){
				webView.goBack();
			}else{
				super.onBackPressed();
			}
			
		}
		
		
}
