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
