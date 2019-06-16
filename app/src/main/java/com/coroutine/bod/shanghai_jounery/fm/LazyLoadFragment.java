package com.coroutine.bod.shanghai_jounery.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * 界面是否已经创建完成
 * 对用户是否已经可见
 * 请求是否已经完毕(防止重复加载）
 */
public abstract class LazyLoadFragment extends Fragment {

    private boolean isViewCreated; // 界面是否已创建完成
    private boolean isVisibleToUser; // 是否对用户可见
    private boolean isDataLoaded; // 数据是否已请求, isNeedReload()返回false的时起作用

    // 实现具体的数据请求逻辑
    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        tryLoadData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewCreated = true;
        tryLoadData();
    }

    /**
     * ViewPager场景下，判断父fragment是否可见
     *
     * @return
     */
    private boolean isParentVisible() {
        Fragment fragment = getParentFragment();
        return fragment == null || (fragment instanceof LazyLoadFragment && ((LazyLoadFragment) fragment).isVisibleToUser);
    }

    /**
     * ViewPager场景下，当前fragment可见，如果其子fragment也可见，则尝试让子fragment请求数据
     */
    private void dispatchParentVisibleState() {
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.isEmpty()) {
            return;
        }
        for (Fragment child : fragments) {
            if (child instanceof LazyLoadFragment && ((LazyLoadFragment) child).isVisibleToUser) {
                ((LazyLoadFragment) child).tryLoadData();
            }
        }
    }

    public void tryLoadData() {
        if (isViewCreated && isVisibleToUser && isParentVisible() &&  !isDataLoaded) {
            loadData();
            isDataLoaded = true;
            // 通知 子 Fragment 请求数据
            dispatchParentVisibleState();
        }
    }

    public void callWhenIdle(){
        loadData();
    }
}