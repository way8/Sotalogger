INSERT INTO radio_ham (callsign) VALUES ('SP9GI');
INSERT INTO notes (ACTIVATION_NOTES) VALUES ('"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum');
INSERT INTO summit (summit_reference, summit_name, summit_points) VALUES ('Sp/BZ-039','Lubogoszcz', 6);
INSERT INTO activation (description, DATE,ACTIVATOR_CALLSIGN, summit_id, notes_id) VALUES ('aktywacja 1', '2009-11-11','SP9GI/P', 1, 1);
INSERT INTO activation (description, DATE,ACTIVATOR_CALLSIGN) VALUES ('aktywacja 2', '2009-12-01','SP9OZI/P');
UPDATE summit SET activation_id = 1 WHERE ID = 1;
UPDATE notes SET activation_id = 1 WHERE ID = 1;
