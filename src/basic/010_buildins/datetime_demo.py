# -*- coding: utf-8-*-
from datetime import datetime, timedelta, timezone, tzinfo 

# 获取当前datetime
now = datetime.now() 
print(now)
print(type(now))


# 用指定日期时间创建datetime
dt = datetime(2015, 4, 19, 12, 20) 
print(dt)

# datetime转换为时间戳
print(dt.timestamp())
# 北京时间
print(datetime.fromtimestamp(1429417200.0))
# UTC 时间
print(datetime.utcfromtimestamp(1429417200.0))


# str转换为datetime
ct = datetime.strptime('2020-1-2 14:20:34','%Y-%m-%d %H:%M:%S')
print(ct)
# datetime转换为str
ct_str = ct.strftime('%Y, %m %d %H:%M')
print(ct_str)

# datetime加减
print(f'now:{now}')
print(f'add 10h: {now + timedelta(hours=10)}')
print(f'add 1d: {now + timedelta(days=1)}')

# 本地时间转换为UTC时间
# 创建时区UTC+8:00
tz_utc_8 = timezone(timedelta(hours=+8))
now = datetime(2018, 4, 19, 12, 20) 
print(f'now:{now}')
# 强制设置为UTC+8:00
dt = now.replace(tzinfo=tz_utc_8)
print(f'new dt:{dt}')


# 时区转换
utc_now = datetime.utcnow().replace(tzinfo=timezone.utc)
print(f'utc_now:{utc_now}')
# astimezone()将转换时区为北京时间
bj_now = utc_now.astimezone(timezone(timedelta(hours=8)))
print(f'bj_now:{bj_now}')
# 东京时间
tokyo_dt = utc_now.astimezone(timezone(timedelta(hours=9)))
print(f'tokyo_dt:{tokyo_dt}')
# astimezone()将bj_dt转换时区为东京时间:
tokyo_dt = bj_now.astimezone(timezone(timedelta(hours=9)))
print(f'tokyo_dt:{tokyo_dt}')
