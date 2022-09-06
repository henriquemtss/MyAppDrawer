package br.com.etecia.myappdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity<onNavigationItemSelected> extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);

        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //Clique no menu para abrir e fechar o NavigationView
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.opennav,
                R.string.closenav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.idContainerNav, new FragmentPerfil()).commit();

            navigationView.setCheckedItem(R.id.mPerfil);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mPerfil:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentPerfil()).commit();

                break;
            case R.id.mFace:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentReconhecimento()).commit();
                break;
            case R.id.mlocalizacao:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentLocalizacao()).commit();
                break;
            case R.id.mHistotico:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentHistorico()).commit();
            case R.id.mCompatilhar:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentCompartilhar()).commit();
                break;
            case R.id.mComfiguracoes:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new FragmentConfiguracoes()).commit();
                break;
            default:

        }


        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        toggle.syncState();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        toggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}