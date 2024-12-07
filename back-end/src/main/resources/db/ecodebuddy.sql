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
VALUES ( 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Hello! I''m Cod-E! \n Do you want to learn more about recycling?\n You can insert an item in the search bar'),
       (1,1, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Howdy! My name is Cod-E! \n I''m here to teach you about recycling. \n You can insert an item in the search bar below');

INSERT INTO public.bins (code_id, version, creationtime, updatetime, dtype, color, description)
VALUES (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'BLUE_BIN', 'Blue Bin (Paper)', 'Blue bin for papers and other stuffs'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'BROWN_BIN', 'Brown Bin (Organic Waste)', 'Brown container for organic waste items'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'GREEN_BIN', 'Green Bin (Glass)', 'Green container for glass items only.'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'RED_BIN', 'Red Bin (Batteries And Hazardous Waste)', 'Red container for batteries and hazardous waste.'),
       (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'YELLOW_BIN', 'Yellow Bin (Plastic and Cans)', 'Yellow container for plastic and cans.');

INSERT INTO public.items ( version, creationtime, updatetime, name, environmentalimpact, reuseandrecycling, bin_id)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cardboard Box', 'Decomposes in 2 months. Produces low pollution when processed correctly.', 'Recyclable into new cardboard products or reused for packaging.', 1);
