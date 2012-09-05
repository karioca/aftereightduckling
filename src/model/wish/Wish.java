package model.wish;

import java.net.URI;

public class Wish {
	
	public String title;
	public URI link;
	public String imageFileAddress;
	public URI imageLink;
	
	public User user;

	@Override
	public String toString(){
		return title;
	}
	
	@Override
	public boolean equals(Object w) {
		if ( this == w ) return true;
		if ( !(w instanceof Wish) ) return false;
		Wish that = (Wish)w;
		  
		boolean res = false;
		res = title.equals(that.title) &&
			  link.equals(that.link) &&
			  imageFileAddress.equals(that.imageFileAddress) &&
			  imageLink.equals(that.imageLink) &&
			  user.equals(that.user);
		
		return res ;
	}
	
}
