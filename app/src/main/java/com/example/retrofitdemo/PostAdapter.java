package com.example.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitdemo.model.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    List<Post> posts = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, null, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bindPost(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.text_body)
        TextView textBody;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindPost(Post post) {
            textTitle.setText(post.getTitle());
            textBody.setText(post.getBody());
        }
    }
}
