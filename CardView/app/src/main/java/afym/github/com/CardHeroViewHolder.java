package afym.github.com;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardHeroViewHolder extends RecyclerView.ViewHolder {

    private CardView heroesCardView;
    private TextView heroName;
    private TextView heroDescription;
    private ImageView heroPhoto;

    public CardHeroViewHolder(View itemView) {
        super(itemView);
        this.heroesCardView = (CardView) itemView.findViewById(R.id.hero_card_view);
        this.heroName = (TextView) itemView.findViewById(R.id.hero_name);
        this.heroDescription = (TextView) itemView.findViewById(R.id.hero_description);
        this.heroPhoto = (ImageView) itemView.findViewById(R.id.hero_photo);
    }

    public CardView getHeroesCardView() {
        return heroesCardView;
    }

    public void setHeroesCardView(CardView heroesCardView) {
        this.heroesCardView = heroesCardView;
    }

    public TextView getHeroName() {
        return heroName;
    }

    public void setHeroName(TextView heroName) {
        this.heroName = heroName;
    }

    public TextView getHeroDescription() {
        return heroDescription;
    }

    public void setHeroDescription(TextView heroDescription) {
        this.heroDescription = heroDescription;
    }

    public ImageView getHeroPhoto() {
        return heroPhoto;
    }

    public void setHeroPhoto(ImageView heroPhoto) {
        this.heroPhoto = heroPhoto;
    }
}
