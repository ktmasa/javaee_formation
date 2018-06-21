def dureePlacement(somme_initiale, taux, somme_finale):
    if somme_initiale > somme_finale:
        return 0
    if taux <= 0:
        return 0

    annees = 0
    while somme_finale > somme_initiale:
        annees = annees + 1
        somme_initiale = somme_initiale * (1 + taux /100.0)
    return annees

somme_initiale = float(input("somme initiale ? "))
objectif = float(input("somme a atteindre ? "))
taux = float(input("taux en % ? "))

print("duree = ", dureePlacement(somme_initiale, taux, objectif))
