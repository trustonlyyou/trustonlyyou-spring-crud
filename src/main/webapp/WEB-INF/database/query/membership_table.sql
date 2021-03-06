create table membershiptable (
    userName char(20) not null,
    userId varchar(40) not null primary key,
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

-- join
insert into membership_table
(userName, userId, userPassword, userBirth, userPhone, userEmail, userPostcode, userAddress, userDetailAddress, userExtraAddress)
values
(
	'오정환', 'trustonlyyou', '1234', '1995-10-24', '01068300772', 'zkem123456@naver.com', '141-081', '경서로7가길 26-12', '101호', '고척동'
);

-- function :: userPhoneFormat
DROP function if exists userPhoneFormat;
DELIMITER $$
create function userPhoneFormat(membershipUserId varchar(33))
	returns char(20)
begin
	return
		(select
			concat_ws("-", substring(userPhone,1,3), REPLACE(substring(userphone, 4, 4), substring(userphone, 4, 4), '****'), substring(userphone, 8, 4))
		from
			membershiptable
		where
			userId = membershipUserId); -- userPhone = char(20)
end $$
DELIMITER ;

-- function :: userAddressFormat
DROP function if exists userAddressFormat;
DELIMITER $$
create function userAddressFormat(membershipUserId varchar(30))
	returns varchar(50)
begin
	return
		(select
			replace(userAddress, substring_index(substring_index(userAddress, ' ', 3), ' ', -1), '****')
        from
			membership_table
        where
			1=1
            and
				userId = membershipUserId
        ); -- userPhone = char(20)
end $$
DELIMITER ;

-- Login
select
	userName, userId, replace(userPassword, userPassword, '****') as userPassword, userPhoneFormat(#{userId}) as userPhone, userEmail, userPostcode, userAddressFormat(#{userId}) as userAddress, userDetailAddress, userExtraAddress
from
	membershiptable
where
	1=1
        and
    userId = #{userId}
        and
    userPassword = #{userPassword}

-- Find ID
select
    userId
from
    membershiptable
where
    1=1
    and userName = #{userName}
    and userPhone = #{userPhone};


-- findPassword

select
    count(*) -- 해당 정보가 있는지 카운팅 한다.
from
    membershiptable
where
    1=1
    and userName=#{userName}
    and userId=#{userId}
    and userPhone=#{userPhone}

-- modify Password
update
    membershiptable
set
    userPassword=#{newUserPassword}
where
    userPhone=#{userPhone}