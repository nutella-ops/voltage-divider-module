#!/Users/macbook/miniconda3/bin/python3


#function to convert char into numeric equivalent, s/o to p & cheeky typecast
def abbreviate(n):
    if 'k' in n:
        n = float(n.replace('k',''))*(10**3)
    elif 'M' in n:
        n = float(n.replace('M',''))*(10**6)
    return n


#supply voltage
vcc = float(input("Vcc = "))


#resistor values and conversions to equivalent floats
r1 = input("R1 = ")
r1 = float(abbreviate(r1))

r2 = input("R2 = ")
r2 = float(abbreviate(r2))


#resistor +/- variation integer and conversion to decimal
tol = input("Tolerance = ")
plus_tol = float(tol)/100
minus_tol = float(tol)/-100


#       0    1      2         3     
vari = [r1, r2, plus_tol, minus_tol]
tol_display = ["+%", "-%"]

#initial states of list variables
r=0
t=2
txt=0


while t <= 3:                                       #start on (n %)            
    print("")                                       #create output formatting
    print("")
    print(tol_display[txt])                         #print (n %) section title
    print("---------------")

    while r <= 1:
        vdiv = vari[r]+vari[r]*vari[t]              #calculate (resistor n) with (n %) modifier
        print("R"+str(r+1)+" = "+str(vdiv))         #print above result w/ display text
        r+=1                                        #advance to next (resistor)
    print("")                                       #end of (n %) pair output formatting
   
    t+=1                                            #increment (n %) modifiter
    r=0                                             #resart (resistor n) count
    txt+=1                                          #increment (n %) display text 