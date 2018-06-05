# AndroidDemos

* app
    探究沉浸式布局


* immersivestatusbar

    探究了沉浸式状态栏；
    

* todo-android

    探究了对mvp开发模式，对recyclerView的封装；
    接下来，该项目用于探究android开发框架的搭建；
    搭建一套属于我自己的核心开发框架；
    
    * 在竖直滚动recyclerView中再去嵌套竖直滚动recyclerView是行不通的。
    并且recyclerView的高度有问题，
    正确的做法是用协调布局；
    
    
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/coordinator_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    
        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:fitsSystemWindows="true">
            <!--app:layout_scrollFlags="scroll|enterAlways"-->
            <RelativeLayout
                android:id="@+id/rel"
                android:layout_width="match_parent"
                android:layout_height="180dp"
                app:layout_scrollFlags="scroll">
    
                <android.support.v4.view.ViewPager
                    android:id="@+id/vp_shuffling"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="#91deca" />
    
                <LinearLayout
                    android:id="@+id/ll_index_container"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_alignParentBottom="true"
                    android:background="@drawable/home_banner_index_mask"
                    android:gravity="center_horizontal"
                    android:orientation="horizontal"
                    android:paddingBottom="5dp"
                    android:paddingTop="5dp" />
            </RelativeLayout>
    
            <android.support.design.widget.TabLayout
                android:id="@+id/tabLayout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#91deca"
                app:tabGravity="fill"
                app:tabMode="fixed"
                app:tabSelectedTextColor="#ff0000"
                app:tabTextColor="#ffffff" />
        </android.support.design.widget.AppBarLayout>
    
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:scrollbars="none"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">
    
            <android.support.v4.view.ViewPager
                android:id="@+id/viewpager"
                android:layout_width="match_parent"
                android:layout_height="match_parent" />
        </LinearLayout>
    
    </android.support.design.widget.CoordinatorLayout>


    
    
* next...

