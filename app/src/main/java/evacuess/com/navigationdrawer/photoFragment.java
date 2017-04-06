package evacuess.com.navigationdrawer;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class photoFragment extends Fragment {

    Button button;
    TextView text1;

    public photoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = inflater.inflate(R.layout.fragment_photo, container, false);

        text1 = (TextView) inflate.findViewById(R.id.editTextPhoto);
        Button b = (Button) inflate.findViewById(R.id.buttonRand);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int i = random.nextInt();

                text1.setText("sdkjbvudf " + i);
            }
        });

        return inflate;
    }

}
