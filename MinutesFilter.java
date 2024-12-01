
/**
 * Décrivez votre classe MinutesFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MinutesFilter implements Filter{
private int min ;
private int max;
 public MinutesFilter(int min ,int max ){
    this.min =min;
this.max = max;}
public boolean satisfies(String id){
return min<=MovieDatabase.getMinutes(id)&&MovieDatabase.getMinutes(id)<=max;}
}
