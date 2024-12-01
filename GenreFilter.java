
/**
 * Décrivez votre classe GenreFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GenreFilter implements Filter{
    
  private   String genre;
    public GenreFilter(String genre){this.genre = genre;}

public boolean satisfies(String id){
return  MovieDatabase.getGenres(id).contains(genre);}

}