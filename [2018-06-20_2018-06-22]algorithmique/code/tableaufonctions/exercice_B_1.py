
def max_A(v1, v2, v3):
    if v1 > v2 and v1 > v3:
        return v1
    if v2 > v1 and v2 > v3:
        return v2
    return v3

#variante un peu plus efficace, moins de comparaison a faire
def max_B(v1, v2, v3):
    if v1 > v2:
        if v1 > v3:
            return v1
        return v3
    else:
        if v2 > v3:
            return v2
        return v3


val1 = float(input("valeur 1: "))
val2 = float(input("valeur 2: "))
val3 = float(input("valeur 3: "))

print("max = ", max_A(val1, val2, val3))
print("max = ", max_B(val1, val2, val3))