package com.noobdevs.infinityread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noobdevs.infinityread.Model.ModelChatCard;

import java.util.ArrayList;

public class AdapterBookChat extends RecyclerView.Adapter<AdapterBookChat.ViewHolderBookChat>
{
    private ArrayList<ModelChatCard> arrayListBookChat ;
    private Context mContext ;

    public AdapterBookChat(ArrayList<ModelChatCard> arrayListBookChat, Context mContext) {
        this.arrayListBookChat = arrayListBookChat;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderBookChat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_dm , parent , false);
        return new ViewHolderBookChat(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBookChat holder, int position)
    {
       ModelChatCard item = arrayListBookChat.get(position);

       holder.userNameBookChat.setText(item.getUserNameChat());
       holder.lastMessageBookChat.setText(item.getUserLatestMessageChat());



    }

    @Override
    public int getItemCount() {
        return arrayListBookChat.size();
    }




    public class ViewHolderBookChat extends RecyclerView.ViewHolder
    {
        ImageView userImageBookChat;
        TextView userNameBookChat , lastMessageBookChat ;
        public ViewHolderBookChat(@NonNull View itemView)
        {
            super(itemView);

            userImageBookChat = itemView.findViewById(R.id.userPicBookChat);
            userNameBookChat = itemView.findViewById(R.id.userNameBookChat);
            lastMessageBookChat = itemView.findViewById(R.id.lastMessageBookChat);

        }
    }
}
