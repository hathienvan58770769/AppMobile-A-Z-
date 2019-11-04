package hathienvan.firstapplication.vd137_143_sqlitesaveimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoVatAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<DoVat> listDoVat;

    public DoVatAdapter(MainActivity context, int layout, List<DoVat> listDoVat) {
        this.context = context;
        this.layout = layout;
        this.listDoVat = listDoVat;
    }

    private class ViewHolder{
        TextView txtTen, txtMota;
        ImageView imgHinh;
    }
    @Override
    public int getCount() {
        return listDoVat.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTen =(TextView) convertView.findViewById(R.id.txtTenDV);
            holder.txtMota =(TextView) convertView.findViewById(R.id.txtMoTaDV);
            holder.imgHinh =(ImageView) convertView.findViewById(R.id.imageViewHinhCustom);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        DoVat doVat = listDoVat.get(position);

        holder.txtTen.setText(doVat.getTen());
        holder.txtMota.setText(doVat.getMoTa());
        //chuyen byte[] -> bitmap
        byte[] hinhAnh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
        holder.imgHinh.setImageBitmap(bitmap);

        return convertView;
    }
}
