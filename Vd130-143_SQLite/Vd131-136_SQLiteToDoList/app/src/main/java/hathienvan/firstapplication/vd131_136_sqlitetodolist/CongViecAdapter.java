package hathienvan.firstapplication.vd131_136_sqlitetodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private  int layout;
    private List<CongViec> listCV;

    public CongViecAdapter(MainActivity context, int layout, List<CongViec> listCV) {
        this.context = context;
        this.layout = layout;
        this.listCV = listCV;
    }

    @Override
    public int getCount() {
        return listCV.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private  class  ViewHolder{
        TextView txtTen;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView             = inflater.inflate(layout, null);
            holder.txtTen           = (TextView) convertView.findViewById(R.id.txtNameCV);
            holder.imgDelete        = (ImageView) convertView.findViewById(R.id.imgDelete);
            holder.imgEdit          = (ImageView) convertView.findViewById(R.id.imgEdit);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final CongViec congViec = listCV.get(position);
        holder.txtTen.setText(congViec.getTenCV());
        //bat su kien sua xoa

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogUpdateCV(congViec.getTenCV(), congViec.getIdCV());
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogDeleteCV(congViec.getTenCV(), congViec.getIdCV());
            }
        });

        return convertView;
    }
}
