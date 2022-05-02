from collections import Counter
import re
def mostCommonWord(paragraph, banned: list) -> str:
    paragraph = paragraph.lower().replace(", ", " ").replace(",", " ")
    paragraph = re.sub("[^a-zA-Z0-9\s]",'', paragraph)
    counter = Counter(paragraph.split(' '))
    for c in counter.most_common():
        if c[0] not in banned:
            return c[0]
    

# mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"])
# mostCommonWord("Bob!, the hit BALL flew far after it was hit.", ["hit"])
mostCommonWord("a, a, a, a, b,b,b,c, c", ["a"])
