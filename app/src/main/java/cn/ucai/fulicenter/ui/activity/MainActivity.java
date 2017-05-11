package cn.ucai.fulicenter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.FuLiCenterApplication;
import cn.ucai.fulicenter.ui.fragment.BoutiqueFragment;
import cn.ucai.fulicenter.ui.fragment.CategoryFragment;
import cn.ucai.fulicenter.ui.fragment.NewGoodsFragment;
import cn.ucai.fulicenter.ui.fragment.PersonalFragment;

public class MainActivity extends AppCompatActivity {
    NewGoodsFragment mNewGoodsFragment;
    BoutiqueFragment mBoutiqueFragment;
    CategoryFragment mCategoryFragment;
    PersonalFragment mPersonalFragment;
    Fragment[] mFragments;
    int currentIndex,index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        showFragment();
    }

    private void initFragment() {
        mNewGoodsFragment = new NewGoodsFragment();
        mBoutiqueFragment = new BoutiqueFragment();
        mCategoryFragment = new CategoryFragment();
        mPersonalFragment= new PersonalFragment();
        mFragments = new Fragment[5];
        mFragments[0] = mNewGoodsFragment;
        mFragments[1] = mBoutiqueFragment;
        mFragments[2] = mCategoryFragment;
        mFragments[4] = mPersonalFragment;
    }

    private void showFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,mFragments[0])
                .add(R.id.fragment_container,mFragments[1])
                .add(R.id.fragment_container,mFragments[2])
                .show(mFragments[0])
                .hide(mFragments[1])
                .hide(mFragments[2])
                .commit();
    }

    public void onCheckedChange(View view){
        switch (view.getId()){
            case R.id.layout_new_good:
                index = 0;
                break;
            case R.id.layout_boutique:
                index = 1;
                break;
            case R.id.layout_category:
                index = 2;
                break;
            case R.id.layout_personal_center:
                if (FuLiCenterApplication.getInstance().getCurrentUser()==null){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }else {
                    index = 4;
                }
                break;
        }
        setFragment();
    }

    private void setFragment() {
        if (index!=currentIndex) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.hide(mFragments[currentIndex]);
            if (!mFragments[index].isAdded()){
                fragmentTransaction.add(R.id.fragment_container,mFragments[index]);
            }
            fragmentTransaction.show(mFragments[index]);
            fragmentTransaction.commit();
            currentIndex = index;
        }
    }


}
