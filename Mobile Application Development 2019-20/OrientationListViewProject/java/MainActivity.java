package com.example.orientationlistviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList< MusicArtist > artistList;
    ArtistListAdapter artistListAdapter;
    TextView rankText, followersText, nameText, bioText;
    ImageView albumImage, instagramImage;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding IDs of objects displayed in application
        listView = findViewById(R.id.id_listview);
        rankText = findViewById(R.id.id_textview_rank);
        followersText = findViewById(R.id.id_textview_followers);
        nameText = findViewById(R.id.id_textview_name);
        bioText = findViewById(R.id.id_textview_bio);
        albumImage = findViewById(R.id.id_imageview_album);
        instagramImage = findViewById(R.id.id_imageview_instagram);

        // Creating the MusicArtist objects
        MusicArtist PostMalone = new MusicArtist("Post Malone", "Austin Richard Post", "Hip Hop/Rap", "55,951,094", "1st in the World", "Post Malone has revolutionized the music industry, drawing influence from the genres of hip-hop, pop, and country.  With each of his major projects, he has released groundbreaking singles of the likes of \"rockstar (feat. 21 Savage)\", \"Sunflower\", and \"Better Now\".  He continue to masterfully implant his crisp, formulaic vocals into any track.", "https://www.youtube.com/watch?v=wXhTHyIgQ_U&ab_channel=PostMaloneVEVO", "https://www.instagram.com/postmalone/", R.drawable.postmaloneportrait, R.drawable.postmalonealbum, R.drawable.postmaloneinstagram);
        MusicArtist BillieEilish = new MusicArtist("Billie Eilish", "Billie Eilish Pirate Baird O'Connell", "Pop", "49,028,557", "2nd in the World", "Billie Eilish, at only 17 years old, has found herself a spot in the mainstream pop industry.  She has combined her melodic voice with the themes of the inner workings of the mind, love, relationships, and dreams, creating a diverse array of hits.  She has quickly become one of the world’s largest pop stars.", "https://www.youtube.com/watch?v=DyDfgMOUjCI&ab_channel=BillieEilishVEVO", "https://www.instagram.com/billieeilish/", R.drawable.billieeilishportrait, R.drawable.billieeilishalbum, R.drawable.billieeilishinstagram);
        MusicArtist TaylorSwift = new MusicArtist("Taylor Swift", "Taylor Alison Swift", "Pop", "37,681,505", "4th in the World", "Taylor Swift has released a transforming selection of music throughout her music career, transitioning from singer/songwriter and country to pop.  With her newest album \"Lover\", Swift has one again established her presence in the public eye through hits such as \"ME!\", \"You Need to Calm Down\", and \"Lover\".  She was recently named Billboard’s music artist of the decade.", "https://www.youtube.com/watch?v=FuXNumBwDOM&ab_channel=TaylorSwiftVEVO", "https://www.instagram.com/taylorswift/", R.drawable.taylorswiftportrait, R.drawable.taylorswiftalbum, R.drawable.taylorswiftinstagram);
        MusicArtist Lizzo = new MusicArtist("Lizzo", "Melissa Viviane Jefferson", "Pop", "25,138,404", "5th in the World", "Lizzo is an artist that has quickly broken into the mainstream with her pop album \"Cuz I Love You\".  Hits such as \"Truth Hurts\", \"Juice\", and \"Boys\" solidify her combination of elements of R&B, pop, and hip-hop as a means to create energetic beats and humorous lyrics.", "https://www.youtube.com/watch?v=P00HMxdsVZI&ab_channel=LizzoMusic", "https://www.instagram.com/lizzobeeating/", R.drawable.lizzoportrait, R.drawable.lizzoalbum, R.drawable.lizzoinstagram);
        MusicArtist DaBaby = new MusicArtist("DaBaby", "Jonathan Lyndale Kirk", "Hip Hop/Rap", "18,407,892", "7th in the World", "DaBaby is arguably the biggest breakout rapper of 2019, releasing the album \"KIRK\" to develop his humorous take on the stereotypical rapper lifestyle juxtaposed against ideals of family.  His flow is remarkable and iconic, and rests upon bass-heavy beats peppered with ad-libs.  His notable songs are \"Suge\", \"VIBEZ\", and \"BOP\".", "https://www.youtube.com/watch?v=U2JyeciEwSI&ab_channel=DaBaby", "https://www.instagram.com/dababy/", R.drawable.dababyportrait, R.drawable.dababyalbum, R.drawable.dababyinstagram);

        // Adding the MusicArtist objects to an ArrayList
        artistList = new ArrayList<>();
        artistList.add(PostMalone);
        artistList.add(BillieEilish);
        artistList.add(TaylorSwift);
        artistList.add(Lizzo);
        artistList.add(DaBaby);

        // Extracting information from savedInstanceState to update objects displayed
        if (savedInstanceState != null) {
            pos = savedInstanceState.getInt("position");
            artistList = (ArrayList<MusicArtist>) savedInstanceState.getSerializable("list");
            if (artistList.size() > 0) {
                if (rankText != null) {
                    rankText.setText(artistList.get(pos).getRank());
                }
                if (followersText != null) {
                    followersText.setText(artistList.get(pos).getFollowers() + " followers");
                }
                if (nameText != null) {
                    nameText.setText(artistList.get(pos).getName());
                }
                if (bioText != null) {
                    bioText.setText(artistList.get(pos).getBio());
                }
                if (albumImage != null) {
                    albumImage.setImageResource(artistList.get(pos).getAlbumLocation());
                    albumImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = artistList.get(pos).getMusicVideoURL();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                }
                if (instagramImage != null) {
                    instagramImage.setImageResource(artistList.get(pos).getInstagramLocation());
                    instagramImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = artistList.get(pos).getInstagramURL();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                }
            }
        }

        // Setting artistListAdapter as custom adapter for listView object
        artistListAdapter = new ArtistListAdapter(this, R.layout.adapter_custom, artistList);
        listView.setAdapter(artistListAdapter);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    pos = position;
                    rankText.setText("Rank: " + artistList.get(position).getRank());
                    followersText.setText("Followers: " + artistList.get(position).getFollowers());
                }
            });
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    pos = position;
                    nameText.setText(artistList.get(position).getName());
                    rankText.setText(artistList.get(position).getRank());
                    followersText.setText(artistList.get(position).getFollowers() + " followers");
                    bioText.setText(artistList.get(position).getBio());
                    albumImage.setImageResource(artistList.get(position).getAlbumLocation());
                    albumImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = artistList.get(pos).getMusicVideoURL();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                    instagramImage.setImageResource(artistList.get(position).getInstagramLocation());
                    instagramImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = artistList.get(pos).getInstagramURL();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                }
            });
        }
    }

    public class ArtistListAdapter extends ArrayAdapter<MusicArtist> {
        Context parentContext;
        ArrayList <MusicArtist> list;
        int xmlResource;

        public ArtistListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MusicArtist> objects) {
            super(context, resource, objects);
            parentContext = context;
            xmlResource = resource;
            list = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)parentContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(xmlResource, null);

            ImageView portrait = adapterView.findViewById(R.id.id_imageview_portrait);
            TextView stageName = adapterView.findViewById(R.id.id_textview_stagename);
            TextView genre = adapterView.findViewById(R.id.id_textview_genre);
            ImageView remove = adapterView.findViewById(R.id.id_imageview_remove);

            portrait.setImageResource(list.get(position).getPortraitLocation());
            stageName.setText(list.get(position).getStageName());
            genre.setText(list.get(position).getGenre());
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    artistList.remove(pos);
                    notifyDataSetChanged();
                }
            });

            return adapterView;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", pos);
        outState.putSerializable("list", artistList);

    }
}