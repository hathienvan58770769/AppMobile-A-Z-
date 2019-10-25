package hathienvan.firstapplication.listviewlevel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
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

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView txtTen = (TextView) convertView.findViewById(R.id.textName);
        TextView txtMoTa = (TextView) convertView.findViewById(R.id.textMoTa);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgView);

        TraiCay traiCay = traiCayList.get(position);

        txtTen.setText(traiCay.getTen());
        txtMoTa.setText(traiCay.getMoTa());
        img.setImageResource(traiCay.getImg());

        return null;
    }
}
