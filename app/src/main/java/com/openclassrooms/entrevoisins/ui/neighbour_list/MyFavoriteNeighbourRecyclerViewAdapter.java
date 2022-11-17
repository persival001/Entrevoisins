package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class MyFavoriteNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.ViewHolder> {

        private final List<Neighbour> mNeighbours;

        public MyFavoriteNeighbourRecyclerViewAdapter(List<Neighbour> items) {
            mNeighbours = items;
        }

        @NonNull
        @Override
        public com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.itemview_favorite_neighbour, parent, false);
            return new com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.ViewHolder holder, int position) {
            Neighbour neighbour = mNeighbours.get(position);
            holder.mNeighbourName.setText(neighbour.getName());
            Glide.with(holder.mNeighbourAvatar.getContext())
                    .load(neighbour.getAvatarUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.mNeighbourAvatar);

            holder.mDeleteButton.setOnClickListener(v -> EventBus.getDefault().post(new DeleteFavoriteNeighbourEvent(neighbour)));
        }

        @Override
        public int getItemCount() {
            return mNeighbours.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.item_list_avatar)
            public ImageView mNeighbourAvatar;
            @BindView(R.id.item_list_name)
            public TextView mNeighbourName;
            @BindView(R.id.item_list_delete_button)
            public ImageButton mDeleteButton;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }
