
tab1 = ["poire", "pomme", "fraise"]

print(tab1)
print(type(tab1)) # -> list

# tableau commence a l'index 0
print(tab1[0])
print(tab1[2])
#print(tab1[5])
print("---------------")
for fruit in tab1:
    print(fruit)
# connaitre la longueur du tableau
print(len(tab1))
tab1[1] = "banane"
print(tab1)
# ajouter un element a la fin
tab1.append("ananas")
print(tab1)

# ajouter un element a une position choisie
tab1.insert(1, "prune")
print(tab1)
print( "banane" in tab1)
print( "pomme" in tab1)

tab1.extend(["mirtylle", "kiwi", "melon"])
print(tab1)

tab2 = tab1[2:5] #extraire un sous tableau de la position 2 a 5 exclus
print(tab2)

del tab1[2] # efface la deuxieme case du tableau
print(tab1)

print(tab1.index("kiwi")) # position d'un element dans le tableau

str = "bonjour monde"
print(str[2])
print(str[2:8])











