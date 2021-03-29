"use strict";

const modalTextParagraph = document.getElementById("modalText");

// Get the button that opens the modal
const btn = document.getElementById("myBtn");

// Get the modal
const modal = document.getElementById("myModal");

const modalContent = document.getElementById("modalContent");

// Get the <span> element that closes the modal
const span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks on the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

const bindPopup = () => {
    const element = document.getElementById("status");

    const originalString = element.innerText.substr(5);

    if (originalString != 0) {
        // modalContent.style.backgroundColor = "lightgreen";

        if (originalString == "Invalid format") {
            modalContent.style.backgroundColor = "lightpink";
        }
        modalTextParagraph.innerText = originalString;
        modal.style.display = "block";
    }
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

window.onload = bindPopup;

