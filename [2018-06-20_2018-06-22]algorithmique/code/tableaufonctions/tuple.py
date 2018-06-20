
l1 = ("3543435435", 45.5, 500, "python forever")
print(l1)
print(type(l1))
# on peut extraire les champs
isbn, prix, nbpages, titre = l1

print(isbn)
print(titre)
# _ permet d'ignorer un des champs du tuple
_, prix, _, _ = l1
print(prix)

tab1 = []
# un tuple est manipulable comme tous les autres types
tab1.append(l1)
print(tab1)



