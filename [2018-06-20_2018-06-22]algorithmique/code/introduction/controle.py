
# demande de saisie a l'utilisateur
saisie = input("quelle heure est il ? ")
# conversion de la saisie en nombre
heure = int(saisie)

# structure conditionelle

if heure < 11:
    print("bonjour, un café?")
else:
    print("bonjour")
    print("belle journée")

print("fini")

age = int(input("quelle est votre age ?"))

# un if n'est pas forcément suivi d'un else
if age > 150:
    print("alien détécté")
    saisie = input("que mangez vous ? ") 
    # et bien sur, les if peuvent être imbriqués
    if saisie == "chat":
        print("bonjour alf")
    print("capture commencée")
print("vraiment fini")

temperature = float(input("quelle temperature ? "))
if temperature < 0.0:
    print("il fait froid")
elif temperature < 20.0:    # ce test n'est vérifié que si le premier if echoue
    print("il fait tempéré")
elif temperature <= 40.0:
    print("il fait chaud")
else:
    print("je foooonnnnd")




