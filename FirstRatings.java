import edu.duke.*;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
    public ArrayList<Movie> loadMovies(String fileName) {
        ArrayList<Movie> movies = new ArrayList<>();
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord i : parser) {
            String id = i.get("id");
            String title = i.get("title");
            String year = i.get("year");
            String country = i.get("country");
            String genre = i.get("genre");
            String director = i.get("director");
            int minutes = Integer.parseInt(i.get("minutes"));
            String poster = i.get("poster");
            Movie m = new Movie(id, title, year, genre, director, country, poster, minutes);
            movies.add(m);
        }
        return movies;
    }
public void testLoadMovie(){
HashMap<String,ArrayList<Movie>> counter = new HashMap<String,ArrayList<Movie>>();
    ArrayList<Movie> list = loadMovies("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratedmoviesfull.csv");
System.out.println("number of movies is "+ list.size());
//for(int i = 0; i<=200;i++){
//System.out.println(list.get(i).getDirector());}
int c = 0;
//for(Movie m : list){
  //  if (m.getGenres().contains("Comedy")){
   // c++;
  //  System.out.println(m);
//}}
    System.out.println(c);
    for(Movie m : list){
   if(m.getMinutes()>150){
   c++;
   // System.out.println(m);
}}
   System.out.println(c);


   
   
   
   
   
   
   
  int maxDirectors = 0;
    for (Movie m : list){
String [] directors  = m.getDirector().split(",");
for (String dr : directors){
        if (!counter.containsKey(dr)){

counter.put(dr,new ArrayList<Movie>());}
if(m.getDirector().contains(dr)){
counter.get(dr).add(m);}

}

}
String max = "";
for(String s : counter.keySet()){
    if (counter.get(s).size()> maxDirectors){
    maxDirectors = counter.get(s).size();
    max = s;
}

}
System.out.println("the most director that directed " +maxDirectors+" is " +max  );
}
public ArrayList<Rater> loadRater(String fileName){
    ArrayList<Rater> list = new ArrayList<Rater>();
    FileResource fr = new FileResource(fileName);
    CSVParser parser = fr.getCSVParser();
    for(CSVRecord record : parser){
        String id = record.get("rater_id");
        String movie_id = record.get("movie_id");
        double rating = Double.parseDouble(record.get("rating"));
        int time = Integer.parseInt(record.get("time"));
        Rater rater = null;
        for(Rater r : list){
            if (r.getID().equals(id)){
                rater = r;
                break;
            }
        }
        if(rater == null){
            rater = new EfficientRater(id);
            list.add(rater);
        }
        rater.addRating(movie_id, rating);
    }
    return list;
}

public void testLoadRater(){
ArrayList<Rater> list = loadRater("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
System.out.println(list.size());
//for(Rater rater: list){
//System.out.println("Rater with ID = "+rater.getID()+"has "+rater.numRatings()+" Ratings: "+rater.getItemsRated());
//}
int c =0;
for (Rater r : list ){
if(r.getID().equals("193")){

   System.out.println(r.getItemsRated().size());
}
}
System.out.println(c);
int maxRatings = 0;
for (Rater r : list){
int numRatings = r.numRatings();
if(numRatings > maxRatings)
maxRatings = numRatings;
}
System.out.println("the max number of ratings  = "+maxRatings);

for (Rater r : list){
int numRatings = r.numRatings();
if(numRatings == maxRatings){
System.out.println("rater id = "+r.getID()+" "+r.getItemsRated());}
        }
        String movie_id = "1798709";
        int count = 0;
        for (Rater r : list){
        if(r.getItemsRated().indexOf(movie_id)!=-1){
        count++;
        }
    }
    System.out.println("the number of times this movie was rated is "+count);
    
    ArrayList<String> uniqueMovies = new ArrayList<String>();
    
    for (Rater r : list){
    ArrayList<String> itemsRated = r.getItemsRated();
    for(String s : itemsRated){
    if(!uniqueMovies.contains(s)){
    uniqueMovies.add(s);
    }
    
    }
    
    }
    System.out.println("number of movies rated is : "+uniqueMovies.size());
}
}
