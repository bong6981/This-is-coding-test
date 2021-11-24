def practice():
    s1 = set([1, 2, 3, 4, 5, 6])
    s2 = set([4, 5, 6, 7, 8, 9])

    gyo = set(s1) & set(s2)
    gyo2 = set(s1).intersection(s2)
    hap = set(s1) | set(s2)
    cha = set(s1) - set(s2)

    print(gyo) ## {4, 5, 6}
    print(gyo2) ## {4, 5, 6}
    print(hap) ## {1, 2, 3, 4, 5, 6, 7, 8, 9}
    print(cha) ## {1, 2, 3}

practice()
