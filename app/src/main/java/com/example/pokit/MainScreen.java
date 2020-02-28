package com.example.pokit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pokit.Fragments.Chat;
import com.example.pokit.Fragments.Home;
import com.example.pokit.Fragments.Others;
import com.example.pokit.Fragments.Search;
import com.example.pokit.Fragments.Stats;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreen extends AppCompatActivity {

    private Home objectHomeFragment;
    private Search objectSearchFragment;
    private Stats stat;
    private Chat chitChat;
    private Others othr;

    private BottomNavigationView objectBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);



        initializeObjects();
    }




    private void changeFragment(Fragment objectFragment)
    {
        try
        {
            FragmentTransaction objectTransaction=getSupportFragmentManager()
                    .beginTransaction();

            objectTransaction.replace(R.id.container,objectFragment).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "changeFragment:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeObjects()
    {
        try
        {
            objectHomeFragment=new Home();
            objectSearchFragment=new Search();
            stat=new Stats();
            chitChat=new Chat();
            othr=new Others();


            objectBottomNavigationView=findViewById(R.id.BNV);
            changeFragment(objectHomeFragment);


            objectBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                            if(item.getItemId()==R.id.menu_home)
                            {
                                changeFragment(objectHomeFragment);
                                return true;
                            }
                            else if(item.getItemId()==R.id.menu_search)
                            {
                                changeFragment(objectSearchFragment);
                                return true;
                            }
                            return false;
                        }
                    }
            );


        }
        catch (Exception e)
        {
            Toast.makeText(this, "initializeObjects:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
