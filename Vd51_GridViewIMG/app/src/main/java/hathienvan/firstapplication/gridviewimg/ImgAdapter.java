package hathienvan.firstapplication.gridviewimg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImgAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Img> imgList;

    public ImgAdapter(Context context, int layout, List<Img> imgList) {
        this.context = context;
        this.layout = layout;
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
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
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag(position);
        }
        Img img = imgList.get(position);
        holder.imageView.setImageResource(img.getImg());
        return convertView;
    }
    private  class  ViewHolder{
        ImageView imageView;
    }

}
