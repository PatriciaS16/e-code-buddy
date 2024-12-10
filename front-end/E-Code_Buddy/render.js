import { createCard, appendErrorMessage, createFormField, createTextElement, createItemTextElement } from './utils.js';

const container = document.getElementById('container'); 

const API_BASE_URL = 'http://localhost:8080/ecodebuddy/api/code'; 

// Flag to ensure buttons only appear during the first interaction
let firstInteractionOccurred = false;

// Home function to load the main page
export function home() {

    container.innerHTML = "";

    // Logo Container
    const logoContainer = document.createElement("div");
    logoContainer.className = "logo-container";

    const logo = document.createElement("img");
    logo.src = "assets/cod-e-logo.png";
    logo.alt = "E-Code Buddy Logo";
    logo.className = "logo";
    logoContainer.appendChild(logo); 

    // Cod-e Container
    const codeContainer = document.createElement("div");
    codeContainer.className = "code-container";

    // Cod-e Text Container
    const codeTextContainer = document.createElement("div");
    codeTextContainer.className = "code-text-container"; 

    // Fetch dynamic welcome speech from backend
    fetch(`${API_BASE_URL}/speech/1`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => { 
            const welcomeText = document.createElement("h4");
            welcomeText.innerHTML = data.text;
            codeTextContainer.appendChild(welcomeText);
        })
        .catch(error => {
            console.error('Error fetching speech:', error);
            const errorText = document.createElement("h4");
            errorText.innerHTML = "Something went wrong. Please try again later.";
            codeTextContainer.appendChild(errorText);
        });

    codeContainer.appendChild(codeTextContainer);

    // Cod-e Robot Container
    const robotContainer = document.createElement("div");
    robotContainer.className = "robot-container";

    const robotImg = document.createElement("img");
    robotImg.src = "assets/cod-e.png";
    robotImg.alt = "Cod-E Robot";
    robotImg.className = "robot";
    robotContainer.appendChild(robotImg);
    codeContainer.appendChild(robotContainer);

    // Search Bar Container
    const searchContainer = document.createElement("div");
    searchContainer.className = "search-container";

    const searchInput = document.createElement("input");
    searchInput.type = "text";
    searchInput.className = "search-input";
    searchInput.placeholder = "Item search";
    searchContainer.appendChild(searchInput);

    const searchButton = document.createElement("button");
    searchButton.className = "search-button";

    const searchIcon = document.createElement("img");
    searchIcon.src = "assets/magnifying-glass.png";
    searchIcon.alt = "Search";
    searchIcon.className = "magnifying-glass";
    searchButton.appendChild(searchIcon);
    searchContainer.appendChild(searchButton);

    // Add event listener for click
    searchButton.addEventListener("click", () => {
        const value = searchInput.value.trim();
        if (value) { 
            // Reset the first interaction flag 
            firstInteractionOccurred = false;
            updateCodeTextContainer(value);
        }
    });

    // Add event listener for enter
    searchInput.addEventListener("keypress", (e) => {
        if (e.key === "Enter") {
            const value = searchInput.value.trim();
            if (value) { 
                // Reset the first interaction flag 
                firstInteractionOccurred = false;
                updateCodeTextContainer(value);
            }
        }
    });

    // Dynamic Container
    const dynamicContainer = document.createElement("div");
    dynamicContainer.className = "dynamic-container"; 

    // Dynamic Content
    const dynamicContent = document.createElement("div");
    dynamicContent.className = "dynamic-content"; 

    // Create image
    const worldImg = document.createElement("img");
    worldImg.src = "assets/world.png"; 
    worldImg.alt = "World Image"; 
    worldImg.className = "world-img";
    dynamicContent.appendChild(worldImg);

    // Add text
    const worldText = document.createElement("h4");
    worldText.innerHTML = "Recycling one aluminum can saves enough energy to run a TV for three hours!";
    dynamicContent.appendChild(worldText);

    // Append dynamic content
    dynamicContainer.appendChild(dynamicContent);    

    // Cards container for bins
    const binsCardsContainer = document.createElement("div");
    binsCardsContainer.className = "bins-cards-container";

    // First row of cards
    const firstRow = document.createElement("div");
    firstRow.className = "bins-card-row";

    // Waste Hub
    const wasteHubCard = createCard("WASTE HUB", "assets/waste-hub.png"); 
    wasteHubCard.addEventListener("click", function() {
        // Change the URL
        history.pushState(null, "", "/wastehub");
        // Call function to display the content for waste hub
        displayAllItems();
    });
    firstRow.appendChild(wasteHubCard);

    // Brown Bin
    const brownBinCard = createCard("BROWN BIN", "assets/brown-bin.png"); 
    brownBinCard.addEventListener("click", function() {
        history.pushState(null, "", "/brown-bin");
        displayBinItems(2)
    });
    firstRow.appendChild(brownBinCard);

    // Green Bin
    const greenBinCard = createCard("GREEN BIN", "assets/green-bin.png"); 
    greenBinCard.addEventListener("click", function() {
        history.pushState(null, "", "/green-bin");
        displayBinItems(3)
    });
    firstRow.appendChild(greenBinCard);

    // Second row of cards
    const secondRow = document.createElement("div");
    secondRow.className = "bins-card-row";

    // Blue bin
    const blueBinCard = createCard("BLUE BIN", "assets/blue-bin.png"); 
    blueBinCard.addEventListener("click",  function() {
        history.pushState(null, "", "/blue-bin");
        displayBinItems(1)
    });
    secondRow.appendChild(blueBinCard);

    // Yellow bin
    const yellowBinCard = createCard("YELLOW BIN", "assets/yellow-bin.png"); 
    yellowBinCard.addEventListener("click",  function() {
        history.pushState(null, "", "/yellow-bin");
        displayBinItems(5)
    });
    secondRow.appendChild(yellowBinCard); 

    // Red bin
    const redBinCard = createCard("RED BIN", "assets/red-bin.png"); 
    redBinCard.addEventListener("click",  function() {
        history.pushState(null, "", "/red-bin");
        displayBinItems(4)
    });
    secondRow.appendChild(redBinCard); 

    // Add rows to card container
    binsCardsContainer.appendChild(firstRow);
    binsCardsContainer.appendChild(secondRow); 

    // Create Creators Container
    const creatorsContainer = document.createElement("div");
    creatorsContainer.className = "creators-container"; 

    // Add Creators Title
    const creatorsTitle = document.createElement("h5");
    creatorsTitle.innerHTML = "Creators:";
    creatorsContainer.appendChild(creatorsTitle); 

    // Add Creators Text 
    const creatorsText = document.createElement("h5");
    creatorsText.innerHTML = "Jorge Coelho | Patrícia Soares | Pedro Ximenes | Sara Gonçalves"; 
    creatorsContainer.appendChild(creatorsText);

    // Append everything to the container
    container.appendChild(logoContainer);
    container.appendChild(codeContainer);
    container.appendChild(searchContainer);
    container.appendChild(dynamicContainer);
    container.appendChild(binsCardsContainer); 
    container.appendChild(creatorsContainer);
}

