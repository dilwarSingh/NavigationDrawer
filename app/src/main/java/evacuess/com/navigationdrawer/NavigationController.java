package evacuess.com.navigationdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class NavigationController extends AppCompatActivity {


    Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigarionID);


        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();


        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

                public void onDrawerClosed(View view) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_photos:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_about_us:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_movies:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_notifications:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_privacy_policy:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "Default case", Toast.LENGTH_LONG).show();
                        break;

                }
                drawerLayout.closeDrawers();

                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
