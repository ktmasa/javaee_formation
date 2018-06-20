
max = int(input("limite superieure "))
# il faut, si on veut inclure potenitellement le max dans
# le resultat, faire max + 1 car range exclus sa borne supérieure

#astuce, avancer de 2 en 2 directement
for i in range(0, max + 1, 2):
    print(i)

print("-----------------------")
# sinon, on teste si le reste de la division par 2 est 0
for i in range(0, max + 1):
    if i % 2 == 0:
        print(i)


