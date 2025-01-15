silly = ""
wrong =  ""
quiet = "-"
typed = input()
display = input()
missing = []

# find modified keys
for i in range(len(typed)):
    x = display.find(typed[i])
    if x == -1:
        missing.append(i)


for item in missing:
    if item < len(display):
        # see if original neighbouring key took its spot, key indicator of quiet key
        # if it didn't it would be a silly key
        if typed[item + 1] == display[item]:
            quiet = typed[item]
            missing.remove(item)
            silly = typed[missing[0]]
    else:
        quiet = typed[item]

# find modified silly (wrong key)
for char in display:
    if typed.find(char) == -1:
        wrong = char

print(silly + " " + wrong)
print(quiet)


