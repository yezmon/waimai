package com.example.waimai2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waimai2.BmobSql.Business;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shangjia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shangjia extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView bname,baddr,btel,bremark;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String str;

    public shangjia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shangjia.
     */
    // TODO: Rename and change types and number of parameters
    public static shangjia newInstance(String param1, String param2) {
        shangjia fragment = new shangjia();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_shangjia, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bname=getActivity().findViewById(R.id.sj_bname);
        baddr=getActivity().findViewById(R.id.sj_badd);
        btel=getActivity().findViewById(R.id.sj_btel);
        bremark=getActivity().findViewById(R.id.sj_bremark);
        Bundle bundle=this.getArguments();
        str=bundle.getString("Bno");
        BmobQuery<Business>business=new BmobQuery<Business>();
        business.addWhereExists("Bname");
        business.findObjects(new FindListener<Business>() {
            @Override
            public void done(List<Business> list, BmobException e) {
                if(e==null){
                    int i=Integer.valueOf(str)-1;
                    bname.setText(list.get(i).getBname().toString());
                    baddr.setText(list.get(i).getBaddress().toString());
                    btel.setText(list.get(i).getBtel().toString());
                    bremark.setText(list.get(i).getBremark().toString());
                }

            }
        });
    }
}
