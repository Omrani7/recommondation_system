import java.util.*;
/**
 * Décrivez votre classe MovieRunnerAverage ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MovieRunnerAverage {

  public void printAverageRatings(){
    SecondRatings sr = new SecondRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv",
    "C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratedmoviesfull.csv");
    System.out.println("number of movies : "+sr.getMovieSize()+" "+"number of ratings : "+sr.getRaterSize());
    int min = 12;
   ArrayList<Rating> list =sr.getAverageRatings(min);
   System.out.println(list.size());
   List<Rating> sortedList = new ArrayList<>(list.size());
     Collections.sort(list);
        for (Rating i : list) {
            System.out.printf("%-10.2f%s%n", i.getValue(), sr.getTitle(i.getItem()));
        }
    
    
/*for (int i = 0; i < list.size(); i++) {
    int minIndex = i;
    for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j).getValue() < list.get(minIndex).getValue()) {
            minIndex = j;
        }
    }
    sortedList.add(list.get(minIndex));
    // Swap the minimum element with the first unsorted element
    Rating tmp = list.get(i);
    list.set(i, list.get(minIndex));
    list.set(minIndex, tmp);
}*/

/*  Rating tmp = null; 
   for(int i = 0; i<list.size(); i++ ){
  Rating max = list.get(i);
for(int j = i+1 ; j < list.size(); j++){
    Rating current = list.get(j);
    if (current.getValue()< max.getValue()){
    tmp = max ;
    
    list.set(i,current);
    list.set(j,tmp);
    
    }
}
 }  */
  // for (Rating r : sortedList){
  //  System.out.println(r.getValue()+" "+sr.getTitle(r.getItem()));
 // } 
    }
    public void  getAverageRatingOneMovie(){
     SecondRatings sr = new SecondRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv",
    "C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratedmoviesfull.csv");
  
     ArrayList<Rating> ratingList = sr.getAverageRatings(2);
        String movieTitle = "Vacation";
        for (Rating i : ratingList) {
            if (sr.getTitle(i.getItem()).equals(movieTitle)) {
                System.out.printf("%-10.2f%s%n", i.getValue(), sr.getTitle(i.getItem()));
            }
        }
        
    }
    }
    
    
    
