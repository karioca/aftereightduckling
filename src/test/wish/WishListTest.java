package test.wish;

import model.wish.User;
import model.wish.Wish;
import model.wish.WishList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class WishListTest {
	
	@Test
	public void testCreateWishList (){		
		
		WishList list = new WishList();
		assertEquals(0, list.size());		
	}
	
	@Test
	public void testAddToWishList(){
		WishList list = new WishList();
		User user = new User("Kari");
		list.add(new Wish());
		assertEquals(1, list.size());
	}
	
	@Test
	public void testRemoveWish(){
		WishList list = new WishList();
		User user = new User("Kari");
		
		Wish wish = new Wish();{ wish.title = "My Greatest Desire";	}
		list.add(wish);
		System.out.println("Elements in list: " + list.size() + " . " + list.toString());
		list.remove(wish);
		System.out.println("Elements in list: " + list.size() + " . " + list.toString());
		assertEquals(0, list.size());
		list.remove(wish);
		System.out.println("Elements in list: " + list.size() + " . " + list.toString());
		assertEquals(0, list.size());	
	}
	
	@Test
	public void testUndoAddToList(){
		User user = new User("Kari");
		WishList list = new WishList();
		fillWishList(list, user);
		System.out.println(list);
		int listSize = list.size();
		

		Wish first = list.elements.get(0);
		list.add(first);
		System.out.println(list);
		System.out.println(user);
		
		list.undo(user);
		System.out.println(list);
		assertEquals(listSize, list.size());
		list.undo(user);
		System.out.println(list);
		assertEquals(listSize-1, list.size());
		System.out.println(user);
		list.undo(user);
		System.out.println(user);
		list.undo(user);
		System.out.println(user);
		list.undo(user);
		System.out.println(user);
	}
	
	@Test
	public void testRedoAdd(){
		User user = new User("Kari");
		WishList list = new WishList();
		fillWishList(list, user);
		System.out.println(list);
		
		Wish first = list.elements.get(0);
		list.add(first);
		System.out.println(list);
		System.out.println(user);
		list.undo(user);
		System.out.println(list);
		System.out.println(user);
		list.redo(user);
		System.out.println(user);
		list.redo(user);
		System.out.println(list);
		System.out.println(user);
		
	}
	
//	@Test
//	public void testTwoUsersUndo(){
//		User kari = new User("Kari"); 
//		User anne = new User("Anne"); 
//		
//		WishList list = new WishList();
//		fillWishList(list, kari);
//		fillWishList(list, anne);
//		System.out.println(list);
//	
//		assertThat(kari, not(anne));
//		
//		//each user has their own CommandKeeper
//		
//		
//	
//	}
	
	private void fillWishList(WishList list, User user) {
		Wish wish = new Wish();{ wish.title = "My Greatest Desire"; wish.user = user;	}
		Wish wish1 = new Wish();{ wish1.title = "World Peace"; wish.user = user;	}
		Wish wish2 = new Wish();{ wish2.title = "Handsome husband"; wish.user = user;	}
		
		Wish[] wishes = new Wish[]{ wish, wish1, wish2 };
				
		for (Wish a : wishes){
			list.add(a);	}		
	}

}
