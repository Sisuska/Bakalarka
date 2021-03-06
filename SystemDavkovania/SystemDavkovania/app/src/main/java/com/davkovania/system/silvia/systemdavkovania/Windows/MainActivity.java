package com.davkovania.system.silvia.systemdavkovania.Windows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.TextView;
import com.davkovania.system.silvia.systemdavkovania.Database.CurrentMedicine;
import com.davkovania.system.silvia.systemdavkovania.Database.Medicine;
import com.davkovania.system.silvia.systemdavkovania.Database.User;
import com.davkovania.system.silvia.systemdavkovania.Entities.Item;
import com.davkovania.system.silvia.systemdavkovania.Entities.UserUtil;
import com.davkovania.system.silvia.systemdavkovania.Fragments.Active;
import com.davkovania.system.silvia.systemdavkovania.Fragments.NotActive;
import com.davkovania.system.silvia.systemdavkovania.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> currentUser = new ArrayList<>();
    RecyclerView names;
    List<CurrentMedicine> currentMedicines = new ArrayList<>();
    ArrayList<Medicine> medicines = new ArrayList<>();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        //names = (RecyclerView) findViewById(R.id.recycleView);

//        Objects.requireNonNull(getActionBar()).setTitle("SILVINKA");
        Objects.requireNonNull(getSupportActionBar()).setTitle("SILVINKA");

        //currentUser = (User) getIntent().getSerializableExtra("user");
//        currentUser = (ArrayList<User>) getIntent().getSerializableExtra("currentUser");

//        medicines = (ArrayList<Medicine>) getIntent().getSerializableExtra("allMedicines");

        User user = UserUtil.getUserFromSharedPreferencies(getSharedPreferences(UserUtil.PREFS_NAME, UserUtil.PREFS_MODE));
//        currentMedicines = user.getCurrentMedicines();
//        medicines = user.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class );
            profileIntent.putExtra("currentUser", currentUser);
            startActivity(profileIntent);
            return true;
        }

        if (id == R.id.action_logout) {
           logingOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logingOut();
    }

    public void logingOut(){
//        SharedPreferences.Editor editor = getSharedPreferences(UserUtil.PREFS_NAME, MODE_PRIVATE).edit();
//        editor.remove("username");
//        editor.remove("name");
//        editor.remove("surname");
//        editor.remove("id");
//        editor.putBoolean("isLogged", false);
//        editor.apply();
        UserUtil.logOut(getSharedPreferences(UserUtil.PREFS_NAME, UserUtil.PREFS_MODE));
        Intent loginPage = new Intent(MainActivity.this, LoginActivity.class);
        loginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginPage);
 }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_fragment, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(
                    getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            Bundle bundle = new Bundle();
//            ArrayList<Medicine> tmpList = new ArrayList<>();
//            Bundle bundle1 = new Bundle();
//            ArrayList<Medicine> tmpList1 = new ArrayList<>();
            Fragment fragment = null;
            switch (position) {
                case 0:
//                    for(Medicine me: medicines){
//                    for(CurrentMedicine m: currentMedicines){
//                       if(m.getActive() == true && m.getMedicineID().equals(me.getObjectId())){
//                           tmpList.add(me);
//                       }
//                     }
//
//                    }
//                    bundle.putSerializable("activeMedicines", tmpList);
                    fragment = new Active();
                   // fragment.setArguments(bundle);
                    break;
                case 1:
//                    for(Medicine me: medicines){
//                        for(CurrentMedicine m: currentMedicines){
//                            if(m.getActive() == false && m.getMedicineID().equals(me.getObjectId())){
//                                tmpList1.add(me);
//                            }
//                        }
//
//                    }
//                    bundle1.putSerializable("activeMedicines", tmpList1);
                    fragment = new NotActive();
                    //fragment.setArguments(bundle1);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Aktivne lieky";
                case 1:
                    return "Neaktivne lieky";
            }
            return null;
        }
    }
}
