# credit to Deon 

class SillyKey:
    def __init__(self, input_char, output_char):
        self.input = input_char
        self.output = output_char

def find_silly_key(input_str, output_str, quiet_c, start):
    input_i = start
    output_i = start

    while input_i < len(input_str):
        if input_str[input_i] == quiet_c:
            input_i += 1
            continue

        if input_str[input_i] != output_str[output_i]:
            return SillyKey(input_str[input_i], output_str[output_i])

        input_i += 1
        output_i += 1

    raise RuntimeError("unexpected input 2")

def main():
    input_str = input()
    output_str = input()

    if len(input_str) == len(output_str):
        # no quiet key
        for i in range(len(input_str)):
            if input_str[i] != output_str[i]:
                print(f"{input_str[i]} {output_str[i]}")
                print('-')
                return

        raise RuntimeError("unexpected input - they match")

    # find index of unmatch
    index_of_unmatch = None
    for i in range(len(output_str)):
        if input_str[i] != output_str[i]:
            index_of_unmatch = i
            break

    if index_of_unmatch is None:
        raise RuntimeError("unexpected input - no mismatch found")

    modified_c = input_str[index_of_unmatch]

    next_unmodified_c = None
    for i in range(index_of_unmatch + 1, len(input_str)):
        if input_str[i] != modified_c:
            next_unmodified_c = input_str[i]
            break

    if next_unmodified_c is None:
        raise RuntimeError("unexpected input 1")

    
    # fooooarrb
    # fxxxxab

    if next_unmodified_c == output_str[index_of_unmatch]:
        # modified_c is the quiet key
        silly = find_silly_key(input_str, output_str, modified_c, index_of_unmatch)
        print(f"{silly.input} {silly.output}")
        print(modified_c)
        return

    # modified_c is the silly key
    silly_key_change = output_str[index_of_unmatch]
    silent_key = input_str[-1]

    for i in range(index_of_unmatch + 1, len(output_str)): 
        if input_str[i] == output_str[i]:
            continue

        if input_str[i] == modified_c:
            continue

        silent_key = input_str[i]
        break

    print(f"{modified_c} {silly_key_change}")
    print(silent_key)

if __name__ == "__main__":
    main()
