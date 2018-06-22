def calendrier(mois, annee):
    enTete(mois, annee)
    corps(mois, annee)

def enTete(mois, annee):
    print("-----------------------------")
    #bonus, centrer le texte
    print("      ", getNomMois(mois), str(annee))
    print("-----------------------------")
    print(" LUN MAR MER JEU VEN SAM DIM")

def corps(mois, annee):
    pass

def getNomMois(mois):
    return ""

def estBissextile(annee):
    pass

def nbJoursMois(mois, annee):
    pass

def jourDebutMois(mois, annee):
    pass


annee = int(input("annee (apres 1800): "))
mois = int(input("mois de 1 à 12: "))
calendrier(mois, annee)