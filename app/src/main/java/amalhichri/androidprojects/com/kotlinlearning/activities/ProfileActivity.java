package amalhichri.androidprojects.com.kotlinlearning.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import amalhichri.androidprojects.com.kotlinlearning.R;
import amalhichri.androidprojects.com.kotlinlearning.adapters.ProfileTabsAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ProfileTabsAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /*** disabling actionBar ****/
        getSupportActionBar().hide();

        /** setting the tabLayout **/
        tabLayout = findViewById(R.id.profileTabs);
        viewPager = findViewById(R.id.viewpager_profileTabs);
        adapter = new ProfileTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        /** populating ui with user data **/
        /** fields data **/
        //Log.d("picture url",Statics.auth.getCurrentUser().getPhotoUrl().toString());
        ((TextView) findViewById(R.id.fullNameInProfile)).setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        // ((TextView) findViewById(R.id.fullNameInProfile)).setText((user.getUsername().isEmpty()?user.getFirstName():user.getUsername()));

       /* if(FirebaseAuth.getInstance().getCurrentUser().toString()!=null){
            Picasso.with(getApplicationContext()).load(Uri.parse(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString())).into((ImageView)findViewById(R.id.userImgProfile));
        }
        else
            ((ImageView)findViewById(R.id.userImgProfile)).setImageResource(R.drawable.backarrow);*/
    }

    /** for calligraphy lib usage **/
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
