"use strict";



const onPageLoad = () => {
    const element = document.getElementById("status");

    console.log(element.innerText);
    // alert(element.innerText < 'status' + element.innerText == false);
    // alert(element.innerText);
    const originalString = element.innerText;

    if (originalString != 0) {
        // const comp1 = element.innerText == 'no status';
        // const comp2 = element.innerText === 'no status';
        alert(element.innerText);
    }
};

window.onload = onPageLoad;

