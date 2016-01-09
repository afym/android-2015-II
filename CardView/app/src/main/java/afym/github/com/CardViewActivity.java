package afym.github.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Log.i("HERO", "BEGIN");
        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.heroes_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ArrayList<String>> heroes = CardViewStaticData.getHeros();
        CardHeroRecyclerAdapter recyclerAdapter = new CardHeroRecyclerAdapter(heroes);
        Log.i("HERO", "Q:"+heroes.size());
        recyclerView.setAdapter(recyclerAdapter);
        Log.i("HERO", "END");

    }
}
