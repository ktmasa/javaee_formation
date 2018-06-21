d1 = dict(pomme=45, poire=75, prune=16)
print(d1)
print(type(d1))
print(d1["poire"])
print("prune presente? ", "prune" in d1)
print("banane presente? ", "banane" in d1)
# on peut remplacer une des valeurs
d1["poire"]=55
print(d1)
#on peut également en ajouter une
d1["fraise"]=88
print(d1)
