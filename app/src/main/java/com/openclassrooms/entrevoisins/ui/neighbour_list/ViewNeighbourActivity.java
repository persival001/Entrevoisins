package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.firstNameTextView)
    TextView mName1;
    @BindView(R.id.firstNameTextView2)
    TextView mName2;
    @BindView(R.id.phoneNumberTextView)
    TextView mPhone;
    @BindView(R.id.emailTextView)
    TextView mEmail;
    @BindView(R.id.addressTextView)
    TextView mAddress;
    @BindView(R.id.commentsTextView)
    TextView mAboutMe;
    @BindView(R.id.avatarImageView)
    ImageView mAvatar;
    @BindView(R.id.favoriteFloatingActionButton)
    FloatingActionButton mFavoriteButton;

    private NeighbourApiService mApiService;
    private Boolean mClick;

    private Neighbour getNeighbour() {
        Intent intent = getIntent();
        return intent.getParcelableExtra("neighbour");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_neighbour);
        this.configureToolbar();
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        init();
    }

    private void init() {

        String mName = getNeighbour().getName();
        mName1.setText(mName);
        mName2.setText(mName);
        mPhone.setText(getNeighbour().getPhoneNumber());
        mAddress.setText(getNeighbour().getAddress());
        mAboutMe.setText(getNeighbour().getAboutMe());

        String mSocialName = "www.facebook.fr/" + mName;
        mEmail.setText(mSocialName);

        String mLinkAvatar = getNeighbour().getAvatarUrl();
        Glide.with(this).load(mLinkAvatar).into(mAvatar);

        if (getNeighbour().getIsFavorite()) {
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
            mClick = true;
        }
        else {
            mClick = false;
        }
    }

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    @OnClick(R.id.favoriteFloatingActionButton)
    void setFavoriteButton() {

        if (mClick) {
            Toast.makeText(this, "Ce voisin a été supprimé de vos favoris", Toast.LENGTH_SHORT).show();
            mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
            mApiService.deleteFavoriteNeighbour(getNeighbour().getId());
            mClick = false;
        }

        else {
            Toast.makeText(this, "Ce voisin a été ajouté à vos favoris", Toast.LENGTH_SHORT).show();
            mApiService.addFavoriteNeighbour(getNeighbour().getId());
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
            mClick = true;
        }
    }
}