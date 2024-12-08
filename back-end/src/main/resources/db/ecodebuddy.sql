INSERT INTO public.code ( version, creationtime, updatetime, name)
VALUES ( 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cod-e');

INSERT INTO public.speeches (code_id, version, creationtime, updatetime, dtype)
VALUES (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'WELCOME'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'UNKNOWN_ITEM'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'KNOWN_ITEM'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'THANKS'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'HOMEPAGE'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SUGGESTION');

INSERT INTO public.dialogs (speech_id, version, creationtime, updatetime, text)
VALUES ( 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Hello! I''m Cod-E! Do you want to learn more about recycling? You can insert an item in the search bar'),
       (1,1, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Howdy! My name is Cod-E! I''m here to teach you about recycling. You can insert an item in the search bar below'),
       (2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'I''m sorry I don''t know the item you tried to search do you want to teach me?'),
       (2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'I''m sorry I haven''t learned anything about the item you tried to search do you want to teach me?'),
       (3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Oh, I know this one! Do you want to me to spill the details?'),
       (3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'YESS! I''ve seen this one before, do you want me to spill all the details?');

INSERT INTO public.bins (code_id, version, creationtime, updatetime, dtype, color, description)
VALUES (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'BLUE_BIN', 'Blue Bin (Paper)', 'Blue bin for papers and other stuffs'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'BROWN_BIN', 'Brown Bin (Organic Waste)', 'Brown container for organic waste items'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'GREEN_BIN', 'Green Bin (Glass)', 'Green container for glass items only.'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'RED_BIN', 'Red Bin (Batteries And Hazardous Waste)', 'Red container for batteries and hazardous waste.'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'YELLOW_BIN', 'Yellow Bin (Plastic and Cans)', 'Yellow container for plastic and cans.');

INSERT INTO public.items ( version, creationtime, updatetime, name, environmentalimpact, reuseandrecycling, bin_id)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Newspaper', 'Can release methane in landfills if it degrades without oxygen. Contributes to deforestation if not recycled.', 'Recyclable into new paper products like tissues, cardboard, and more.', 1),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cardboard Box', 'Takes about 2 months to decompose. Recycling saves trees and energy.', 'Recyclable into new cardboard or paper. Can be reused for storage or crafting.', 1),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Office Paper', 'Takes 2–6 weeks to decompose. Produces greenhouse gases in landfills', 'Recyclable into new paper or used for compost.', 1),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Paper Cup (Unwaxed)', 'Decomposes within 2 months. Recycling reduces landfill use and energy waste.', 'Recyclable if clean. Can be composted in some cases.', 1),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cereal Box', 'Takes about 2 months to decompose. Recycling saves trees and energy.', 'Recyclable and great for creative crafts or storage.', 1),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Water Bottle', 'Takes 450 years to decompose. Major source of microplastics.', 'Recyclable into new bottles, fabrics, or containers.', 5),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Aluminum Can', 'Takes 80–200 years to decompose. Produces fewer emissions when recycled.', 'Recyclable into new cans or aluminum products.', 5),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Yogurt Cup', 'Takes up to 500 years to degrade. Pollutes oceans and land.', 'Recyclable into plastic items if clean.', 5),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Food Wrapper', 'Contributes to global plastic pollution. Takes decades to degrade.', 'Can be recycled in specialized facilities.', 5),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Shampoo Bottle', 'Takes centuries to degrade. Adds to land and ocean plastic pollution.', 'Recyclable into new plastic products.', 5),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Wine Bottle', 'Lasts forever in landfills. Making new glass pollutes the air with carbon emissions.', 'Reusable for decor or storage. Fully recyclable into new glass products.', 3),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Jam Jar', 'Lasts indefinitely in landfills. Recycling reduces energy use and raw material need.', 'Wash and reuse for storage. Fully recyclable.', 3),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Beverage Bottle', 'Takes over a million years to degrade. Contributes to landfill bulk.', 'Fully recyclable into new glass containers.', 3),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Glass Plate (Unbroken)', 'Does not decompose in landfills. Requires energy-intensive recycling.', 'Reusable for various purposes. Fully recyclable.', 3),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cosmetic Jar', 'Stays in landfills indefinitely. Recycling helps save resources.', 'Reusable for DIY projects. Recyclable into new glass items.', 3),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AA Battery', 'Contains toxic heavy metals like cadmium and mercury. Pollutes soil and water.', 'Recyclable at designated facilities to recover materials.', 4),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Smartphone Battery', 'Contains lithium, which is toxic to the environment. Risk of explosion if not properly disposed of.', 'Recyclable for recovery of rare metals.', 4),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Power Bank', 'Toxic chemicals can leach into soil and water. Difficult to degrade.', 'Recyclable for electronic and metal components.', 4),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Car Battery', 'Acid and lead content can cause severe pollution. Highly hazardous waste.', 'Recyclable at specialized facilities to recover lead and other materials.', 4),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Button Cell Battery', 'Contains mercury, posing risks to wildlife and humans if improperly disposed.', 'Recyclable through e-waste programs.', 4),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Banana Peel', 'Decomposes in a few weeks but emits methane if in landfills.', 'Compostable into nutrient-rich soil.', 2),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Coffee Grounds', 'Organic waste contributes to methane emissions if landfilled.', 'Excellent for compost or garden fertilizer.', 2),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Eggshells', 'Biodegradable but wasteful if not composted.', 'Adds calcium to soil.', 2),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Food Scraps (Vegetables)', 'Decomposes quickly but creates methane in landfills.', 'Compostable into organic fertilizer.', 2),
       (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Tea Bags (Unbleached)', 'Biodegradable but produces greenhouse gases in landfills.', 'Compostable. Enriches soil with organic matter.', 2);
