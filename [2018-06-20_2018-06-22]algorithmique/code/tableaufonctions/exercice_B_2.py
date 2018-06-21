def prixHT(prixTTC, taux=0.2):
    return prixTTC / (1 + taux)

prixTTC = float(input("entrez un prix ttc a convertir: "))
print("prix HT (tva 20%) = ", prixHT(prixTTC))
print("prix HT (tva 5%) = ", prixHT(prixTTC, taux=0.05))
