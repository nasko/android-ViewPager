/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayMap<String, String> fragments = new ArrayMap<String, String>();

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.put("0", "MondayFragment");
        fragments.put("1", "TuesdayFragment");
        fragments.put("2", "WednesdayFragment");
        fragments.put("3", "ThursdayFragment");
        fragments.put("4", "FridayFragment");
    }

    @Override
    public Fragment getItem(int position) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.example.android.viewpager."
                + fragments.get(String.valueOf(position)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Fragment fr = null;
        try {
            fr = (Fragment) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fr;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