// Function to update cod-e text container based on user input
export function updateCodeTextContainer(query) {
    const codeTextContainer = document.querySelector(".code-text-container");

    // Clear existing content in text container
    codeTextContainer.innerHTML = "";

    // Fetch the wastehubdata to check for the item across bins
    fetch(`${API_BASE_URL}/bin/wastehubdata`)
        .then((response) => response.json())
        .then((data) => {
            // Create an empty array to hold all items across all bins
            const allItems = [];
            
            // Loop through each bin in the data
            data.forEach(bin => {
                // Add all items (individually) from this bin to the array.
                allItems.push(...bin.items); 
            });

            // Search for the item based on the query
            const item = allItems.find(item => item.name.toLowerCase() === query.toLowerCase());

            if (!item) {
                // Item not found in bins, fetch "unknown item" speech
                return fetch(`${API_BASE_URL}/speech/2`); 
            }

            // Item found in bins, fetch "known item" speech
            return fetch(`${API_BASE_URL}/speech/3`); 
        })
        .then((response) => response.json())
        .then((data) => {
            const newText = document.createElement("h4"); 
            // Speech text from the API
            newText.innerHTML = data.text;

            // Append the speech text to the container
            codeTextContainer.appendChild(newText);

            // Check for first interaction
            if (!firstInteractionOccurred) {
                // If known item, show "Yes" to see details, "No" to home
                if (data.text.includes("details")) {
                    renderFirstInteractionButtons(codeTextContainer, query, "known");
                }
                // If unknown item, show "Yes" to add item, "No" to home
                else if (data.text.includes("sorry")) {
                    renderFirstInteractionButtons(codeTextContainer, query, "unknown");
                }
                firstInteractionOccurred = true;
            }
        })
        .catch((error) => {
            console.error("Error fetching item or speech:", error);
            const errorMessage = document.createElement("p");
            errorMessage.innerHTML = "Could not fetch the item or speech. Please try again.";
            errorMessage.className = "dynamic-text";
            codeTextContainer.appendChild(errorMessage);
        });
}

// Render the buttons for first interaction based on known or unknown item
function renderFirstInteractionButtons(parentElement, query, itemType) {
    const yesButton = document.createElement("button");
    yesButton.className = "dialogue-option-buttons";
    yesButton.innerText = "Yes!";

    const noButton = document.createElement("button");
    noButton.className = "dialogue-option-buttons";
    noButton.innerText = "No..";

    // Append buttons
    parentElement.appendChild(yesButton);
    parentElement.appendChild(noButton);

    // Handle "Yes" button based on item type (known or unknown)
    yesButton.addEventListener("click", () => {
        firstInteractionOccurred = false;
        if (itemType === "known") {
            // Show item details for known item
            const newPath = "/item-description";
            window.history.pushState({}, "", newPath);
            displayItemByUserInput(query);
        } else if (itemType === "unknown") {
            // Show a form to add the item for unknown item
            const newPath = "/add-item";
            window.history.pushState({}, "", newPath);
            showAddItemForm(query);
        }
    });

    // Handle "No" button, go back to home
    noButton.addEventListener("click", () => {
        firstInteractionOccurred = false;
        home();
    });
}
