

def sum(num):
    if num:
    # Recursive function call
        return num + sum(num-1)
    else:
        return 0
 
# Call calculateSum() function
res = sum(10)
 
# Print result
print(res)