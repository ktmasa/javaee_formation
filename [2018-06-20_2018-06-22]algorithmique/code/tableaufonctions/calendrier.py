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
    print(estBissextile(annee))
    print(nbJoursMois(mois, annee))

def getNomMois(mois):
    noms = ["janvier", "fevrier", "mars", "avril", "mai", "juin",
            "juillet", "aout", "septembre", "octobre", "novembre", "decembre"]
    if (mois < 1 or mois > 12):
        return "inconnu"
    return noms[mois - 1]

# True si bissextile
# tous les 4 ans, sauf les siecles, mais quand même tous les 400 ans
def estBissextile(annee):
    return False
    
# renvoyer le nombre de jours du mois
def nbJoursMois(mois, annee):
    return 0

def jourDebutMois(mois, annee):
    pass


annee = int(input("annee (apres 1800): "))
mois = int(input("mois de 1 à 12: "))
calendrier(mois, annee)