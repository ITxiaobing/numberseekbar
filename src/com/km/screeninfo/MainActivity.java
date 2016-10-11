package com.km.screeninfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private TextView tvModel;
		private TextView tvScreenHeight1;
		private TextView tvScreenHeight2;
		private TextView tvScreenHeight3;
		private TextView tvScreenWidth1;
		private TextView tvScreenWidth2;
		private TextView tvScreenWidth3;
		private TextView tvScreenDensity2;
		private TextView tvScreenDensityDPI2;
		private TextView tvScreenDensity3;
		private TextView tvScreenDensityDPI3;
		private TextView tvScreenWidth4;
		private TextView tvScreenHeight4;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			tvModel = (TextView) rootView.findViewById(R.id.tv_model);
			tvScreenHeight1 = (TextView) rootView.findViewById(R.id.tv_screen_height1);
			tvScreenHeight2 = (TextView) rootView.findViewById(R.id.tv_screen_height2);
			tvScreenHeight3 = (TextView) rootView.findViewById(R.id.tv_screen_height3);
			tvScreenHeight4 = (TextView) rootView.findViewById(R.id.tv_screen_height4);
			
			tvScreenWidth1 = (TextView) rootView.findViewById(R.id.tv_screen_width1);
			tvScreenWidth2 = (TextView) rootView.findViewById(R.id.tv_screen_width2);
			tvScreenWidth3 = (TextView) rootView.findViewById(R.id.tv_screen_width3);
			tvScreenWidth4 = (TextView) rootView.findViewById(R.id.tv_screen_width4);
			
			tvScreenDensity2 = (TextView) rootView.findViewById(R.id.tv_screen_density2);
			tvScreenDensityDPI2 = (TextView) rootView.findViewById(R.id.tv_screen_densityDPI2);
			
			tvScreenDensity3 = (TextView) rootView.findViewById(R.id.tv_screen_density3);
			tvScreenDensityDPI3 = (TextView) rootView.findViewById(R.id.tv_screen_densityDPI3);
			
			
			tvModel.setText(android.os.Build.MODEL);
			
			// 获取屏幕密度（方法1）  
			int screenWidth1  = getActivity().getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）  
			int screenHeight1 = getActivity().getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高（像素，如：800p）

			tvScreenHeight1.setText(screenHeight1+" px");
			tvScreenWidth1.setText(screenWidth1+" px");
			
			
			// 获取屏幕密度（方法2）  
			DisplayMetrics dm2 = getResources().getDisplayMetrics();  
		  
			float density  = dm2.density;        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）  
			int densityDPI = dm2.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）  
			float xdpi = dm2.xdpi;             
			float ydpi = dm2.ydpi;  
			  
			int screenWidth2  = dm2.widthPixels;      // 屏幕宽（像素，如：480px）  
			int screenHeight2 = dm2.heightPixels;     // 屏幕高（像素，如：800px） 

			tvScreenHeight2.setText(screenHeight2+" px");
			tvScreenWidth2.setText(screenWidth2+" px");
			tvScreenDensity2.setText(density+"");
			tvScreenDensityDPI2.setText(densityDPI+"");
			
			// 获取屏幕密度（方法3）  
			DisplayMetrics dm3 = new DisplayMetrics();  
			getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm3);  
			  
			density  = dm3.density;      // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）  
			densityDPI = dm3.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）  
			xdpi = dm3.xdpi;           
			ydpi = dm3.ydpi;  
			  
			tvScreenDensity3.setText(density+"");
			tvScreenDensityDPI3.setText(densityDPI+"");
			  
			int screenWidth3 = dm3.widthPixels;          // 屏幕宽（px，如：480px） 
			int screenHeight3 = dm3.heightPixels;        // 屏幕高（px，如：800px）  
			
			tvScreenHeight3.setText(screenHeight3+" px");
			tvScreenWidth3.setText(screenWidth3+" px");
			  
			float screenWidthDip  = (dm3.widthPixels/density);    // 屏幕宽（dip，如：320dip）  
			float screenHeightDip = (dm3.heightPixels/density);   // 屏幕宽（dip，如：533dip） 

			tvScreenHeight4.setText(screenHeightDip+" dip");
			tvScreenWidth4.setText(screenWidthDip+" dip");
			return rootView;
		}
	}

}
