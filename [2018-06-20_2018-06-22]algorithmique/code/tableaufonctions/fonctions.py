
#declaration d'une fonction
def bonjour(nom):
    print("bonjour", nom)

# cette fonction renvoie une valeur, ici le carre du parametre
def carre(nombre):
    # print(saisie)   ca marche, car saisie est une variable globale
    return nombre * nombre

def salutation(nom, civilite="Mme"):
    chaine = "bonjour "+ civilite + " " + nom
    return chaine
# une fonction recursive
# elle se rapelle elle-meme
# fact(5) 5 * fact(4) -> 4 * fact(3) ... fact(1) -> 1
def factorielle(n):
    if n <= 1:
        return 1
    else:
        return n * factorielle(n - 1)

print(factorielle(5))

saisie = input("votre nom ? ")
bonjour(saisie)  # nous appelons la fonction definie au dessus
#chaine = "haha, pawned"
print(carre(6))
print(salutation(saisie, "mr"))
#print(chaine)  ca plante, car chaine n'existe que dans la fonction
#print(chaine)
print(salutation(saisie))
# possibilite de passer les arguments dans le desordre en les nommants
print(salutation(civilite="mr", nom=saisie))

