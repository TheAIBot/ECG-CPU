#rawSquare @ 0..31
#arrayStartIndex @ 32
#squared @ 33
#ALLOWED_BITS @ 34
#N @ 35
#totalValue 36
#return 37

-----------------------------------------------------

arrayStartIndex++;
arrayStartIndex &= ALLOWED_BITS;
unsigned short lastSquaredValue = rawSquare[arrayStartIndex];
rawSquare[arrayStartIndex] = squared;
totalValue += squared - lastSquaredValue;
return totalValue / N;


-----------------------------------------------------

#arrayStartIndex++;
Load r0 arrayStartIndex
Load r1 @1
Add r0 r0 r1

#arrayStartIndex &= ALLOWED_BITS;
Load r1 ALLOWED_BITS
And r0 r0 r1

#unsigned short lastSquaredValue = rawSquare[arrayStartIndex];
Load r2 @r0 # lastSquaredValue

#rawSquare[arrayStartIndex] = squared;
Load r3 squared # squared
Store r0 r3

#totalValue += squared - lastSquaredValue;
Sub r2 r3 r2
Load r3 totalValue
Add r0 r3 r2 # totalValue

#return totalValue / N;
shiftRight r0 r0 5
Store @return r0

-----------------------------------------------------
Upgrade Complete!


#arrayStartIndex++;
Load r0 arrayStartIndex
AddI r0 r0 1

#arrayStartIndex &= ALLOWED_BITS;
Load r1 ALLOWED_BITS
And r0 r0 r1
Store arrayStartIndex r0

#unsigned short lastSquaredValue = rawSquare[arrayStartIndex];
Load r2 @r0 # lastSquaredValue

#rawSquare[arrayStartIndex] = squared;
Load r3 squared # squared
Store r0 r3

#totalValue += squared - lastSquaredValue;
Sub r2 r3 r2
Load r3 totalValue
Add r0 r3 r2 # totalValue
Store totalValue r0

#return totalValue / N;
shiftRight r0 r0 5
Store @return r0



-----------------------------------------------------

Load
Add
AddI
And
Store
Sub
ShiftRightI
JMP


R-instruction op R R R
I-instruction op R R I
B-Instruction op R Addr













