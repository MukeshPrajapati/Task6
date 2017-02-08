package mukesh.com.task6;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {
    private Button btn_next;
    private View view;
    private Fragment f2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        btn_next = (Button)view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                EditText editText = (EditText)view.findViewById(R.id.et_name);
                String uname = editText.getText().toString();

                f2 = new Fragment2();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                bundle.putString("Username", uname);
                f2.setArguments(bundle);

                ft.replace(R.id.main_id, f2);

                ft.addToBackStack("Frag1");

                editText.clearFocus();
                ft.commit();
            }
        });
        return view;
    }
}