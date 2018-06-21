def compteImpaire(nombres):
    compteur = 0
    for nb in nombres:
        if (nb%2 != 0):   # un nombre est impaire si le reste la division par 2 n'est pas 0
            compteur += 1
    return compteur

print("nb impaires pour [1,3,4,5,2,9]:", compteImpaire([1,3,4,5,2,9]))
print("nb impaires pour [2,4,6,3,0,1]:", compteImpaire([2,4,6,3,0,1]))


