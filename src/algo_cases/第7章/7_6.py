def activity(time):
    re=[]
    time.sort(key=lambda x:x[1])
    re.append(time[0])
    for t in time[1:]:
        if t[0]>=re[-1][1]:
            re.append(t)
    return re,len(re)
