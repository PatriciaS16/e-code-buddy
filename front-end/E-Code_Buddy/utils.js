// Helper function to create individual cards for bins
export function createCard(title, iconSrc) {
    const cardButton = document.createElement("button");
    cardButton.className = "card-button";

    const icon = document.createElement("img");
    icon.src = iconSrc;
    icon.alt = title;
    icon.className = "card-icon";

    const cardTitle = document.createElement("p");
    cardTitle.className = "card-title";
    cardTitle.innerHTML = title;

    cardButton.appendChild(icon);
    cardButton.appendChild(cardTitle);

    return cardButton;
} 

// Helper function to append error messages to the dynamic content
export function appendErrorMessage(dynamicContent, message) {
    const errorMessage = document.createElement("p");
    errorMessage.innerHTML = message;
    errorMessage.className = "dynamic-text";
    dynamicContent.appendChild(errorMessage);
}

// Helper function to create input fields with labels
export function createFormField({ type, labelText, inputId, inputName, placeholder, value = "" }) { 
    const label = document.createElement("label");
    label.setAttribute("for", inputId); 
    label.textContent = labelText; 

    const input = document.createElement("input");
    input.type = type; 
    input.id = inputId; 
    input.name = inputName; 
    input.placeholder = placeholder; 
    input.value = value; 

    return { label, input };
} 

// Helper function (dynamic-text) to create a paragraph with a label and value
export function createTextElement(label, value) {
    const paragraph = document.createElement("p");
    paragraph.innerHTML = `<strong>${label}:</strong> ${value}`;
    paragraph.className = "dynamic-text";
    return paragraph;
} 

// Helper function (item-dynamic-text) to create a paragraph with a label and value
export function createItemTextElement(label, value) {
    const paragraph = document.createElement("p");
    paragraph.innerHTML = `<strong>${label}:</strong> ${value}`;
    paragraph.className = "item-dynamic-text";
    return paragraph;
} 
