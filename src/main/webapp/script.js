function showVslDetails() {
    const btn = document.querySelector('#btn');
// handle click button
    btn.onclick = function () {
        const rbs = document.querySelectorAll('input[name="choice"]');
        let selectedValue;
        for (const rb of rbs) {
            if (rb.checked) {
                selectedValue = rb.value;
                break;
            }
        }
        alert(selectedValue);
        //         gameDetailsParagraph.textContent = `Opis gry: ${game.description}`;
    }
}

// function createDetailsButton() {
//     let detailsButton = createButton("Pokaż szczegóły");
//     detailsButton.onclick = () => {
//         let rowIndex = detailsButton.parentNode.parentNode.rowIndex - 1;
//         let game = games[rowIndex];
//         let gameDetailsParagraph = document.getElementById("game-details");
//         gameDetailsParagraph.textContent = `Opis gry: ${game.description}`;
//     };
//     return detailsButton;
// }