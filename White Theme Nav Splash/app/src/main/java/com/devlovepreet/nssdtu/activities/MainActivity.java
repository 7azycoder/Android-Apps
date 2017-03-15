package com.devlovepreet.nssdtu.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.devlovepreet.nssdtu.R;
import com.devlovepreet.nssdtu.fragments.AboutUsFragment;
import com.devlovepreet.nssdtu.fragments.AppInfoFragment;
import com.devlovepreet.nssdtu.fragments.BookmarksFragment;
import com.devlovepreet.nssdtu.fragments.ContactsFragment;
import com.devlovepreet.nssdtu.fragments.PostsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;
    String title;
    private static final String TAG_Title = "save_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null)
        {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.container, new PostsFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setElevation(15);
            getSupportActionBar().setTitle(R.string.home);
        }
        else{
            getSupportActionBar().setElevation(15);
            title = savedInstanceState.getString(TAG_Title);
            getSupportActionBar().setTitle(title);
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            PostsFragment postsFragment = new PostsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, postsFragment).commit();
            getSupportActionBar().setTitle(R.string.home);
            item.setChecked(true);

        } else if (id == R.id.nav_bookmarks) {
            BookmarksFragment bookmarksFragment = new BookmarksFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, bookmarksFragment).commit();
            getSupportActionBar().setElevation(15);
            getSupportActionBar().setTitle(R.string.bookmarks);
            item.setChecked(true);

        }
        else if (id == R.id.nav_about_us) {
            AboutUsFragment aboutUsFragment = new AboutUsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutUsFragment).commit();
            getSupportActionBar().setElevation(15);
            getSupportActionBar().setTitle(R.string.about_us);
            item.setChecked(true);

        }
        else if (id == R.id.nav_contacts) {
            ContactsFragment contactsFragment = new ContactsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactsFragment).commit();
            getSupportActionBar().setElevation(15);
            getSupportActionBar().setTitle(R.string.contacts);
            item.setChecked(true);

        }
        else if (id == R.id.nav_app_info) {
            AppInfoFragment appInfoFragment = new AppInfoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, appInfoFragment).commit();
            getSupportActionBar().setElevation(15);
            getSupportActionBar().setTitle(R.string.app_info);
            item.setChecked(true);

        } else if (id == R.id.nav_feedback) {
            getSupportActionBar().setElevation(15);
            Toast.makeText(this,R.string.feedback,Toast.LENGTH_LONG).show();
            item.setChecked(true);

        } else if (id == R.id.nav_share_app) {
            getSupportActionBar().setElevation(15);
            Toast.makeText(this,R.string.share_app,Toast.LENGTH_LONG).show();
            item.setChecked(true);

        } else {
            setTitle(R.string.app_name);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        title = getSupportActionBar().getTitle().toString();
        outState.putString(TAG_Title, title);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}