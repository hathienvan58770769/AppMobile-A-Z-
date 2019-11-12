package hathienvan.firstapplication.androidwebservice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<SinhVien> listSV;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> listSV) {
        this.context = context;
        this.layout = layout;
        this.listSV = listSV;
    }

    @Override
    public int getCount() {
        return listSV.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private  class ViewHolder{
        TextView txtHoTen, txtNamSinh, txtDiaChi;
        ImageView imgedit, imgDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtHoTen = (TextView) convertView.findViewById(R.id.textViewHoTen);
            holder.txtNamSinh = (TextView) convertView.findViewById(R.id.textViewNamSinh);
            holder.txtDiaChi = (TextView) convertView.findViewById(R.id.textViewDiaChi);
            holder.imgedit = (ImageView) convertView.findViewById(R.id.imgEdit);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            convertView.setTag(holder);


        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final SinhVien sinhVien = listSV.get(position);

        holder.txtHoTen.setText(sinhVien.getHoTen());

        holder.txtNamSinh.setText("Nam Sinh : "+sinhVien.getNamSinh());
        holder.txtDiaChi.setText(sinhVien.getDiaChi());

        //bat su ien xoa & update
        holder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainEditSVActivity.class);
                intent.putExtra("dataSinhVien", sinhVien);
                context.startActivity(intent);
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deleted(sinhVien.getHoTen(), sinhVien.getId());
            }
        });

        return convertView;
    }
    private void Deleted(String ten, final int id){
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(context);
        dialogDelete.setMessage("Ban co muon xoa sinh vien " + ten + " khong?");
        dialogDelete.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteSV(id);

            }
        });
        dialogDelete.setNegativeButton("khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogDelete.show();
    }
}
