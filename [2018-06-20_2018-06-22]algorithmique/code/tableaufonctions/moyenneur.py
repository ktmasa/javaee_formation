
def saisie_note(message="note? ", noteMin=0, noteMax=20):
    while True:
        note = float(input(message))
        if note >= noteMin and note <= noteMax:
            return note
        print("note incorrecte, min=", noteMin, " et max=", noteMax)

def statistiques_notes(notes):
    minNote, maxNote, total = 10000 , -10000, 0.0
    for note in notes:
        total += note
        if note < minNote:
            minNote = note
        if note > maxNote:
            maxNote = note
    # on renvoie (moyenne, min, max)
    return ( total / len(notes), minNote, maxNote)

nbNotes = int(input("combien de notes? "))

notes = []  #tableau de notes vide au debut
for i in range(0, nbNotes):
    notes.append(saisie_note())

moyenne, minNote, maxNote = statistiques_notes(notes)
print("moyenne=", moyenne)
print("min=", minNote)
print("max=", maxNote)
