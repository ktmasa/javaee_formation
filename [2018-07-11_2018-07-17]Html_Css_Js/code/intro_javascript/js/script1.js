console.log("bonjour, javascript");
// declaration d'une variable
var i = 10;
console.log('i = ' + i);
console.log('type i = ' + typeof(i));
// number -> nombre
i = "vincent";
console.log('i = ' + i);
console.log('type i = ' + typeof(i));
// string -> chaine de caracteres
var b = true;
console.log("b = " + b);
console.log("type b = " + typeof(b));
// boolean -> true/false
var v1 = 12;
var v2 = "12";
if (v1 == v2) {
    console.log("v1 == v2 est vrai");
}
else {
    console.log("v1 == v2 est faux");
}
console.log(v1 + v2);
console.log(v1 + Number(v2));
var tab1 = ["lundi", "mardi", "mercredi"];
console.log("longueur tab1 = " + tab1.length);
console.log("tab1[2] = " + tab1[2]);
tab1.push("jeudi");
console.log(tab1);
console.log(typeof(tab1));

tab1[1] = null;
console.log(tab1);
delete tab1[1];
console.log(tab1);

var v3 = undefined;
console.log(v3);
console.log(typeof(v3));

var obj1 = {
    prenom : "vincent",
    nom : "courtalon",
    poste: "formateur"
};
console.log(obj1);
console.log(obj1.nom);
console.log(obj1["nom"]);
obj1.age = 41;
console.log(obj1);

for (var prop in obj1) {
    console.log(prop + " -> " + obj1[prop]);
}

var tab2 = ["pion",
             "cavalier",
             "fou",
             "tour",
             "reine",
              "roi"];
for (var idx in tab2) {
    console.log(idx + " -> " + tab2[idx]);
}
