def texteStatistiques(texte):
    voyelles = "aeiouy"
    separateur = " .,;?:!\n"
    totalVoyelle = 0
    compteurVoyelles = dict(a=0, e=0, i=0, o=0, u=0, y=0)
    dansMot = False
    compteurMots = 0
    for c in texte:
        #comptage de mots
        if c in separateur:
            dansMot = False
        else:
            if not dansMot:
                compteurMots += 1
            dansMot = True
        #comptage de voyelles
        if c in voyelles:
            totalVoyelle += 1
            compteurVoyelles[c] += 1
    
    return (compteurVoyelles["a"] / totalVoyelle * 100.0,
            compteurVoyelles["e"] / totalVoyelle * 100.0,
            compteurVoyelles["i"] / totalVoyelle * 100.0,
            compteurVoyelles["o"] / totalVoyelle * 100.0,
            compteurVoyelles["u"] / totalVoyelle * 100.0,
            compteurVoyelles["y"] / totalVoyelle * 100.0,
            compteurMots)

texte = """
    La maison qu'il habitait se composait, nous l'avons dit, 
    d'un rez-de-chaussée et d'un seul étage : trois pièces au
    rez-de-chaussée, trois chambres au premier, au-dessus un
    grenier. Derrière la maison un jardin d'un quart d'arpent.
    Les deux femmes occupaient le premier. L'évêque logeait en bas.
    La première pièce, qui s'ouvrait sur la rue, lui servait de salle
    à manger, la deuxième de chambre à coucher, la troisième d'oratoire.
    On ne pouvait sortir de cet oratoire sans passer par la chambre
    à coucher, ni sortir de la chambre à coucher sans passer par la
    salle à manger. Dans l'oratoire, au fond, il y avait une alcôve
    fermée avec un lit pour les cas d'hospitalité. M. l'évêque offrait
    ce lit aux curés de campagne que des affaires ou les besoins de leur paroisse amenaient à Digne.
La pharmacie de l'hôpital, petit bâtiment ajouté à la maison et pris sur le jardin, avait été transformée en cuisine et en cellier.
Il y avait en outre dans le jardin une étable qui était l'ancienne cuisine de l'hospice et où l'évêque entretenait deux vaches. Quelle que fût la quantité de lait qu'elles lui donnassent, il en envoyait invariablement tous les matins la moitié aux malades de l'hôpital. Je paye ma dîme, disait-il.
"""
ca, ce, ci, co, cu, cy, nbMots = texteStatistiques(texte)
print(" % de a : ", ca)
print(" % de e : ", ce)
print(" % de i : ", ci)
print(" % de o : ", co)
print(" % de u : ", cu)
print(" % de y : ", cy)
print(" nombre de mots : ", nbMots)
