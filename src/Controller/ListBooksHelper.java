/**
 * @author chadrobbins - cerobbins@dmacc.edu
 * CIS 175 - Spring 2022
 * Sep 9, 2022
 */
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.ListBooks;

/**
 * @author chadrobbins
 *
 */
public class ListBooksHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Bookshelf");
	
	public void insertItem(ListBooks lb) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lb);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListBooks> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<ListBooks> allBooks = em.createQuery("SELECT i FROM ListBooks i").getResultList();
		return allBooks;
	}

	public void removeBook(ListBooks toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBooks> typedQuery = em.createQuery("select li from ListBooks li where li.name = :selectedName and li.author = :selectedAuthor"
				+ " and li.genre = :selectedGenre and li.pageCount = :selectedPageCount", ListBooks.class);
		
		//Substitute parameter with actual data from the toDelete book
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		typedQuery.setParameter("selectedPageCount", toDelete.getPageCount());
		
		ListBooks result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListBooks> searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBooks> typedQuery = em.createQuery("select li from ListBooks li where li.name = :selectedName", ListBooks.class);
		typedQuery.setParameter("selectedName", title);
		List<ListBooks> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void updateItem(ListBooks toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<ListBooks> searchForItemByAuthor(String author) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBooks> typedQuery = em.createQuery("select li from ListBooks li where li.author = :selectedAuthor", ListBooks.class);
		typedQuery.setParameter("selectedAuthor", author);
		List<ListBooks> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListBooks> searchForItemByGenre(String genre) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBooks> typedQuery = em.createQuery("select li from ListBooks li where li.genre = :selectedGenre", ListBooks.class);
		typedQuery.setParameter("selectedGenre", genre);
		List<ListBooks> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListBooks> searchForItemByPageCount(int pageCount) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBooks> typedQuery = em.createQuery("select li from ListBooks li where li.pageCount = :selectedPageCount", ListBooks.class);
		typedQuery.setParameter("selectedPageCount", pageCount);
		List<ListBooks> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public ListBooks searchBookByID(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListBooks found = em.find(ListBooks.class, idToEdit);
		em.close();
		return found;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
