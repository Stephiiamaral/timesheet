
insert into message(message) value ("Date and time in invalid format"); -- 400
insert into message(message) value ("Required field not informed"); -- 400
insert into message(message) value ("Saturday and Sunday are not allowed as a working day"); -- 403
insert into message(message) value ("Time already registered"); -- 409
insert into message(message) value ("You cannot allocate time greater than the time worked in the day"); -- 400
insert into message(message) value ("Report not found"); -- 404