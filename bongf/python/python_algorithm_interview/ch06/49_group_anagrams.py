from collections import defaultdict
def groupAnagrams(strs):
    dic = defaultdict(list)
    for str in strs:
        tmp = "".join(sorted(list(str)))
        print(tmp)
        dic[tmp].append(str)
    ans = []
    for key in dic.keys():
        ans.append(dic[key])
    return ans

print(groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
