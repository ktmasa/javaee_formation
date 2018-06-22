import random

def cherche_lineaire(elem, tab):
    pas = 0
    for i in range(0, len(tab)):
        pas += 1
        if (tab[i] == elem):
            return (i, pas)
    return (-1, pas)

def cherche_dichotomie(elem, tab):
    pas = 0
    if len(tab) == 0:
        return -1
    debut = 0
    fin = len(tab) - 1
    while debut <= fin:
        millieu = ((fin - debut) // 2) + debut
        pas += 1
        if tab[millieu] == elem:
            return (millieu, pas)
        if tab[millieu] < elem:
            debut = millieu + 1
        else:
            fin = millieu - 1
    return (-1, pas)


tab = [1, 5, 8, 2, -3, 4, 25, 6]

print(tab)
print(cherche_lineaire(-3, tab))
print(cherche_lineaire(5, tab))
print(cherche_lineaire(12, tab))

#tri du tableau
print("--------------------------------------")
tab.sort()
print(tab)
print(cherche_dichotomie(-3, tab))
print(cherche_dichotomie(5, tab))
print(cherche_dichotomie(12, tab))

tab = []
for i in range(1, 1000):
    tab.append(random.randrange(1,2000))

#print(tab)
print("---------------------------------")
print(cherche_lineaire(-3, tab))
print(cherche_lineaire(1250, tab))
print(cherche_lineaire(4200, tab))

tab.sort()
print("---------------------------------")
print(cherche_dichotomie(-3, tab))
print(cherche_dichotomie(1250, tab))
print(cherche_dichotomie(4200, tab))


