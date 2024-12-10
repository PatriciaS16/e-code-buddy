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

// Function to handle form submission
async function handleFormSubmit(form) {
    try {
        // Create a FormData object from the submitted form
        const formData = new FormData(form);

        // Get the waste category entered by the user
        const wasteCategory = formData.get("wasteCategory");
        if (!wasteCategory) {
            alert("Please specify the waste category (e.g., Blue Bin).");
            return;
        }

        // Extract the first word of the waste category (the bin color)
        const binColor = wasteCategory.split(" ")[0].trim().toLowerCase();
        
        // Fetch all the bins from the backend
        const binsResponse = await fetch(`${API_BASE_URL}/bin/wastehubdata`);
        if (!binsResponse.ok) {
            throw new Error("Failed to fetch bins.");
        }

        // Parse the JSON response containing the bins
        const bins = await binsResponse.json();

        // Find a matching bin based on the color from the waste category
        const matchingBin = bins.find(bin => bin.color.toLowerCase().includes(binColor)); 
        if (!matchingBin) {
            alert(`No bin found for the color "${binColor}". Please check your input.`);
            return;
        }

        // Create the new item object with the data from the form
        const newItem = {
            name: formData.get("name"),
            environmentalImpact: formData.get("environmentalImpact"),
            reuseAndRecycling: formData.get("reuseAndRecycling"),
        };

        // Send a POST request to add the item to the correct bin
        const addItemResponse = await fetch(`${API_BASE_URL}/bin/${matchingBin.id}/add`, {
            method: "POST",
            body: JSON.stringify(newItem),
            headers: { "Content-Type": "application/json" },
        });

        // Check if the item was added successfully
        if (!addItemResponse.ok) {
            const errorData = await addItemResponse.json();
            throw new Error(errorData.message || "Failed to add item.");
        }

        alert("Item added successfully!"); 
        home();
    } catch (error) {
        console.error("Error adding item:", error); 
        alert(`Error: ${error.message}`);
    }
}

// Function to show the form for adding an unknown item
export function showAddItemForm(itemName = "") {
    const dynamicContainer = document.querySelector(".dynamic-container");
    const dynamicContent = document.querySelector(".dynamic-content");
    dynamicContent.innerHTML = ""; 

    // Create the form element to hold all the fields
    const form = document.createElement("form");
    form.className = "add-item-form";
    
    // Create and append the form title
    const formTitle = document.createElement("h4");
    formTitle.textContent = "Add a new item";
    form.appendChild(formTitle);

    // Create an array of form fields (using the helper function)
    const fields = [
        createFormField({ type: "text", labelText: "Name:", inputId: "itemName", inputName: "name", placeholder: "e.g., Water Bottle", value: itemName }),
        createFormField({ type: "text", labelText: "Waste Category:", inputId: "wasteCategory", inputName: "wasteCategory", placeholder: "e.g., Yellow Bin" }),
        createFormField({ type: "text", labelText: "Environmental Impact:", inputId: "environmentalImpact", inputName: "environmentalImpact", placeholder: "e.g., Takes 450 years to decompose." }),
        createFormField({ type: "text", labelText: "Reuse & Recycling:", inputId: "reuseAndRecycling", inputName: "reuseAndRecycling", placeholder: "e.g., Recyclable into new bottles." }),
    ];

    // Append each form field (label and input) to the form
    fields.forEach(field => {
        form.appendChild(field.label);
        form.appendChild(field.input);
    });

    // Create and append the submit button
    const submitButton = document.createElement("button");
    submitButton.type = "submit"; 
    submitButton.textContent = "Add Item"; 
    form.appendChild(submitButton);

    // Add an event listener to handle form submission
    form.addEventListener("submit", (e) => {
        e.preventDefault(); 
        handleFormSubmit(form); 
    });

    dynamicContent.appendChild(form);
    dynamicContainer.appendChild(dynamicContent);
}

// Function to display an item details based on user input
export function displayItemByUserInput(itemName) {
    const dynamicContainer = document.querySelector(".dynamic-container");
    const dynamicContent = document.querySelector(".dynamic-content");
    dynamicContent.innerHTML = "";

    // Fetch all bins and items from the backend
    fetch(`${API_BASE_URL}/bin/wastehubdata`)
        .then((response) => {
            if (!response.ok) {
                throw new Error("Failed to fetch bins and items");
            }
            return response.json();
        })
        .then((bins) => { 
            // Initialize variables to store the matched item and bin category
            let matchedItem = null;
            let binCategory = "Unknown"; 

            // Iterate through all bins
            for (const bin of bins) { 
                // Search an item in the current bin that matches the provided itemName (and store it)
                matchedItem = bin.items.find(item => item.name.toLowerCase() === itemName.toLowerCase());
                if (matchedItem) { 
                    // Store the bin color if the item is found
                    binCategory = bin.color; 
                    // Stop searching after finding the item
                    break;
                }
            }

            if (!matchedItem) {
                throw new Error(`Item "${itemName}" not found`);
            }

            // Dynamically create and append item details
            dynamicContent.appendChild(createTextElement("Name", matchedItem.name));
            dynamicContent.appendChild(createTextElement("Waste Category", binCategory));
            dynamicContent.appendChild(createTextElement("Environmental Impact", matchedItem.environmentalImpact));
            dynamicContent.appendChild(createTextElement("Reuse & Recycling", matchedItem.reuseAndRecycling));

            dynamicContainer.appendChild(dynamicContent);
        })
        .catch((error) => {
            console.error("Error fetching item or bin details:", error);
            appendErrorMessage(dynamicContent, `Could not find details for "${itemName}". Please try again.`);
            dynamicContainer.appendChild(dynamicContent);
        });
}

