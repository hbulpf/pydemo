def work(time,m):
    tmp=[0 for _ in range(m)]
    if len(time)<=m:
        return max(time)
    else:
        time.sort(reverse=True)
        tmp[0:m]=time[0:m]
        for t in time[m:]:
            min_=tmp.index(min(tmp))
            tmp[min_]+=t
    return max(tmp)
