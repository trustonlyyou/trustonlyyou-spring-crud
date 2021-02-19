
-- board list
select
    bno as num, title, regdate, viewCnt, userId
from
    freeboard
where
    bno > 0
order by
    regdate desc
limit
    #{pageStart}, #{perPageNum}

-- 총 데이터의 갯수
select
    count(bno)
from
    freeboard
where
    bno > 0

-- num 의 최대 값 :: 다음 글  보여 줄 때 사용
select
    max(bno) as num
from
    freeboard

-- detailPage data
select
    title, regdate, content, viewCnt, userId
from
    freeboard
where
    bno > 0
and
    bno = #{numCalc}

-- write
insert into freeboard
    (title, content, userId)
values
    (#{title}, #{content}, #{userId});

-- view up
update
    freeboard
set
    viewCnt = viewCnt + 1
where
    bno = #{index}