# demander a l'utilisateur une temperature en celsius
# verifier qu'elle est valide sinon l'indiquer
# convertir en farenheit et afficher

temperature = float(input("quelle temperature C°"))
if temperature < -273.15 or temperature > 10000:
    print("temperature invalide")
else:
    farheneit = (temperature * 1.8) + 32.0
    print("en farheneit: ", farheneit)

