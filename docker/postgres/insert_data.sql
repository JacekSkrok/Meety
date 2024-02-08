INSERT INTO time_slots (time_slot_id,time_slot_date,start_time,end_time,is_keynote_time_slot)
VALUES (1,'2024-01-01','9:00','9:45',TRUE),
       (2,'2024-02-06','10:00','11:00',FALSE),
       (3,'2024-03-02','11:15','11:45',FALSE),
       (4,'2024-04-23','12:45','13:45',FALSE),
       (5,'2024-05-25','14:00','15:00',FALSE),
       (6,'2024-06-13','15:15','15:45',FALSE),
       (7,'2024-07-10','16:00','17:00',FALSE),
       (8,'2024-08-18','9:00','10:00',FALSE),
       (9,'2024-09-30','10:15','11:15',FALSE),
       (10,'2024-10-13','11:30','12:00',FALSE),
       (11,'2024-11-12','13:00','14:00',FALSE),
       (12,'2024-12-31','14:15','15:00',TRUE);

INSERT INTO appointments (appointment_id,appointment_name,appointment_length,appointment_description)
VALUES (1, 'The Golden Age of Software', 45, 'The evolution of software development has ushered in a golden era characterized by unprecedented innovation and accessibility, transforming industries and daily life alike.'),
       (2, 'How Sleep Impacts Your Training Limits', 60, 'Adequate sleep is paramount for optimizing athletic performance as it facilitates muscle repair, cognitive function, and hormone regulation, ultimately defining the extent of ones training capabilities.'),
       (3, 'How to Go Out with Friends', 60, 'Nurturing social connections is essential for well-being, and going out with friends provides an avenue for shared experiences, laughter, and support, enriching lifes tapestry.'),
       (4, 'Do We Need Facebook?', 60, 'Facebooks pervasive influence prompts critical reflections on its societal impact, raising questions about privacy, misinformation, and digital well-being, prompting discussions on its necessity in the modern age.'),
       (5, 'Impact of Vitamins on Our Eyes', 60, 'Vitamins play a crucial role in maintaining eye health, influencing functions like vision clarity, protection against age-related degeneration, and overall ocular well-being.'),
       (6, 'Is Rococo Still Hot?', 60, 'The Rococo style, known for its ornate and whimsical aesthetic, continues to captivate admirers with its playful elegance and enduring influence in art, architecture, and design.'),
       (7, 'Be Like Gordon Ramsey', 60, 'Emulating the culinary prowess and fiery passion of Gordon Ramsay involves dedication to craft, attention to detail, and a willingness to push boundaries, inspiring excellence in the kitchen.'),
       (8, 'Art-Deco', 30, 'Art Deco, characterized by its geometric shapes, bold colors, and lavish ornamentation, epitomizes the glamour and modernity of the early 20th century, leaving an indelible mark on architecture, fashion, and the decorative arts.'),
       (9, 'Beautiful Towns of the Middle East', 30, 'The Middle East boasts a rich tapestry of stunning towns and cities, each offering a unique blend of history, culture, and architectural splendor, inviting exploration and appreciation.'),
       (10, 'Basic Sketching', 30, 'Mastering basic sketching techniques lays the foundation for artistic expression, honing skills in observation, composition, and rendering, unlocking creative potential and visual communication.'),
       (11, 'USA for Free', 30, 'Exploring the USA on a budget unveils a wealth of opportunities for cost-conscious travelers, from national parks and scenic byways to free cultural attractions and local festivals, offering unforgettable experiences without breaking the bank.'),
       (12, 'Like a Dog with Cat', 60, 'Navigating relationships with contrasting personalities, akin to a dog and cat, requires patience, understanding, and acceptance of differences, fostering harmony and mutual respect.');

INSERT INTO appointment_schedule (schedule_id,time_slot_id,appointment_id,room)
VALUES (1,1,1,'Orange room'),
       (2,2,2,'Blue room'),
       (3,3,3,'Pink room'),
       (4,4,4,'Indigo room'),
       (5,5,5,'Cyan room'),
       (6,6,6,'Magenta room'),
       (7,7,7,'Khaki room'),
       (8,8,8,'Silver room'),
       (9,9,9,'Beige room'),
       (10,10,10,'Azure room'),
       (11,11,11,'Black room'),
       (12,12,12,'Teal room');

INSERT INTO tags (tag_id,description)
VALUES (1,'Programming'),
       (2,'Sport'),
       (3,'Social live'),
       (4,'Social media'),
       (5,'Medicine'),
       (6,'Design'),
       (7,'Cooking'),
       (8,'Painting'),
       (9,'Architecture'),
       (10,'Drawing'),
       (11,'Travels'),
       (12,'Animals');

INSERT INTO hosts (host_id,first_name,last_name,title,company,host_bio,host_photo)
VALUES (1,'Sergio','Becker','Senior Developer','MicroOcean Software','Test', null),
       (2,'James','Lowrey','Solutions Architect','Fabrikam Industries','Test', null),
       (3,'Gloria','Franklin','Enerprise Architect','Carved Rock Online','Test', null),
       (4,'Lori','Vanhoose','Java Technical Lead','National Bank','Test', null),
       (5,'Raymond','Hall','Senior Developer','City Power and Electric','Test', null),
       (6,'Sam','Vasquez','Software Analyst','Globalmantics Consulting','Test', null),
       (7,'Justin','Clark','Principal Engineer','Tangerine Hippopotamus Consulting','Test', null),
       (8,'Barbara','Williams','Senior DBA','Contoso','Test', null),
       (9,'James','Sharp','Technical Lead','Adventureworks','Test', null),
       (10,'Julie','Rowe','Software Architect','Northwind Trading','Test', null),
       (11,'Tonya','Burke','Senior Cloud Consultant','Big Data Consulting','Test', null),
       (12,'Nicole','Perry','Pets behaviourist','World Wide Animals','Test', null);

INSERT INTO appointment_hosts (appointment_id,host_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (4,4),
       (5,5),
       (6,6),
       (7,7),
       (8,8),
       (9,9),
       (10,10),
       (11,11),
       (12,12);