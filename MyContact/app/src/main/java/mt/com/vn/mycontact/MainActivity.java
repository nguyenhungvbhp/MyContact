package mt.com.vn.mycontact;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mt.com.vn.modell.MyContact;
import mt.com.vn.mydapter.AdapterContact;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private ArrayList<MyContact> arrMyContact;
    private AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        Log.e("RUN", "ERROR");
        Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
    }

    private void initViews() {
        lvContact = (ListView) this.findViewById(R.id.lvContact);
        arrMyContact  = new ArrayList<>();
        arrMyContact.add(new MyContact("Hùng", "099999999"));
        adapterContact = new AdapterContact(this, android.R.layout.simple_list_item_1,
                arrMyContact);
        lvContact.setAdapter(adapterContact);
        adapterContact.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.itAdd:
                openDialog();
                break;
        }
        return true;
    }


    //Hàm mở dialog để thêm số điện thoại
    private void openDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Thêm số điện thoại");
        dialog.setContentView(R.layout.dialog_add_number);
        dialog.getWindow().getAttributes().windowAnimations =
                R.style.AddContact;
        dialog.setCancelable(false);

        final EditText edtName =
                (EditText) dialog.getWindow().findViewById(R.id.edtAddName);
        final EditText edtNumberPhone =
                (EditText) dialog.getWindow().findViewById(R.id.edtAddNumberPhone);
        Button btnAdd =
                (Button) dialog.getWindow().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtName.getText().toString().isEmpty()
                        || edtNumberPhone.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                MyContact myContact = new MyContact(edtName.getText().toString(),
                        edtNumberPhone.getText().toString());
                Toast.makeText(MainActivity.this, arrMyContact.size()+"",
                        Toast.LENGTH_SHORT).show();
                arrMyContact.add(myContact);
                adapterContact.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm thành công!",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        Button btnBack =
                (Button) dialog.getWindow().findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
