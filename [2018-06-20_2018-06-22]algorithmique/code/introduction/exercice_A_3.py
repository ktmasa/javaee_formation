# saisie
taille = int(input("taille figure? "))

# pour chaque ligne
for ligne in range(0, taille):
    ligne_courante = ""
    # pour chaque colonne, ou caractere de la ligne courante
    for colonne in range(0, taille - ligne):
        # si bord superieur ou gauche ou droit
        if ligne == 0 or colonne == 0 or colonne == taille - ligne - 1:
            ligne_courante = ligne_courante + "*" # bord
        else:
            ligne_courante = ligne_courante + "-" # sinon centre
    print(ligne_courante)

