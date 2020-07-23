use supersightingsdb;

insert into powers (powerName, powerDescription) values
	('Super Strength', 'Allows the user to greatly increase their strength and agility'),
    ('Erasure', 'Allows the user to erase other supers powers by looking them in the eye'),
    ('Heal', 'Allows the user to greatly speed up a supers healing process through contact'),
    
    ('Explosion', 'Allows the user to excrete nitroglycerin like sweat from thier palms and ignite it at will to create an explosion'),
    ('Half-Cold Half-Hot', 'Allows the user to generate ice from the right side of their body and flames from the left side of their body'),
    ('Hardening', 'Allows the user to harden their body like rock to protect the user or to use to attack'),
    
    ('Permeation', 'Allows the user to phase any part of thier body through physical matter'),
    ('Manifest', 'Allows the user to enhance their limbs with super powered versions of anything they consume'),
    ('Stamina Wave', 'Allows the user to steal stamina from any super as well as give their own stamina to any super through wave-like blasts'),
    
    ('Decay', 'Allows the user to decay anything they touch almost immediately'),
    ('Copy', 'Allows the user to copy and use the power of another super by touching them for up to 10 minutes'),
    ('Double', 'Allows the user to create a near perfect double of anything including other supers but only at 50% durability'),
    
    ('Overhaul', 'Allows the user to disassemble and reassemble matter with their bare hands'),
    ('Chronostasis', 'Allows the user to extend their hair to a sharp object which they can use to cut and temporarily slow down another super'),
    ('Strongarm', 'Allows the user to rotate and move their shoulders at extreme speed and power giving them immensely fast and strong punches');
    
insert into supers (superName, superDescription, powerId) values
	('All Might', 'The #1 hero', 1),
    ('Eraser Head', 'Expert at Hand-to-hand combat', 2),
    ('Recovery Girl', 'Support role only', 3),
    
    ('Kacchan', 'Hot headed, and does not work well with others', 4),
    ('Shoto', 'A prodigy. Can attack and defend at the same time', 5),
    ('Red Riot', 'Defensive based hero', 6),
    
    ('Lemillion', 'Expected to be the future #1 hero', 7),
    ('Suneater', 'Very strong but does not believe in his abilities', 8),
    ('Nejire', 'Bubbly personality, mainly a support role', 9),
    
    ('Tomura Shigaraki', 'Young leader of the League of Villians chosen by mentor All For One', 10),
    ('Himiko Toga', 'Can imitate any hero', 11),
    ('Twice', 'Has Muliple Personality Disorder. Has trouble controlling himself', 12),
    
    ('Overhaul', 'Dangerous young leader of the Shie Hassaikai. Not much is known about him', 13),
    ('Chrono', 'Used in a support role to capture heroes', 14),
    ('Kendo', 'Expert Martial Artist', 15);
    
insert into organizations (orgName, orgDescription, orgAddress, orgCity, orgState, orgZip, phone) values
	('Pro Heroes', 'Professional heroes contracted through the government', '123 Pro St', 'Brooklyn Park', 'MN', '55443', '651-123-4567'),
    ('Hero Academy', 'Hero high school training young heroes to become pro heroes', '456 Academy Ave', 'Minneapolis', 'MN', '55404', '612-111-1111'),
    ('The Big 3', 'Former Students of the Hero Academy. Interning to become pro heroes', '789 Plus Ultra Rd', 'Minneapolis', 'MN', '55111', '612-222-3333'),
    ('League of Villians', 'Villinous Organization created by the Strongest Villian All For One', '666 Villian Ln', 'St. Paul', 'MN', '55101', '763-999-8888'),
    ('Shie Hassaikai', 'Gang of Supervillians. Not much is known about them', '555 Dat Way', 'St. Paul', 'MN', '55146', '763-777-6666');
    
insert into organizations_supers (orgId, superId) values
	(1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (3, 7),
    (3, 8),
    (3, 9),
    (4, 10),
    (4, 11),
    (4, 12),
    (5, 13),
    (5, 14),
    (5, 15);
    
insert into locations (locName, locDescription, locAddress, locCity, locState, locZip, locLatitude, locLongitude) values
	('US Bank Stadium', 'Home of the Minnesota Vikings', '401 Chicago Ave', 'Minneapolis', 'MN', '55415', 44.973411, -93.257621),
    ('Minnehaha Park', 'Home to the Minnehaha Falls. One of the oldest and most populat parks in Minneapolis', 'Minnehaha Ave', 'Minneapolis', 'MN', '55417',  44.915001, -93.209999),
    ('Park Center Senior High', 'Public High School on the border of Brooklyn Park and Brooklyn Center, hence the name "Park Center"', '7300 Brooklyn Blvd', 'Brooklyn Park', 'MN', '55443', 45.111181, -93.350499);
    
insert into sightings (superId, locId, sightingDate) values
	(13, 1, '2020-06-20'),
    (7, 1, '2020-06-20'),
    (4, 2, '2020-06-25'),
    (5, 2, '2020-06-25'),
    (1, 3, '2020-07-04'),
    (2, 2, '2020-07-10'),
    (10, 1, '2020-07-10'),
    (12, 3, '2020-07-15'),
    (6, 3, '2020-07-15'),
    (3, 3, '2020-07-20');
