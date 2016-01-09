package afym.github.com;

import java.util.ArrayList;

public class CardViewStaticData {
    public static int HERO_NAME = 0;
    public static int HERO_IMAGE = 1;
    public static int HERO_DESCRIPTION = 2;

    public static ArrayList<ArrayList<String> > getHeros(){
        ArrayList<ArrayList<String> > heroes = new ArrayList<>();

        ArrayList<String> ironman = new ArrayList<>();
        ironman.add("Iron Man");
        ironman.add("http://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg");
        ironman.add("Tony has a genius level intellect that allows him to invent a wide range of sophisticated devices, specializing in advanced weapons and armor. He possesses a keen business mind.");

        ArrayList<String> captain = new ArrayList<>();
        captain.add("Captain America");
        captain.add("http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087/standard_xlarge.jpg");
        captain.add("Captain America had mastered the martial arts of American-style boxing and judo, and had combined these disciplines with his own unique hand-to-hand style of combat.");

        ArrayList<String> spiderman = new ArrayList<>();
        spiderman.add("Spider-Man");
        spiderman.add("https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg");
        spiderman.add("Peter is an accomplished scientist, inventor and photographer.");

        ArrayList<String> blackwindow = new ArrayList<>();
        blackwindow.add("Black Window");
        blackwindow.add("http://x.annihil.us/u/prod/marvel/i/mg/9/10/537ba3f27a6e0/standard_xlarge.jpg");
        blackwindow.add("Natasha Romanova, known by many aliases, is an expert spy, athlete, and assassin. Trained at a young age by the KGB's infamous Red Room Academy, the Black Widow was formerly an enemy to the Avengers.");

        heroes.add(ironman);
        heroes.add(captain);
        heroes.add(spiderman);
        heroes.add(blackwindow);

        return heroes;
    }
}
