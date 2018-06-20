# une boucle permet de repeter l'execution d'un bloc de code
# tant qu'une condition est vrai ou un certains nombre de fois

compteur = 0
while compteur < 10:
    print(compteur) # affiche le compteur
    compteur += 1   # augemente le compteur de 1 
print("fini")

#r1 = range(2, 10)
#print(r1)
print("------------------------------")
# boucler sur toutes les valeurs entre 2 et 10(exclus),
#  par pas de 3
for i in range(2, 10, 3):
    print(i)

nbRepetition = int(input("nombre de repetition ? "))
for i in range(0, nbRepetition):
    print(i)

# on parcours chaque element de la liste un par un
jours = ["lundi", "mardi", "mercredi", "jeudi", "vendredi"]
for jour in jours:
    print(jour)

print("--------------------------------")
for j in range(0, len(jours)):
    print(jours[j])

#print(j)



