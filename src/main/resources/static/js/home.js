// seleziono l'elemento paragrafo

var titleText = document.getElementById("book-title-best-sellers");

// definisco la funzione che sottolinea il testo
function underlineText(event) {
    event.preventDefault();

    titleText.style.textDecoration = "underline";
}

// definisco la funzione che rimuove la sottolineatura
function removeUnderline(event) {
    event.preventDefault();
    titleText.style.textDecoration = "none";
}


var titleText1 = document.getElementsByClassName("title-best-sellers");

function underlineText1(element, event) {
  event.preventDefault();
  element.style.textDecoration = "underline";
}

function removeUnderline1(element, event) {
  event.preventDefault();
  element.style.textDecoration = "none";
}

for (var i = 0; i < titleText1.length; i++) {
  var element = titleText1[i];
  // aggiungi qui il codice per aggiungere gli event listener a element
  // usando le funzioni underlineText1 e removeUnderline1
  element.addEventListener("mouseover", function(event) {
    underlineText1(this, event);
  });
  element.addEventListener("mouseout", function(event) {
    removeUnderline1(this, event);
  });
}





