package com.hfad.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder>{
    private String[] captions;
    private int[] imageIds;
    private Listener listener;
    interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public CaptionedImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardview= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent,false);
        return new ViewHolder(cardview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardview = holder.cardview;
        ImageView imageview = (ImageView) cardview.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardview.getContext(),imageIds[position]);
        imageview.setImageDrawable(drawable);
        imageview.setContentDescription(captions[position]);
        TextView textView = (TextView) cardview.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null) listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardview;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardview=itemView;
        }
    }
    public CaptionedImageAdapter(String[] captions,int[] imageIds){
        this.imageIds=imageIds;
        this.captions=captions;
    }
}