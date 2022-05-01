def reorderLogFiles(logs):
    letter_logs = []
    digit_logs = []

    for log in logs:
        if log.split()[1].isdigit():
            digit_logs.append(log)
        else:
            letter_logs.append(log) 

    letter_logs.sort(key=lambda x: (x.split()[1:], x.split()[0]))
    
    return letter_logs + digit_logs



print(reorderLogFiles(["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]))



