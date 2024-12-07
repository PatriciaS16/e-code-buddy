INSERT INTO public.code ( version, creationtime, updatetime, name)
VALUES ( 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cod-e');

INSERT INTO public.speeches (code_id, version, creationtime, updatetime, dtype)
VALUES (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'WELCOME');

INSERT INTO public.dialogs (speech_id, version, creationtime, updatetime, text)
VALUES ( 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Isto é um teste de welcome');