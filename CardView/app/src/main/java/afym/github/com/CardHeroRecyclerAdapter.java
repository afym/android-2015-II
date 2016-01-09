package afym.github.com;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CardHeroRecyclerAdapter extends RecyclerView.Adapter<CardHeroViewHolder> {
    private ArrayList<ArrayList<String>> heroes;

    public CardHeroRecyclerAdapter(ArrayList<ArrayList<String>> heroes) {
        Log.i("HERO", "CardHeroRecyclerAdapter");
        this.heroes = heroes;
    }

    @Override
    public CardHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("HERO", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_card_view, parent, false);
        CardHeroViewHolder cardHeroViewHolder = new CardHeroViewHolder(view);
        return cardHeroViewHolder;
    }

    @Override
    public void onBindViewHolder(CardHeroViewHolder cardHeroViewHolder, int position) {
        Log.i("HERO", "P:" + position);
        cardHeroViewHolder.getHeroName().setText(this.heroes.get(position).get(CardViewStaticData.HERO_NAME));
        cardHeroViewHolder.getHeroDescription().setText(this.heroes.get(position).get(CardViewStaticData.HERO_DESCRIPTION));
        String url = this.heroes.get(position).get(CardViewStaticData.HERO_IMAGE);
        CardImageAsyncTask task = new CardImageAsyncTask(url, cardHeroViewHolder.getHeroPhoto());
        task.execute();

    }

    @Override
    public int getItemCount() {
        Log.i("HERO", "getItemCount");
        return this.heroes.size();
    }
}
