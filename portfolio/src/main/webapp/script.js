async function showRandomFact() {
    const responseFromServer = await fetch('/random-fact');
    const facts = await responseFromServer.json();

    const randomNumber = Math.floor(Math.random() * 3);
    let selectedFact = "";

    if (randomNumber == 0) {
        selectedFact = facts[0];
    }else if (randomNumber == 1) {
        selectedFact = facts[1];
    }else{
        selectedFact = facts[2];
    }
    const dateContainer = document.getElementById('fact-container');
    dateContainer.innerText = selectedFact;
}

async function showCommunications() {
    const responseFromServer = await fetch('/view-communications');
    const communications = await responseFromServer.json();

    const communicationsListElement = document.getElementById('communications-container');
    communicationsListElement.innerHTML = '';
    
    for (let i=0; i < communications.length; i++) {
        communicationsListElement.appendChild(createBoldElement("Message " + (i+1)));
        communicationsListElement.appendChild(createListElement('Name: ' + communications[i].name));
        communicationsListElement.appendChild(createListElement('Email: ' + communications[i].email));
        communicationsListElement.appendChild(createListElement('Reason: ' + communications[i].reason));
        communicationsListElement.appendChild(createListElement('Message: ' + communications[i].message));
    }
    
}


function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
}

function createBoldElement(text) {
    const bElement = document.createElement('b');
    bElement.innerText = text;
    return bElement;
}
