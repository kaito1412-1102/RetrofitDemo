package com.example.retrofitdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.retrofitdemo.model.Post;
import com.example.retrofitdemo.request.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_getdata)
    Button btnGetData;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    @OnClick(R.id.btn_getdata)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getdata:
                getPost();
                break;
        }
    }

    private void initRecyclerView() {
        adapter = new PostAdapter();
        posts = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void getPost() {
        ServiceGenerator.getRequestApi().getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.body() != null) {
                    adapter.setPosts(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

}