import { home, displayItemByUserInput, displayAllItems, displayBinItems, showAddItemForm } from './render.js';

// Create routing for pages
const routes = [
    { path: '/', page: home },
    { path: '/item-description', page: displayItemByUserInput }, 
    { path: '/wastehub', page: displayAllItems },
    { path: '/brown-bin', page: () => displayBinItems(2) },
    { path: '/green-bin', page: () => displayBinItems(3) },
    { path: '/blue-bin', page: () => displayBinItems(1) },
    { path: '/yellow-bin', page: () => displayBinItems(5) },
    { path: '/red-bin', page: () => displayBinItems(4) }, 
    { path: '/add-item', page: showAddItemForm },
]

// Function to find route and render a page
export function renderPage(path) {
    // Find the correct route given the path
    const route = routes.find(r => r.path === path);

    if (route) {
        route.page();
    } else {
        home();
    }
}
