import java.util.*;
/**
 * Décrivez votre classe MovieRunnerWithFilters ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MovieRunnerWithFilters {
public void  printAverageRatings(){ 
   ThirdRatings sr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
   System.out.println("number of movies : "+ MovieDatabase.size() +" "+"number of ratings : "+sr.getRaterSize());
    
    int min = 35;
   ArrayList<Rating> list =sr.getAverageRatings(min);
   System.out.println(list.size());

     Collections.sort(list);
        for (Rating i : list) {
            System.out.printf("%-10.2f%s%n", i.getValue(), MovieDatabase.getTitle(i.getItem()));
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
    public void printAverageRatingsByYear(){
      ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
    YearAfterFilter yaf = new YearAfterFilter(2000);
     System.out.println("number of movies : "+ MovieDatabase.size() +" "+"number of ratings : "+tr.getRaterSize());

   ArrayList<Rating> list =tr.getAverageRatingsByFilter(20,yaf);
   System.out.println(list.size());
   List<Rating> sortedList = new ArrayList<>(list.size());
     Collections.sort(list);
        for (Rating i : list) {
            System.out.printf("%-10.2f%s%n", i.getValue(), MovieDatabase.getTitle(i.getItem()));
        }
   }
   public void printAverageRatingsByGenre(){
        ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
         System.out.println("number of movies : "+ MovieDatabase.size() +" "+"number of ratings : "+tr.getRaterSize());
   GenreFilter gf = new GenreFilter("Comedy");
ArrayList<Rating> list =tr.getAverageRatingsByFilter(20,gf);
   System.out.println(list.size());
  
     Collections.sort(list);
        for (Rating i : list) {
            System.out.printf("%-10.2f%s%n%4s%n", i.getValue(), MovieDatabase.getTitle(i.getItem()),MovieDatabase.getGenres(i.getItem()) );
        }   
}
public void printAverageRatingsByMinutes​(){
        ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
         System.out.println("number of movies : "+ MovieDatabase.size() +" "+"number of ratings : "+tr.getRaterSize());
MinutesFilter mf = new MinutesFilter(105,135);
ArrayList<Rating> list =tr.getAverageRatingsByFilter(5,mf);
   System.out.println(list.size());
 
     Collections.sort(list);
     /*   for (Rating i : list) {
            System.out.println(   "  "+i.getValue()+" "+MovieDatabase.getTitle(i.getItem())+" time :  "+ MovieDatabase.getMinutes(i.getItem()));
        } */
}
public void printAverageRatingsByDirectors(){
    ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
DirectorsFilter df = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
ArrayList<Rating> list =tr.getAverageRatingsByFilter(4,df);
System.out.println(list.size());
     Collections.sort(list);
       /* for (Rating i : list) {
            System.out.println(   "  "+i.getValue()+" "+MovieDatabase.getTitle(i.getItem())+"   "+ MovieDatabase.getDirector(i.getItem()));
        }*/

}
public void printAverageRatingsByYearAfterAndGenre(){
ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
    AllFilters af = new AllFilters();
    af.addFilter(new GenreFilter("Drama"));
    af.addFilter(new YearAfterFilter(1990));
    ArrayList<Rating> list = tr.getAverageRatingsByFilter(8,af); 
   System.out.println(list.size());
  
     Collections.sort(list);
        for (Rating i : list) {
            System.out.println(   "  "+i.getValue()+" "+MovieDatabase.getTitle(i.getItem())+"   "+ MovieDatabase.getGenres(i.getItem()   ));
        }
}
public void printAverageRatingsByDirectorsAndMinutes(){
ThirdRatings tr = new ThirdRatings("C:\\Users\\moham\\Downloads\\StepOneStarterProgram\\data\\ratings.csv");
    MovieDatabase.initialize("ratedmoviesfull.csv");
    AllFilters af = new AllFilters();
    af.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
    af.addFilter(new MinutesFilter(90,180));
    ArrayList<Rating> list = tr.getAverageRatingsByFilter(3,af); 
System.out.println(list.size());
  
     /*Collections.sort(list);
        for (Rating i : list) {
            System.out.println(   "  "+i.getValue()+" "+MovieDatabase.getTitle(i.getItem())+"   "+ MovieDatabase.getMinutes(i.getItem())+"  "+MovieDatabase.getDirector(i.getItem()   ));
        }*/
}

}

