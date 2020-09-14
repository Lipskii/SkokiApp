select * from type_of_hill
ALTER TABLE result ADD fkski_jumper INT FOREIGN KEY REFERENCES ski_jumper(idski_jumper)

select * from result

CREATE TABLE race_director (
idrace_director int identity(1,1) PRIMARY KEY NOT NULL,
fkperson int foreign key references person(idperson) not null
)

alter table eventcom ADD fkrace_director INT FOREIGN KEY REFERENCES race_director(idrace_director)

























