package mukesh.com.task6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fragment3 extends Fragment {
    private View view;
    private Button btn_previous2;
    private Fragment f2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment3, container, false);


        TextView username = (TextView)view.findViewById(R.id.tv_nameRes);
        TextView semester = (TextView)view.findViewById(R.id.tv_semRes) ;
        String str1 = getArguments().getString("Username");
        String str2 = getArguments().getString("Semester");
        username.setText(str1);
        semester.setText(str2);

        btn_previous2 = (Button)view.findViewById(R.id.btn_previous2);
        btn_previous2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                f2 = new Fragment2();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_id, f2);

                ft.addToBackStack("Frag3");
                fm.popBackStack("Frag2",2);
                ft.commit();
            }
        });

        return view;
    }
}
