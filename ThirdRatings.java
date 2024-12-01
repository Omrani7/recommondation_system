import java.util.*;
/**
 * Décrivez votre classe ThirdRatings ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ThirdRatings {

    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this( "ratings.csv");
    }
    public ThirdRatings(String raterFile){
    FirstRatings fr = new FirstRatings();
 
    myRaters = fr.loadRater(raterFile);
    }

public int getRaterSize(){
return myRaters.size();
}
private double getAverageByID( String movieID,int minRatings){
int count = 0;
int totalRating = 0;
    for(Rater r : myRaters){
if(r.hasRating(movieID)){
totalRating +=r.getRating(movieID);
count++;
 }
}
 
    if (count >= minRatings) return  (double)totalRating / count;
        

return 0.0;}
public ArrayList<Rating> getAverageRatings(int minRatings){
ArrayList<Rating> list  = new ArrayList<Rating>();
ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
for(String ID : movies){

double rate = getAverageByID(ID,minRatings);
if(rate > 0){
Rating rating = new Rating(ID,rate);
list.add(rating);}
} 
return list ;
}
public ArrayList<Rating>getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria){
ArrayList<Rating> list = new ArrayList<Rating>();
ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
for(String ID : movies){

double rate = getAverageByID(ID,minimalRaters);
if(rate > 0){
Rating rating = new Rating(ID,rate);
list.add(rating);}
} 
return list ;
}


}
