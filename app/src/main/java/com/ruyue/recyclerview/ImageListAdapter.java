package com.ruyue.recyclerview;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;

        import java.util.List;

        import static com.ruyue.recyclerview.Data.TYPE_HEADER;
        import static com.ruyue.recyclerview.Data.TYPE_ITEM;

public class ImageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> myList;
    private Context myContext;

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataNumber;
        TextView dataDesc;
        ImageView avatar;

        public ImageViewHolder(View view) {
            super(view);
            dataTitle = view.findViewById(R.id.data_title);
            dataNumber = view.findViewById(R.id.data_number);
            dataDesc = view.findViewById(R.id.data_desc);
            avatar = view.findViewById(R.id.avatar);
        }
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        public HeadViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.data_head);
        }
    }

    public ImageListAdapter(Context context, List<Data> myList) {
        this.myContext = context;
        this.myList = myList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if(viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multiple_list_layout, parent, false);
            return new HeadViewHolder(view);
        } else if(viewType == TYPE_ITEM){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_layout, parent, false);
            return new ImageViewHolder(view);
        } else {
            return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = myList.get(position);
        if(data != null) {
            switch(data.type) {
                case TYPE_HEADER:
                    ((HeadViewHolder) holder).header.setText(data.getTitle());
                    break;
                case TYPE_ITEM:
                    ((ImageViewHolder) holder).dataTitle.setText(data.getTitle());
                    ((ImageViewHolder) holder).dataNumber.setText(data.getNumber() + "");
                    ((ImageViewHolder) holder).dataDesc.setText(data.getDescription());
                    Glide.with(myContext).load(data.getAvatar()).into(((ImageViewHolder)holder).avatar);
                    break;
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (myList.get(position).getType()) {
            case 0:
                return Data.TYPE_ITEM;
            case 1:
                return Data.TYPE_HEADER;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
