list1 = [4,7,3,7,9,6,5]
list2 = [9,3,4,8,6,2,0]

# Combined list1 and list2
list3 = list1+list2

# Print combined list
print(list3)

# create empty list
list4 =[]

# Check if elements in the list gives modulous as 0.
for x in list3:
    if x%2 ==0:
        list4.append(x)

# Print list4 which is a list of even numbers.
print (list4)