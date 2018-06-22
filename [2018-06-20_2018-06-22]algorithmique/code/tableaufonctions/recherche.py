def cherche_lineaire(elem, tab):
    pas = 0
    for i in range(0, len(tab)):
        pas += 1
        if (tab[i] == elem):
            return (i, pas)
    return (-1, pas)

def cherche_dichotomie(elem, tab):
    


tab = [1, 5, 8, 2, -3, 4, 25, 6]

print(tab)
print(cherche_lineaire(-3, tab))
print(cherche_lineaire(5, tab))
print(cherche_lineaire(12, tab))

#tri du tableau
tab.sort()
print(tab)

