nb_notes = int(input("nombres de notes souhaitees: "))
total = 0.0   # cette variable accumulera la somme des notes
min_note = 21.0  # cette variable stockera la plus petite note rencontrée
max_note = -1.0  # idem pour la plus grande

compteur_note = 0  # combien de note on été saisie

while compteur_note < nb_notes:
    note = float(input("saisie note: "))
    if note >= 0.0 and note <= 20.0:
        total = total + note
        if note < min_note:
            min_note = note
        if note > max_note:
            max_note = note
        compteur_note += 1
    else:
        print("note invalide, doit etre entre 0 et 20")

print("moyenne = ", total / compteur_note)
print("max = ", max_note)
print("min = ", min_note)

