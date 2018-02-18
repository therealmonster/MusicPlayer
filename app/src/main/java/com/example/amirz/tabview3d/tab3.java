package com.example.amirz.tabview3d;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by amirz on 2/12/2018.
 */

public class tab3 extends Fragment{
    View c;
    public tab3() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        c= inflater.inflate(R.layout.activity_tab3,container,false);
        return c;

    }
}
