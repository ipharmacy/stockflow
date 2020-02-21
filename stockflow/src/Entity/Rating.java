
package Entity;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class Rating {
    private int idrating,idlivreur,note ;
    private int iduser ; 
    String commentaire ; 

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Rating(int idrating, int idlivreur, int note, int iduser, String commentaire) {
        this.idrating = idrating;
        this.idlivreur = idlivreur;
        this.note = note;
        this.iduser = iduser;
        this.commentaire = commentaire;
    }
    public Rating( int idlivreur, int note, int iduser, String commentaire) {
       
        this.idlivreur = idlivreur;
        this.note = note;
        this.iduser = iduser;
        this.commentaire = commentaire;
    }

    public Rating() {
        
    }

    public int getIdrating() {
        return idrating;
    }

    public int getIdlivreur() {
        return idlivreur;
    }

    public int getNote() {
        return note;
    }
    
    public int getIduser()
            
    {
        return iduser ; 
    }
    
    public String getCommentaire()
    {
        return commentaire ; 
    }

    public void setIdrating(int idrating) {
        this.idrating = idrating;
    }

    public void setIdlivreur(int idlivreur) {
        this.idlivreur = idlivreur;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    

    @Override
    public String toString() {
        return "Rating{" + "idrating=" + idrating + ", idlivreur=" + idlivreur + ", note=" + note +"iduser="+iduser+"commentaire="+commentaire+ '}';
    }

    public Rating(int idrating, int idlivreur, int note) {
        this.idrating = idrating;
        this.idlivreur = idlivreur;
        this.note = note;
    }
    
    
    
}
