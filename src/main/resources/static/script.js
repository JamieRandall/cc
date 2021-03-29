"use strict";



const onPageLoad = () => {
    const element = document.getElementById("status");

    if (element.innerText === 'no status') {

    } else {
        alert(element.innerText);
    }
};

window.onload = onPageLoad;
