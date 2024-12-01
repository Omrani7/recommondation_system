
/**
 * Décrivez votre classe DirectorsFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DirectorsFilter implements Filter {
private String Directors;
public DirectorsFilter (String Directors){
this.Directors = Directors;}
public boolean satisfies(String id){

String []directors = Directors.split(",");
for (String director : directors){

if (MovieDatabase.getDirector(id).contains(director))
return true;
} 
return false; 
}
}