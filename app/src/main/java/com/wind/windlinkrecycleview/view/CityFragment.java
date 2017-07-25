package com.wind.windlinkrecycleview.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wind.windlinkrecycleview.CityContract;
import com.wind.windlinkrecycleview.MainActivity;
import com.wind.windlinkrecycleview.R;
import com.wind.windlinkrecycleview.model.CityBean;
import com.wind.windlinkrecycleview.presenter.CityPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcong on 2017/7/24.
 */

public class CityFragment extends Fragment implements CityContract.View{
    private CityContract.Presenter mpresenter;
    private RecyclerView recyclerView;
    private List<CityBean> list=new ArrayList<>();
    @Override
    public void onResume() {
        super.onResume();
        mpresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_city,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.rv_city);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setPresenter(CityContract.Presenter presenter) {
        mpresenter=presenter;
    }

    @Override
    public void showSnackBar() {
        mpresenter.onClick();
    }

    @Override
    public void showCity() {
        Context context=getActivity();
        initData(context.getResources().getStringArray(R.array.province));
    }

    private void initData(final String[] province ) {
        List<String[]> citylist=new ArrayList<>();
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
        citylist.add(new String[]{"深圳","东莞","广州","韶关"});
            for (int i=0;i<province.length;i++)
            {
                CityBean titleBean=new CityBean();
                titleBean.setProvince(province[i]);
                titleBean.setTitle(true);
                list.add(titleBean);
                CityBean cityBean=new CityBean();
                for (int j=0;j<citylist.get(i).length;j++)
                {
                    cityBean.setCity(citylist.get(i)[j]);
                    list.add(cityBean);
                }


            }
        Log.i(">>>>>>",list.get(2).city.toString());
        Log.i(">>>>>>",citylist.size()+"");
        Log.i(">>>>>>",list.size()+"");
    }
}