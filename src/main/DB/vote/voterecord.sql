create table vote.voterecord
(
    voter      char(30) null,
    voteNumber int      null,
    constraint voterecord_ibfk_1
        foreign key (voteNumber) references vote.voteitem (voteNumber)
);

create index voteNumber
    on vote.voterecord (voteNumber);

