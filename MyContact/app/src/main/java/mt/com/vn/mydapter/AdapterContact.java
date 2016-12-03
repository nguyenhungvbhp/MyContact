package mt.com.vn.mydapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mt.com.vn.modell.MyContact;
import mt.com.vn.mycontact.R;

/**
 * Created by ManhHung on 12/3/2016.
 */

public class AdapterContact extends ArrayAdapter {
    private ArrayList<MyContact> arrContact;
    private LayoutInflater inflater;


    public AdapterContact(Context context, int resource, ArrayList<MyContact> arrContact) {
        super(context, resource, arrContact);
        this.arrContact = arrContact;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final MyContact myContact = arrContact.get(position);
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_contact, parent, false);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            TextView tvNumberPhone = (TextView) view.findViewById(R.id.tvNumberPhone);
            ImageView imgMessage = (ImageView) view.findViewById(R.id.imgMessage);
            ImageView imgCall = (ImageView) view.findViewById(R.id.imgCall);
            ImageView imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            imgMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendMessage(myContact);
                }
            });

            imgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    call(myContact);
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delete(myContact);
                }
            });
            tvName.setText(myContact.getName());
            tvNumberPhone.setText(myContact.getNumberPhone());

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        return view;
    }

    private void delete(MyContact myContact) {
    }

    private void call(MyContact myContact) {

    }

    private void sendMessage(MyContact myContact) {

    }

    class ViewHolder {
        TextView tvName;
        TextView tvNumberPhone;
        ImageView imgMassage;
        ImageView imgCall;
        ImageView imgDelete;
    }
}
