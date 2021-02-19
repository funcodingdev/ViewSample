package cn.funcoding.viewsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private static final String Key_Page_Lay_Res = "Key_Page_Lay_Res";

    @LayoutRes
    int pageLayRes;

    public static PageFragment newInstance(@LayoutRes int pageLayRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(Key_Page_Lay_Res, pageLayRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            pageLayRes = args.getInt(Key_Page_Lay_Res);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ViewStub sampleStub = view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(pageLayRes);
        sampleStub.inflate();
        return view;
    }
}
