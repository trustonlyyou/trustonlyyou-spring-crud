create table membership_table (
    userName char(20) not null,
    userId varchar(30) not null primary key,
    userPassword varchar(100) not null,
    userBirth char(10) not null,
    userPhone char(20) not null,
    userEmail varchar(50) not null,
    userPostcode varchar(30) not null,
    userAddress varchar(50) not null,
    userDetailAddress varchar(50) null,
    userExtraAddress varchar(50) null,
    regdate timestamp default CURRENT_TIMESTAMP
);

-- insert test query
insert into membership_table
(userName, userId, userPassword, userBirth, userPhone, userEmail, userPostcode, userAddress, userDetailAddress, userExtraAddress)
values
(
	'오정환', 'trustonlyyou', '1234', '1995-10-24', '01068300772', 'zkem123456@naver.com', '141-081', '경서로7가길 26-12', '101호', '고척동'
);