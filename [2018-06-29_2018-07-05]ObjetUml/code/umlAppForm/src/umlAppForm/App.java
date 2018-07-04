package umlAppForm;

/**
 * 
 * @author Stagiaire
 *
 * @startuml
 * actor Client
 * database Catalogue
 *  
 * -> Client : connection
 * activate Client
 * Client -> Catalogue : selectProduit
 * deactivate Client
 * activate Catalogue
 * Catalogue -> Client : produit
 * deactivate Catalogue
 * 
 * activate Client
 * Create Panier
 * note right
 * 	le panier est crée
 *  au premier produit
 * end note
 * Client -> Panier : <<create>> addProduit
 * deactivate Client
 * activate Panier #FFBBBB
 * Panier -> Client : total
 * deactivate Panier
 * 
 * activate Client
 * loop chaque produit
 * Client -> Catalogue : selectProduit
 * activate Catalogue
 * Catalogue -> Client : produit
 * deactivate Catalogue
 * 
 * Client -> Panier : addProduit
 * deactivate Client
 * activate Panier #FFBBBB
 * Panier -> Panier : calcultotal
 * activate Panier #BBFFBB
 * deactivate Panier
 * Panier -> Client : total
 * deactivate Panier
 * end  
 * activate Client
 * create Commande
 * Client -> Commande : <<create>> creer
 * deactivate Client
 * activate Commande
 * Commande -> Commande : valider
 * activate Commande
 * deactivate Commande
 * Commande -> Client : commandeOk
 * deactivate Commande
 * activate Client
 * Client -> Panier : <<destroy>>
 * destroy Panier
 * deactivate Client
 * @enduml
 * 
 * @startuml
 */

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
