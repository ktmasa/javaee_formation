package umlAppForm;
/**
 * 
 * @startuml
 * 
 * left to right direction
 * actor "porteur carte" as pc
 * actor "client banque" as cb
 * pc <|-- cb
 * 
 * rectangle DAB {
 * 
 * 	pc -- (retirer argent)
 *  cb -- (consulter solde)
 * 	(retirer argent) -- (authentifier)
 *   
 * }
 * (authentifier) -- VISA
 * @enduml
 * 
 * @startuml
 *  mot : dans un mot
 *  pasmot : pas dans un mot
 *  [*] --> pasmot : debut lecture
 *  mot --> pasmot : caractere non alpha
 *  pasmot --> mot : caractere alpha
 *  mot --> mot : caractere alpha
 *  pasmot --> pasmot : caractere non alpha
 *  mot --> [*]
 *  pasmot --> [*]
 *  
 *  
 * @enduml
 * 
 * @startuml
 * 
 */


public class Categorie {

}
