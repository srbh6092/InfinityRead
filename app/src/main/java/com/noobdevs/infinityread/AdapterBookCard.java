package com.noobdevs.infinityread;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noobdevs.infinityread.Model.ModelBookCard;

import java.util.ArrayList;

public class AdapterBookCard  extends RecyclerView.Adapter<AdapterBookCard.ViewHolderBookCard>
{
    private ArrayList<ModelBookCard> arrayListBookCard;
    private Context mContext ;

    public AdapterBookCard(ArrayList<ModelBookCard> arrayListBookCard , Context mContext) {
        this.arrayListBookCard = arrayListBookCard;
        this.mContext = mContext ;
    }


    @NonNull
    @Override
    public ViewHolderBookCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_card, parent, false);
        return new ViewHolderBookCard(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBookCard holder, int position) {
        ModelBookCard item = arrayListBookCard.get(position);

        holder.bookNameBookCard.setText(item.getBookName());
        holder.userNameBookCard.setText(item.getUserFullName());
        holder.pointsBookCard.setText(item.getpoints());
        holder.starsBookCard.setText(item.getStars());
        holder.photoCountBookCard.setText(item.getPhotosCount());

    }


    @Override
    public int getItemCount() {
        return arrayListBookCard.size();
    }



    class ViewHolderBookCard extends RecyclerView.ViewHolder
    {

        ImageView userPicBookCard ;
        TextView bookNameBookCard , userNameBookCard , pointsBookCard , starsBookCard , photoCountBookCard ;
        public ViewHolderBookCard( View itemView) {
            super(itemView);

            userPicBookCard = itemView.findViewById(R.id.userPicBookCard);
            bookNameBookCard = itemView.findViewById(R.id.bookNameBookCard);
            userNameBookCard = itemView.findViewById(R.id.userNameBookCard);
            pointsBookCard = itemView.findViewById(R.id.pointsBookCard);
            starsBookCard = itemView.findViewById(R.id.starsBookCard);
            photoCountBookCard = itemView.findViewById(R.id.photosBookCard);

        }
    }

}


