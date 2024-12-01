
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String raterFile,String movieFile){
    FirstRatings fr = new FirstRatings();
    myMovies = fr.loadMovies(movieFile);
    myRaters = fr.loadRater(raterFile);
    }
    public int getMovieSize(){
    return myMovies.size();
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
for(Movie m : myMovies){
String movieID = m.getID();
double rate = getAverageByID(movieID,minRatings);
if(rate > 0){
Rating rating = new Rating(movieID,rate);
list.add(rating);}
} 
return list ;
}
public String getTitle(String movieID){
for(Movie m : myMovies){
if (m.getID().equals(movieID)){
return m.getTitle();
}
}
return "Not found!";}
public String getID(String movieTitle){
for(Movie m : myMovies){
if(m.getTitle().equals(movieTitle)){
return m.getID();}
}
return "Not Found";}
public double averageRatingOneMovie(String title){
String movieID = getID(title);
return getAverageByID(movieID,0);
}


}