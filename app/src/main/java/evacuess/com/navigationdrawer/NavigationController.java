package evacuess.com.navigationdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class NavigationController extends AppCompatActivity {


    Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigarionID);


        //      fragment = findViewById(R.id.homeId);

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
        navigationView.setSelected(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                selectedNavItem(item.getItemId());
                return true;
            }
        });

        selectedNavItem(R.id.nav_home);
        navigationView.getMenu().getItem(0).setChecked(true);

    }

    public void selectedNavItem(int item) {
     /*   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
*/
        switch (item) {
            case R.id.nav_home:
                Log.d("frag", "1");
                Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_LONG).show();

                Fragment fragHome = new fragment_home();
                FragmentManager fm = getSupportFragmentManager();

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frammuu, fragHome);
                transaction.commit();

     /*        transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
*/
                getSupportActionBar().setTitle("Home");
                break;

            case R.id.nav_photos:
                Log.d("frag", "2");
                Toast.makeText(getApplicationContext(), "photos", Toast.LENGTH_LONG).show();

                Fragment fragPhoto = new photoFragment();
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction1 = fm1.beginTransaction();
                transaction1.replace(R.id.frammuu, fragPhoto);
                transaction1.commit();

                getSupportActionBar().setTitle("Photos");
                break;
            case R.id.nav_about_us:
                Toast.makeText(getApplicationContext(), "about us", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_movies:
                Toast.makeText(getApplicationContext(), "movies", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_notifications:
                Toast.makeText(getApplicationContext(), "notifications", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_privacy_policy:
                Toast.makeText(getApplicationContext(), "privacy", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_LONG).show();
                break;

            default:
                Toast.makeText(getApplicationContext(), "Default case", Toast.LENGTH_LONG).show();
                break;

        }

        drawerLayout.closeDrawers();

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
