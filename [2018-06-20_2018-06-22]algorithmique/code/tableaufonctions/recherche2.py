#
# [2, 10, 5, 15, 3, 4, 9, 1]
#
# [15, 16, 20, 8, 3, 4, 7]
#
# [15, 3, 4]
#
# ecrire petit programme
# quelle est la complexité ??

import random

def instersection(tabA, tabB):
    #retourne le tableau des valeurs communes a tabA et tabB
    pas = 0
    tabresult = []
    for elemA in tabA:
        for elemB in tabB:
            pas += 1
            if (elemA == elemB):
                tabresult.append(elemA)
                break
    return (pas, tabresult)

def instersection_trie(tabA, tabB):
    posA = 0
    posB = 0
    tabresult = []
    pas = 0
    while posA < len(tabA) and posB < len(tabB):
        pas += 1
        if tabA[posA] == tabB[posB]:
            tabresult.append(tabA[posA])
            posA +=1
            posB +=1
        elif tabA[posA] > tabB[posB]:
            posB += 1
        else:
            posA += 1
    return (pas, tabresult)


tab1 = [2, 10, 5, 15, 3, 4, 9, 1]
tab2 = [15, 16, 20, 8, 3, 4, 7]

print(instersection(tab1, tab2))

print("-----------------------------------------")
tab1 = []
tab2 = []
for i in range(1, 1000):
    tab1.append(random.randrange(1,5000))
    tab2.append(random.randrange(1,5000))

print(instersection(tab1, tab2))

tab1.sort()
tab2.sort()
print("-----------------------------------------")
print(instersection_trie(tab1, tab2))