// Function to display all items from all bins (waste hub)
export function displayAllItems() {
    const dynamicContainer = document.querySelector(".dynamic-container");
    const dynamicContent = document.querySelector(".dynamic-content");
    dynamicContent.innerHTML = ""; 

    // Waste Hub Title Div
    const wasteHubTitleDiv = document.createElement("div");
    wasteHubTitleDiv.className = "waste-hub-title-div";

    // Waste Hub Image
    const wasteHubImg = document.createElement("img");
    wasteHubImg.src = "assets/waste-hub.png"; 
    wasteHubImg.className = "waste-hub-img";
    wasteHubTitleDiv.appendChild(wasteHubImg); 

    // Waste Hub Text
    const wasteHubText = document.createElement("h4");
    wasteHubText.innerHTML = "WASTE HUB (WASTE COLLECTION POINT)"; 
    wasteHubText.className = "waste-hub-text";
    wasteHubTitleDiv.appendChild(wasteHubText); 

    // Append the waste hub title div
    dynamicContent.appendChild(wasteHubTitleDiv); 

    // Fetch all bins from the backend (including items in each bin)
    fetch(`${API_BASE_URL}/bin/wastehubdata`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch bins");
            }
            return response.json();
        })
        .then(bins => {
            // Array to hold all items, each with a 'binCategory' (color of the bin)
            const allItems = [];
            // Iterate through each bin and its items
            bins.forEach(bin => {
                bin.items.forEach(item => {
                    // Add item to the array with binCategory (bin color)
                    allItems.push({
                        ...item,
                        binCategory: bin.color
                    });
                });
            });

            // Create a card for each item
            allItems.forEach(item => {
                const itemCard = document.createElement("div");
                itemCard.className = "item-card";

                itemCard.appendChild(createItemTextElement("Name", item.name));
                itemCard.appendChild(createItemTextElement("Waste Category", item.binCategory));
                itemCard.appendChild(createItemTextElement("Environmental Impact", item.environmentalImpact));
                itemCard.appendChild(createItemTextElement("Reuse & Recycling", item.reuseAndRecycling));

                dynamicContent.appendChild(itemCard);
            });
        })
        .catch(error => {
            console.error("Error fetching bins or items:", error);
            appendErrorMessage(dynamicContent, "Could not load bins or items. Please try again."); 
        });

    dynamicContainer.appendChild(dynamicContent);
} 

// Function to display items for a specific bin
export function displayBinItems(binId) {
    const dynamicContainer = document.querySelector(".dynamic-container");
    const dynamicContent = document.querySelector(".dynamic-content");
    dynamicContent.innerHTML = ""; 

    // Bin Title Div
    const binTitleDiv = document.createElement("div");
    binTitleDiv.className = "bin-title-div";

    // Fetch bin details from the backend
    fetch(`${API_BASE_URL}/bin/${binId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch bin details");
            }
            return response.json();
        })
        .then(bin => { 
            // Extract color name from bin.color 
            const binColor = bin.color.split(' ')[0];

            // Update the bin title div with bin-specific information 

            // Bin Image
            const binImg = document.createElement("img");
            binImg.src = `assets/${binColor.toLowerCase()}-bin.png`;
            binImg.className = "bin-img";
            binTitleDiv.appendChild(binImg); 

            // Bin Text
            const binText = document.createElement("h4");
            binText.innerHTML = `${bin.color.toUpperCase()}`; 
            binText.className = "bin-text";
            binTitleDiv.appendChild(binText);

            // Append the bin title div
            dynamicContent.appendChild(binTitleDiv);

            // Fetch and display the items for this bin
            return fetch(`${API_BASE_URL}/bin/${binId}/items`);
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch bin items");
            }
            return response.json();
        })
        .then(items => {
            if (items.length === 0) { 
                appendErrorMessage(dynamicContent, "This bin currently has no items.");
            } else {
                items.forEach(item => {
                    const itemCard = document.createElement("div");
                    itemCard.className = "item-card";

                    itemCard.appendChild(createItemTextElement("Name", item.name));
                    itemCard.appendChild(createItemTextElement("Environmental Impact", item.environmentalImpact));
                    itemCard.appendChild(createItemTextElement("Reuse & Recycling", item.reuseAndRecycling));

                    // Create the delete button
                    const deleteDiv = document.createElement("div");
                    deleteDiv.className = "delete-div";

                    const deleteButton = document.createElement("button");
                    deleteButton.className = "delete-item-button";
                    deleteButton.innerHTML = "Delete"; 
                    deleteDiv.appendChild(deleteButton);

                    // Add an event listener for the delete functionality
                    deleteButton.addEventListener("click", () => {
                        // Ask the user for confirmation
                        const userConfirmed = confirm(`Are you sure you want to delete the item "${item.name}"?`);
                        if (userConfirmed) {
                            // Call the delete endpoint using fetch
                            fetch(`${API_BASE_URL}/bin/${binId}/item/${item.id}`, {
                                method: "DELETE",
                            })
                            .then(response => {
                                if (response.ok) {
                                    // On success, remove the item
                                    itemCard.remove();
                                } else {
                                    alert("Failed to delete item. Try again later.");
                                }
                            })
                            .catch(error => {
                                console.error("Error deleting item:", error);
                                alert("An error occurred while deleting the item.");
                            });
                        }
                    });

                    itemCard.appendChild(deleteDiv);
                    dynamicContent.appendChild(itemCard);
                });
            }
        })
        .catch(error => {
            console.error("Error fetching bin or item details:", error);
            appendErrorMessage(dynamicContent, "Could not load bin or items. Please try again."); 
        });

    dynamicContainer.appendChild(dynamicContent);
} 
