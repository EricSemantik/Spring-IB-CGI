package spring.formation.model;

public interface Views {
	public interface ViewBase {}
	
	public interface ViewCommentaire extends ViewBase {}
	
	public interface ViewProduit extends ViewBase {}
	
	public interface ViewProduitDetail extends ViewProduit {}
	
	public interface ViewPersonne extends ViewBase {}
	
	public interface ViewClient extends ViewPersonne {}
	
	public interface ViewFournisseur extends ViewPersonne {}
	
	public interface ViewUtilisateur extends ViewBase {}
}
