CREATE TABLE Authentication(
    login varchar(50) not null,
    password varchar(50)  not null,
    role varchar(8) not null,
    id_user int primary key GENERATED BY DEFAULT AS IDENTITY
    CHECK (role = 'tutor' or role = 'student')
);

create table Tutor(
    id_tutor int references Authentication(id_user) on delete cascade on update cascade primary key,
    fname varchar(50)  not null,
    mobile varchar(12)  not null,
    city varchar(50)  not null,
    experience int null,
    workPlace varchar(50) null
);

create table student(
    id_student int references Authentication(id_user) on delete cascade on update cascade primary key,
    fName varchar(50) not null,
    yearsOld int not null,
    city varchar(50) not null,
    mobile varchar(12)  not null
);

create table Advertisement(
    id_Advertisement int primary key GENERATED BY DEFAULT AS IDENTITY,
    tutor_id_tutor int references Tutor(id_tutor) on delete cascade on update cascade,
    price int null,
    duration time not null,
    subject varchar(50) not null
);

create table Lesson(
    idLesson int GENERATED BY DEFAULT AS IDENTITY,
    id_Advertisement int references Advertisement(id_Advertisement) on delete cascade on update cascade,
    id_Student int references student(id_student) on delete cascade on update cascade,
    accept varchar(3),
    startLesson timestamp,
    endLesson timestamp,
    MarkLesson int,
    Comment varchar(1000)
    CHECK (accept = 'yes' or accept = 'no')
)

