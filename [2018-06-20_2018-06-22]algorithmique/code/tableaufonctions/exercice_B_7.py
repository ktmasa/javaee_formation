# symboles contiendra les chiffre utilisé par exemple ['I', 'V', 'X']
def getChiffreIndividuel(nombre, symboles):
    if nombre == 0:
        return ""
    if nombre < 4:
        return symboles[0] * nombre
    if nombre == 4:
        return symboles[0] + symboles[1]
    if nombre == 5:
        return symboles[1]
    if nombre < 9:
        return symboles[1] + (symboles[0] * (nombre - 5))
    if nombre == 9:
        return symboles[0] + symboles[2]

def getNombreRomain(nombre):
    unite = nombre % 10
    dizaine = (nombre // 10) % 10
    centaine =  (nombre // 100) % 10
    str = getChiffreIndividuel(centaine, ['C', 'D', 'M'])
    str += getChiffreIndividuel(dizaine, ['X', 'L', 'C'])
    str += getChiffreIndividuel(unite, ['I', 'V', 'X'])
    return str

nbr = int(input("chiffre a traduire "))
print(getNombreRomain(nbr))


