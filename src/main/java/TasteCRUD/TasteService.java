/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;

import Model.Breweries;
import Model.BreweriesGeocode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Model.DBUtil;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author k00214874
 */
@Service
public class TasteService {
       public List<Breweries> getAllBreweries() {
           EntityManager em = DBUtil.getEMF().createEntityManager();
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
         public int getmaxBreweryGeoID()
       {
             EntityManager em = DBUtil.getEMF().createEntityManager();
        Integer maxId = (Integer) em.createNamedQuery("BreweriesGeocode.findMaxId").getSingleResult();
       
       
           System.out.println("maxgeoid"+maxId);
       return maxId;
       
       }
       public int getmaxBreweryID()
       {
             EntityManager em = DBUtil.getEMF().createEntityManager();
        Integer maxId = (Integer) em.createNamedQuery("Breweries.findMaxId").getSingleResult();
       
       
           System.out.println("maxid"+maxId);
       return maxId;
       
       }
    public int addBrewery(Breweries b)
      {
          System.out.println("Brewery obj"+b);
          System.out.println("Breweryid"+b.getBrewery_id()+" gid"+b.getgeoid());
          Integer geoid=getmaxBreweryGeoID()+1;
          
          EntityManager em =DBUtil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
          try{
              trans.begin();
              em.persist(b);
              trans.commit();
          }
      catch(Exception ex){
          System.out.println("ex"+ ex);
          return 0;//failed
      }
          finally{
              em.close();
          }
          return 1; // succeeded

      }
       
    public void addBreweryGeo(BreweriesGeocode g)
      {
          
          System.out.println("Geocode obj"+ g);
         //BreweriesGeocode gobj= new BreweriesGeocode(g.getId(), g.getBreweryId(), g.getLatitude(), g.getLongitude());
          EntityManager em =DBUtil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
          try{
              trans.begin();
              em.persist(g);
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
        EntityManager em = DBUtil.getEMF().createEntityManager();

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

    public void editBrewery(Breweries brew) {
            
         //BreweriesGeocode gobj= new BreweriesGeocode(g.getId(), g.getBreweryId(), g.getLatitude(), g.getLongitude());
          EntityManager em =DBUtil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
          try{
              trans.begin();
              em.merge(brew);
              trans.commit();
          }
      catch(Exception ex){
          System.out.println("ex"+ ex);
          
      }
          finally{
              em.close();
          }
    }
     public void deleteBrew(Breweries b)
      {
          EntityManager em = DBUtil.getEMF().createEntityManager();
          EntityTransaction trans= em.getTransaction();
          try{
              trans.begin();
              em.remove(em.merge(b));
              trans.commit();
              
          }
          catch(Exception e){
              System.out.println("ex"+ e);
          }
          finally {
              em.close();
          }
      }
}
