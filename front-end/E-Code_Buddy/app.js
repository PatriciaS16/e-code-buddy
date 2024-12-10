import { renderPage } from "./routes.js";

// Set up event listener for navigation anchors
document.querySelectorAll('button').forEach(anchor => {
    anchor.addEventListener('click', function(event) {
        event.preventDefault(); // Prevents browser from triggering GET request

        // Get the path from the anchor
        const path = event.target.getAttribute('href');

        // Change URL using pushState
        window.history.pushState({}, '', path);

        renderPage(path);
    });
});

// Handle browser back and forward buttons
window.addEventListener('popstate', () => {
    renderPage(document.location.pathname)
}
);

// Handle inital load
renderPage(document.location.pathname);