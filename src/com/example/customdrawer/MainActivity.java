package com.example.customdrawer;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		// ActionBar�̃A�v���A�C�R�����h���[���[�J���{�^���Ƃ��Ďg�p����
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle�𐶐�
		mDrawerToggle = new ActionBarDrawerToggle(
				this,
				mDrawerLayout,
				R.drawable.ic_drawer,
				R.string.drawer_open,
				R.string.drawer_close
				) {
			public void onDrawerClosed(View view) {
				invalidateOptionsMenu();
			}
			
			public void onDrawerOpened(View drawerView) {
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 	ActionBarDrawerToggle���g�p���鎞�́AonPostCreate()��onConfigurationChanged()�̃I�[�o�[���C�h���K�v
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// onRestoreInstanceState�̌�ŁA��Ԃ𓯊�������
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// configuration���ω��������ɂ��A�h���[���[�̏�Ԃ𓯊�������
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// �h���[���[���J���^����{�^���̃n���h�����O
		// �����ActionBarDrawerToggle����������
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		mDrawerLayout.closeDrawers();
		return super.onOptionsItemSelected(item);
	}

	public DrawerLayout getDrawer() {
		return mDrawerLayout;
	}
}
