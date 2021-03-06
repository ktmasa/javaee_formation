def calendrier(mois, annee):
    enTete(mois, annee)
    corps(mois, annee)

def enTete(mois, annee):
    chaine = "-----------------------------"
    print(chaine)
    #bonus, centrer le texte
    texte = getNomMois(mois) + " " + str(annee)
    print(" " * ((len(chaine) - len(texte)) // 2), texte)
    print(chaine)
    print(" LUN MAR MER JEU VEN SAM DIM")

def corps(mois, annee):
    #print(estBissextile(annee))
    #print(nbJoursMois(mois, annee))
    #print(jourDebutMois(mois, annee))

    nbjours = nbJoursMois(mois, annee)
    jourdebut = jourDebutMois(mois, annee)
    # retrait initial
    for retrait in range(0, jourdebut):
        print("    ", end="")

    for j in range(0, nbjours):
        espace = "  "
        if j < 9:
            espace += " "
        print(espace, j+1, sep="", end="")
        if (j + jourdebut) % 7 == 6:
            print("") # retour a la ligne

    


def getNomMois(mois):
    noms = ["janvier", "fevrier", "mars", "avril", "mai", "juin",
            "juillet", "aout", "septembre", "octobre", "novembre", "decembre"]
    if (mois < 1 or mois > 12):
        return "inconnu"
    return noms[mois - 1]

# True si bissextile
# tous les 4 ans, sauf les siecles, mais quand même tous les 400 ans
def estBissextile(annee):
    return annee % 4 == 0 and annee % 100 != 0 or annee % 400 == 0

# renvoyer le nombre de jours du mois
def nbJoursMois(mois, annee):
    if mois in [1, 3, 5, 7, 8, 10, 12]:
        return 31
    if mois in [4, 6, 9, 11]:
        return 30
    if mois == 2:
        if estBissextile(annee):
            return 29
        else:
            return 28
    return 0

def jourDebutMois(mois, annee):
    # demarrage au 1er janvier 1800
    compteur_jour = 2  # c'est un mecredi
    #compter les jours jusqu'a la date qui nous intéresse
    # et renvoyer une valeur entre 0 (lundi) et 6 (dimanche)
    for a in range(1800, annee):
        if estBissextile(a):
            compteur_jour += 366
        else:
            compteur_jour += 365
    # 1er janvier de l'annee qui nous intéresse
    #on compte les mois restants
    for m in range(1, mois):
        compteur_jour += nbJoursMois(m, annee)
    #on est sur le bon jour
    return compteur_jour % 7




annee = int(input("annee (apres 1800): "))
mois = int(input("mois de 1 à 12: "))
calendrier(mois, annee)