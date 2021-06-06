example_list = list(input("Enter comma separated fruit names: ").split(", "))
# example_list = ["apple","banana","cherry","apple"]
length = len(example_list)

if example_list[0]==example_list[length-1]:
    print("First and last items are same.")
else:
    print("First and last items are not same.")

example_list.append("orange")

length = len(example_list)
if example_list[0]==example_list[length-1]:
    print("First and last items are same.")
else:
    print("First and last items are not same.")