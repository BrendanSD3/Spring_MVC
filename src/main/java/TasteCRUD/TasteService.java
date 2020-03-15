/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;

import Model.Beers;
import Model.Breweries;
import Model.BreweriesGeocode;
import Model.Categories;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Model.DBUtil;
import Model.Styles;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author k00214874
 */
@Service
public class TasteService {
     public List<Beers> getbeerbyname(String name)
       {
             EntityManager em = DBUtil.getEMF().createEntityManager();
            String query="SELECT b FROM Beers b WHERE b.name LIKE :name";
           TypedQuery<Beers> tq = em.createQuery(query, Beers.class);
           tq.setParameter("name","%"+name+"%");
       
        List<Beers> list=null;
        
        try {
            list = tq.getResultList();
            System.out.println("list"+ list);
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
       }
     public Beers getbeerByID(int beerid) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Beers beer = null;
        try {
            beer = em.find(Beers.class, beerid);
            //System.out.println("PRinting result"+ property);
            if (beer == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return beer;
    }
    public Styles getStyleByID(int styleid) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Styles style = null;
        try {
            style = em.find(Styles.class, styleid);
            //System.out.println("PRinting result"+ property);
            if (style == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return style;
    }
     public Categories getCatByID(int catid) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Categories cat = null;
        try {
            cat = em.find(Categories.class, catid);
            //System.out.println("PRinting result"+ property);
            if (cat == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return cat;
    }
    
//    public Boolean editBeer(Beers beer, double newprice) {
//            beer.setSellPrice(newprice);
//            System.out.println("Beer to be updated:  "+ beer);
//        System.out.println("Sell price= "+beer.getSellPrice());
//        EntityManager em =DBUtil.getEMF().createEntityManager();
//          EntityTransaction trans=em.getTransaction();
//          //Boolean success=true;
//          try{
//              trans.begin();
//              em.merge(beer);
//              trans.commit();
//          }
//      catch(Exception ex){
//          System.out.println("ex"+ ex + "Transaction"+trans.toString());
//          //success=false;
//          //return success;
//          
//      }
//          finally{
//              em.close();
//          }
//         // success=true;
//          return true;
//    }
    public Boolean editBeer(Beers beer, double newprice) {
            int id= beer.getId();
            double price=beer.getSellPrice();
            //System.out.println("price"+price);
            EntityManager em = DBUtil.getEMF().createEntityManager();
            
            EntityTransaction trans=em.getTransaction();
           
            //tq.setParameter("price",newprice);
            em.getTransaction().begin();

            String jpqlUpdate = "UPDATE Beers SET sellPrice = :price WHERE id = :id ";
            int updatedEntities = em.createQuery( jpqlUpdate )
                            .setParameter( "price", newprice )
                            .setParameter( "id", id )
                            .executeUpdate();
                            em.getTransaction().commit();
            em.close();
            
            System.out.println("updatedEntities"+updatedEntities);
            
            
            
           // Beers beers=tq.getSingleResult();
            //beers.setSellPrice(newprice);
//            try{        
//                trans.begin();
//                em.merge(beer);
//                trans.commit();
//    
//    }
//            catch(Exception ex){
//                System.out.println("ex"+ ex);
//            }
//           
//            finally{
//              em.close();
//          }
          return true;
    }
    
    
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
          System.out.println("Brewery obj"+b.getbrewid()+" "+b.getBrewery_id()+" ");
          //System.out.println("Breweryid"+b.getBrewery_id()+" gid"+b.getgeoid());
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
