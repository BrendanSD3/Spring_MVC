/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;

import Model.Breweries;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Model.dbutil;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author k00214874
 */
@Service
public class TasteService {
       public List<Breweries> getAllBreweries() {
           EntityManager em = dbutil.getEMF().createEntityManager();
        String query="SELECT b FROM Breweries b";
        TypedQuery<Breweries> tq = em.createQuery(query, Breweries.class);
//        
            
 
        List<Breweries> list = null;
        
        try {
            list = tq.getResultList();
            //System.out.println("list"+ list);
            if (list == null || list.size() == 0) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        //System.out.println("Got the list"+list);
        return list;       

    }//end 
    public void addBrewery(Breweries b)
      {
          EntityManager em =dbutil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
          try{
              trans.begin();
              em.persist(b);
              trans.commit();
          }
      catch(Exception ex){
          System.out.println("ex"+ ex);
          
      }
          finally{
              em.close();
          }
      }
    public Breweries getbrewByID(int brewid) {
        EntityManager em = dbutil.getEMF().createEntityManager();

        Breweries brew = null;
        try {
            brew = em.find(Breweries.class, brewid);
            //System.out.println("PRinting result"+ property);
            if (brew == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return brew;
    }
}
