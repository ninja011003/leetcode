a =[1,2,3,4,5]
b =[6,7,8,9,10]


for i in range(len(a)):
    a[i]=a[i]+b[i]
    b[i]=a[i]-b[i]
    a[i]=a[i]-b[i]

print(f"a:{a}")
print(f"b:{b}")