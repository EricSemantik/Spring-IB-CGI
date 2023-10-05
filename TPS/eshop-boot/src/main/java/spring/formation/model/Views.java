package spring.formation.model;

public interface Views {
	public interface ViewBase {}
	
	public interface ViewCommentaire extends ViewBase {}
	
	public interface ViewProduit extends ViewBase {}
	
	public interface ViewProduitDetail extends ViewProduit {}
}
